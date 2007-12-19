/*
 * SQLUserDAOFactory.java
 *
 * Created on 15 de octubre de 2007, 0:14
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package model.user;


import java.sql.Connection;
import javax.sql.DataSource;
import model.util.*;

/**
 *
 * @author Alvarete
 */

public final class SQLUserDAOFactory {
    /*
    private final static String DAO_CLASS_NAME_PARAMETER =
        "SQLUserDAOFactory/daoClassName";
    */
    private final static Class daoClass = getDAOClass();
    
    private SQLUserDAOFactory() {}
    
    private static Class getDAOClass() {
    
        Class theClass = null;
    
        try {
        
            // Coge los parametros del archivo ConfigurationParameters
            /*
            String daoClassName = //"model.user.StandarSQLUserDAO";
                ConfigurationParametersManager.getParameter(
                    DAO_CLASS_NAME_PARAMETER);
            
            theClass = Class.forName(daoClassName);*/
            theClass = Class.forName("model.user.StandarSQLUserDAO");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return theClass;
        
    }
    
    public static SQLUserDAO getDAO() throws InternalErrorException {
        
        try {        
            return (SQLUserDAO) daoClass.newInstance();
        } catch (Exception e) {
            throw new InternalErrorException(e);
        }
        
    }
    /* 
     * Test code. Uncomment for testing. Test this class and any class
     * implementing "SQLUserDAO".
     */
    public static void main (String[] args) {                                     //
                                                                                  //
        Connection connection = null;                                             //
                                                                                  //
        try {                                                                     //
                                                                                  //
            /* Get a connection. */                                               //
            DataSource dataSource = new SimpleDataSource();                       //
            connection = dataSource.getConnection();                              //
                                                                                  //
            /* Get dao. */                                                        //
            SQLUserDAO dao = SQLUserDAOFactory.getDAO();                          //
                                                                                  //
            /* Test "SQLUserProfileDAO::create". */                               //
            System.out.println("Test for 'SQLUserDAO::create'");                  //
            UserDTO userDTO = new UserDTO("alvaro","alvpass",                     //
                    "Alvaro","Torroba","alvarotorroba@hotmail.com");              //
            dao.create(connection, userDTO);                                      //
            System.out.println("userDTO created => " + userDTO);                  //
                                                                                  //
            /* Test "SQLUserDAO::exists". */                                      //
            System.out.println("Test for 'SQLUserDAO::exists'");                  //
            if (!dao.exists(connection, userDTO.getNick())) {                     //
                throw new Exception("Can not find user profile with " +           //
                    "nick = " +                                                   //
                    userDTO.getNick());                                           //
            }                                                                     //
                                                                                  //
            /* Test "SQLUserDAO::find". */                                        //
            System.out.println("Test for 'SQLUserDAO::find'");                    //
            System.out.println(dao.find(connection,                               //
                userDTO.getNick()));                                              //
                                                                                  //
            /* Test "SQLUserDAO::update". */                                      //
            System.out.println("Test for 'SQLUserDAO::update'");                  //
            userDTO.setNombre("Alvarete");                                        //
            userDTO.setApellido("Torrobilla");                                    //
            userDTO.setEmail("alvaretetorrobilla@hotmail.com");                   //
            userDTO.setPass("newpass");                                           //
            dao.update(connection, userDTO);                                      //
            System.out.println(dao.find(connection,                               //
                userDTO.getNick()));                                              //
                                                                                  //
            /* Test "SQLUserDAO::remove". */                                      //
            System.out.println("Test for 'SQLUserDAO::remove'");                  //
            dao.remove(connection, userDTO.getNick());                            //
                                                                                  //
            if (dao.exists(connection, userDTO.getNick())) {                      //
                throw new Exception("SQLUserDAO::remove failed");                 //
            }                                                                     //
                                                                                  //
            /* Tests OK. */                                                       //
            System.out.println("Tests OK !!!!");                                  //
                                                                                  //
        } catch (Exception e) {                                                   //
            e.printStackTrace();                                                  //
        } finally {                                                               //
            try {                                                                 //
                GeneralOperations.closeConnection(connection);                    //
            } catch (InternalErrorException e) {                                  //
                e.printStackTrace();                                              //
            }                                                                     //
        }                                                                         //
                                                                                  //
    }    
    
}

