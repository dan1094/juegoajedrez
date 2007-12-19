/*
 * Casilla.java
 *
 * Created on 19 de septiembre de 2007, 13:14
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package model.partida;

import alice.tuprolog.MalformedGoalException;
import alice.tuprolog.NoSolutionException;
import alice.tuprolog.Prolog;
import alice.tuprolog.SolveInfo;
import alice.tuprolog.Term;
import model.prolog.Partida_Prolog;

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
        int fila=this.getFila();
        int col=this.getColumna();
        Partida_Prolog pp = new Partida_Prolog();
        Prolog engine = new Prolog();
        String tableroProlog="t0";
        String turno="blancas";
        
//        System.out.println("FD="+fd+",CD="+cd);
//        //Tengo que tener en cuenta el color de la ficha.
//        if(this.getColor()) return(tablero.tablero[fd][cd].getAmenazada_por_blancas());
//        else return(tablero.tablero[fd][cd].getAmenazada_por_negras());
        
        String cadena="casillaAmenazada(estado("+tableroProlog+","+turno+"),"+fila+","+col+").";
        
        try
        {
            SolveInfo info=null;
            Term solution=null;
            
            info = engine.solve(cadena);
            solution = info.getSolution();
            
            System.out.println("SOLUTION: "+solution);
            
               
        } catch(MalformedGoalException ex){
            System.out.println("Consulta incorrecta");
        } catch(NoSolutionException ex){
            System.out.println("No hay ningún resultado que satisfaga la consulta");
            return(false);
        }
        
        return (true);
    }

    public void setAmenazada_por_negras(boolean amenazada_por_negras) {
        this.amenazada_por_negras = amenazada_por_negras;
    }

    public boolean getAmenazada_por_blancas() {
        int fila=this.getFila();
        int col=this.getColumna();
        Partida_Prolog pp = new Partida_Prolog();
        Prolog engine = new Prolog();
        String tableroProlog="t0";
        String turno="negras";
        
//        System.out.println("FD="+fd+",CD="+cd);
//        //Tengo que tener en cuenta el color de la ficha.
//        if(this.getColor()) return(tablero.tablero[fd][cd].getAmenazada_por_blancas());
//        else return(tablero.tablero[fd][cd].getAmenazada_por_negras());
        
        String cadena="casillaAmenazada(estado("+tableroProlog+","+turno+"),"+fila+","+col+").";
        
        try
        {
            SolveInfo info=null;
            Term solution=null;
            
            info = engine.solve(cadena);
            solution = info.getSolution();
            
            System.out.println("SOLUTION: "+solution);
            
               
        } catch(MalformedGoalException ex){
            System.out.println("Consulta incorrecta");
        } catch(NoSolutionException ex){
            System.out.println("No hay ningún resultado que satisfaga la consulta");
            return(false);
        }
        
        return (true);
    }
    
    public void setAmenazada_por_blancas(boolean amenazada_por_blancas){
        this.amenazada_por_blancas=amenazada_por_blancas;
    }
    
}
