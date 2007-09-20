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
    public Torre() {
    }
    
    public boolean movimiento_dentro_tablero(){
    //abstract porque depende del tipo de ficha
    return(true);
    }
    
}
