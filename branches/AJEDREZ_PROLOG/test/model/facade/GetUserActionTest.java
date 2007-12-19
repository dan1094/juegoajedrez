/*
 * GetUserActionTest.java
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
import model.util.InstanceNotFoundException;
import model.util.InternalErrorException;
import model.util.NonTransactionalPlainAction;
import model.util.SimpleDataSource;

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
        
        DataSource dataSource = new SimpleDataSource();
        Connection connection = dataSource.getConnection();
        
        String nick = "hato";
        String apellido = "topo";
        String nombre = "hans";
        
        GetUserAction action = new GetUserAction(nick);
       
        UserDTO result = (UserDTO) action.execute(connection);
        
        assertEquals(nick, result.getNick());
        assertEquals(nombre, result.getNombre());
        assertEquals(apellido, result.getApellido());
    }
    
}
