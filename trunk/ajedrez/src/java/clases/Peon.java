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
    
   public boolean movimiento_dentro_tablero(){
    //abstract porque depende del tipo de ficha
    return(true);
    }
    
        
    
}

	    
	   