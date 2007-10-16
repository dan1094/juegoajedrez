/*
 * ControllerTest.java
 * JUnit based test
 *
 * Created on 15 de octubre de 2007, 23:50
 */

package clases;

import junit.framework.*;
import java.io.*;

/**
 *
 * @author Pablo
 */
public class ControllerTest extends TestCase {
    
    public ControllerTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    /**
     * Test of tablero_personalizado method, of class clases.Controller.
     */
    public void testTablero_personalizado() {
        System.out.println("tablero_personalizado");
        
        Controller instance = new Controller();
        
        boolean expResult = true;
        boolean result = instance.tablero_personalizado();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ofrecer_ficha method, of class clases.Controller.
     */
    public void testOfrecer_ficha() {
        System.out.println("ofrecer_ficha");
        
        Controller instance = new Controller();
        
        int expResult = 0;
        int result = instance.ofrecer_ficha();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ofrecer_fila method, of class clases.Controller.
     */
    public void testOfrecer_fila() {
        System.out.println("ofrecer_fila");
        
        Controller instance = new Controller();
        
        int expResult = 0;
        int result = instance.ofrecer_fila();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ofrecer_columna method, of class clases.Controller.
     */
    public void testOfrecer_columna() {
        System.out.println("ofrecer_columna");
        
        Controller instance = new Controller();
        
        int expResult = 0;
        int result = instance.ofrecer_columna();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pedir_color method, of class clases.Controller.
     */
    public void testPedir_color() {
        System.out.println("pedir_color");
        
        Controller instance = new Controller();
        
        boolean expResult = true;
        boolean result = instance.pedir_color();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ofrecer_cambio_ficha method, of class clases.Controller.
     */
    public void testOfrecer_cambio_ficha() {
        System.out.println("ofrecer_cambio_ficha");
        
        Controller instance = new Controller();
        
        int expResult = 0;
        int result = instance.ofrecer_cambio_ficha();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
