/*
 * NativeEntityIdentifierGenerator.java
 *
 * Created on 27 de septiembre de 2007, 21:37
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package model.util;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * A generic implementation of <code>EntityIdentifierGenerator</code> for
 * databases providing native identifier generators  (sequences).
 * <p>
 * Required configuration properties:
 * <ul>
 * <li> <code>NativeEntityIdentifierGenerator/query</code>: the query to
 * launch when an identifier must be generated. This query uses
 * the parameter <code>$1</code> for the name of the sequence.
 * <li> <code>NativeEntityIdentifierGenerator/sequence-<b>entityName</b>
 * </code> per entity: it specifies the name of the sequence for the entity
 * <code><b>entityName</b></code>.</li>
 * </ul>
 */
public class NativeEntityIdentifierGenerator
    implements EntityIdentifierGenerator {
    
    //private final static String QUERY_PARAMETER =
    //    "NativeEntityIdentifierGenerator/query";
        
    private final static String templateQueryString =
        getTemplateQueryString();
        
    private static String getTemplateQueryString() {
    
        String templateQueryString = null;
        
        try {        
            //return ConfigurationParametersManager.getParameter(QUERY_PARAMETER);                        
		return "SELECT nextval('?1')";
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return templateQueryString;
        
    }

    private String getQueryString(String sequenceName) {
        
        return templateQueryString.replaceAll("\\?1", sequenceName);

    }
    
    public Long nextIdentifier(Connection connection, 
        String entityName) throws InternalErrorException {
    
        Statement statement = null;
        ResultSet resultSet = null;

        try {
        
            /* Get sequence name. */
            //String sequenceName = ConfigurationParametersManager.getParameter(
            //    "NativeEntityIdentifierGenerator/sequence-" + entityName);
		String sequenceName = entityName + "Seq";

            /* Get the next identifier. */
            String queryString =  getQueryString(sequenceName);
            statement = connection.createStatement();   
            resultSet = statement.executeQuery(queryString);
            if (!resultSet.next()) {
                throw new SQLException("Sequence '" + sequenceName + "'" +
                    " does not return next value");
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
