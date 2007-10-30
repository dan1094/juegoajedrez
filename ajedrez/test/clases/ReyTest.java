/*
 * ReyTest.java
 * JUnit based test
 *
 * Created on 23 de octubre de 2007, 22:29
 */

package clases;

import junit.framework.*;

/**
 *
 * @author Eduardo
 */
public class ReyTest extends TestCase {
    
    private Rey rey;
    private Tablero tablero;

    protected void setUp() throws Exception {
        rey = new Rey(0,true);
        tablero = new Tablero();
    }

    protected void tearDown() throws Exception {
        this.rey=null;
        this.tablero = null;
    }

  

   

    /**
     * Test of movimiento_correspondiente_ficha method, of class clases.Rey.
     */
    public void testMovimiento_vertical_rey() {
        System.out.println("movimiento_vertical_rey");
        
        Tablero tablero = new Tablero(1);
        Partida partida = new Partida(1,true,tablero,true,true);
        tablero = tablero.vacio(partida);
        
        int fo = 0;
        int co = 4;
        int fd = 1;
        int cd = 4;
        
        Ficha instance = new Rey(0,false);
        instance = tablero.crear_ficha(1,false,0);
        
        boolean expResult = true;
        boolean result = instance.movimiento_correspondiente_ficha(tablero, fo, co, fd, cd);
        assertEquals(expResult, result);
    }
    
    public void testMovimiento_horizontal_rey() {
        System.out.println("movimiento_horizontal_rey");
        
        Tablero tablero = new Tablero(1);
        Partida partida = new Partida(1,true,tablero,true,true);
        tablero = tablero.vacio(partida);
        
        int fo = 0;
        int co = 4;
        int fd = 0;
        int cd = 3;
        
        Ficha instance = new Rey(0,false);
        instance = tablero.crear_ficha(1,false,0);
        
        boolean expResult = true;
        boolean result = instance.movimiento_correspondiente_ficha(tablero, fo, co, fd, cd);
        assertEquals(expResult, result);
    }

    public void testMovimiento_rey_no_valido() {
        System.out.println("movimiento_rey_no_valido");
        
        Tablero tablero = new Tablero(1);
        Partida partida = new Partida(1,true,tablero,true,true);
        tablero = tablero.vacio(partida);
        
        int fo = 0;
        int co = 4;
        int fd = 0;
        int cd = 7;
        
        Ficha instance = new Rey(0,false);
        instance = tablero.crear_ficha(1,false,0);
        
        boolean expResult = false;
        boolean result = instance.movimiento_correspondiente_ficha(tablero, fo, co, fd, cd);
        assertEquals(expResult, result);
    }

    /**
     * Test of enroque method, of class clases.Rey.
     */
    public void testEnroque() {
        System.out.println("enroque");
        
        Tablero tablero = null;
        int fo = 0;
        int co = 0;
        int fd = 0;
        int cd = 0;
        boolean tipo_enroque = true;
        Rey instance = null;
        
        instance.enroque(tablero, fo, co, fd, cd, tipo_enroque);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of camino_libre method, of class clases.Rey.
     */
    public void testCamino_libre() {
        System.out.println("camino_libre");
        
        Tablero tablero = null;
        int fo = 0;
        int co = 0;
        int fd = 0;
        int cd = 0;
        boolean tipo_enroque = true;
        Rey instance = null;
        
        boolean expResult = true;
        boolean result = instance.camino_libre(tablero, fo, co, fd, cd, tipo_enroque);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
