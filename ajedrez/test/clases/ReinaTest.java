/*
 * ReinaTest.java
 * JUnit based test
 *
 * Created on 23 de octubre de 2007, 22:18
 */

package clases;

import junit.framework.*;

/**
 *
 * @author Eduardo
 */

public class ReinaTest extends TestCase {
    
    private Reina reina;
    private Tablero tablero;
    

    protected void setUp() throws Exception {
        reina = new Reina(0,true);
        tablero = new Tablero();
    }

    protected void tearDown() throws Exception {
        this.reina=null;
        this.tablero = null;
    }

    /**
     * Test of movimiento_correspondiente_ficha method, of class clases.Reina.
     */
    public void testMovimiento_vertical_reina() {
        System.out.println("movimiento_vertical_reina");
        
        Tablero tablero = new Tablero(1);
        Partida partida = new Partida(1,true,tablero,true,true);
        
        int fo = 0;
        int co = 3;
        int fd = 1;
        int cd = 3;
        
        Ficha instance = new Reina(0,false);
        instance = tablero.crear_ficha(2,false,0);
        
        boolean expResult = true;
        boolean result = instance.movimiento_correspondiente_ficha(tablero, fo, co, fd, cd);
        assertEquals(expResult, result);
    }
    
    
     public void testMovimiento_horizontal_reina() {
        System.out.println("movimiento_horizontal_reina");
        
        Tablero tablero = new Tablero(1);
        Partida partida = new Partida(1,true,tablero,true,true);
        
        int fo = 0;
        int co = 3;
        int fd = 0;
        int cd = 4;
        
        Ficha instance = new Reina(0,false);
        instance = tablero.crear_ficha(2,false,0);
        
        boolean expResult = true;
        boolean result = instance.movimiento_correspondiente_ficha(tablero, fo, co, fd, cd);
        assertEquals(expResult, result);
    }

    /**
     * Test of es_recto method, of class clases.Reina.
     */
    /*public void testEs_recto() {
        System.out.println("es_recto");
        
        int fo = 0;
        int co = 4;
        int fd = 1;
        int cd = 0;
        Reina instance = null;
        
        boolean expResult = true;
        boolean result = instance.es_recto(fo, co, fd, cd);
        assertEquals(expResult, result);
        
        
    }*/
    
}
