/*
 * EntityIdentifierRetrieverFactory.java
 *
 * Created on 29 de septiembre de 2007, 0:10
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package model.util;

/**
 *
 * @author CEU
 */
// For testing.
import javax.sql.DataSource;

/**
 * A factory to get <code>EntityIdentifierRetriever</code> objects.
 * <p>
 * Required configuration properties:
 * <ul>
 * <li><code>EntityIdentifierRetrieverFactory/retrieverClassName</code>: it must
 * specify the full class name of the class implementing
 * <code>EntityIdentifierRetriever</code>.</li>
 * </ul>
 */
public final class EntityIdentifierRetrieverFactory {
    
    private final static String RETRIEVER_CLASS_NAME_PARAMETER =
        "EntityIdentifierRetrieverFactory/retrieverClassName";
        
    private final static Class retrieverClass = getRetrieverClass();
    
    private EntityIdentifierRetrieverFactory() {}
    
    private static Class getRetrieverClass() {
    
        Class theClass = null;
    
        try {
        
            String retrieverClassName = 
                ConfigurationParametersManager.getParameter(
                    RETRIEVER_CLASS_NAME_PARAMETER);
            
            theClass = Class.forName(retrieverClassName);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return theClass;
        
    }
    
    public static EntityIdentifierRetriever getRetriever() 
        throws InternalErrorException {    
        
        try {        
            return (EntityIdentifierRetriever) retrieverClass.newInstance();
        } catch (Exception e) {
            throw new InternalErrorException(e);
        }
        
    }

    /* 
     * Test code. Uncomment for testing. Tests this class and any class
     * implementing "EntityIdentifierRetriever".
     */
//    public static void main (String[] args) {
//
//        java.sql.Connection connection = null;    
//        
//        try {                            
//        
//            /* Test. */    
//            DataSource dataSource = new SimpleDataSource();        
//            connection = dataSource.getConnection();
//            
//            EntityIdentifierRetriever retriever = 
//                EntityIdentifierRetrieverFactory.getRetriever();
//            System.out.println("Generated identifier: " +
//                retriever.getGeneratedIdentifier(connection));
//                
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                GeneralOperations.closeConnection(connection);
//            } catch (InternalErrorException e) {
//                e.printStackTrace();
//            }
//        }
//        
//    }

}
