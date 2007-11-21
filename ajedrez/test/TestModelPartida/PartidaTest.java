/*
 * PartidaTest.java
 * JUnit based test
 *
 * Created on 22 de octubre de 2007, 21:42
 */

package TestModelPartida;

import junit.framework.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.jar.Pack200;
import model.partida.*;

/**
 *
 * @author Juanjito
 */
public class PartidaTest extends TestCase {
    
    public PartidaTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

  

   
   
    public static Test suite(){
        return new TestSuite(PartidaTest.class);
    }
    /**
     * Prueba del metodo getTurno , de la clase clases.Partida.
     */
    public void testGetTurno() {
        System.out.println("getTurno");
        
        Tablero instance = new Tablero(1);
        Partida partida = new Partida(1,true,instance,true,true);
        
    //    Partida instance = new Partida();
        
        boolean expResult = true;
        boolean result = partida.getTurno();
        assertEquals(expResult, result);
        
       
    }
    
    
    /**
     * Prueba del metodo cambio_turno , de la clase clases.Partida.
     */
    public void testCambio_turno() {
        System.out.println("cambio_turno");
        
        Tablero instance = new Tablero(1);
        Partida partida = new Partida(1,true,instance,true,true);
        
    //    Partida instance = new Partida();
        

        partida.cambio_turno();
        
        boolean aux=false;
        
        assertEquals(aux,partida.getTurno());
    }

    /**
     * Prueba del metodo cambio_ficha , de la clase clases.Partida.
     */
    public void testCambio_ficha() {
        System.out.println("cambio_ficha");
        
        Tablero tablero = null;
        int eleccion = 0;
        int fd = 0;
        int cd = 0;
        
  //       Tablero instance = new Tablero(1);
  //      Partida partida = new Partida(1,true,instance,true,true);
        
        Partida instance = new Partida();
        
        Tablero expResult = null;
        Tablero result = instance.cambio_ficha(tablero, eleccion, fd, cd);
        assertEquals(expResult, result);
        
       
    }

    /**
     * Prueba del metodo ofrecer_cambio , de la clase clases.Partida.
     */
    public void testOfrecer_cambio() {
        System.out.println("ofrecer_cambio");
        
   //     Partida partida = null;
        int fo = 0;
        int co = 0;
        int fd = 0;
        int cd = 0;
        
        Tablero instance = new Tablero(1);
        Partida partida = new Partida(1,true,instance,true,true);
        
  //      Partida instance = new Partida();
        
        partida.ofrecer_cambio(partida, fo, co, fd, cd);
        
       
    }

    /**
     * Prueba del metodo comprobar_movimiento , de la clase clases.Partida.
     */
    public void testComprobar_movimiento() {
        System.out.println("comprobar_movimiento");
        
        int filaorigen = 1;
        int columnaorigen = 1;
        int filadestino = 2;
        int columnadestino = 1;
        
        Tablero instance = new Tablero(1);
        Partida partida = new Partida(1,true,instance,true,true);
        
        
        Tablero resultado = instance.inicializar_tablero_estandar(partida);
        //Tablero tablero = null;
        //Partida instance = new Partida();
        
        boolean expResult = true;

        boolean result = partida.comprobar_movimiento(filaorigen, columnaorigen, filadestino, columnadestino, resultado);
        assertEquals(expResult, result);
        
        // TODO revisar el cadigo de prueba generado y eliminar la llamada predeterminada que falta.
        //fail("El caso de prueba es un prototipo.");
    }

    /**
     * Prueba del metodo mover , de la clase clases.Partida.
     */
    public void testMover() {
        System.out.println("mover");
        
        int filaorigen = 1;
        int columnaorigen = 1;
        int filadestino = 2;
        int columnadestino = 1;
        Tablero instance = new Tablero(1);
        Partida partida = new Partida(1,true,instance,true,true);
        
        
        Tablero resultado = instance.inicializar_tablero_estandar(partida);
        //Tablero tablero = null;
        //Partida instance = new Partida();
        
        boolean expResult = true;
        
       
        boolean result = partida.mover(filaorigen, columnaorigen, filadestino, columnadestino, resultado);
        assertEquals(expResult, result);
        
        // TODO revisar el cadigo de prueba generado y eliminar la llamada predeterminada que falta.
        //fail("El caso de prueba es un prototipo.");
    }

    /**
     * Prueba del metodo ocupada_color , de la clase clases.Partida.
     */
    public void testOcupada_color() {
        System.out.println("ocupada_color");
        
        Tablero tablero = null;
        int fo = 0;
        int co = 0;
        Tablero instance = new Tablero(1);
        Partida partida = new Partida(1,true,instance,true,true);
        
        
        Tablero resultado = instance.inicializar_tablero_estandar(partida);
        
        boolean expResult = true;
        boolean result = partida.ocupada_color(resultado, fo, co);
        assertEquals(expResult, result);
        
        // TODO revisar el cadigo de prueba generado y eliminar la llamada predeterminada que falta.
        //fail("El caso de prueba es un prototipo.");
    }

    /**
     * Prueba del metodo obtener_tablero , de la clase clases.Partida.
     */
    public void testObtener_tablero() {
        System.out.println("obtener_tablero");
        
        
        Tablero instance = new Tablero(1);
        Partida partida = new Partida(1,true,instance,true,true);
        
        
        Tablero resultado = instance.inicializar_tablero_estandar(partida);
        
        Partida expResult = partida;
        Partida result = partida.obtener_tablero();
        assertEquals(expResult, result);
        
        // TODO revisar el cadigo de prueba generado y eliminar la llamada predeterminada que falta.
        //fail("El caso de prueba es un prototipo.");
    }


    /**
     * Prueba del metodo fin_partida , de la clase clases.Partida.
     */
    //Lo Compruebo en falso porque en true todavia no se puede ya que no hemos
    //legado a partida con tablas o mate
    public void testFin_partida() {
        System.out.println("fin_partida");
        
      
        
        Partida partida = null;
        Partida instance = new Partida();
        
        
        boolean expResult = false;
        boolean result = instance.fin_partida();
        assertEquals(expResult, result);
        
        // TODO revisar el cadigo de prueba generado y eliminar la llamada predeterminada que falta.
        //fail("El caso de prueba es un prototipo.");
    }

}
