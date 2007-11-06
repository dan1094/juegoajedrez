/*
 * Casilla.java
 *
 * Created on 19 de septiembre de 2007, 13:14
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package model.partida;



/**
 *
 * @author Pablo
 */

public class Casilla {
   
    protected Ficha ficha;
    protected int fila;
    protected int columna;
    protected boolean amenazada_por_blancas;
    protected boolean amenazada_por_negras;
  
    
    /** Creates a new instance of Casilla */
    public Casilla() {
    }
    
    public Casilla(Ficha ficha, int fila, int columna, 
            boolean amenazada_por_blancas, boolean amenazada_por_negras){
        this.columna=columna;
        this.fila=fila;
        this.ficha=ficha;
        this.amenazada_por_blancas=false;
        this.amenazada_por_negras=false;
    }

    public Ficha getFicha() {
        return this.ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha=ficha;
    }

    public int getFila() {
        return this.fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return this.columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public boolean getOcupada() {
        if(this.getFicha()==null) return(false);
        else return(true);
    }
    
    public boolean getAmenazada_por_negras() {
        return this.amenazada_por_negras;
    }

    public void setAmenazada_por_negras(boolean amenazada_por_negras) {
        this.amenazada_por_negras = amenazada_por_negras;
    }

    public boolean getAmenazada_por_blancas(){
        return this.amenazada_por_blancas;
    }
    
    public void setAmenazada_por_blancas(boolean amenazada_por_blancas){
        this.amenazada_por_blancas=amenazada_por_blancas;
    }
    
}
