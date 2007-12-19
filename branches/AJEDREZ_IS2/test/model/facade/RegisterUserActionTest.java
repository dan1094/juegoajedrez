/*
 * RegisterUserActionTest.java
 * JUnit based test
 *
 * Created on 18 de noviembre de 2007, 20:20
 */

package model.facade;

import javax.sql.DataSource;
import junit.framework.*;
import java.sql.Connection;
import model.user.SQLUserDAO;
import model.user.SQLUserDAOFactory;
import model.user.UserDTO;
import model.util.DuplicateInstanceException;
import model.util.InstanceNotFoundException;
import model.util.InternalErrorException;
import model.util.PasswordEncrypter;
import model.util.SimpleDataSource;
import model.util.TransactionalPlainAction;

/**
 *
 * @author Juanjito
 */
public class RegisterUserActionTest extends TestCase {
    
    public RegisterUserActionTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(RegisterUserActionTest.class);
        
        return suite;
    }

    /**
     * Prueba del metodo execute , de la clase model.facade.RegisterUserAction.
     */
    public void testExecute() throws Exception {
        System.out.println("execute");
        
        DataSource dataSource = new SimpleDataSource();
        Connection connection = dataSource.getConnection();
        
        UserDTO userDTO = new UserDTO();
        
        userDTO.setApellido("Alonso");
        userDTO.setEmail("FernandoAlonso@gmail.com");
        userDTO.setNick("Alons");
        userDTO.setNombre("Fernando");
        userDTO.setPass("1234");
       

        RegisterUserAction action = new RegisterUserAction(userDTO);
       
        action.execute(connection);
    }
    
}
