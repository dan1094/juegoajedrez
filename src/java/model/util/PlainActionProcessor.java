/*
 * PlainActionProcessor.java
 *
 * Created on 29 de septiembre de 2007, 0:18
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package model.util;

/**
 *
 * @author CEU
 */
import model.facade.ChangePasswordAction;
import java.sql.Connection;
import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * A utility class to execute plain actions.
 */
public final class PlainActionProcessor {

    private PlainActionProcessor() {}

    public final static Object process(DataSource dataSource, 
        NonTransactionalPlainAction action)
            throws ModelException, InternalErrorException {

        Connection connection = null;
        
        try {
                        
            connection = dataSource.getConnection();            
            
            return action.execute(connection);
            
        } catch (SQLException e) {
            throw new InternalErrorException(e);
        } finally {
            GeneralOperations.closeConnection(connection);
        }
        
    }    
    
    /**
     * Executes a transactional plain action over a connection with
     * transaction isolation level set to "transaction serializable". If the
     * action throws {@link SQLException}, {@link InternalErrorException},
     * {@link RuntimeException} or {@link Error}, the transaction is 
     * rollbacked.
     */
    public final static Object process(DataSource dataSource,
        TransactionalPlainAction action)
        throws ModelException, InternalErrorException {
        
        Connection connection = null;
        boolean rollback = false;
        
        try {
        
            /* 
             * Get a connection with isolation level to 
             * "TRANSACTION_SERIALIZABLE" and autocommit to "false".
             *
             * IMPORTANT: Some JDBC drivers require "setTransactionIsolation"
             * to be called before "setAutoCommit".
             */
            connection = dataSource.getConnection();
            connection.setTransactionIsolation(
                Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);                
            
            /* Execute action. */
            Object result = action.execute(connection);            
            
            /* Return "result". */
            return result;
            
        } catch(SQLException e) {
            rollback = true;
            throw new InternalErrorException(e);
        } catch(InternalErrorException e) {
            rollback = true;
            throw e;         
        } catch(RuntimeException e) {
            rollback = true;
            throw e;
        } catch(Error e) {
            rollback = true;
            throw e;
        } finally {
            try {
                /* Commit or rollback, and finally, close connection. */
                if (connection != null) {
                    if (rollback) {
                        connection.rollback();
                    } else {
                        connection.commit();
                    }
                    connection.close();
                }
            } catch (SQLException e) {
                throw new InternalErrorException(e);
            }
        }
                        
    }

}
