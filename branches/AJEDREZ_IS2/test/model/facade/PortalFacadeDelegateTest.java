/*
 * PortalFacadeDelegateTest.java
 * JUnit based test
 *
 * Created on 18 de noviembre de 2007, 20:20
 */

package model.facade;

import junit.framework.*;
import java.io.Serializable;
import model.partida.Partida;
import model.user.UserDTO;
import model.util.DuplicateInstanceException;
import model.util.IncorrectPasswordException;
import model.util.InstanceNotFoundException;
import model.util.InternalErrorException;

/**
 *
 * @author Juanjito
 */
public class PortalFacadeDelegateTest extends TestCase {
    
    public PortalFacadeDelegateTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(PortalFacadeDelegateTest.class);
        
        return suite;
    }

    /**
     * Prueba del metodo registerUser , de la clase model.facade.PortalFacadeDelegate.
     */
    public void testRegisterUser() throws Exception {
        System.out.println("registerUser");
        
        UserDTO userDTO = null;
        PortalFacadeDelegate instance = new PortalFacadeDelegate();
        
        instance.registerUser(userDTO);
        
        // TODO revisar el cadigo de prueba generado y eliminar la llamada predeterminada que falta.
        fail("El caso de prueba es un prototipo.");
    }

    /**
     * Prueba del metodo signIn , de la clase model.facade.PortalFacadeDelegate.
     */
    public void testSignIn() throws Exception {
        System.out.println("signIn");
        
        String nick = "";
        String password = "";
        boolean passwordIsEncrypted = true;
        PortalFacadeDelegate instance = new PortalFacadeDelegate();
        
        LoginResultDTO expResult = null;
        LoginResultDTO result = instance.signIn(nick, password, passwordIsEncrypted);
        assertEquals(expResult, result);
        
        // TODO revisar el cadigo de prueba generado y eliminar la llamada predeterminada que falta.
        fail("El caso de prueba es un prototipo.");
    }

    /**
     * Prueba del metodo getUser , de la clase model.facade.PortalFacadeDelegate.
     */
    public void testGetUser() throws Exception {
        System.out.println("getUser");
        
        PortalFacadeDelegate instance = new PortalFacadeDelegate();
        
        UserDTO expResult = null;
        UserDTO result = instance.getUser();
        assertEquals(expResult, result);
        
        // TODO revisar el cadigo de prueba generado y eliminar la llamada predeterminada que falta.
        fail("El caso de prueba es un prototipo.");
    }

    /**
     * Prueba del metodo storeUser , de la clase model.facade.PortalFacadeDelegate.
     */
    public void testStoreUser() throws Exception {
        System.out.println("storeUser");
        
        UserDTO userDTO = null;
        PortalFacadeDelegate instance = new PortalFacadeDelegate();
        
        instance.storeUser(userDTO);
        
        // TODO revisar el cadigo de prueba generado y eliminar la llamada predeterminada que falta.
        fail("El caso de prueba es un prototipo.");
    }

    /**
     * Prueba del metodo changePassword , de la clase model.facade.PortalFacadeDelegate.
     */
    public void testChangePassword() throws Exception {
        System.out.println("changePassword");
        
        String oldPassword = "";
        String newPassword = "";
        PortalFacadeDelegate instance = new PortalFacadeDelegate();
        
        instance.changePassword(oldPassword, newPassword);
        
        // TODO revisar el cadigo de prueba generado y eliminar la llamada predeterminada que falta.
        fail("El caso de prueba es un prototipo.");
    }

    /**
     * Prueba del metodo mover , de la clase model.facade.PortalFacadeDelegate.
     */
    public void testMover() throws Exception {
        System.out.println("mover");
        
        int filaOrigen = 0;
        int columnaOrigen = 0;
        int filaDestino = 0;
        int columnaDestino = 0;
        Partida partida = null;
        PortalFacadeDelegate instance = new PortalFacadeDelegate();
        
        Partida expResult = null;
        Partida result = instance.mover(filaOrigen, columnaOrigen, filaDestino, columnaDestino, partida);
        assertEquals(expResult, result);
        
        // TODO revisar el cadigo de prueba generado y eliminar la llamada predeterminada que falta.
        fail("El caso de prueba es un prototipo.");
    }

    /**
     * Prueba del metodo esTablas , de la clase model.facade.PortalFacadeDelegate.
     */
    public void testEsTablas() throws Exception {
        System.out.println("esTablas");
        
        Partida partida = null;
        PortalFacadeDelegate instance = new PortalFacadeDelegate();
        
        boolean expResult = true;
        boolean result = instance.esTablas(partida);
        assertEquals(expResult, result);
        
        // TODO revisar el cadigo de prueba generado y eliminar la llamada predeterminada que falta.
        fail("El caso de prueba es un prototipo.");
    }

    /**
     * Prueba del metodo esJaqueMate , de la clase model.facade.PortalFacadeDelegate.
     */
    public void testEsJaqueMate() throws Exception {
        System.out.println("esJaqueMate");
        
        Partida partida = null;
        PortalFacadeDelegate instance = new PortalFacadeDelegate();
        
        boolean expResult = true;
        boolean result = instance.esJaqueMate(partida);
        assertEquals(expResult, result);
        
        // TODO revisar el cadigo de prueba generado y eliminar la llamada predeterminada que falta.
        fail("El caso de prueba es un prototipo.");
    }

    /**
     * Prueba del metodo nuevaPartida , de la clase model.facade.PortalFacadeDelegate.
     */
    public void testNuevaPartida() throws Exception {
        System.out.println("nuevaPartida");
        
        PortalFacadeDelegate instance = new PortalFacadeDelegate();
        
        Partida expResult = null;
        Partida result = instance.nuevaPartida();
        assertEquals(expResult, result);
        
        // TODO revisar el cadigo de prueba generado y eliminar la llamada predeterminada que falta.
        fail("El caso de prueba es un prototipo.");
    }

    /**
     * Implementacion generada de la clase abstracta model.facade.PortalFacadeDelegate. Por favor llene los cuerpos de prueba de los metodos generados.
     */
    private class PortalFacadeDelegateImpl implements PortalFacadeDelegate {

        public void registerUser(model.user.UserDTO userDTO) {
            // TODO llene el cuerpo para proporcionar una implementacion de utilidad
            
        }

        public model.facade.LoginResultDTO signIn(java.lang.String nick, java.lang.String password, boolean passwordIsEncrypted) {
            // TODO llene el cuerpo para proporcionar una implementacion de utilidad
            
            return null;
        }

        public model.user.UserDTO getUser() {
            // TODO llene el cuerpo para proporcionar una implementacion de utilidad
            
            return null;
        }

        public void storeUser(model.user.UserDTO userDTO) {
            // TODO llene el cuerpo para proporcionar una implementacion de utilidad
            
        }

        public void changePassword(java.lang.String oldPassword, java.lang.String newPassword) {
            // TODO llene el cuerpo para proporcionar una implementacion de utilidad
            
        }

        public model.partida.Partida mover(int filaOrigen, int columnaOrigen, int filaDestino, int columnaDestino, model.partida.Partida partida) {
            // TODO llene el cuerpo para proporcionar una implementacion de utilidad
            
            return null;
        }

        public boolean esTablas(model.partida.Partida partida) {
            // TODO llene el cuerpo para proporcionar una implementacion de utilidad
            
            return false;
        }

        public boolean esJaqueMate(model.partida.Partida partida) {
            // TODO llene el cuerpo para proporcionar una implementacion de utilidad
            
            return false;
        }

        public model.partida.Partida nuevaPartida() {
            // TODO llene el cuerpo para proporcionar una implementacion de utilidad
            
            return null;
        }
    }

    
}
