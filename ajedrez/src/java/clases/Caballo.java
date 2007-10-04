/*
 * Caballo.java
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
public class Caballo extends Ficha{
    
    /** Creates a new instance of Caballo */
    public Caballo(int id_ficha, boolean color){
        super(id_ficha,color);
        this.setTipo_ficha("caballo");
    }
    
    public boolean movimiento_correspondiente_ficha(Tablero tablero,int filaorigen, int columnaorigen, int filadestino, int columnadestino){
       //Se debe comprobar que el movimiento es en L. Dos hacia delante y una al lado o viceversa.
       //No importa si hay fichas por el camino, ya que puede saltar.
        
        
       
       return(true);
        
    }
}
