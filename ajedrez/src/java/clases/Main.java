/*
 * Main.java
 *
 * Created on 23 de septiembre de 2007, 19:55
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package clases;

import java.io.*;

/**
 *
 * @author Pablo
 */
public class Main {
    
    /** Creates a new instance of Main */
    public Main() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
        
        System.out.println("Bienvenido al Ajedrez");
        //Se define el array que pertenecera al Tablero
        Casilla tab[][];
        tab = new Casilla[8][8];
        //Creo una instancia de la clase tablero con turno para BLANCAS(false)
        Tablero tablero = new Tablero(new Long(1), false, tab);
        //Se colocan las fichas (por ahora solo alfil) en sus posiciones iniciales
        tablero.inicializar_tablero(tablero);
        
        //Flujo para leer datos
        InputStreamReader isr = new InputStreamReader(System.in);
        
        
	    }
    
}
