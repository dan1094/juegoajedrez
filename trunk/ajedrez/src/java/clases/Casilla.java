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
   
    private Long id_casilla; 
    private Long id_ficha;
    private Long fila;
    private String columna;
    private boolean ocupada;
    
    
    
    /** Creates a new instance of Casilla */
    public Casilla() {
    }

    public Long getId_casilla() {
        return id_casilla;
    }

    public void setId_casilla(Long id_casilla) {
        this.id_casilla = id_casilla;
    }

    public Long getId_ficha() {
        return id_ficha;
    }

    public void setId_ficha(Long id_ficha) {
        this.id_ficha = id_ficha;
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
