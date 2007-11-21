/*
 * AlfilTest.java
 * JUnit based test
 *
 * Created on 23 de octubre de 2007, 22:09
 */

package TestModelPartida;

import junit.framework.*;
import model.partida.*;


public class AlfilTest extends TestCase {
    
    private Alfil alfil;
    private Tablero tablero;

    protected void setUp() throws Exception {
        alfil = new Alfil(true);
        tablero = new Tablero();
    }

    protected void tearDown() throws Exception {
        this.alfil=null;
        this.tablero = null;
    }

     
    /**
     * Test of movimiento_correspondiente_ficha method, of class clases.Alfil.
     */
    public void testMovimiento_correspondiente_ficha_No_Valido() {
        System.out.println("movimiento_correspondiente_ficha");
        
        Tablero tablero = new Tablero(1);
        Partida partida = new Partida(1,true,tablero,true,true);
        tablero = tablero.vacio(partida);
        
        int fo = 0;
        int co = 2;
        int fd = 0;
        int cd = 4;
        
       Ficha instance = partida.tablero.crear_ficha(5,true);
       partida.tablero.tablero[fo][co].setFicha(instance);
        boolean expResult = false;
        boolean result = partida.comprobar_movimiento(fo,co,fd,cd,tablero);
        assertEquals(expResult, result);
        
        
    }
    public void testMovimiento_correspondiente_ficha_Hacia_Delante() {
        System.out.println("movimiento_correspondiente_ficha");
        
        Tablero tablero = new Tablero(1);
        Partida partida = new Partida(1,true,tablero,true,true);
        tablero = tablero.vacio(partida);
        
        int fo = 0;
        int co = 0;
        int fd = 1;
        int cd = 1;
        
        Ficha instance = partida.tablero.crear_ficha(5,true);
        partida.tablero.tablero[fo][co].setFicha(instance);
        boolean expResult = true;
        boolean result = partida.comprobar_movimiento(fo,co,fd,cd,tablero);

        assertEquals(expResult, result);
        
        
    }
    
    public void testMovimiento_correspondiente_ficha_Hacia_Atras() {
        System.out.println("movimiento_correspondiente_ficha");
        
        Tablero tablero = new Tablero(1);
        Partida partida = new Partida(1,true,tablero,true,true);
        tablero = tablero.vacio(partida);
        
        int fo = 5;
        int co = 2;
        int fd = 4;
        int cd = 1;
        
       Ficha instance = partida.tablero.crear_ficha(5,true);
        partida.tablero.tablero[fo][co].setFicha(instance);
        boolean expResult = true;
        boolean result = partida.comprobar_movimiento(fo,co,fd,cd,tablero);

        assertEquals(expResult, result);
            
    }
 
    public void testMovimiento_correspondiente_Comer() {
        System.out.println("movimiento_correspondiente_ficha");
        
        Tablero tablero = new Tablero(1);
        Partida partida = new Partida(1,true,tablero,true,true);
        tablero=tablero.vacio(partida);
        
        int fo = 0;
        int co = 2;
        int fd = 3;
        int cd = 5;
        
        //Ficha instance = new Alfil(0,true);
        Ficha instance = partida.tablero.crear_ficha(5,true);
        //Ficha instance2 = new Torre(1,false);
        Ficha instance2 = partida.tablero.crear_ficha(3,false);
        
        partida.tablero.tablero[fo][co].setFicha(instance);
        partida.tablero.tablero[fd][cd].setFicha(instance2);
        
        boolean expResult = true;
        boolean result = partida.comprobar_movimiento(fo,co,fd,cd,tablero);
        assertEquals(expResult, result);
        
        
    }
    public void testMovimiento_No_Comer_Mismo_Color() {
        System.out.println("movimiento_correspondiente_ficha");
        
        Tablero tablero = new Tablero(1);
        Partida partida = new Partida(1,true,tablero,true,true);
        tablero=tablero.vacio(partida);
        
        int fo = 0;
        int co = 2;
        int fd = 3;
        int cd = 5;
        
        //Ficha instance = new Alfil(0,true);
        Ficha instance = partida.tablero.crear_ficha(5,true);
        //Ficha instance2 = new Torre(1,false);
        Ficha instance2 = partida.tablero.crear_ficha(3,true);
        
        partida.tablero.tablero[fo][co].setFicha(instance);
        partida.tablero.tablero[fd][cd].setFicha(instance2);
        
        boolean expResult = false;
        boolean result = partida.comprobar_movimiento(fo,co,fd,cd,tablero);
        assertEquals(expResult, result);
        
        
    }
}
