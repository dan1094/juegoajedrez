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
    protected boolean turno;    //turno del jugador (BLANCAS=0, NEGRAS=1)
    protected Casilla tablero[][];
        
    /** Creates a new instance of Tablero */
    public Tablero() {        
    }
    
    /**Crea una tablero con los atributos especificados*/
    public Tablero(Long id, boolean tur, Casilla tablero[][]){
        this.id_tablero=id;
        this.turno=tur;
        this.tablero=tablero;
    }
    
    /**Cambia el turno de la partida.*/
    public void setTurno(boolean turno){
        this.turno=turno;
    }
    
    /**Obtiene el turno de la partida, a quien le toca mover*/
    public boolean getTurno(){
        return(this.turno);
    }
    
    /**Coloca las fichas en su posicion inicial*/
    public Tablero colocar_fichas(Tablero tablero){
        
        //Colocar cada ficha en su sitio del tablero
        return tablero;
    }
    
    /**Elimina el tablero, eliminando la partida*/
    public void eliminar_tablero(){} //¿Hara falta eliminar tablero?
    
    /*Asocia las letras del tablero con las coordenadas, aunque +1, igual que la fila
     *return 0 es error*/
    public int asociar_columnas(String letra){
            if(letra.equalsIgnoreCase("A")) return(1);
            else if(letra.equalsIgnoreCase("B")) return(2);
            else if (letra.equalsIgnoreCase("C")) return(3);
            else if (letra.equalsIgnoreCase("D")) return(4);
            else if (letra.equalsIgnoreCase("E")) return(5);
            else if (letra.equalsIgnoreCase("F")) return(6);
            else if (letra.equalsIgnoreCase("G")) return(7);
            else if (letra.equalsIgnoreCase("H")) return(8);
            else return(0);
     
    }
    /**Mueve la ficha de la casilla inicial (ci,fi) a la casilla final (cf,ff)*/
    public void mover_ficha(String ci, Long fi, String cf, Long ff){
        
       
    }
    
}
