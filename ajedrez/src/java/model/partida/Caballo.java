/*
 * Caballo.java
 *
 * Created on 19 de septiembre de 2007, 13:05
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package model.partida;

import model.util.LogManager;

/**
 *
 * @author Pablo
 */
public class Caballo extends Ficha{
    
    /** Creates a new instance of Caballo */
    public Caballo(boolean color){
        super(color);
        this.setTipo_ficha("caballo");
    }
    
    public boolean movimiento_correspondiente_ficha(Tablero tablero,int fo,int co,int fd,int cd){
       //Se debe comprobar que el movimiento es en L. Dos hacia delante y una al lado o viceversa.
       //No importa si hay fichas por el camino, ya que puede saltar.
        System.out.println("Entra en el caballo.");
     //   LogManager.info("Entra en el caballo.");
        //Hay 8 movimientos, 2 por cada diagonal.
        if((fd==fo+2)&&(cd==co+1)) //MOV.1
        {
            return(true);
        }else if((fd==fo+1)&&(cd==co+2)) //MOV.2
        {
            return(true);
        }else if((fd==fo+2)&&(cd==co-1)) //MOV.3
        {
            return(true);
        }else if((fd==fo+1)&&(cd==co-2)) //MOV.4
        {
            return(true);
        }else if((fd==fo-2)&&(cd==co+1))  //MOV.5
        {
            return(true);
        }else if((fd==fo-1)&&(cd==co+2))  //MOV.6
        {
            return(true);
        }else if((fd==fo-2)&&(cd==co-1))  //MOV.7
        {
            return(true);
        }else if((fd==fo-1)&&(cd==co-2))  //MOV.8
        {
            return(true);
        }else{
            System.out.println("El movimiento no se corresponde con un caballo.");
       //     LogManager.info("El movimiento no se corresponde con un caballo.");
            return(false);
        }
    }
  public Tablero amenazar_casillas(Tablero tablero, int fila, int columna){
        
      if(this.getColor()){//FICHA NEGRA
          
          if(super.dentro_amenaza(fila+1,columna+2))  tablero.tablero[fila+1][columna+2].setAmenazada_por_negras(true);
          if(super.dentro_amenaza(fila+2,columna+1))  tablero.tablero[fila+2][columna+1].setAmenazada_por_negras(true);
          if(super.dentro_amenaza(fila+1,columna-2))  tablero.tablero[fila+1][columna-2].setAmenazada_por_negras(true);
          if(super.dentro_amenaza(fila+2,columna-1))  tablero.tablero[fila+2][columna-1].setAmenazada_por_negras(true);
          if(super.dentro_amenaza(fila-1,columna-2))  tablero.tablero[fila-1][columna-2].setAmenazada_por_negras(true);
          if(super.dentro_amenaza(fila-2,columna-1))  tablero.tablero[fila-2][columna-1].setAmenazada_por_negras(true);
          if(super.dentro_amenaza(fila-1,columna+2))  tablero.tablero[fila-1][columna+2].setAmenazada_por_negras(true);
          if(super.dentro_amenaza(fila-2,columna+1))  tablero.tablero[fila-2][columna+1].setAmenazada_por_negras(true);
       }else {//FICHA BLANCA
          if(super.dentro_amenaza(fila+1,columna+2))  tablero.tablero[fila+1][columna+2].setAmenazada_por_blancas(true);
          if(super.dentro_amenaza(fila+2,columna+1))  tablero.tablero[fila+2][columna+1].setAmenazada_por_blancas(true);
          if(super.dentro_amenaza(fila+1,columna-2))  tablero.tablero[fila+1][columna-2].setAmenazada_por_blancas(true);
          if(super.dentro_amenaza(fila+2,columna-1))  tablero.tablero[fila+2][columna-1].setAmenazada_por_blancas(true);
          if(super.dentro_amenaza(fila-1,columna-2))  tablero.tablero[fila-1][columna-2].setAmenazada_por_blancas(true);
          if(super.dentro_amenaza(fila-2,columna-1))  tablero.tablero[fila-2][columna-1].setAmenazada_por_blancas(true);
          if(super.dentro_amenaza(fila-1,columna+2))  tablero.tablero[fila-1][columna+2].setAmenazada_por_blancas(true);
          if(super.dentro_amenaza(fila-2,columna+1))  tablero.tablero[fila-2][columna+1].setAmenazada_por_blancas(true);
       }
      
        return(tablero);
    }   
  
  
}
