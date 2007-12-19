/*
 * EntityIdentifierGeneratorFactory.java
 *
 * Created on 27 de septiembre de 2007, 21:25
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package model.util;
/**
 *
 * @author CEU
 */
public final class EntityIdentifierGeneratorFactory {
        
    private final static String GENERATOR_CLASS_NAME_PARAMETER =
        "EntityIdentifierGeneratorFactory/generatorClassName";
        
    private final static Class generatorClass = getGeneratorClass();
    
    private EntityIdentifierGeneratorFactory() {}
    
    private static Class getGeneratorClass() {
    
        Class theClass = null;
    
        try {
        
         String generatorClassName = 
                ConfigurationParametersManager.getParameter(
                    GENERATOR_CLASS_NAME_PARAMETER);
           
            // String generatorClassName = "es.udc.fi.is.jss.myportal.model.util.NativeEntityIdentifierGenerator";
            theClass = Class.forName(generatorClassName);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return theClass;
        
    }
    
    public static EntityIdentifierGenerator getGenerator() 
        throws InternalErrorException {    
        
        try {        
            return (EntityIdentifierGenerator) generatorClass.newInstance();
        } catch (Exception e) {
            throw new InternalErrorException(e);
        }
        
    }

    /* 
     * Test code. Uncomment for testing. Tests this class and any class
     * implementing "EntityIdentifierGenerator".
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
//            EntityIdentifierGenerator generator = 
//                EntityIdentifierGeneratorFactory.getGenerator();
//            System.out.println("Generated identifier: " +
//                generator.nextIdentifier(connection, "Account"));
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
