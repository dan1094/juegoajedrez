/*
 * FideTest.java
 * JUnit based test
 *
 * Created on 17 de noviembre de 2007, 20:41
 */

package controller;

import junit.framework.*;
import model.partida.Partida;
import model.partida.Casilla;
import model.partida.Ficha;
import model.partida.Tablero;

/**
 *
 * @author Pablo
 */
public class FideTest extends TestCase {
    
    public FideTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    /**
     * Test of de_fide_a_modelo method, of class controller.Fide.
     */
    public void testDe_fide_a_modelo_Alfil() {
        System.out.println("de_fide_a_modelo");
        Fide instance = new Fide();
        
        Tablero tablero = new Tablero(1);
        Partida partida = new Partida(1,true,tablero,true,true);
        tablero = tablero.vacio(partida);
        
        int fo = 0;
        int co = 2;
        int fd = 4;
        int cd = 4;
        
       Ficha ficha = partida.tablero.crear_ficha(5,true);
       partida.tablero.tablero[fo][co].setFicha(ficha);
        String coordenadas_fide = "Ae5";
        //Fide instance = new Fide();
        
        int[] expResult = new int[4];
        expResult[0]=0;
        expResult[1]=2;
        expResult[2]=3;
        expResult[3]=4;
        int[] result = instance.de_fide_a_modelo(partida, coordenadas_fide);
        
        System.out.println(result[0]);
        System.out.println(result[1]);
        System.out.println(result[2]);
        System.out.println(result[3]);
        assertEquals(expResult[0], result[0]);
        assertEquals(expResult[1], result[1]);
        assertEquals(expResult[2], result[2]);
        assertEquals(expResult[3], result[3]);
        
        
    }
    public void testDe_fide_a_modelo_Torre() {
        System.out.println("de_fide_a_modelo");
        Fide instance = new Fide();
        
        Tablero tablero = new Tablero(1);
        Partida partida = new Partida(1,true,tablero,true,true);
        tablero = tablero.vacio(partida);
        
        int fo = 1;
        int co = 2;
        int fd = 5;
        int cd = 2;
        
       Ficha ficha = partida.tablero.crear_ficha(3,true);
       partida.tablero.tablero[fo][co].setFicha(ficha);
        String coordenadas_fide = "Tc3";
        //Fide instance = new Fide();
        
        int[] expResult = new int[4];
        expResult[0]=fo;
        expResult[1]=co;
        expResult[2]=fd;
        expResult[3]=cd;
        int[] result = instance.de_fide_a_modelo(partida, coordenadas_fide);
        
        System.out.println(result[0]);
        System.out.println(result[1]);
        System.out.println(result[2]);
        System.out.println(result[3]);
        assertEquals(expResult[0], result[0]);
        assertEquals(expResult[1], result[1]);
        assertEquals(expResult[2], result[2]);
        assertEquals(expResult[3], result[3]);
        
        
    }
    
    public void testDe_fide_a_modelo_Peon() {
        System.out.println("de_fide_a_modelo");
        Fide instance = new Fide();
        
        Tablero tablero = new Tablero(1);
        Partida partida = new Partida(1,true,tablero,true,true);
        tablero = tablero.vacio(partida);
        
        int fo = 1;
        int co = 2;
        int fd = 3;
        int cd = 2;
        
       Ficha ficha = partida.tablero.crear_ficha(6,true);
       partida.tablero.tablero[fo][co].setFicha(ficha);
        String coordenadas_fide = "c5";
        //Fide instance = new Fide();
        
        int[] expResult = new int[4];
        expResult[0]=fo;
        expResult[1]=co;
        expResult[2]=fd;
        expResult[3]=cd;
        int[] result = instance.de_fide_a_modelo(partida, coordenadas_fide);
        
        System.out.println(result[0]);
        System.out.println(result[1]);
        System.out.println(result[2]);
        System.out.println(result[3]);
        assertEquals(expResult[0], result[0]);
        assertEquals(expResult[1], result[1]);
        assertEquals(expResult[2], result[2]);
        assertEquals(expResult[3], result[3]);
        
        
    }

    public void testDe_fide_a_modelo_Rey() {
        System.out.println("de_fide_a_modelo");
        Fide instance = new Fide();
        
        Tablero tablero = new Tablero(1);
        Partida partida = new Partida(1,true,tablero,true,true);
        tablero = tablero.vacio(partida);
        
        int fo = 0;
        int co = 0;
        int fd = 1;
        int cd = 1;
        
       Ficha ficha = partida.tablero.crear_ficha(1,true);
       partida.tablero.tablero[fo][co].setFicha(ficha);
        String coordenadas_fide = "Rb7";
        //Fide instance = new Fide();
        
        int[] expResult = new int[4];
        expResult[0]=fo;
        expResult[1]=co;
        expResult[2]=fd;
        expResult[3]=cd;
        int[] result = instance.de_fide_a_modelo(partida, coordenadas_fide);
        
        System.out.println(result[0]);
        System.out.println(result[1]);
        System.out.println(result[2]);
        System.out.println(result[3]);
        assertEquals(expResult[0], result[0]);
        assertEquals(expResult[1], result[1]);
        assertEquals(expResult[2], result[2]);
        assertEquals(expResult[3], result[3]);
        
        
    }
    
    public void testDe_fide_a_modelo_Dama() {
        System.out.println("de_fide_a_modelo");
        Fide instance = new Fide();
        
        Tablero tablero = new Tablero(1);
        Partida partida = new Partida(1,true,tablero,true,true);
        tablero = tablero.vacio(partida);
        
        int fo = 0;
        int co = 0;
        int fd = 4;
        int cd = 4;
        
       Ficha ficha = partida.tablero.crear_ficha(2,true);
       partida.tablero.tablero[fo][co].setFicha(ficha);
        String coordenadas_fide = "De4";
        //Fide instance = new Fide();
        
        int[] expResult = new int[4];
        expResult[0]=fo;
        expResult[1]=co;
        expResult[2]=fd;
        expResult[3]=cd;
        int[] result = instance.de_fide_a_modelo(partida, coordenadas_fide);
        
        System.out.println(result[0]);
        System.out.println(result[1]);
        System.out.println(result[2]);
        System.out.println(result[3]);
        assertEquals(expResult[0], result[0]);
        assertEquals(expResult[1], result[1]);
        assertEquals(expResult[2], result[2]);
        assertEquals(expResult[3], result[3]);
        
        
    }
    public void testDe_fide_a_modelo_Caballo() {
        System.out.println("de_fide_a_modelo");
        Fide instance = new Fide();
        
        Tablero tablero = new Tablero(1);
        Partida partida = new Partida(1,true,tablero,true,true);
        tablero = tablero.vacio(partida);
        
        int fo = 0;
        int co = 0;
        int fd = 2;
        int cd = 1;
        
       Ficha ficha = partida.tablero.crear_ficha(4,true);
       partida.tablero.tablero[fo][co].setFicha(ficha);
        String coordenadas_fide = "Cb6";
        //Fide instance = new Fide();
        
        int[] expResult = new int[4];
        expResult[0]=fo;
        expResult[1]=co;
        expResult[2]=fd;
        expResult[3]=cd;
        int[] result = instance.de_fide_a_modelo(partida, coordenadas_fide);
        
        System.out.println(result[0]);
        System.out.println(result[1]);
        System.out.println(result[2]);
        System.out.println(result[3]);
        assertEquals(expResult[0], result[0]);
        assertEquals(expResult[1], result[1]);
        assertEquals(expResult[2], result[2]);
        assertEquals(expResult[3], result[3]);
        
        
    }
   /*
    public void testIniciar_parser() {
        System.out.println("iniciar_parser");
        
        Partida partida = null;
        String traduciendo = "";
        Fide instance = new Fide();
        
        int[] expResult = null;
        int[] result = instance.iniciar_parser(partida, traduciendo);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of state1 method, of class controller.Fide.
     */
    
    
}
