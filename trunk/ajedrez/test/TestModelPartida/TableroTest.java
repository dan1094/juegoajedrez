/*
 * TableroTest.java
 * JUnit based test
 *
 * Created on 22 de octubre de 2007, 20:26
 */

package TestModelPartida;

import junit.framework.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import model.partida.*;

/**
 *
 * @author Juanjito
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
     * Prueba del metodo inicializar_tablero_estandar , de la clase clases.Tablero.
     */
    public void testInicializar_tablero_estandar() {
        System.out.println("inicializar_tablero_estandar");
        
       
        
        Tablero instance = new Tablero(1);
        Partida partida = new Partida(1,true,instance,true,true);
        
        
        Tablero result = instance.inicializar_tablero_estandar(partida);
       
        String  resultado= result.getCasilla(0,4).getFicha().getTipo_ficha();
        
        assertEquals(resultado, "rey");
        
        // TODO revisar el cadigo de prueba generado y eliminar la llamada predeterminada que falta.
        //fail("El caso de prueba es un prototipo.");
    }
    public void testInicializar_tablero_estandar_p2() {
        System.out.println("inicializar_tablero_estandar_p2");
        
       
        
        Tablero instance = new Tablero(1);
        Partida partida = new Partida(1,true,instance,true,true);
        
        
        Tablero result = instance.inicializar_tablero_estandar(partida);
       
        String  resultado= result.getCasilla(1,4).getFicha().getTipo_ficha();
        
        assertEquals(resultado, "peon");
        
        // TODO revisar el cadigo de prueba generado y eliminar la llamada predeterminada que falta.
        //fail("El caso de prueba es un prototipo.");
    }
    
    
     public void testInicializar_tablero_estandar_p3() {
        System.out.println("inicializar_tablero_estandar_p3");
        
       
        
        Tablero instance = new Tablero(1);
        Partida partida = new Partida(1,true,instance,true,true);
        
        
        Tablero result = instance.inicializar_tablero_estandar(partida);
       
        String  resultado= result.getCasilla(0,1).getFicha().getTipo_ficha();
        
        assertEquals(resultado, "caballo");
        
        // TODO revisar el cadigo de prueba generado y eliminar la llamada predeterminada que falta.
        //fail("El caso de prueba es un prototipo.");
    }

    /**
     * Prueba del metodo inicializar_tablero_personalizado , de la clase clases.Tablero.
     */
  
    
    public void testDentro_tablero() {
        System.out.println("dentro_tablero");
        
        int fila = 0;
        int columna = 0;
       // Tablero instance = new Tablero();
        
        Tablero instance = new Tablero(1);
        Partida partida = new Partida(1,true,instance,true,true);
        
        Tablero result = instance.inicializar_tablero_estandar(partida);
        
        boolean expResult = true;
        boolean resultado = result.dentro_tablero(fila, columna);
        assertEquals(expResult, resultado);
        
        
    }

   
    
    
}
