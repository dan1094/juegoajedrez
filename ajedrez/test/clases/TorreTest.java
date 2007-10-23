/*
 * TorreTest.java
 * JUnit based test
 *
 * Created on 23 de octubre de 2007, 21:50
 */

package clases;

import junit.framework.*;

/**
 *
 * @author Eduardo
 */
public class TorreTest extends TestCase {
    
    private Torre torre;
    private Tablero tablero;

    protected void setUp() throws Exception {
        torre = new Torre(0,true);
        tablero = new Tablero();
    }

    protected void tearDown() throws Exception {
        this.torre=null;
        this.tablero = null;
    }

    /**
     * Test of movimiento_correspondiente_ficha method, of class clases.Torre.
     */
    public void testMovimiento_vertical_torre() {
        System.out.println("movimiento_vertical_torre");
        
        Tablero tablero = new Tablero(1);
        Partida partida = new Partida(1,true,tablero,true,true);
        
        int fo = 0;
        int co = 1;
        int fd = 0;
        int cd = 0;
        
        Ficha instance = new Torre(0,false);
        instance = tablero.crear_ficha(3,false,0);
        
        boolean expResult = true;
        boolean result = instance.movimiento_correspondiente_ficha(tablero, fo, co, fd, cd);
        assertEquals(expResult, result);
        
        
    }
    
    public void testMovimiento_horizontal_torre() {
        System.out.println("movimiento_horizontal_torre");
        
        Tablero tablero = new Tablero(1);
        Partida partida = new Partida(1,true,tablero,true,true);
        
        int fo = 0;
        int co = 0;
        int fd = 0;
        int cd = 1;
        
        Ficha instance = new Torre(0,false);
        instance = tablero.crear_ficha(3,false,0);
        
        boolean expResult = true;
        boolean result = instance.movimiento_correspondiente_ficha(tablero, fo, co, fd, cd);
        assertEquals(expResult, result);
        
        
    }
}
