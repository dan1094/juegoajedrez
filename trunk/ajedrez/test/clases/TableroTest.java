/*
 * TableroTest.java
 * JUnit based test
 *
 * Created on 7 de octubre de 2007, 1:26
 */

package clases;

import junit.framework.*;

/**
 *
 * @author Pablo
 */
public class TableroTest extends TestCase {
    
    public TableroTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    /**
     * Test of inicializar_tablero method, of class clases.Tablero.
     */
    public void testInicializar_tablero() {
        System.out.println("inicializar_tablero");
        
        Tablero tablero = null;
        Tablero instance = new Tablero();
        
        Tablero expResult = null;
        Tablero result = instance.inicializar_tablero(tablero);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTurno method, of class clases.Tablero.
     */
    public void testSetTurno() {
        System.out.println("setTurno");
        
        boolean turno = true;
        Tablero instance = new Tablero();
        
        instance.setTurno(turno);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cambio_turno method, of class clases.Tablero.
     */
    public void testCambio_turno() {
        System.out.println("cambio_turno");
        
        Tablero instance = new Tablero();
        
        instance.cambio_turno();
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTurno method, of class clases.Tablero.
     */
    public void testGetTurno() {
        System.out.println("getTurno");
        
        Tablero instance = new Tablero();
        
        boolean expResult = true;
        boolean result = instance.getTurno();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCasilla method, of class clases.Tablero.
     */
    public void testGetCasilla() {
        System.out.println("getCasilla");
        
        int fila = 0;
        int columna = 0;
        Tablero instance = new Tablero();
        
        Casilla expResult = null;
        Casilla result = instance.getCasilla(fila, columna);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCasilla method, of class clases.Tablero.
     */
    public void testSetCasilla() {
        System.out.println("setCasilla");
        
        Casilla casilla = null;
        int fila = 0;
        int columna = 0;
        Tablero instance = new Tablero();
        
        instance.setCasilla(casilla, fila, columna);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mover method, of class clases.Tablero.
     */
    public void testMover() {
        System.out.println("mover");
        
        int filaorigen = 0;
        int columnaorigen = 0;
        int filadestino = 0;
        int columnadestino = 0;
        Tablero tablero = null;
        Tablero instance = new Tablero();
        
        boolean expResult = true;
        boolean result = instance.mover(filaorigen, columnaorigen, filadestino, columnadestino, tablero);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dentro_tablero method, of class clases.Tablero.
     */
    public void testDentro_tablero() {
        System.out.println("dentro_tablero");
        
        int fila = 0;
        int columna = 0;
        Tablero instance = new Tablero();
        
        boolean expResult = true;
        boolean result = instance.dentro_tablero(fila, columna);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of comprobar_movimiento method, of class clases.Tablero.
     */
    public void testComprobar_movimiento() {
        System.out.println("comprobar_movimiento");
        
        int filaorigen = 0;
        int columnaorigen = 0;
        int filadestino = 0;
        int columnadestino = 0;
        Tablero tablero = null;
        Tablero instance = new Tablero();
        
        boolean expResult = true;
        boolean result = instance.comprobar_movimiento(filaorigen, columnaorigen, filadestino, columnadestino, tablero);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ocupada_color method, of class clases.Tablero.
     */
    public void testOcupada_color() {
        System.out.println("ocupada_color");
        
        Tablero tablero = null;
        int fo = 0;
        int co = 0;
        Tablero instance = new Tablero();
        
        boolean expResult = true;
        boolean result = instance.ocupada_color(tablero, fo, co);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
