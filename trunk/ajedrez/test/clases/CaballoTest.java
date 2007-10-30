/*
 * CaballoTest.java
 * JUnit based test
 *
 * Created on 23 de octubre de 2007, 21:36
 */

package clases;

import junit.framework.*;

/**
 *
 * @author Eduardo
 */
public class CaballoTest extends TestCase {
    
    private Caballo caballo;
    private Tablero tablero;

    protected void setUp() throws Exception {
        caballo = new Caballo(0,true);
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
        
        Caballo instance = new Caballo(0,false);
        
        boolean expResult = true;
        boolean result = instance.movimiento_correspondiente_ficha(tablero, fo, co, fd, cd);
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
        
        Caballo instance = new Caballo(0,false);
        
        boolean expResult = true;
        boolean result = instance.movimiento_correspondiente_ficha(tablero, fo, co, fd, cd);
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
        
        Caballo instance = new Caballo(0,false);
        
        boolean expResult = false;
        boolean result = instance.movimiento_correspondiente_ficha(tablero, fo, co, fd, cd);
        assertEquals(expResult, result);
        
        
    }
    
}
