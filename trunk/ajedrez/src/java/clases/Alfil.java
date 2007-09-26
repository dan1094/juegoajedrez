/*
 * Alfil.java
 *
 * Created on 19 de septiembre de 2007, 13:05
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package clases;

/**
 *
 * @author Pablo
 */
public class Alfil extends Ficha{
    
    /** Creates a new instance of Alfil */
    public Alfil() {
    }
    
    public boolean diagonal(int fo, int co, int fd, int cd){
        //Para comprobar que es diagonal, debemos sumar a la fila y a la columna
        //a la vez el mismo numero. Sumar y restar el mismo numero. Restar el mismo numero.
        //Restar y sumar el mismo numero.
              
        return(true);
    }
    
    /**Metodo que recorre las posibilidades de movimiento, comprobando que las casillas
     *intermedias (no la de destino) estan libres. Este metodo no es necesario para el
     *caballo, ya que este puede saltar fichas)*/
    public boolean camino_libre(int fo, int co, int fd, int cd){
        //Para cada sitio de la diagonal, debemos comprobar que esta libre
        return(true);
    }
    
    public boolean movimiento_correspondiente_ficha(int filaorigen, int columnaorigen, int filadestino, int columnadestino){
        //Se debe comprobar que el el movimiento es diagonal.
        boolean diagonal=diagonal(filaorigen,columnaorigen,filadestino,columnadestino);
        
        //Se debe comprobar que no hay fichas por el camino.
        boolean camino_libre=camino_libre(filaorigen,columnaorigen,filadestino,columnadestino);
        
        return(diagonal&&camino_libre);
    }
            
    
}