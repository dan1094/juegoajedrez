/*
 * GeneralOperations.java
 *
 * Created on 29 de septiembre de 2007, 0:12
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package model.util;

/**
 *
 * @author CEU
 */
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

public final class GeneralOperations {

    private GeneralOperations() {}
    
    /**
     * It closes a <code>ResultSet</code> if not <code>null</code>.
     */
    public static void closeResultSet(ResultSet resultSet) 
        throws InternalErrorException {
        
        if (resultSet != null) {        
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new InternalErrorException(e);
            }        
        }
        
    }

    /**
     * It closes a <code>Statement</code> if not <code>null</code>.
     */
    public static void closeStatement(Statement statement) 
        throws InternalErrorException {
        
        if (statement != null) {        
            try {
                statement.close();
            } catch (SQLException e) {
                throw new InternalErrorException(e);
            }        
        }
        
    }
    
    /**
     * It closes a <code>Connection</code> if not <code>null</code>.
     */
    public static void closeConnection(Connection connection)
        throws InternalErrorException {
        
        if (connection != null) {        
            try {
                connection.close();
            } catch (SQLException e) {
                throw new InternalErrorException(e);
            }        
        }
        
    }

}
