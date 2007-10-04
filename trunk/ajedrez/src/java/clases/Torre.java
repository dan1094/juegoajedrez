/*
 * Torre.java
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
public class Torre extends Ficha{
    
    /**
     * Creates a new instance of Torre
     */
    public Torre(int id_ficha, boolean color){
        super(id_ficha,color);
        this.setTipo_ficha("torre");
    }
    
    public boolean movimiento_correspondiente_ficha(Tablero tablero,int filaorigen, int columnaorigen, int filadestino, int columnadestino){
       //Se debe comprobar que mueve recto y que no hay fichas por el camino.
       
       return(true);
        
    }
    
}
