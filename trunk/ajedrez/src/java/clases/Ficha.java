/*
 * Ficha.java
 *
 * Created on 19 de septiembre de 2007, 12:50
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package clases;


/**
 *
 * @author Pablo
 */
public abstract class Ficha {
    
	    protected String color;
	    protected Long id_ficha;
            
            public String getColor(){
                return(this.color);
            }
            
            public void setColor(String color){
                this.color=color;
            }
            
            /**Comprueba si el movimiento solicitado esta permitido*/
            public boolean movimiento_permitido(String a, String b){
                //¿ficha que hay en esa casilla?
                //¿ocupada?  --> funcion dentro de casilla.
                //¿por ficha de que color?
                //¿el movimiento esta dentro del tablero?
                return(true);
            }
            /**Comprueba si la casilla esta ocupada*/
            public boolean casilla_ocupada(String a){
                return true;
            }
            
            /**Comprueba si el movimiento de esa ficha en concreto, esta dentro del
             *tablero. Es una parte de la comprobacion total del movimiento*/
            public abstract boolean movimiento_dentro_tablero();
                //abstract porque depende del tipo de ficha
            
            
            
            
}