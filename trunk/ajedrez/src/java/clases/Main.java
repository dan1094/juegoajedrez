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
        Tablero tablero = new Tablero(1, false);
        //Se colocan las fichas en sus posiciones iniciales
        System.out.println("Creando tablero e inicializandolo...");
        tablero.inicializar_tablero(tablero);
        
        //Flujo para leer datos
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //LEEMOS LA CASILLA ORIGEN
        int filaorigen=0, columnaorigen=0, filadestino=0, columnadestino=0;
        try {
            System.out.println("Indique la fila que desea mover");
            //Leemos la fila destino
            filaorigen = Integer.parseInt(in.readLine())-1;
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Entrada incorrecta de la fila origen.");
        } 
        
        try {
            System.out.println("Indique la columna que desea mover.");
            //Leemos la columna origen
            columnaorigen = Integer.parseInt(in.readLine())-1;
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Entrada incorrecta de la columna origen.");
        }
        try {
            System.out.println("Indique la fila a la que desea mover");
            //Leemos la fila destino
            filadestino = Integer.parseInt(in.readLine())-1;
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Entrada incorrecta de la fila destino.");
        } 
        
        try {
            System.out.println("Indique la columna a la que desea mover.");
            //Leemos la columna destino
            columnadestino = Integer.parseInt(in.readLine())-1;
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Entrada incorrecta de la columna destino.");
        }
        
        //Movemos la ficha, del origen (obligatorio) al destino dado por el usuario
        //ESTA FIJADO A MOVER EL ALFIL BLANCO DE LA IZQUIERDA.
        //Debemos cambiarlo y pedirle al usuario que ficha quiere mover y modificarlo
        //en la llamada a mover-----
      boolean movida=tablero.mover(filaorigen,columnaorigen,filadestino,columnadestino,tablero);
      if(movida)
        { 
          //Para comprobar que ha movido, miramos lo que hay ahora en la casilla destino.
          Ficha ficha=tablero.getCasilla(filadestino,columnadestino).getFicha();
          System.out.println("Ha movido el/la: "+ficha.getTipo_ficha()+", de color " +
                  ficha.getColor());
                }
      else
          System.out.println("La ficha no pudo ser movida.");
        
	    }
    
}
