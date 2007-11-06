/*
 * CaballoTest.java
 * JUnit based test
 *
 * Created on 23 de octubre de 2007, 21:36
 */

package model.partida;

import junit.framework.*;


public class CaballoTest extends TestCase {
    
    private Caballo caballo;
    private Tablero tablero;

    protected void setUp() throws Exception {
        caballo = new Caballo(true);
        tablero = new Tablero();
    }

    protected void tearDown() throws Exception {
        this.caballo=null;
        this.tablero = null;
    }

    /**
     * Test of movimiento_correspondiente_ficha method, of class clases.Caballo.
     */
    public void testMovimiento_correspondiente_ficha_Hacia_Delante() {
        System.out.println("movimiento_correspondiente_ficha");
        
        Tablero tablero = new Tablero(1);
        Partida partida = new Partida(1,true,tablero,true,true);
        
        tablero = tablero.inicializar_tablero_estandar(partida);
        
        int fo = 0;
        int co = 1;
        int fd = 2;
        int cd = 0;
        
        Ficha instance = partida.tablero.crear_ficha(4,true);
       partida.tablero.tablero[fo][co].setFicha(instance);
        boolean expResult = true;
        boolean result = partida.comprobar_movimiento(fo,co,fd,cd,tablero);
        
        assertEquals(expResult, result);
        
        
    }
    
    
    public void testMovimiento_correspondiente_ficha_Hacia_Atras() {
        System.out.println("movimiento_correspondiente_ficha");
        
        Tablero tablero = new Tablero(1);
        Partida partida = new Partida(1,true,tablero,true,true);
        
        tablero = tablero.inicializar_tablero_estandar(partida);
        
        int fo = 4;
        int co = 6;
        int fd = 2;
        int cd = 5;
        
        Ficha instance = partida.tablero.crear_ficha(4,true);
       partida.tablero.tablero[fo][co].setFicha(instance);
        boolean expResult = true;
        boolean result = partida.comprobar_movimiento(fo,co,fd,cd,tablero);
        
        assertEquals(expResult, result);
        
        
    }
    
    
     public void testMovimiento_correspondiente_ficha_No_Valido() {
        System.out.println("movimiento_correspondiente_ficha");
        
        Tablero tablero = new Tablero(1);
        Partida partida = new Partida(1,true,tablero,true,true);
        
        tablero = tablero.inicializar_tablero_estandar(partida);
        
        int fo = 4;
        int co = 6;
        int fd = 2;
        int cd = 6;
        
        Ficha instance = partida.tablero.crear_ficha(4,true);
       partida.tablero.tablero[fo][co].setFicha(instance);
        boolean expResult = false;
        boolean result = partida.comprobar_movimiento(fo,co,fd,cd,tablero);
        
        assertEquals(expResult, result);
        
        
    }
     public void testMovimiento_correspondiente_Comer() {
        System.out.println("movimiento_correspondiente_ficha");
        
        Tablero tablero = new Tablero(1);
        Partida partida = new Partida(1,true,tablero,true,true);
        tablero=tablero.vacio(partida);
        
        int fo = 0;
        int co = 1;
        int fd = 2;
        int cd = 2;
        
        //Ficha instance = new Alfil(0,true);
        Ficha instance = partida.tablero.crear_ficha(4,true);
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
        int co = 1;
        int fd = 2;
        int cd = 2;
        
        //Ficha instance = new Alfil(0,true);
        Ficha instance = partida.tablero.crear_ficha(4,true);
        //Ficha instance2 = new Torre(1,false);
        Ficha instance2 = partida.tablero.crear_ficha(3,true);
        
        partida.tablero.tablero[fo][co].setFicha(instance);
        partida.tablero.tablero[fd][cd].setFicha(instance2);
        
        boolean expResult = false;
        boolean result = partida.comprobar_movimiento(fo,co,fd,cd,tablero);
        assertEquals(expResult, result);
        
        
    }
    
}
