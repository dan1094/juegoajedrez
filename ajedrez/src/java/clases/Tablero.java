/*
 * Tablero.java
 *
 * Created on 19 de septiembre de 2007, 13:07
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package clases;

/**
 *
 * @author Pablo
 */
public class Tablero {
    
    protected Long id_tablero; //numero de tablero
    protected String turno;    //turno del jugador (turno='b' / 'a')'
    protected Casilla tablero[][];
    
    
    /** Creates a new instance of Tablero */
    public Tablero() {        
    }
    /**Crea una tablero con los atributos especificados*/
    public Tablero(Long id, String tur, Casilla tablero[][]){
        this.id_tablero=id;
        this.turno=tur;
        this.tablero=tablero;
    }
    
    /**Coloca las fichas en su posicion inicial*/
    public Tablero colocar_fichas(Tablero tablero){
        //Colocar cada ficha en su sitio del tablero
        return tablero;
    }
    
    /**Elimina el tablero, eliminando la partida*/
    public void eliminar_tablero(){} //¿Hara falta eliminar tablero?
    
}
