/*
 * FichaTest.java
 * JUnit based test
 *
 * Created on 16 de octubre de 2007, 17:48
 */

package clases;

import junit.framework.*;

/**
 *
 * @author Administrador
 */
public class FichaTest extends TestCase {
    
    public FichaTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }  

    public void testDentro() {
        System.out.println("dentro");
        
        int fil = -1;
        int col = 1;
        Ficha instance = new Peon(0,true);
        
        boolean expResult = false;
        boolean result = instance.dentro(fil, col);
        assertEquals(expResult, result);
        
       
    }
    
}
