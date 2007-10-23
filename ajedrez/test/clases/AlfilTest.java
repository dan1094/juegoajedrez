/*
 * AlfilTest.java
 * JUnit based test
 *
 * Created on 23 de octubre de 2007, 22:09
 */

package clases;

import junit.framework.*;

/**
 *
 * @author Eduardo
 */
public class AlfilTest extends TestCase {
    
    private Alfil alfil;
    private Tablero tablero;

    protected void setUp() throws Exception {
        alfil = new Alfil(0,true);
        tablero = new Tablero();
    }

    protected void tearDown() throws Exception {
        this.alfil=null;
        this.tablero = null;
    }

    /**
     * Test of movimiento_correspondiente_ficha method, of class clases.Alfil.
     */
    public void testMovimiento_correspondiente_ficha() {
        System.out.println("movimiento_correspondiente_ficha");
        
        Tablero tablero = new Tablero(1);
        Partida partida = new Partida(1,true,tablero,true,true);
        
        int fo = 0;
        int co = 2;
        int fd = 1;
        int cd = 1;
        
        Ficha instance = new Alfil(0,false);
        instance = tablero.crear_ficha(5,false,0);
        
        boolean expResult = true;
        boolean result = instance.movimiento_correspondiente_ficha(tablero, fo, co, fd, cd);
        assertEquals(expResult, result);
        
        
    }
    
}
