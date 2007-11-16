/*
 * FideTest.java
 * JUnit based test
 *
 * Created on 8 de noviembre de 2007, 12:05
 */

package controller;

import junit.framework.*;
import model.partida.Alfil;
import model.partida.Caballo;
import model.partida.Casilla;
import model.partida.Ficha;
import model.partida.Partida;
import model.partida.Peon;
import model.partida.Dama;
import model.partida.Rey;
import model.partida.Tablero;
import model.partida.Torre;

/**
 *
 * @author Pablo
 */
public class FideTest extends TestCase {
    
    public FideTest(String testName) {
        super(testName);
    }

    /**
     * Test of de_fide_a_modelo method, of class controller.Fide.
     */
    public void testDe_fide_a_modelo() {
        System.out.println("de_fide_a_modelo");
        //Partida partida = new Partida();
        String coordenadas_fide = "Dxf6";
        Fide instance = new Fide();
        
            Ficha peon_b_1 = new Peon(false);
            Ficha tor_b_1 = new Torre(false);
            Ficha cab_b_1 = new Caballo(false);
            Ficha alf_b_1 = new Alfil(false);
            Ficha reina_b = new Dama(false);
            Ficha rey_b = new Rey(false);

        //CREAMOS LAS FICHAS NEGRAS 
            Ficha peon_n_1 = new Peon(true);
            Ficha tor_n_1 = new Torre(true);
            Ficha cab_n_1 = new Caballo(true);
            Ficha alf_n_1 = new Alfil(true);
            Ficha reina_n = new Dama(true);
            Ficha rey_n = new Rey(true);
            
            Tablero tablero = new Tablero(0);
            Partida partida = new Partida();
            partida.setTablero(tablero);
            partida.setTurno(false);
            
            
            int m, n;
            for(m=0;m<8;m++)
                for(n=0;n<8;n++)
                {
                    partida.tablero.tablero[m][n] = new Casilla(null,m,n,false,false);
                }
            
            //Hay que meter las fichas a machete
                    partida.tablero.tablero[0][4].setFicha(rey_n);
                    partida.tablero.tablero[2][2].setFicha(alf_n_1);
                    partida.tablero.tablero[2][5].setFicha(cab_n_1);
                    partida.tablero.tablero[2][6].setFicha(reina_n);
                    partida.tablero.tablero[3][0].setFicha(peon_n_1);
                    partida.tablero.tablero[3][3].setFicha(peon_b_1);
                    partida.tablero.tablero[3][6].setFicha(cab_b_1);
                    partida.tablero.tablero[4][1].setFicha(tor_n_1);
                    partida.tablero.tablero[5][2].setFicha(reina_b);
                    partida.tablero.tablero[6][7].setFicha(tor_b_1);
                    partida.tablero.tablero[7][1].setFicha(alf_b_1);
                    partida.tablero.tablero[7][3].setFicha(rey_b);
                    
                    
        int[] expResult = new int[4];
        expResult[0]=5;
        expResult[1]=2;
        expResult[2]=2;
        expResult[3]=5;
                
        int[] result = instance.de_fide_a_modelo(partida, coordenadas_fide);
        assertEquals(expResult, result);
        
       
    }

    /*Prueba el metodo Obtener caracter. Lo que hace es coger el primer caracter y
     avanzar en el string al siguiente, para que quede referenciado para la siguiente
     iteración*/
    public void testObtenerCaracter() {
        System.out.println("obtenerCaracter");
        
        String traduciendo = "pablo";
        Fide instance = new Fide();
        String expTraduciendo="ablo";
        String resTraduciendo=traduciendo.substring(1);
        
        char expResult = 'p';
        char result = instance.obtenerCaracter(traduciendo);
        //Del char
        assertEquals(expResult, result);
        //Del String
        assertEquals(expTraduciendo,resTraduciendo);
        
    }

    protected void setUp() throws Exception {
        
        
    }

    protected void tearDown() throws Exception {
    }

   
    /**
     * Test of stateEnroque method, of class controller.Fide.
     */
    public void testStateEnroque() {
        System.out.println("stateEnroque");
        
        Partida partida = null;
        String traduciendo = "";
        Fide instance = new Fide();
        
        int[] expResult = null;
        int[] result = instance.stateEnroque(partida, traduciendo);
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
     * Test of stateTorre method, of class controller.Fide.
     */
    public void testStateTorre() {
        System.out.println("stateTorre");
        
        Partida partida = null;
        String traduciendo = "";
        Fide instance = new Fide();
        
        int[] expResult = null;
        int[] result = instance.stateTorre(partida, traduciendo);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of stateCaballo method, of class controller.Fide.
     */
    public void testStateCaballo() {
        System.out.println("stateCaballo");
        
        Partida partida = null;
        String traduciendo = "";
        Fide instance = new Fide();
        
        int[] expResult = null;
        int[] result = instance.stateCaballo(partida, traduciendo);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of stateAlfil method, of class controller.Fide.
     */
    public void testStateAlfil() {
        System.out.println("stateAlfil");
        
        Partida partida = null;
        String traduciendo = "";
        Fide instance = new Fide();
        
        int[] expResult = null;
        int[] result = instance.stateAlfil(partida, traduciendo);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of stateDama method, of class controller.Fide.
     */
    public void testStateDama() {
        System.out.println("stateDama");
        
        
            Ficha peon_b_1 = new Peon(false);
            Ficha tor_b_1 = new Torre(false);
            Ficha cab_b_1 = new Caballo(false);
            Ficha alf_b_1 = new Alfil(false);
            Ficha reina_b = new Dama(false);
            Ficha rey_b = new Rey(false);

        //CREAMOS LAS FICHAS NEGRAS 
            Ficha peon_n_1 = new Peon(true);
            Ficha tor_n_1 = new Torre(true);
            Ficha cab_n_1 = new Caballo(true);
            Ficha alf_n_1 = new Alfil(true);
            Ficha reina_n = new Dama(true);
            Ficha rey_n = new Rey(true);
            
            Tablero tablero = new Tablero(0);
            Partida partida = new Partida();
            partida.setTablero(tablero);
            
            
            int m, n;
            for(m=0;m<8;m++)
                for(n=0;n<8;n++)
                {
                    partida.tablero.tablero[m][n] = new Casilla(null,m,n,false,false);
                }
            
            //Hay que meter las fichas a machete
                    partida.tablero.tablero[0][4].setFicha(rey_n);
                    partida.tablero.tablero[2][2].setFicha(alf_n_1);
                    partida.tablero.tablero[2][5].setFicha(cab_n_1);
                    partida.tablero.tablero[2][6].setFicha(reina_n);
                    partida.tablero.tablero[3][0].setFicha(peon_n_1);
                    partida.tablero.tablero[3][3].setFicha(peon_b_1);
                    partida.tablero.tablero[3][6].setFicha(cab_b_1);
                    partida.tablero.tablero[4][1].setFicha(tor_n_1);
                    partida.tablero.tablero[5][2].setFicha(reina_b);
                    partida.tablero.tablero[6][7].setFicha(tor_b_1);
                    partida.tablero.tablero[7][1].setFicha(alf_b_1);
                    partida.tablero.tablero[7][3].setFicha(rey_b);
                    
                    
        String traduciendo = "";
        Fide instance = new Fide();
        
        int[] expResult = null;
        int[] result = instance.stateDama(partida, traduciendo);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of stateRey method, of class controller.Fide.
     */
    public void testStateRey() {
        System.out.println("stateRey");
        
        Partida partida = null;
        String traduciendo = "";
        Fide instance = new Fide();
        
        int[] expResult = null;
        int[] result = instance.stateRey(partida, traduciendo);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of statePeon method, of class controller.Fide.
     */
    public void testStatePeon() {
        System.out.println("statePeon");
        
        Partida partida = null;
        String traduciendo = "";
        Fide instance = new Fide();
        
        int[] expResult = null;
        int[] result = instance.statePeon(partida, traduciendo);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of obtenerFichas method, of class controller.Fide.
     */
    public void testObtenerFichas() {
        System.out.println("obtenerFichas");
        
            Ficha peon_b_1 = new Peon(false);
            Ficha tor_b_1 = new Torre(false);
            Ficha cab_b_1 = new Caballo(false);
            Ficha alf_b_1 = new Alfil(false);
            Ficha reina_b = new Dama(false);
            Ficha rey_b = new Rey(false);
            Ficha peon_n_1 = new Peon(true);
            Ficha tor_n_1 = new Torre(true);
            Ficha tor_n_2 = new Torre(true);
            Ficha cab_n_1 = new Caballo(true);
            Ficha alf_n_1 = new Alfil(true);
            Ficha reina_n = new Dama(true);
            Ficha rey_n = new Rey(true);
            
            Tablero tablero = new Tablero(0);
            Partida partida = new Partida();
            partida.setTablero(tablero);
            partida.setTurno(false);
            
            
            int m, n;
            for(m=0;m<8;m++)
                for(n=0;n<8;n++)
                {
                    partida.tablero.tablero[m][n] = new Casilla(null,m,n,false,false);
                }
            
            //Hay que meter las fichas a machete
                    partida.tablero.tablero[0][0].setFicha(tor_n_2);
                    partida.tablero.tablero[0][4].setFicha(rey_n);
                    partida.tablero.tablero[2][2].setFicha(alf_n_1);
                    partida.tablero.tablero[2][5].setFicha(cab_n_1);
                    partida.tablero.tablero[2][6].setFicha(reina_n);
                    partida.tablero.tablero[3][0].setFicha(peon_n_1);
                    partida.tablero.tablero[3][3].setFicha(peon_b_1);
                    partida.tablero.tablero[3][6].setFicha(cab_b_1);
                    partida.tablero.tablero[4][1].setFicha(tor_n_1);
                    partida.tablero.tablero[5][2].setFicha(reina_b);
                    partida.tablero.tablero[6][7].setFicha(tor_b_1);
                    partida.tablero.tablero[7][1].setFicha(alf_b_1);
                    partida.tablero.tablero[7][3].setFicha(rey_b);
                    
        String tipo_ficha = "dama";
        boolean color = false;
        Fide instance = new Fide();
        
        int[][] expResult = new int[2][8];
            expResult[0][0]=5;
            expResult[1][0]=2;
            expResult[0][1]=-1;
            expResult[1][1]=-1;
            expResult[0][2]=-1;
            expResult[1][2]=-1;
            expResult[0][3]=-1;
            expResult[1][3]=-1;
            expResult[0][4]=-1;
            expResult[1][4]=-1;
            expResult[0][5]=-1;
            expResult[1][5]=-1;
            expResult[0][6]=-1;
            expResult[1][6]=-1;
            expResult[0][7]=-1;
            expResult[1][7]=-1;
        
        int[][] result = new int[2][8];
        result = instance.obtenerFichas(partida, tipo_ficha, color);
        for(int i=0;i<2;i++){
            for(int j=0;j<8;j++){
                System.out.print(result[i][j]);
            }
            System.out.println("");
        }
        
        for(int i=0;i<2;i++){
            for(int j=0;j<8;j++){
                System.out.print(expResult[i][j]);
            }
            System.out.println("");
        }
               
        assertEquals(expResult, result);
    
    }

    /**
     * Test of existeDestino method, of class controller.Fide.
     */
    public void testExisteDestino() {
        System.out.println("existeDestino");
        
        Partida partida = null;
        String movimiento = "";
        int[] coor = null;
        Fide instance = new Fide();
        
        boolean expResult = true;
        boolean result = instance.existeDestino(partida, movimiento, coor);
        assertEquals(expResult, result);
        
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
     * Test of hayficha method, of class controller.Fide.
     */
    public void testHayficha() {
        System.out.println("hayficha");
        
        int[][] lista_fichas = new int[2][8];
        lista_fichas[0][0]=5;
        lista_fichas[1][0]=2;
        lista_fichas[0][1]=3;
        lista_fichas[1][1]=3;
        
        int indice = 1;
        Fide instance = new Fide();
        
        boolean expResult = true;
        boolean result = instance.hayficha(lista_fichas, indice);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of es_letra_min method, of class controller.Fide.
     */
    public void testEs_letra_min() {
        System.out.println("es_letra_min");
        
        char letra = 'g';
        Fide instance = new Fide();
        
        boolean expResult = true;
        boolean result = instance.es_letra_min(letra);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of es_numero_1a8 method, of class controller.Fide.
     */
    public void testEs_numero_1a8() {
        System.out.println("es_numero_1a8");
        
        char letra = '3';
        Fide instance = new Fide();
        
        boolean expResult = true;
        boolean result = instance.es_numero_1a8(letra);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of stateMoviendo method, of class controller.Fide.
     */
    public void testStateMoviendo() {
        System.out.println("stateMoviendo");
        
        Partida partida = null;
        int[][] lista_fichas = null;
        String traduciendo = "";
        Fide instance = new Fide();
        
        int[] expResult = null;
        int[] result = instance.stateMoviendo(partida, lista_fichas, traduciendo);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of stateComiendo method, of class controller.Fide.
     */
    public void testStateComiendo() {
        System.out.println("stateComiendo");
        
        Partida partida = null;
        int[][] lista_fichas = null;
        String traduciendo = "";
        Fide instance = new Fide();
        
        int[] expResult = null;
        int[] result = instance.stateComiendo(partida, lista_fichas, traduciendo);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of convertirFila method, of class controller.Fide.
     */
    public void testConvertirFila() {
        System.out.println("convertirFila");
        
        char a = '6';
        Fide instance = new Fide();
        
        int expResult = 2;
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
     * Test of buscarMovimiento method, of class controller.Fide.
     */
    public void testBuscarMovimiento() {
        System.out.println("buscarMovimiento");
        
        Partida partida = null;
        int[][] lista = null;
        int filaD = 0;
        int colD = 0;
        Fide instance = new Fide();
        
        int[] expResult = null;
        int[] result = instance.buscarMovimiento(partida, lista, filaD, colD);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
