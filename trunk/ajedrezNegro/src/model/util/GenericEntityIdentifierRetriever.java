/*
 * GenericEntityIdentifierRetriever.java
 *
 * Created on 29 de septiembre de 2007, 0:14
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package model.util;

/**
 *
 * @author CEU
 */
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * A generic implementation of <code>EntityIdentifierGenerator</code>.
 * It launches the query specified by the configuration parameter
 * <code>GenericEntityIdentifierRetriever/query</code>.
 */
public class GenericEntityIdentifierRetriever 
    implements EntityIdentifierRetriever {
    
    private final static String QUERY_PARAMETER =
        "GenericEntityIdentifierRetriever/query";
    
    private final static String queryString = getQueryString();
        
    private static String getQueryString() {
    
        String queryString = null;
    
        try {
            return ConfigurationParametersManager.getParameter(QUERY_PARAMETER);                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return queryString;
        
    }

    public Long getGeneratedIdentifier(Connection connection)
        throws InternalErrorException {
    
        Statement statement = null;
        ResultSet resultSet = null;

        try {
        
            statement = connection.createStatement();   
            resultSet = statement.executeQuery(queryString);
            if (!resultSet.next()) {
                throw new SQLException("Identifier not generated");
            }

            return new Long(resultSet.getLong(1));

        } catch (Exception e) {        
            throw new InternalErrorException(e);
        } finally {
            GeneralOperations.closeResultSet(resultSet);
            GeneralOperations.closeStatement(statement);
        }
        
    }
    
}
