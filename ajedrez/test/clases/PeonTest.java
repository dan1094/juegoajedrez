/*
 * PeonTest.java
 * JUnit based test
 *
 * Created on 16 de octubre de 2007, 16:10
 */

package clases;

import junit.framework.*;

/**
 *
 * @author Administrador
 */
public class PeonTest extends TestCase {
    
    private Peon peon;
    private Tablero tablero;
    
     
    
    protected void setUp() throws Exception {
        peon = new Peon(0,true);
        tablero = new Tablero();
        
    }

    protected void tearDown() throws Exception {
        this.peon=null;
        this.tablero = null;
    }

    /**
     * Test of movimiento_correspondiente_ficha method, of class clases.Peon.
     */
    public void testMovimiento_correspondiente_ficha() {
        System.out.println("movimiento_correspondiente_ficha");
        
        Tablero tablero = new Tablero();
        
        int fo = 5;
        int co = 2;
        int fd = 4;
        int cd = 2;
        
        Peon instance = new Peon(0,false);
        
        boolean expResult = true;
        boolean resultadoObtenido = instance.movimiento_correspondiente_ficha(tablero, fo, co, fd, cd);
        assertEquals(expResult, resultadoObtenido);
        
        
    }
    
}
