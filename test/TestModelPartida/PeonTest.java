/*
 * PeonTest.java
 * JUnit based test
 *
 * Created on 16 de octubre de 2007, 16:10
 */

package TestModelPartida;

import junit.framework.*;
import model.partida.*;

/**
 *
 * @author Administrador
 */
public class PeonTest extends TestCase {
    
    private Peon peon;
    private Tablero tablero;
    
     
    
    protected void setUp() throws Exception {
        peon = new Peon(true);
        tablero = new Tablero();
        
    }

    protected void tearDown() throws Exception {
        this.peon=null;
        this.tablero = null;
    }

    public static Test suite(){
        return new TestSuite(PeonTest.class);
    }
    /**
     * Test of movimiento_correspondiente_ficha method, of class clases.Peon.
     */
    public void testMovimiento_sencillo_peon() {
        System.out.println("movimiento_sencillo_peon");
        
        Tablero tablero = new Tablero(1);
        Partida partida = new Partida(1,true,tablero,true,true);
        
       
        tablero = tablero.vacio(partida);
        
        int fo = 1;
        int co = 1;
        int fd = 2;
        int cd = 1;
        Ficha instance = partida.tablero.crear_ficha(6,true);
        partida.tablero.tablero[fo][co].setFicha(instance);
        boolean expResult = true;
        boolean resultadoObtenido = partida.comprobar_movimiento(fo,co,fd,cd,tablero);
        assertEquals(expResult, resultadoObtenido);
        
        
    }
    
    public void testMovimiento_doble_peon() {
        System.out.println("movimiento_doble_peon");
        
        Tablero tablero = new Tablero(1);
        Partida partida = new Partida(1,true,tablero,true,true);
        
        tablero = tablero.vacio(partida);
        
        int fo = 1;
        int co = 1;
        int fd = 3;
        int cd = 1;
        
        Ficha instance = partida.tablero.crear_ficha(6,true);
        partida.tablero.tablero[fo][co].setFicha(instance);
        boolean expResult = true;
        boolean resultadoObtenido = partida.comprobar_movimiento(fo,co,fd,cd,tablero);
        assertEquals(expResult, resultadoObtenido);
        
        
    }
    
    
     public void testMovimiento_Peon_No_Valido_Vertical() {
        System.out.println("movimiento_doble_peon");
        
        Tablero tablero = new Tablero(1);
        Partida partida = new Partida(1,true,tablero,true,true);
        
        tablero = tablero.inicializar_tablero_estandar(partida);
        
        int fo = 1;
        int co = 1;
        int fd = 4;
        int cd = 1;
        
        Ficha instance = partida.tablero.crear_ficha(6,true);
        partida.tablero.tablero[fo][co].setFicha(instance);
        boolean expResult = false;
        boolean resultadoObtenido = partida.comprobar_movimiento(fo,co,fd,cd,tablero);
        assertEquals(expResult, resultadoObtenido);
        
        
    }
     
     public void testMovimiento_Peon_No_Valido_Horizontal() {
        System.out.println("movimiento_doble_peon");
        
        Tablero tablero = new Tablero(1);
        Partida partida = new Partida(1,true,tablero,true,true);
        
        tablero = tablero.inicializar_tablero_estandar(partida);
        
        int fo = 1;
        int co = 1;
        int fd = 1;
        int cd = 2;
        
        Ficha instance = partida.tablero.crear_ficha(6,true);
        partida.tablero.tablero[fo][co].setFicha(instance);
        boolean expResult = false;
        boolean resultadoObtenido = partida.comprobar_movimiento(fo,co,fd,cd,tablero);
        assertEquals(expResult, resultadoObtenido);
        
        
    }
    
    public void testMovimiento_Peon_No_Comer_Mismo_Color() {
        System.out.println("movimiento_correspondiente_ficha");
        
        Tablero tablero = new Tablero(1);
        Partida partida = new Partida(1,true,tablero,true,true);
        tablero=tablero.vacio(partida);
        
        int fo = 1;
        int co = 1;
        int fd = 2;
        int cd = 0;
        
        //Ficha instance = new Alfil(0,true);
        Ficha instance = partida.tablero.crear_ficha(6,true);
        //Ficha instance2 = new Torre(1,false);
        Ficha instance2 = partida.tablero.crear_ficha(3,true);
        
        partida.tablero.tablero[fo][co].setFicha(instance);
        partida.tablero.tablero[fd][cd].setFicha(instance2);
        
        boolean expResult = false;
        boolean result = partida.comprobar_movimiento(fo,co,fd,cd,tablero);
        assertEquals(expResult, result);
        
        
    }
    public void testMovimiento_Peon_Comer() {
        System.out.println("movimiento_correspondiente_ficha");
        
        Tablero tablero = new Tablero(1);
        Partida partida = new Partida(1,true,tablero,true,true);
        tablero=tablero.vacio(partida);
        
        int fo = 1;
        int co = 1;
        int fd = 2;
        int cd = 0;
        
        //Ficha instance = new Alfil(0,true);
        Ficha instance = partida.tablero.crear_ficha(6,true);
        //Ficha instance2 = new Torre(1,false);
        Ficha instance2 = partida.tablero.crear_ficha(3,false);
        
        partida.tablero.tablero[fo][co].setFicha(instance);
        partida.tablero.tablero[fd][cd].setFicha(instance2);
        
        boolean expResult = true;
        boolean result = partida.comprobar_movimiento(fo,co,fd,cd,tablero);
        assertEquals(expResult, result);
        
        
    }
}
