/*
 * CasillaTest.java
 * JUnit based test
 *
 * Created on 16 de octubre de 2007, 17:29
 */

package model.partida;

import junit.framework.*;

/**
 *
 * @author Administrador
 */
public class CasillaTest extends TestCase {
    
    private Casilla casilla;
    
    public CasillaTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
        
        this.casilla = new Casilla();
        
    }

    protected void tearDown() throws Exception {
        
        this.casilla = null;
    }

    /**
     * Test of getId_casilla method, of class clases.Casilla.
     */
    public void testGetId_casilla() {
        System.out.println("getId_casilla");
        
        Casilla instance = new Casilla();
        
        int expResult = 0;
        int result = this.casilla.getId_casilla(); //llama al metodo de la clase casilla
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setId_casilla method, of class clases.Casilla.
     */
    public void testSetId_casilla() {
        System.out.println("setId_casilla");
        
        int id_casilla = 0;
        Casilla instance = new Casilla();
        
        instance.setId_casilla(id_casilla);
        
        
    }

    /**
     * Test of getFicha method, of class clases.Casilla.
     */
    public void testGetFicha() {
        System.out.println("getFicha");
        
        Casilla instance = new Casilla();
        
        Ficha expResult = null;
        Ficha result = instance.getFicha();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setFicha method, of class clases.Casilla.
     */
    public void testSetFicha() {
        System.out.println("setFicha");
        
        Ficha ficha = null;
        Casilla instance = new Casilla();
        
        instance.setFicha(ficha);
        
    }

    /**
     * Test of getFila method, of class clases.Casilla.
     */
    public void testGetFila() {
        System.out.println("getFila");
        
        Casilla instance = new Casilla();
        
        int expResult = 0;
        int result = instance.getFila();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setFila method, of class clases.Casilla.
     */
    public void testSetFila() {
        System.out.println("setFila");
        
        int fila = 0;
        Casilla instance = new Casilla();
        
        instance.setFila(fila);
        
       
    }

    /**
     * Test of getColumna method, of class clases.Casilla.
     */
    public void testGetColumna() {
        System.out.println("getColumna");
        
        Casilla instance = new Casilla();
        
        int expResult = 0;
        int result = instance.getColumna();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setColumna method, of class clases.Casilla.
     */
    public void testSetColumna() {
        System.out.println("setColumna");
        
        int columna = 0;
        Casilla instance = new Casilla();
        
        instance.setColumna(columna);
        
        
    }

    /**
     * Test of getOcupada method, of class clases.Casilla.
     */
    public void testGetOcupada() {
        System.out.println("getOcupada");
        
        Casilla instance = new Casilla();
        
        boolean expResult = false;
        boolean result = instance.getOcupada();
        assertEquals(expResult, result);
        
        
    }
    
}
