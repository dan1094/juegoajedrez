/*
 * StandarSQLUserDAOTest.java
 * JUnit based test
 *
 * Created on 18 de noviembre de 2007, 19:37
 */

package model.user;

import javax.sql.DataSource;
import junit.framework.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.util.*;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Juanjito
 */
public class StandarSQLUserDAOTest extends TestCase {
    
    public StandarSQLUserDAOTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    /**
     * Prueba del metodo create , de la clase model.user.StandarSQLUserDAO.
     */
    public void testCreate() throws Exception {
        System.out.println("create");
        
        DataSource dataSource = new SimpleDataSource();
        Connection connection = dataSource.getConnection();
        
        UserDTO userDTO = new UserDTO();
        
        userDTO.setApellido("topo");
        userDTO.setNombre("Hans");
        userDTO.setNick("hato");
        userDTO.setEmail("kajfksajf");
        userDTO.setPass("1234");
        
        StandarSQLUserDAO instance = new StandarSQLUserDAO();
        
        instance.create(connection, userDTO);
        
    }

    /**
     * Prueba del metodo exists , de la clase model.user.StandarSQLUserDAO.
     */
    public void testExists() throws Exception {
        System.out.println("exists");
        
        DataSource dataSource = new SimpleDataSource();
        Connection connection = dataSource.getConnection();
        
        String nick = "nick2";
        
        StandarSQLUserDAO instance = new StandarSQLUserDAO();
        
        boolean expResult = true;
        boolean result = instance.exists(connection, nick);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Prueba del metodo find , de la clase model.user.StandarSQLUserDAO.
     */
    public void testFind() throws Exception {
        System.out.println("find");
        
        DataSource dataSource = new SimpleDataSource();
        Connection connection = dataSource.getConnection();
        
        UserDTO userDTO =new UserDTO();
        
        String nick = "paquito_yamaha";
        StandarSQLUserDAO instance = new StandarSQLUserDAO();
        
      //  UserDTO expResult = null;
        userDTO = instance.find(connection, nick);
        
        System.out.println(userDTO.toString());
        
        assertEquals(nick,userDTO.getNick());
        
        
    }

    /**
     * Prueba del metodo update , de la clase model.user.StandarSQLUserDAO.
     */
    public void testUpdate() throws Exception {
        System.out.println("update");
        
        DataSource dataSource = new SimpleDataSource();
        Connection connection = dataSource.getConnection();
        
        UserDTO userDTO = new UserDTO();
        
        userDTO.setApellido("gemez");
        userDTO.setNombre("paco");
        userDTO.setNick("nick1");
        userDTO.setEmail("kajfksajf");
        userDTO.setPass("1234");
        
        StandarSQLUserDAO instance = new StandarSQLUserDAO();
        
        instance.update(connection, userDTO);
        
        
    }

    /**
     * Prueba del metodo remove , de la clase model.user.StandarSQLUserDAO.
     */
    public void testRemove() throws Exception {
        System.out.println("remove");
        
         DataSource dataSource = new SimpleDataSource();
        Connection connection = dataSource.getConnection();
        
        String nick = "invitado";
        
        StandarSQLUserDAO instance = new StandarSQLUserDAO();
        
        instance.remove(connection, nick);
        
        
    }
    
}
