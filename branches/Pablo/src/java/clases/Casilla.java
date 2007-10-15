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
   
    protected int id_casilla; 
    protected Ficha ficha;
    protected int fila;
    protected int columna;
  
    
    /** Creates a new instance of Casilla */
    public Casilla() {
    }
    
    public Casilla(int id_casilla, Ficha ficha, int fila, int columna){
        this.id_casilla=id_casilla;
        this.columna=columna;
        this.fila=fila;
        this.ficha=ficha;
    }

    public int getId_casilla() {
        return this.id_casilla;
    }

    public void setId_casilla(int id_casilla) {
        this.id_casilla = id_casilla;
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
    
}
