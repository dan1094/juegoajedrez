/*
 * Peon.java
 *
 * Created on 19 de septiembre de 2007, 13:00
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package clases;

/**
 *
 * @author Pablo
 */
public class Peon extends Ficha{
    
    
    /** Creates a new instance of Peon */
    public Peon() {
    }
    
   public boolean movimiento_correspondiente_ficha(int filaorigen, int columnaorigen, int filadestino, int columnadestino){
       //Se debe comprobar que el movimiento es hacia delante. Puede ser sencillo, o doble,
       //si se trata del primer movimiento.
       boolean color=super.getColor();
       //color=false=BLANCAS
       //color=true=NEGRAS
       if(color){
           
       }else
       {
           
       }
       return(true);
        
    }
    
        
    
}

	    
	   