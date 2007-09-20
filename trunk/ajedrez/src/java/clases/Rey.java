/*
 * Rey.java
 *
 * Created on 19 de septiembre de 2007, 13:06
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package clases;

/**
 *
 * @author Pablo
 */
public class Rey extends Ficha{
    
    /** Creates a new instance of Rey */
    public Rey() {
    }
  
    public boolean movimiento_dentro_tablero(){
    //abstract porque depende del tipo de ficha
    return(true);
    }
    
}
