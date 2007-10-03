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
    public static void main(String[] args){ 
        
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
        BufferedReader br= new BufferedReader(isr);
        
        System.out.println("Solo puede mover el alfil blanco. Indique la fila.");
        String fila="", columna="";
        try {
            
            //Leemos la fila destino
            fila = br.readLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        try {
            //Leemos la columna destino
            columna = br.readLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        //Pasamos a enteros y restamos 1 para que corresponda con los indices
        int fil = Integer.parseInt(fila);
        int col = Integer.parseInt(columna);
        fil--;
        col--;
        //Movemos la ficha, del origen (obligatorio) al destino dado por el usuario
        tablero.mover(0,2,fil,col,tablero);
        
        
        
        
        
	    }
    
}
