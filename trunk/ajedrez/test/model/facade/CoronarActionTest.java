/*
 * CoronarActionTest.java
 * JUnit based test
 *
 * Created on 18 de noviembre de 2007, 20:20
 */

package model.facade;

import junit.framework.*;
import model.partida.*;
import model.util.*;

/**
 *
 * @author Juanjito
 */
public class CoronarActionTest extends TestCase {
    
    public CoronarActionTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(CoronarActionTest.class);
        
        return suite;
    }

    /**
     * Prueba del metodo execute , de la clase model.facade.CoronarAction.
     */
    public void testExecute() throws Exception {
        System.out.println("execute");
        
        int filorigen = 0;
        int colorigen = 3;
        String ficha=null;
        Casilla casilla = new Casilla();
        
        Tablero tablero = new Tablero(1);
        Partida partida = new Partida(1,true,tablero,true,true);
        tablero = tablero.vacio(partida);
        
        Ficha instance = partida.tablero.crear_ficha(6,true);
        partida.tablero.tablero[0][3].setFicha(instance);
        
      // partida.getTablero().setCasilla(casilla,0,3);
       //partida.getTablero().
        
        System.out.println("p1");
        CoronarAction action = new CoronarAction(filorigen,colorigen,partida,2);
        System.out.println("p2");
        ficha=partida.getTablero().getCasilla(0,3).getFicha().getTipo_ficha();
        System.out.println(ficha);
        String expResult = "dama";
        Object result = action.execute();
        assertEquals(expResult, ficha);
        
    }
    
}
