/*
 * ReyTest.java
 * JUnit based test
 *
 * Created on 23 de octubre de 2007, 22:29
 */

package TestModelPartida;

import junit.framework.*;
import model.partida.*;

/**
 *
 * @author Eduardo
 */
public class ReyTest extends TestCase {
    
    private Rey rey;
    private Tablero tablero;

    protected void setUp() throws Exception {
        rey = new Rey(true);
        tablero = new Tablero();
    }

    protected void tearDown() throws Exception {
        this.rey=null;
        this.tablero = null;
    }

  

   public static Test suite(){
        return new TestSuite(ReyTest.class);
    }

    /**
     * Test of movimiento_correspondiente_ficha method, of class clases.Rey.
     */
    public void testMovimiento_Rey_Vertical() {
        System.out.println("movimiento_vertical_rey");
        
        Tablero tablero = new Tablero(1);
        Partida partida = new Partida(1,true,tablero,true,true);
        tablero = tablero.vacio(partida);
        
        int fo = 0;
        int co = 4;
        int fd = 1;
        int cd = 4;
        
        Ficha instance = partida.tablero.crear_ficha(1,true);
       partida.tablero.tablero[fo][co].setFicha(instance);
        boolean expResult = true;
        boolean result = partida.comprobar_movimiento(fo,co,fd,cd,tablero);
        assertEquals(expResult, result);
    }
    
    public void testMovimiento_Rey_Horizontal() {
        System.out.println("movimiento_horizontal_rey");
        
        Tablero tablero = new Tablero(1);
        Partida partida = new Partida(1,true,tablero,true,true);
        tablero = tablero.vacio(partida);
        
        int fo = 0;
        int co = 4;
        int fd = 0;
        int cd = 3;
        
        Ficha instance = partida.tablero.crear_ficha(1,true);
       partida.tablero.tablero[fo][co].setFicha(instance);
        boolean expResult = true;
        boolean result = partida.comprobar_movimiento(fo,co,fd,cd,tablero);
        assertEquals(expResult, result);
    }
     public void testMovimiento_Rey_Oblicuo() {
        System.out.println("movimiento_horizontal_rey");
        
        Tablero tablero = new Tablero(1);
        Partida partida = new Partida(1,true,tablero,true,true);
        tablero = tablero.vacio(partida);
        
        int fo = 0;
        int co = 4;
        int fd = 1;
        int cd = 5;
        
        Ficha instance = partida.tablero.crear_ficha(1,true);
        partida.tablero.tablero[fo][co].setFicha(instance);
        boolean expResult = true;
        boolean result = partida.comprobar_movimiento(fo,co,fd,cd,tablero);
        assertEquals(expResult, result);
    }

    public void testMovimiento_Rey_No_Valido() {
        System.out.println("movimiento_rey_no_valido");
        
        Tablero tablero = new Tablero(1);
        Partida partida = new Partida(1,true,tablero,true,true);
        tablero = tablero.vacio(partida);
        
        int fo = 0;
        int co = 4;
        int fd = 0;
        int cd = 7;
        
        Ficha instance = partida.tablero.crear_ficha(1,true);
       partida.tablero.tablero[fo][co].setFicha(instance);
        boolean expResult = false;
        boolean result = partida.comprobar_movimiento(fo,co,fd,cd,tablero);
        assertEquals(expResult, result);
    }

    public void testMovimiento_Rey_No_Comer_Mismo_Color() {
        System.out.println("movimiento_correspondiente_ficha");
        
        Tablero tablero = new Tablero(1);
        Partida partida = new Partida(1,true,tablero,true,true);
        tablero=tablero.vacio(partida);
        
        int fo = 0;
        int co = 2;
        int fd = 0;
        int cd = 3;
        
        //Ficha instance = new Alfil(0,true);
        Ficha instance = partida.tablero.crear_ficha(1,true);
        //Ficha instance2 = new Torre(1,false);
        Ficha instance2 = partida.tablero.crear_ficha(3,true);
        
        partida.tablero.tablero[fo][co].setFicha(instance);
        partida.tablero.tablero[fd][cd].setFicha(instance2);
        
        boolean expResult = false;
        boolean result = partida.comprobar_movimiento(fo,co,fd,cd,tablero);
        assertEquals(expResult, result);
        
        
    }
     public void testMovimiento_Rey_Comer_Horizontal() {
        System.out.println("movimiento_correspondiente_ficha");
        
        Tablero tablero = new Tablero(1);
        Partida partida = new Partida(1,true,tablero,true,true);
        tablero=tablero.vacio(partida);
        
        int fo = 0;
        int co = 2;
        int fd = 0;
        int cd = 3;
        
        //Ficha instance = new Alfil(0,true);
        Ficha instance = partida.tablero.crear_ficha(1,true);
        //Ficha instance2 = new Torre(1,false);
        Ficha instance2 = partida.tablero.crear_ficha(3,false);
        
        partida.tablero.tablero[fo][co].setFicha(instance);
        partida.tablero.tablero[fd][cd].setFicha(instance2);
        
        boolean expResult = true;
        boolean result = partida.comprobar_movimiento(fo,co,fd,cd,tablero);
        assertEquals(expResult, result);
        
        
    }
    public void testMovimiento_Rey_Comer_Vertical() {
        System.out.println("movimiento_correspondiente_ficha");
        
        Tablero tablero = new Tablero(1);
        Partida partida = new Partida(1,true,tablero,true,true);
        tablero=tablero.vacio(partida);
        
        int fo = 0;
        int co = 2;
        int fd = 1;
        int cd = 2;
        
        //Ficha instance = new Alfil(0,true);
        Ficha instance = partida.tablero.crear_ficha(1,true);
        //Ficha instance2 = new Torre(1,false);
        Ficha instance2 = partida.tablero.crear_ficha(3,false);
        
        partida.tablero.tablero[fo][co].setFicha(instance);
        partida.tablero.tablero[fd][cd].setFicha(instance2);
        
        boolean expResult = true;
        boolean result = partida.comprobar_movimiento(fo,co,fd,cd,tablero);
        assertEquals(expResult, result);
        
        
    }
    public void testMovimiento_Rey_Comer_Oblicuo() {
        System.out.println("movimiento_correspondiente_ficha");
        
        Tablero tablero = new Tablero(1);
        Partida partida = new Partida(1,true,tablero,true,true);
        tablero=tablero.vacio(partida);
        
        int fo = 2;
        int co = 2;
        int fd = 3;
        int cd = 3;
        
        //Ficha instance = new Alfil(0,true);
        Ficha instance = partida.tablero.crear_ficha(1,true);
        //Ficha instance2 = new Torre(1,false);
        Ficha instance2 = partida.tablero.crear_ficha(3,false);
        
        partida.tablero.tablero[fo][co].setFicha(instance);
        partida.tablero.tablero[fd][cd].setFicha(instance2);
        
        boolean expResult = true;
        boolean result = partida.comprobar_movimiento(fo,co,fd,cd,tablero);
        assertEquals(expResult, result);
        
        
    }
}
