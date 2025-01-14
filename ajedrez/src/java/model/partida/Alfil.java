/*
 * Alfil.java
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
public class Alfil extends Ficha{
    
    /** Creates a new instance of Alfil */
    public Alfil(boolean color){
        super(color);
        this.setTipo_ficha("alfil");
    }
    
    public boolean movimiento_correspondiente_ficha(Tablero tablero, int fo, int co, int fd, int cd){
        //Para comprobar que es diagonal, debemos sumar a la fila y a la columna
        //a la vez el mismo numero. Sumar y restar el mismo numero. Restar el mismo numero.
        //Restar y sumar el mismo numero.
        System.out.println("Mueve un alfil.");
      //  LogManager.info("Mueve un alfil.");
        int i=fo;
        int j=co;
        boolean libre=true;
        if(esDiagonal(fo,co,fd,cd)){
        //Hay 4 posibles movimientos diagonales
        if((fd>fo)&&(cd>co)){
            //Movimiento hacia abajo y a la derecha. 
            System.out.println("Mueve diagonal abajo-derecha");
        //    LogManager.info("Mueve diagonal abajo-derecha");
            
            for(i=fo+1,j=co+1;(i<fd)&&(j<cd)&&libre;i++,j++) libre=!tablero.tablero[i][j].getOcupada();
        } else if((fd>fo)&&(cd<co)){
                   //Movimiento hacia abajo y a la izda.
                    System.out.println("Mueve diagonal abajo-izquierda");
        //            LogManager.info("Mueve diagonal abajo-izquierda");
                    for(i=fo+1,j=co-1;(i<fd)&&(j>cd)&&libre;i++,j--)  libre=!tablero.tablero[i][j].getOcupada();
                }else if((fd<fo)&&(cd>co)){
                         //Movimiento hacia arriba y a la derecha
                          System.out.println("Mueve diagonal arriba-derecha");
          //                LogManager.info("Mueve diagonal arriba-derecha");
                          for(i=fo-1,j=co+1;(i>fd)&&(j<cd)&&libre;i--,j++) libre=!tablero.tablero[i][j].getOcupada();                  
                      }else if((fd<fo)&&(cd<co)){
                                //Movimiento hacia arriba y a la izquierda
                                System.out.println("Mueve diagonal arriba-izquierda");
            //                    LogManager.info("Mueve diagonal arriba-izquierda");
                                for(i=fo-1,j=co-1;(i>fd)&&(i>cd)&&libre;i--,j--)  libre=!tablero.tablero[i][j].getOcupada();
                            }else return(false);
        if(libre) return(libre);
        else {
             System.out.println("El movimiento no se puede realizar. Hay una ficha impidiendo " +
                "el paso.");
           //  LogManager.info("El movimiento no se puede realizar. Hay una ficha impidiendo " +
           //     "el paso.");
             return(false);
        }
        }else return(false);
    }
    
    public Tablero amenazar_casillas(Tablero tablero,int fila, int columna){
        int i,j;
        boolean libre=true;
        if(this.getColor()){//FICHA NEGRA
            for(i=fila-1,j=columna-1;(i>=0)&&(j>=0)&&libre;i--,j--){
                tablero.tablero[i][j].setAmenazada_por_negras(true);
                libre=!tablero.tablero[i][j].getOcupada();
            }
            libre=true;
            for(i=fila-1,j=columna+1;(i>=0)&&(j<=7)&&libre;i--,j++){
                tablero.tablero[i][j].setAmenazada_por_negras(true);
                libre=!tablero.tablero[i][j].getOcupada();
            }
            libre=true;
            for(i=fila+1,j=columna-1;(i<=7)&&(j>=0)&&libre;i++,j--){
                tablero.tablero[i][j].setAmenazada_por_negras(true);
                libre=!tablero.tablero[i][j].getOcupada();
            }
            libre=true;
            for(i=fila+1,j=columna+1;(i<=7)&&(j<=7)&&libre;i++,j++){
                tablero.tablero[i][j].setAmenazada_por_negras(true);
                libre=!tablero.tablero[i][j].getOcupada();
            }
            
        }else{//FICHA BLANCA
            for(i=fila-1,j=columna-1;(i>=0)&&(j>=0)&&libre;i--,j--){
                tablero.tablero[i][j].setAmenazada_por_blancas(true);
                libre=!tablero.tablero[i][j].getOcupada();
            }
            libre=true;
            for(i=fila-1,j=columna+1;(i>=0)&&(j<=7)&&libre;i--,j++){
                tablero.tablero[i][j].setAmenazada_por_blancas(true);
                libre=!tablero.tablero[i][j].getOcupada();
            }
            libre=true;
            for(i=fila+1,j=columna-1;(i<=7)&&(j>=0)&&libre;i++,j--){
                tablero.tablero[i][j].setAmenazada_por_blancas(true);
                libre=!tablero.tablero[i][j].getOcupada();
            }
            libre=true;
            for(i=fila+1,j=columna+1;(i<=7)&&(j<=7)&&libre;i++,j++){
                tablero.tablero[i][j].setAmenazada_por_blancas(true);
                libre=!tablero.tablero[i][j].getOcupada();
            }
        }
        
        
        return(tablero);
    }    
    
    public boolean esDiagonal(int fo, int co, int fd, int cd){
        System.out.println("FO:"+fo);
        System.out.println("CO:"+co);
        System.out.println("FD:"+fd);
        System.out.println("FD:"+cd);
        if(Math.abs(fo-fd)==(Math.abs(co-cd))) return(true);
        else return(false);
    }
}