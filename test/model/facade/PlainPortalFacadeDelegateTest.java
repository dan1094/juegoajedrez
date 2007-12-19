/*
 * PlainPortalFacadeDelegateTest.java
 * JUnit based test
 *
 * Created on 18 de noviembre de 2007, 20:20
 */

package model.facade;

import junit.framework.*;
import javax.sql.DataSource;
import model.partida.Partida;
import model.user.UserDTO;
import model.util.DataSourceLocator;
import model.util.DuplicateInstanceException;
import model.util.GlobalNames;
import model.util.IncorrectPasswordException;
import model.util.InstanceNotFoundException;
import model.util.InternalErrorException;
import model.util.PlainActionProcessor;

/**
 *
 * @author Juanjito
 */
public class PlainPortalFacadeDelegateTest extends TestCase {
    
    public PlainPortalFacadeDelegateTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(PlainPortalFacadeDelegateTest.class);
        
        return suite;
    }

    /**
     * Prueba del metodo registerUser , de la clase model.facade.PlainPortalFacadeDelegate.
     */
    public void testRegisterUser() throws Exception {
        System.out.println("registerUser");
        
        UserDTO userDTO = null;
        PlainPortalFacadeDelegate instance = new PlainPortalFacadeDelegate();
        
        instance.registerUser(userDTO);
        
        // TODO revisar el cadigo de prueba generado y eliminar la llamada predeterminada que falta.
        fail("El caso de prueba es un prototipo.");
    }

    /**
     * Prueba del metodo signIn , de la clase model.facade.PlainPortalFacadeDelegate.
     */
    public void testSignIn() throws Exception {
        System.out.println("signIn");
        
        String nick = "";
        String password = "";
        boolean passwordIsEncrypted = true;
        PlainPortalFacadeDelegate instance = new PlainPortalFacadeDelegate();
        
        LoginResultDTO expResult = null;
        LoginResultDTO result = instance.signIn(nick, password, passwordIsEncrypted);
        assertEquals(expResult, result);
        
        // TODO revisar el cadigo de prueba generado y eliminar la llamada predeterminada que falta.
        fail("El caso de prueba es un prototipo.");
    }

    /**
     * Prueba del metodo getUser , de la clase model.facade.PlainPortalFacadeDelegate.
     */
    public void testGetUser() throws Exception {
        System.out.println("getUser");
        
        PlainPortalFacadeDelegate instance = new PlainPortalFacadeDelegate();
        
        UserDTO expResult = null;
        UserDTO result = instance.getUser();
        assertEquals(expResult, result);
        
        // TODO revisar el cadigo de prueba generado y eliminar la llamada predeterminada que falta.
        fail("El caso de prueba es un prototipo.");
    }

    /**
     * Prueba del metodo storeUser , de la clase model.facade.PlainPortalFacadeDelegate.
     */
    public void testStoreUser() throws Exception {
        System.out.println("storeUser");
        
        UserDTO userDTO = null;
        PlainPortalFacadeDelegate instance = new PlainPortalFacadeDelegate();
        
        instance.storeUser(userDTO);
        
        // TODO revisar el cadigo de prueba generado y eliminar la llamada predeterminada que falta.
        fail("El caso de prueba es un prototipo.");
    }

    /**
     * Prueba del metodo changePassword , de la clase model.facade.PlainPortalFacadeDelegate.
     */
    public void testChangePassword() throws Exception {
        System.out.println("changePassword");
        
        String oldClearPassword = "";
        String newClearPassword = "";
        PlainPortalFacadeDelegate instance = new PlainPortalFacadeDelegate();
        
        instance.changePassword(oldClearPassword, newClearPassword);
        
        // TODO revisar el cadigo de prueba generado y eliminar la llamada predeterminada que falta.
        fail("El caso de prueba es un prototipo.");
    }

    /**
     * Prueba del metodo mover , de la clase model.facade.PlainPortalFacadeDelegate.
     */
    public void testMover() throws Exception {
        System.out.println("mover");
        
        int filaOrigen = 0;
        int columnaOrigen = 0;
        int filaDestino = 0;
        int columnaDestino = 0;
        Partida partida = null;
        PlainPortalFacadeDelegate instance = new PlainPortalFacadeDelegate();
        
        Partida expResult = null;
        Partida result = instance.mover(filaOrigen, columnaOrigen, filaDestino, columnaDestino, partida);
        assertEquals(expResult, result);
        
        // TODO revisar el cadigo de prueba generado y eliminar la llamada predeterminada que falta.
        fail("El caso de prueba es un prototipo.");
    }

    /**
     * Prueba del metodo esTablas , de la clase model.facade.PlainPortalFacadeDelegate.
     */
    public void testEsTablas() throws Exception {
        System.out.println("esTablas");
        
        Partida partida = null;
        PlainPortalFacadeDelegate instance = new PlainPortalFacadeDelegate();
        
        boolean expResult = true;
        boolean result = instance.esTablas(partida);
        assertEquals(expResult, result);
        
        // TODO revisar el cadigo de prueba generado y eliminar la llamada predeterminada que falta.
        fail("El caso de prueba es un prototipo.");
    }

    /**
     * Prueba del metodo esJaqueMate , de la clase model.facade.PlainPortalFacadeDelegate.
     */
    public void testEsJaqueMate() throws Exception {
        System.out.println("esJaqueMate");
        
        Partida partida = null;
        PlainPortalFacadeDelegate instance = new PlainPortalFacadeDelegate();
        
        boolean expResult = true;
        boolean result = instance.esJaqueMate(partida);
        assertEquals(expResult, result);
        
        // TODO revisar el cadigo de prueba generado y eliminar la llamada predeterminada que falta.
        fail("El caso de prueba es un prototipo.");
    }

    /**
     * Prueba del metodo nuevaPartida , de la clase model.facade.PlainPortalFacadeDelegate.
     */
    public void testNuevaPartida() throws Exception {
        System.out.println("nuevaPartida");
        
        PlainPortalFacadeDelegate instance = new PlainPortalFacadeDelegate();
        
        Partida expResult = null;
        Partida result = instance.nuevaPartida();
        assertEquals(expResult, result);
        
        // TODO revisar el cadigo de prueba generado y eliminar la llamada predeterminada que falta.
        fail("El caso de prueba es un prototipo.");
    }
    
}
