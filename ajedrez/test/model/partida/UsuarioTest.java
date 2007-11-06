/*
 * UsuarioTest.java
 * JUnit based test
 *
 * Created on 16 de octubre de 2007, 18:47
 */

package model.partida;

import junit.framework.*;

/**
 *
 * @author Juanjito
 */
public class UsuarioTest extends TestCase {
    
    private Usuario usuario;
    
    public UsuarioTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
        this.usuario= new Usuario();
    }

    protected void tearDown() throws Exception {
        this.usuario=null;
    }

    /**
     * Prueba del metodo getId_usuario , de la clase clases.Usuario.
     */
    public void testGetId_usuario() {
        System.out.println("getId_usuario");
        
        Usuario instance = new Usuario();
        
        int expResult = -1;
        int result = this.usuario.getId_usuario();
        assertEquals(expResult, result);
        
        // TODO revisar el cadigo de prueba generado y eliminar la llamada predeterminada que falta.
        //fail("El caso de prueba es un prototipo.");
    }

    /**
     * Prueba del metodo setId_usuario , de la clase clases.Usuario.
     */
    public void testSetId_usuario() {
        System.out.println("setId_usuario");
        
        int id_usuario = 0;
        Usuario instance = new Usuario();
        
        instance.setId_usuario(id_usuario);
        
        // TODO revisar el cadigo de prueba generado y eliminar la llamada predeterminada que falta.
        //fail("El caso de prueba es un prototipo.");
    }

    /**
     * Prueba del metodo getNombre , de la clase clases.Usuario.
     */
    public void testGetNombre() {
        System.out.println("getNombre");
        
        Usuario instance = new Usuario();
        
        String expResult = null;
        String result = instance.getNombre();
        assertEquals(expResult, result);
        
        // TODO revisar el cadigo de prueba generado y eliminar la llamada predeterminada que falta.
        //fail("El caso de prueba es un prototipo.");
    }

    /**
     * Prueba del metodo setNombre , de la clase clases.Usuario.
     */
    public void testSetNombre() {
        System.out.println("setNombre");
        
        String nombre = "";
        Usuario instance = new Usuario();
        
        instance.setNombre(nombre);
        
        // TODO revisar el cadigo de prueba generado y eliminar la llamada predeterminada que falta.
        //fail("El caso de prueba es un prototipo.");
    }

    /**
     * Prueba del metodo getEmail , de la clase clases.Usuario.
     */
    public void testGetEmail() {
        System.out.println("getEmail");
        
        Usuario instance = new Usuario();
        
        String expResult = null;
        String result = instance.getEmail();
        assertEquals(expResult, result);
        
        // TODO revisar el cadigo de prueba generado y eliminar la llamada predeterminada que falta.
        //fail("El caso de prueba es un prototipo.");
    }

    /**
     * Prueba del metodo setEmail , de la clase clases.Usuario.
     */
    public void testSetEmail() {
        System.out.println("setEmail");
        
        String email = "";
        Usuario instance = new Usuario();
        
        instance.setEmail(email);
        
        // TODO revisar el cadigo de prueba generado y eliminar la llamada predeterminada que falta.
        //fail("El caso de prueba es un prototipo.");
    }

    /**
     * Prueba del metodo getPass , de la clase clases.Usuario.
     */
    public void testGetPass() {
        System.out.println("getPass");
        
        Usuario instance = new Usuario();
        
        String expResult = null;
        String result = instance.getPass();
        assertEquals(expResult, result);
        
        // TODO revisar el cadigo de prueba generado y eliminar la llamada predeterminada que falta.
        //fail("El caso de prueba es un prototipo.");
    }

    /**
     * Prueba del metodo setPass , de la clase clases.Usuario.
     */
    public void testSetPass() {
        System.out.println("setPass");
        
        String pass = "";
        Usuario instance = new Usuario();
        
        instance.setPass(pass);
        
        // TODO revisar el cadigo de prueba generado y eliminar la llamada predeterminada que falta.
       // fail("El caso de prueba es un prototipo.");
    }

    /**
     * Prueba del metodo getNick , de la clase clases.Usuario.
     */
    public void testGetNick() {
        System.out.println("getNick");
        
        Usuario instance = new Usuario();
        
        String expResult = null;
        String result = instance.getNick();
        assertEquals(expResult, result);
        
        // TODO revisar el cadigo de prueba generado y eliminar la llamada predeterminada que falta.
        //fail("El caso de prueba es un prototipo.");
    }

    /**
     * Prueba del metodo setNick , de la clase clases.Usuario.
     */
    public void testSetNick() {
        System.out.println("setNick");
        
        String nick = "";
        Usuario instance = new Usuario();
        
        instance.setNick(nick);
        
        // TODO revisar el cadigo de prueba generado y eliminar la llamada predeterminada que falta.
        //fail("El caso de prueba es un prototipo.");
    }

    /**
     * Prueba del metodo isValid , de la clase clases.Usuario.
     */
    public void testIsValid() {
        System.out.println("isValid");
        
        Usuario instance = new Usuario();
        
        boolean expResult = false;
        boolean result = instance.isValid();
        assertEquals(expResult, result);
        
        // TODO revisar el cadigo de prueba generado y eliminar la llamada predeterminada que falta.
        //fail("El caso de prueba es un prototipo.");
    }

    /**
     * Prueba del metodo setValid , de la clase clases.Usuario.
     */
    public void testSetValid() {
        System.out.println("setValid");
        
        boolean valid = true;
        Usuario instance = new Usuario();
        
        instance.setValid(valid);
        
        // TODO revisar el cadigo de prueba generado y eliminar la llamada predeterminada que falta.
        //fail("El caso de prueba es un prototipo.");
    }
    
}
