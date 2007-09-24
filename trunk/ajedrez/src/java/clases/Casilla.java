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
    protected Ficha ficha;
    protected Long fila;
    protected String columna;
    protected boolean ocupada; //0-> vacia, 1->ocupada
       
    
    
    /** Creates a new instance of Casilla */
    public Casilla() {
    }

    public Long getId_casilla() {
        return id_casilla;
    }

    public void setId_casilla(Long id_casilla) {
        this.id_casilla = id_casilla;
    }

    public Ficha getFicha() {
        return this.ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha=ficha;
    }

    public Long getFila() {
        return fila;
    }

    public void setFila(Long fila) {
        this.fila = fila;
    }

    public String getColumna() {
        return columna;
    }

    public void setColumna(String columna) {
        this.columna = columna;
    }

    public boolean getOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }
    
       
   
    
    
    
    
    
    
    
              
    
}
