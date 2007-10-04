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
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Solo puede mover el alfil blanco.");
        int fila=0, columna=0;
        try {
            System.out.println("Indique la fila a la que desea mover.");
            //Leemos la fila destino
            fila = Integer.parseInt(in.readLine())-1;
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Entrada incorrecta.");
        } 
        
        try {
            System.out.println("Indique la columna a la que desea mover.");
            //Leemos la columna destino
            columna = Integer.parseInt(in.readLine())-1;
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Entrada incorrecta.");
        }
        
        //Movemos la ficha, del origen (obligatorio) al destino dado por el usuario
      boolean movida=tablero.mover(0,2,fila,columna,tablero);
      if(movida)
        { 
          System.out.println("FICHA DESTINO: "+tablero.getCasilla(fila,columna).getFicha().getTipo_ficha());
      }
      else
          System.out.println("La ficha no pudo ser movida.");
        
	    }
    
}
