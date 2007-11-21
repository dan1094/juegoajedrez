/*
 * NuevaPartidaActionTest.java
 * JUnit based test
 *
 * Created on 18 de noviembre de 2007, 20:20
 */

package model.facade;

import junit.framework.*;
import model.partida.Partida;
import model.util.InstanceNotFoundException;
import model.util.InternalErrorException;

/**
 *
 * @author Juanjito
 */
public class NuevaPartidaActionTest extends TestCase {
    
    public NuevaPartidaActionTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(NuevaPartidaActionTest.class);
        
        return suite;
    }

    /**
     * Prueba del metodo execute , de la clase model.facade.NuevaPartidaAction.
     */
    public void testExecute() throws Exception {
        System.out.println("execute");
        
        NuevaPartidaAction instance = new NuevaPartidaAction();
        
        Object expResult = null;
        Object result = instance.execute();
        assertEquals(expResult, result);
        
        // TODO revisar el cadigo de prueba generado y eliminar la llamada predeterminada que falta.
        fail("El caso de prueba es un prototipo.");
    }
    
}
