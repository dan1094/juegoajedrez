/*
 * CasillaTest.java
 * JUnit based test
 *
 * Created on 16 de octubre de 2007, 17:29
 */

package TestModelPartida;

import junit.framework.*;
import model.partida.*;

/**
 *
 * @author Administrador
 */
public class CasillaTest extends TestCase {
    
    private Casilla casilla;
    
    public CasillaTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
        
        this.casilla = new Casilla();
        
    }

    protected void tearDown() throws Exception {
        
        this.casilla = null;
    }

   

    public static Test suite(){
        return new TestSuite(CasillaTest.class);
    }
    /**
     * Test of getOcupada method, of class clases.Casilla.
     */
    public void test_Casilla_Ocupada() {
        System.out.println("getOcupada");
        
        Casilla instance = new Casilla();
        
        boolean expResult = false;
        boolean result = instance.getOcupada();
        assertEquals(expResult, result);
        
        
    }
    
}
