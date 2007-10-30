/*
 * PeonTest.java
 * JUnit based test
 *
 * Created on 16 de octubre de 2007, 16:10
 */

package clases;

import junit.framework.*;

/**
 *
 * @author Administrador
 */
public class PeonTest extends TestCase {
    
    private Peon peon;
    private Tablero tablero;
    
     
    
    protected void setUp() throws Exception {
        peon = new Peon(0,true);
        tablero = new Tablero();
        
    }

    protected void tearDown() throws Exception {
        this.peon=null;
        this.tablero = null;
    }

    /**
     * Test of movimiento_correspondiente_ficha method, of class clases.Peon.
     */
    public void testMovimiento_sencillo_peon() {
        System.out.println("movimiento_sencillo_peon");
        
        Tablero tablero = new Tablero(1);
        Partida partida = new Partida(1,true,tablero,true,true);
        
        tablero = tablero.inicializar_tablero_estandar(partida);
        
        int fo = 1;
        int co = 1;
        int fd = 2;
        int cd = 1;
        
        Peon instance = new Peon(0,false);
        
        boolean expResult = true;
        boolean resultadoObtenido = instance.movimiento_correspondiente_ficha(tablero, fo, co, fd, cd);
        assertEquals(expResult, resultadoObtenido);
        
        
    }
    
    public void testMovimiento_doble_peon() {
        System.out.println("movimiento_doble_peon");
        
        Tablero tablero = new Tablero(1);
        Partida partida = new Partida(1,true,tablero,true,true);
        
        tablero = tablero.inicializar_tablero_estandar(partida);
        
        int fo = 1;
        int co = 1;
        int fd = 3;
        int cd = 1;
        
        Peon instance = new Peon(0,false);
        
        boolean expResult = true;
        boolean resultadoObtenido = instance.movimiento_correspondiente_ficha(tablero, fo, co, fd, cd);
        assertEquals(expResult, resultadoObtenido);
        
        
    }
    
    //FALTAN LOS TEST DE MOVER MAL!!
    
    /*public void testMovimiento_comer_peon() {
        System.out.println("movimiento_comer_peon");
        
        Tablero tablero = new Tablero(1);
        Partida partida = new Partida(1,true,tablero,true,true);
        
        tablero = tablero.inicializar_tablero_estandar(partida);
        
        int fo = 1;
        int co = 1;
        int fd = 2;
        int cd = 1;
        
        Peon instance = new Peon(0,false);
        
        boolean expResult = true;
        boolean resultadoObtenido = instance.movimiento_correspondiente_ficha(tablero, fo, co, fd, cd);
        assertEquals(expResult, resultadoObtenido);
        
        
    }*/
    
}
