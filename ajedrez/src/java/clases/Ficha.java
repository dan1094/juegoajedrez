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
    
    protected int id_ficha;
        //Añado un id_casilla donde se deberá introducir el id de la casilla en la
        //que esta situada la ficha.
    protected int id_casilla;
    protected boolean color;
    protected String tipo_ficha;
    
    public Ficha(int id_ficha, boolean color){
        this.id_ficha=id_ficha;
        this.color=color;
        
    }
    
    
    public boolean getColor(){
        return(this.color);
    }
    
    public void setColor(boolean color){
        //color=true -> BLANCAS
        //color=false -> NEGRAS
        this.color=color;
    }
    
    public int getId_ficha(){
        return(this.id_ficha);
    }
    
    public void setId_ficha(int id_ficha){
        this.id_ficha=id_ficha;
    }
    
    public String getTipo_ficha(){
        return(this.tipo_ficha);
    }
    
    public void setTipo_ficha(String tipo_ficha){
        this.tipo_ficha=tipo_ficha;
    }
    
    public int getId_casilla(){
        return(this.id_casilla);
    }
    
    public void setId_casilla(int id_casilla){
        this.id_casilla=id_casilla;
    }
    
    public abstract boolean movimiento_correspondiente_ficha(Tablero tablero, int filaorigen, int columnaorigen, int filadestino, int columnadestino);
    
    
    /**Comprueba si la casilla seleccionada esta dentro*/
    public boolean dentro(int fil, int col){
        if(fil>=1&&fil<=8&&col<=8&&col>=1) return(true);
        else return(false);
    }
    
    public boolean dentro_amenaza(int fila, int col){
        if((fila>=0)&&(fila<=7)&&(col>=0)&&(col<=7)) return(true);
        else return(false);
    }
    
    /**Esta funcion marca cada casilla amenazada por una ficha*/
    public abstract Tablero amenazar_casillas(Tablero tablero,int fila, int columna);
    
    
        
}