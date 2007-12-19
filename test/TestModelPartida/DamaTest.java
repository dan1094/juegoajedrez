/*
 * ReinaTest.java
 * JUnit based test
 *
 * Created on 23 de octubre de 2007, 22:18
 */

package TestModelPartida;

import junit.framework.*;
import model.partida.*;

/**
 *
 * @author Eduardo
 */

public class DamaTest extends TestCase {
    
   // private Reina reina;
   // private Tablero tablero;
    

    protected void setUp() throws Exception {
     //   reina = new Reina(true);
     //   tablero = new Tablero();
    }

    protected void tearDown() throws Exception {
     //   this.reina=null;
     //   this.tablero = null;
    }

    
    public static Test suite(){
        return new TestSuite(DamaTest.class);
    }
    /**
     * Test of movimiento_correspondiente_ficha method, of class clases.Reina.
     */
    public void testMovimiento_Dama_vertical() {
        System.out.println("movimiento_vertical_reina");
        
        Tablero tablero = new Tablero(1);
        Partida partida = new Partida(1,true,tablero,true,true);
        tablero=tablero.vacio(partida);
        int fo = 0;
        int co = 3;
        int fd = 1;
        int cd = 3;
        
        Ficha instance = partida.tablero.crear_ficha(2,true);
       partida.tablero.tablero[fo][co].setFicha(instance);
        boolean expResult = true;
        boolean result = partida.comprobar_movimiento(fo,co,fd,cd,tablero);
        assertEquals(expResult, result);
    }
    
    
     public void testMovimiento_Dama_horizontal() {
        System.out.println("movimiento_horizontal_reina");
        
        Tablero tablero = new Tablero(1);
        Partida partida = new Partida(1,true,tablero,true,true);
        tablero=tablero.vacio(partida);
        
        int fo = 0;
        int co = 3;
        int fd = 0;
        int cd = 4;
        
        Ficha instance = partida.tablero.crear_ficha(2,true);
       partida.tablero.tablero[fo][co].setFicha(instance);
        boolean expResult = true;
        boolean result = partida.comprobar_movimiento(fo,co,fd,cd,tablero);
        assertEquals(expResult, result);
    }

     public void testMovimiento_Dama_oblicuo() {
        System.out.println("movimiento_oblicuo_reina");
        
        Tablero tablero = new Tablero(1);
        Partida partida = new Partida(1,true,tablero,true,true);
        tablero = tablero.vacio(partida);
        int fo = 4;
        int co = 1;
        int fd = 5;
        int cd = 2;
        
        Ficha instance = partida.tablero.crear_ficha(2,true);
       partida.tablero.tablero[fo][co].setFicha(instance);
        boolean expResult = true;
        boolean result = partida.comprobar_movimiento(fo,co,fd,cd,tablero);
        assertEquals(expResult, result);
    }
     
    /* public void testMovimiento_Dama_No_Valido() {
        System.out.println("movimiento_reina_No_Valido");
        
        Tablero tablero = new Tablero(1);
        Partida partida = new Partida(1,true,tablero,true,true);
        
        tablero = tablero.vacio(partida);
        
        int fo = 3;
        int co = 2;
        int fd = 0;
        int cd = 7;
        
        Ficha instance = partida.tablero.crear_ficha(2,true);
       partida.tablero.tablero[fo][co].setFicha(instance);
        boolean expResult = false;
        boolean result = partida.comprobar_movimiento(fo,co,fd,cd,tablero);
        assertEquals(expResult, result);
    }*/
    public void testMovimiento_Dama_No_Comer_Mismo_Color() {
        System.out.println("movimiento_correspondiente_ficha");
        
        Tablero tablero = new Tablero(1);
        Partida partida = new Partida(1,true,tablero,true,true);
        tablero=tablero.vacio(partida);
        
        int fo = 0;
        int co = 2;
        int fd = 3;
        int cd = 5;
        
        //Ficha instance = new Alfil(0,true);
        Ficha instance = partida.tablero.crear_ficha(2,true);
        //Ficha instance2 = new Torre(1,false);
        Ficha instance2 = partida.tablero.crear_ficha(3,true);
        
        partida.tablero.tablero[fo][co].setFicha(instance);
        partida.tablero.tablero[fd][cd].setFicha(instance2);
        
        boolean expResult = false;
        boolean result = partida.comprobar_movimiento(fo,co,fd,cd,tablero);
        assertEquals(expResult, result);
        
        
    }
    public void testMovimiento_Dama_Comer_Vertical() {
        System.out.println("movimiento_correspondiente_ficha");
        
        Tablero tablero = new Tablero(1);
        Partida partida = new Partida(1,true,tablero,true,true);
        tablero=tablero.vacio(partida);
        
        int fo = 2;
        int co = 2;
        int fd = 2;
        int cd = 5;
        
        //Ficha instance = new Alfil(0,true);
        Ficha instance = partida.tablero.crear_ficha(2,true);
        //Ficha instance2 = new Torre(1,false);
        Ficha instance2 = partida.tablero.crear_ficha(3,false);
        
        partida.tablero.tablero[fo][co].setFicha(instance);
        partida.tablero.tablero[fd][cd].setFicha(instance2);
        
        boolean expResult = true;
        boolean result = partida.comprobar_movimiento(fo,co,fd,cd,tablero);
        assertEquals(expResult, result);
        
        
    }
    
    public void testMovimiento_Dama_Comer_Horizontal() {
        System.out.println("movimiento_correspondiente_ficha");
        
        Tablero tablero = new Tablero(1);
        Partida partida = new Partida(1,true,tablero,true,true);
        tablero=tablero.vacio(partida);
        
        int fo = 2;
        int co = 2;
        int fd = 5;
        int cd = 2;
        
        //Ficha instance = new Alfil(0,true);
        Ficha instance = partida.tablero.crear_ficha(2,true);
        //Ficha instance2 = new Torre(1,false);
        Ficha instance2 = partida.tablero.crear_ficha(3,false);
        
        partida.tablero.tablero[fo][co].setFicha(instance);
        partida.tablero.tablero[fd][cd].setFicha(instance2);
        
        boolean expResult = true;
        boolean result = partida.comprobar_movimiento(fo,co,fd,cd,tablero);
        assertEquals(expResult, result);
        
        
    }
    public void testMovimiento_Comer_Oblicuo() {
        System.out.println("movimiento_correspondiente_ficha");
        
        Tablero tablero = new Tablero(1);
        Partida partida = new Partida(1,true,tablero,true,true);
        tablero=tablero.vacio(partida);
        
        int fo = 2;
        int co = 2;
        int fd = 5;
        int cd = 5;
        
        //Ficha instance = new Alfil(0,true);
        Ficha instance = partida.tablero.crear_ficha(2,true);
        //Ficha instance2 = new Torre(1,false);
        Ficha instance2 = partida.tablero.crear_ficha(3,false);
        
        partida.tablero.tablero[fo][co].setFicha(instance);
        partida.tablero.tablero[fd][cd].setFicha(instance2);
        
        boolean expResult = true;
        boolean result = partida.comprobar_movimiento(fo,co,fd,cd,tablero);
        assertEquals(expResult, result);
        
        
    }
}
