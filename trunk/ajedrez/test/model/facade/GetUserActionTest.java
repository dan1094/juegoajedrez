/*
 * GetUserActionTest.java
 * JUnit based test
 *
 * Created on 18 de noviembre de 2007, 20:20
 */

package model.facade;

import junit.framework.*;
import java.sql.Connection;
import model.user.SQLUserDAO;
import model.user.SQLUserDAOFactory;
import model.util.InstanceNotFoundException;
import model.util.InternalErrorException;
import model.util.NonTransactionalPlainAction;

/**
 *
 * @author Juanjito
 */
public class GetUserActionTest extends TestCase {
    
    public GetUserActionTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(GetUserActionTest.class);
        
        return suite;
    }

    /**
     * Prueba del metodo execute , de la clase model.facade.GetUserAction.
     */
    public void testExecute() throws Exception {
        System.out.println("execute");
        
        Connection connection = null;
        GetUserAction instance = null;
        
        Object expResult = null;
        Object result = instance.execute(connection);
        assertEquals(expResult, result);
        
        // TODO revisar el cadigo de prueba generado y eliminar la llamada predeterminada que falta.
        fail("El caso de prueba es un prototipo.");
    }
    
}
