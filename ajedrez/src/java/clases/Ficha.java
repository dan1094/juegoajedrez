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
            
            /**Devuelve el color de la ficha F*/
            public String color_ficha(){
                return(this.color);
            }
            
            /**Comprueba si el movimiento solicitado esta permitido*/
            public abstract boolean movimiento_permitido(String a, String b);
                //¿ficha que hay en esa casilla?
                //¿ocupada?  --> funcion dentro de casilla.
                //¿por ficha de que color?
                //¿el movimiento esta dentro del tablero?
            
            /**Comprueba si la casilla esta ocupada*/
            public boolean casilla_ocupada(String a){
                return true;
            }
            
            /**Devuelve la ficha de una casilla determinada*/
            public abstract Ficha ficha_de_casilla();
                //habria que mirar como relacionamos la casilla con la ficha
            
            /**Comprueba si el movimiento de esa ficha en concreto, esta dentro del
             *tablero. Es una parte de la comprobacion total del movimiento*/
            public abstract boolean movimiento_dentro_tablero();
                //abstract porque depende del tipo de ficha
            
            /**Mueve la ficha de la posicion de inicio, a la casilla solicitada*/
            public void mover(){
                //no seria abstracto porque el movimiento lo unico que hace es cambiar
                //coordenadas. Con comprobarlo bien en "movimiento_permitido" llegaria
            }
            
            
}