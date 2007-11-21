/*
 * LoginResultDTOTest.java
 * JUnit based test
 *
 * Created on 18 de noviembre de 2007, 20:20
 */

package model.facade;

import junit.framework.*;
import java.io.Serializable;

/**
 *
 * @author Juanjito
 */
public class LoginResultDTOTest extends TestCase {
    
    public LoginResultDTOTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(LoginResultDTOTest.class);
        
        return suite;
    }

    /**
     * Prueba del metodo getNombre , de la clase model.facade.LoginResultDTO.
     */
    public void testGetNombre() {
        System.out.println("getNombre");
        
        LoginResultDTO instance = null;
        
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        
        // TODO revisar el cadigo de prueba generado y eliminar la llamada predeterminada que falta.
        fail("El caso de prueba es un prototipo.");
    }

    /**
     * Prueba del metodo setNombre , de la clase model.facade.LoginResultDTO.
     */
    public void testSetNombre() {
        System.out.println("setNombre");
        
        String nombre = "";
        LoginResultDTO instance = null;
        
        instance.setNombre(nombre);
        
        // TODO revisar el cadigo de prueba generado y eliminar la llamada predeterminada que falta.
        fail("El caso de prueba es un prototipo.");
    }

    /**
     * Prueba del metodo getEncryptedPassword , de la clase model.facade.LoginResultDTO.
     */
    public void testGetEncryptedPassword() {
        System.out.println("getEncryptedPassword");
        
        LoginResultDTO instance = null;
        
        String expResult = "";
        String result = instance.getEncryptedPassword();
        assertEquals(expResult, result);
        
        // TODO revisar el cadigo de prueba generado y eliminar la llamada predeterminada que falta.
        fail("El caso de prueba es un prototipo.");
    }

    /**
     * Prueba del metodo setEncryptedPassword , de la clase model.facade.LoginResultDTO.
     */
    public void testSetEncryptedPassword() {
        System.out.println("setEncryptedPassword");
        
        String encryptedPassword = "";
        LoginResultDTO instance = null;
        
        instance.setEncryptedPassword(encryptedPassword);
        
        // TODO revisar el cadigo de prueba generado y eliminar la llamada predeterminada que falta.
        fail("El caso de prueba es un prototipo.");
    }

    /**
     * Prueba del metodo toString , de la clase model.facade.LoginResultDTO.
     */
    public void testToString() {
        System.out.println("toString");
        
        LoginResultDTO instance = null;
        
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        
        // TODO revisar el cadigo de prueba generado y eliminar la llamada predeterminada que falta.
        fail("El caso de prueba es un prototipo.");
    }
    
}
