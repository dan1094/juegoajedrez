/*
 * ChangePasswordActionTest.java
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
import model.util.IncorrectPasswordException;
import model.util.InstanceNotFoundException;
import model.util.InternalErrorException;
import model.util.PasswordEncrypter;
import model.util.SimpleDataSource;
import model.util.TransactionalPlainAction;

/**
 *
 * @author Juanjito
 */
public class ChangePasswordActionTest extends TestCase {
    
    public ChangePasswordActionTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(ChangePasswordActionTest.class);
        
        return suite;
    }

    /**
     * Prueba del metodo execute , de la clase model.facade.ChangePasswordAction.
     */
    public void testExecute() throws Exception {
        System.out.println("execute");
        
        DataSource dataSource = new SimpleDataSource();
        Connection connection = dataSource.getConnection();
        
        ChangePasswordAction action = new ChangePasswordAction("invitado","1234","1234567");
        
        Object expResult = null;
        Object result = action.execute(connection);
        assertEquals(expResult, result);
        
    }
    
}
