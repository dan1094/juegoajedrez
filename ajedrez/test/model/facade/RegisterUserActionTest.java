/*
 * RegisterUserActionTest.java
 * JUnit based test
 *
 * Created on 18 de noviembre de 2007, 20:20
 */

package model.facade;

import junit.framework.*;
import java.sql.Connection;
import model.user.SQLUserDAO;
import model.user.SQLUserDAOFactory;
import model.user.UserDTO;
import model.util.DuplicateInstanceException;
import model.util.InstanceNotFoundException;
import model.util.InternalErrorException;
import model.util.PasswordEncrypter;
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
        
        Connection connection = null;
        RegisterUserAction instance = null;
        
        Object expResult = null;
        Object result = instance.execute(connection);
        assertEquals(expResult, result);
        
        // TODO revisar el cadigo de prueba generado y eliminar la llamada predeterminada que falta.
        fail("El caso de prueba es un prototipo.");
    }
    
}
