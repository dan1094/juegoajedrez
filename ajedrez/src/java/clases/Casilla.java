/*
 * Casilla.java
 *
 * Created on 19 de septiembre de 2007, 13:14
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package clases;

/**
 *
 * @author Pablo
 */

public class Casilla {
   
    protected Long id_casilla; 
    protected Long id_ficha;
    protected Long fila;
    protected String columna;
    protected boolean ocupada;
    
    
    
    /** Creates a new instance of Casilla */
    public Casilla() {
    }
    public boolean ocupada(Long fil, String col){
        return(this.ocupada);
    }
    
}
