/*
 * FideTest.java
 * JUnit based test
 *
 * Created on 17 de noviembre de 2007, 20:41
 */

package controller;

import junit.framework.*;
import model.partida.Ficha;
import model.partida.Partida;
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
        
        int[] expResult = null;
        int[] result = instance.iniciar_parser(partida);
        assertEquals(expResult, result);
        
        System.out.println(result[0]);
        System.out.println(result[1]);
        System.out.println(result[2]);
        System.out.println(result[3]);
        assertEquals(expResult[0], result[0]);
        assertEquals(expResult[1], result[1]);
        assertEquals(expResult[2], result[2]);
        assertEquals(expResult[3], result[3]);
        
        
        int[] expResult = null;
        int[] result = instance.state1(partida, c );
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    public void testDe_fide_a_modelo_Torre() {
        System.out.println("de_fide_a_modelo");
        Fide instance = new Fide();
        
        int[] expResult = null;
        int[] result = instance.state2(partida,  tipo_ficha);
        assertEquals(expResult, result);
        
        int fo = 1;
        int co = 2;
        int fd = 5;
        int cd = 2;
        
       Ficha ficha = partida.tablero.crear_ficha(3,true);
       partida.tablero.tablero[fo][co].setFicha(ficha);
        String coordenadas_fide = "Tc3";
        //Fide instance = new Fide();
        
        int[] expResult = null;
        int[] result = instance.state3(partida, c, tipo_ficha);
        assertEquals(expResult, result);
        
        System.out.println(result[0]);
        System.out.println(result[1]);
        System.out.println(result[2]);
        System.out.println(result[3]);
        assertEquals(expResult[0], result[0]);
        assertEquals(expResult[1], result[1]);
        assertEquals(expResult[2], result[2]);
        assertEquals(expResult[3], result[3]);
        
        
        int[] expResult = null;
        int[] result = instance.state4(partida, colDestino, c, tipo_ficha);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    public void testDe_fide_a_modelo_Peon() {
        System.out.println("de_fide_a_modelo");
        Fide instance = new Fide();
        
        int[] expResult = null;
        int[] result = instance.state5(partida, c, tipo_ficha);
        assertEquals(expResult, result);
        
        int fo = 1;
        int co = 2;
        int fd = 3;
        int cd = 2;
        
       Ficha ficha = partida.tablero.crear_ficha(6,true);
       partida.tablero.tablero[fo][co].setFicha(ficha);
        String coordenadas_fide = "c5";
        //Fide instance = new Fide();
        
        int[] expResult = null;
        int[] result = instance.state6(partida, colDestino, c_sig, tipo_ficha);
        assertEquals(expResult, result);
        
        System.out.println(result[0]);
        System.out.println(result[1]);
        System.out.println(result[2]);
        System.out.println(result[3]);
        assertEquals(expResult[0], result[0]);
        assertEquals(expResult[1], result[1]);
        assertEquals(expResult[2], result[2]);
        assertEquals(expResult[3], result[3]);
        
        
        int[] expResult = null;
        int[] result = instance.state7(partida, colOrigen, tipo_ficha);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public void testDe_fide_a_modelo_Rey() {
        System.out.println("de_fide_a_modelo");
        Fide instance = new Fide();
        
        int[] expResult = null;
        int[] result = instance.state8(partida, colOrigen, c_sig, tipo_ficha);
        assertEquals(expResult, result);
        
        int fo = 0;
        int co = 0;
        int fd = 1;
        int cd = 1;
        
       Ficha ficha = partida.tablero.crear_ficha(1,true);
       partida.tablero.tablero[fo][co].setFicha(ficha);
        String coordenadas_fide = "Rb7";
        //Fide instance = new Fide();
        
        int[] expResult = null;
        int[] result = instance.state9(partida, c, colOrigen, tipo_ficha);
        assertEquals(expResult, result);
        
        System.out.println(result[0]);
        System.out.println(result[1]);
        System.out.println(result[2]);
        System.out.println(result[3]);
        assertEquals(expResult[0], result[0]);
        assertEquals(expResult[1], result[1]);
        assertEquals(expResult[2], result[2]);
        assertEquals(expResult[3], result[3]);
        
        
        int[] expResult = null;
        int[] result = instance.state10(partida, c, colOrigen, colDestino, tipo_ficha);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    public void testDe_fide_a_modelo_Dama() {
        System.out.println("de_fide_a_modelo");
        Fide instance = new Fide();
        
        int[] expResult = null;
        int[] result = instance.state11(partida, colOrigen, c, colDestino, tipo_ficha);
        assertEquals(expResult, result);
        
        int fo = 0;
        int co = 0;
        int fd = 4;
        int cd = 4;
        
       Ficha ficha = partida.tablero.crear_ficha(2,true);
       partida.tablero.tablero[fo][co].setFicha(ficha);
        String coordenadas_fide = "De4";
        //Fide instance = new Fide();
        
        int[] expResult = null;
        int[] result = instance.state12(partida, c, tipo_ficha);
        assertEquals(expResult, result);
        
        System.out.println(result[0]);
        System.out.println(result[1]);
        System.out.println(result[2]);
        System.out.println(result[3]);
        assertEquals(expResult[0], result[0]);
        assertEquals(expResult[1], result[1]);
        assertEquals(expResult[2], result[2]);
        assertEquals(expResult[3], result[3]);
        
        
        int[] expResult = null;
        int[] result = instance.state13(partida, filaOrigen, tipo_ficha);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    public void testDe_fide_a_modelo_Caballo() {
        System.out.println("de_fide_a_modelo");
        Fide instance = new Fide();
        
        int[] expResult = null;
        int[] result = instance.state14(partida, c, filaOrigen, tipo_ficha);
        assertEquals(expResult, result);
        
        int fo = 0;
        int co = 0;
        int fd = 2;
        int cd = 1;
        
       Ficha ficha = partida.tablero.crear_ficha(4,true);
       partida.tablero.tablero[fo][co].setFicha(ficha);
        String coordenadas_fide = "Cb6";
        //Fide instance = new Fide();
        
        int[] expResult = null;
        int[] result = instance.state15(partida, filaOrigen, c, tipo_ficha);
        assertEquals(expResult, result);
        
        System.out.println(result[0]);
        System.out.println(result[1]);
        System.out.println(result[2]);
        System.out.println(result[3]);
        assertEquals(expResult[0], result[0]);
        assertEquals(expResult[1], result[1]);
        assertEquals(expResult[2], result[2]);
        assertEquals(expResult[3], result[3]);
        
        
        int[] expResult = null;
        int[] result = instance.state16(partida, c, filaOrigen, colDestino, tipo_ficha);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
   /*
    public void testIniciar_parser() {
        System.out.println("iniciar_parser");
        
        Partida partida = null;
        String traduciendo = "";
        Fide instance = new Fide();
        
        int[] expResult = null;
        int[] result = instance.state17(partida, filaOrigen, c, colDestino, tipo_ficha);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of state1 method, of class controller.Fide.
     */
    public void testState18() {
        System.out.println("state18");
        
        Partida partida = null;
        String traduciendo = "";
        Fide instance = new Fide();
        
        int[] expResult = null;
        int[] result = instance.state18(partida );
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of state19 method, of class controller.Fide.
     */
    public void testState19() {
        System.out.println("state19");
        
        Partida partida = null;
        String traduciendo = "";
        Fide instance = new Fide();
        
        int[] expResult = null;
        int[] result = instance.state19(partida );
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of state20 method, of class controller.Fide.
     */
    public void testState20() {
        System.out.println("state20");
        
        Partida partida = null;
        String traduciendo = "";
        Fide instance = new Fide();
        
        int[] expResult = null;
        int[] result = instance.state20(partida );
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of state21 method, of class controller.Fide.
     */
    public void testState21() {
        System.out.println("state21");
        
        Partida partida = null;
        String traduciendo = "";
        Fide instance = new Fide();
        
        int[] expResult = null;
        int[] result = instance.state21(partida );
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of state22 method, of class controller.Fide.
     */
    public void testState22() {
        System.out.println("state22");
        
        Partida partida = null;
        char c = ' ';
        String traduciendo = "";
        Fide instance = new Fide();
        
        int[] expResult = null;
        int[] result = instance.state22(partida,c );
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of state23 method, of class controller.Fide.
     */
    public void testState23() {
        System.out.println("state23");
        
        Partida partida = null;
        int colDestino = 0;
        char c = ' ';
        String traduciendo = "";
        Fide instance = new Fide();
        
        int[] expResult = null;
        int[] result = instance.state23(partida, colDestino, c );
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of state24 method, of class controller.Fide.
     */
    public void testState24() {
        System.out.println("state24");
        
        Partida partida = null;
        int columna = 0;
        String traduciendo = "";
        Fide instance = new Fide();
        
        int[] expResult = null;
        int[] result = instance.state24(partida, columna );
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of state25 method, of class controller.Fide.
     */
    public void testState25() {
        System.out.println("state25");
        
        Partida partida = null;
        int colOrigen = 0;
        char c = ' ';
        String traduciendo = "";
        Fide instance = new Fide();
        
        int[] expResult = null;
        int[] result = instance.state25(partida, colOrigen, c );
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of state26 method, of class controller.Fide.
     */
    public void testState26() {
        System.out.println("state26");
        
        Partida partida = null;
        char c = ' ';
        int colOrigen = 0;
        int colDestino = 0;
        String traduciendo = "";
        Fide instance = new Fide();
        
        int[] expResult = null;
        int[] result = instance.state26(partida, c, colOrigen, colDestino );
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarMovimiento4_6 method, of class controller.Fide.
     */
    public void testBuscarMovimiento4_6() {
        System.out.println("buscarMovimiento4_6");
        
        Partida partida = null;
        String tipo_ficha = "";
        int filaDestino = 0;
        int colDestino = 0;
        Fide instance = new Fide();
        
        int[] expResult = null;
        int[] result = instance.buscarMovimiento4_6(partida, tipo_ficha, filaDestino, colDestino);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarMovimiento10_11 method, of class controller.Fide.
     */
    public void testBuscarMovimiento10_11() {
        System.out.println("buscarMovimiento10_11");
        
        Partida partida = null;
        int cO = 0;
        int fD = 0;
        int cD = 0;
        String tipo_ficha = "";
        Fide instance = new Fide();
        
        int[] expResult = null;
        int[] result = instance.buscarMovimiento10_11(partida, cO, fD, cD, tipo_ficha);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarMovimiento17 method, of class controller.Fide.
     */
    public void testBuscarMovimiento17() {
        System.out.println("buscarMovimiento17");
        
        Partida partida = null;
        int filaOrigen = 0;
        int filaDestino = 0;
        int colDestino = 0;
        String tipo_ficha = "";
        Fide instance = new Fide();
        
        int[] expResult = null;
        int[] result = instance.buscarMovimiento17(partida, filaOrigen, filaDestino, colDestino, tipo_ficha);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarMovimiento16 method, of class controller.Fide.
     */
    public void testBuscarMovimiento16() {
        System.out.println("buscarMovimiento16");
        
        Partida partida = null;
        int filaOrigen = 0;
        int filaDestino = 0;
        int colDestino = 0;
        String tipo_ficha = "";
        Fide instance = new Fide();
        
        int[] expResult = null;
        int[] result = instance.buscarMovimiento16(partida, filaOrigen, filaDestino, colDestino, tipo_ficha);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of aniadir method, of class controller.Fide.
     */
    public void testAniadir() {
        System.out.println("aniadir");
        
        int filaO = 0;
        int colO = 0;
        int[][] fichas_validas = null;
        Fide instance = new Fide();
        
        int[][] expResult = null;
        int[][] result = instance.aniadir(filaO, colO, fichas_validas);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of correcto method, of class controller.Fide.
     */
    public void testCorrecto() {
        System.out.println("correcto");
        
        int[][] lista = null;
        Fide instance = new Fide();
        
        boolean expResult = true;
        boolean result = instance.correcto(lista);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of transformar method, of class controller.Fide.
     */
    public void testTransformar() {
        System.out.println("transformar");
        
        int[][] fichas = new int[2][1];
        fichas[0][0]=5;
        fichas[1][0]=2;
        
        int fD = 2;
        int cD = 7;
        Fide instance = new Fide();
        
        int[] expResult = new int[4];
        expResult[0]=5;
        expResult[1]=2;
        expResult[2]=2;
        expResult[3]=7;
        
        int[] result = instance.transformar(fichas, fD, cD);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of obtenerCaracter method, of class controller.Fide.
     */
    public void testObtenerCaracter() {
        System.out.println("obtenerCaracter");
        
        String traduciendo = "traduciendo";
        Fide instance = new Fide();
        
        char expResult = 't';
        char result = instance.obtenerCaracter();
        
        assertEquals(expResult, result);
             
    }

    /**
     * Test of asociarTipoficha method, of class controller.Fide.
     */
    public void testAsociarTipoficha() {
        System.out.println("asociarTipoficha");
        
        char c = 'T';
        Fide instance = new Fide();
        
        String expResult = "torre";
        String result = instance.asociarTipoficha(c);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of esMayuscula method, of class controller.Fide.
     */
    public void testEsMayuscula() {
        System.out.println("esMayuscula");
       
        char c1 = 'g';
        char c2 = '5';
        char c3 = 'T';
        Fide instance = new Fide();
        
        boolean expResult1 = false;
        boolean expResult2 = false;
        boolean expResult3 = true;
        
        boolean result1 = instance.esMayuscula(c1);
        boolean result2 = instance.esMayuscula(c2);
        boolean result3 = instance.esMayuscula(c3);
        
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        assertEquals(expResult3, result3);
    }

    /**
     * Test of esMinuscula method, of class controller.Fide.
     */
    public void testEsMinuscula() {
        System.out.println("esMinuscula");
        
        char c1 = 'g';
        char c2 = '5';
        char c3 = 'T';
        Fide instance = new Fide();
        
        boolean expResult1 = true;
        boolean expResult2 = false;
        boolean expResult3 = false;
        
        boolean result1 = instance.esMinuscula(c1);
        boolean result2 = instance.esMinuscula(c2);
        boolean result3 = instance.esMinuscula(c3);
        
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        assertEquals(expResult3, result3);
        
    }

    /**
     * Test of esNumero method, of class controller.Fide.
     */
    public void testEsNumero() {
        System.out.println("esNumero");
        
        char letra1 = '4';
        char letra2 = 'h';
        Fide instance = new Fide();
        
        boolean expResult1 = true;
        boolean expResult2 = false;
        boolean result1 = instance.esNumero(letra1);
        boolean result2 = instance.esNumero(letra2);
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        
    }

    
    
    /**
     * Test of buscarFichaMismaColumna method, of class controller.Fide.
     */
    public void testBuscarFichaMismaColumna() {
        System.out.println("buscarFichaMismaColumna");
        
        Partida partida = null;
        String tipo_ficha = "";
        int fila = 0;
        Fide instance = new Fide();
        
        int[] expResult = null;
        int[] result = instance.buscarFichaMismaColumna(partida, tipo_ficha, fila);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of inicializacion method, of class controller.Fide.
     */
    public void testInicializacion() {
        System.out.println("inicializacion");
        
        int[][] coordenadas = null;
        Fide instance = new Fide();
        
        int[][] expResult = null;
        int[][] result = instance.inicializacion(coordenadas);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of comprobarfin method, of class controller.Fide.
     */
    public void testComprobarfin() {
        System.out.println("comprobarfin");
        
        String trad1 = "fwef";
        String trad2 = "";
        Fide instance = new Fide();
        
        boolean expResult1 = false;
        boolean expResult2 = true;
        boolean result1 = instance.comprobarfin();
        boolean result2 = instance.comprobarfin();
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        
    }

    /**
     * Test of convertirFila method, of class controller.Fide.
     */
    public void testConvertirFila() {
        System.out.println("convertirFila");
        
        char a = '5';
        Fide instance = new Fide();
        
        int expResult = 3;
        int result = instance.convertirFila(a);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of convertirColumna method, of class controller.Fide.
     */
    public void testConvertirColumna() {
        System.out.println("convertirColumna");
        
        char a = 'f';
        Fide instance = new Fide();
        
        int expResult = 5;
        int result = instance.convertirColumna(a);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of enroqueCorto method, of class controller.Fide.
     */
    public void testEnroqueCorto() {
        System.out.println("enroqueCorto");
        
        Partida partida = null;
        Fide instance = new Fide();
        
        int[] expResult = null;
        int[] result = instance.enroqueCorto(partida);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enroqueLargo method, of class controller.Fide.
     */
    public void testEnroqueLargo() {
        System.out.println("enroqueLargo");
        
        Partida partida = null;
        Fide instance = new Fide();
        
        int[] expResult = null;
        int[] result = instance.enroqueLargo(partida);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hayFicha method, of class controller.Fide.
     */
    public void testHayFicha() {
        System.out.println("hayFicha");
        
        int[][] fichas = null;
        int i = 0;
        Fide instance = new Fide();
        
        boolean expResult = true;
        boolean result = instance.hayFicha(fichas, i);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarPeon method, of class controller.Fide.
     */
    public void testBuscarPeon() {
        System.out.println("buscarPeon");
        
        Partida partida = null;
        int colOrigen = 0;
        int filaDestino = 0;
        int colDestino = 0;
        Fide instance = new Fide();
        
        int[] expResult = null;
        int[] result = instance.buscarPeon(partida, colOrigen, filaDestino, colDestino);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of comprobar_movimiento method, of class controller.Fide.
     */
    public void testComprobar_movimiento() {
        System.out.println("comprobar_movimiento");
        
        int filaorigen = 0;
        int columnaorigen = 0;
        int filadestino = 0;
        int columnadestino = 0;
        Partida partida = null;
        Fide instance = new Fide();
        
        boolean expResult = true;
        boolean result = instance.comprobar_movimiento(filaorigen, columnaorigen, filadestino, columnadestino, partida);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    
}
