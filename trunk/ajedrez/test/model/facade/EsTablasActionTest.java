/*
 * EsTablasActionTest.java
 * JUnit based test
 *
 * Created on 18 de noviembre de 2007, 20:20
 */

package model.facade;

import junit.framework.*;
import model.partida.*;
import model.util.*;

/**
 *
 * @author Juanjito
 */
public class EsTablasActionTest extends TestCase {
    
    public EsTablasActionTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(EsTablasActionTest.class);
        
        return suite;
    }

    /**
     * Prueba del metodo execute , de la clase model.facade.EsTablasAction.
     */
    public void testExecute() throws Exception {
        System.out.println("execute");
        
        EsTablasAction instance = null;
        
        boolean expResult = true;
        boolean result = instance.execute();
        assertEquals(expResult, result);
        
        // TODO revisar el cadigo de prueba generado y eliminar la llamada predeterminada que falta.
        fail("El caso de prueba es un prototipo.");
    }
    
}
