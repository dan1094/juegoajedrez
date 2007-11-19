/*
 * Torre.java
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
public class Torre extends Ficha{
    
    /**
     * Creates a new instance of Torre
     */
    public Torre(boolean color){
        super(color);
        this.setTipo_ficha("torre");
    }
    
    public boolean movimiento_correspondiente_ficha(Tablero tablero,int fo,int co,int fd,int cd){
       //Se debe comprobar que mueve recto y que no hay fichas por el camino.
       int i=0;
       int j=0;
       boolean libre=true;
       System.out.println("Se mueve una torre.");
       LogManager.info("Se mueve una torre.");
       
       //Hay 4 posibles movimientos. Derecha, Izquierda, Arriba y Abajo
       if((co==cd)&&(fo==fd)) {
           //El origen y el destino son iguales
           System.out.println("Origen y destino iguales. No se puede mover.");
           LogManager.info("Origen y destino iguales. No se puede mover.");
           return(false);           
       }else if((fo!=fd)&&(co!=cd)) {
           System.out.println("Movimiento no permitido. Debe mover en linea recta.");
           LogManager.info("Movimiento no permitido. Debe mover en linea recta.");
           return(false);
       }else if(fo==fd){
           //Quiere decir que se mueve en la misma fila (HORIZONTALMENTE)
           System.out.println("Mueve horizontalmente.");
           LogManager.info("Mueve horizontalmente.");
           if(cd>co){
               //Mueve hacia la derecha
               System.out.println("Mueve a la derecha.");
               LogManager.info("Mueve a la derecha.");
               for(i=co+1;((i<cd)&&(libre));i++) {
                  //Miro si esa casilla esta ocupada
                  libre=!tablero.tablero[fo][i].getOcupada();
               }
               
           }else if(cd<co){
               //Mueve hacia la izquierda
               System.out.println("Mueve a la izquierda.");
               LogManager.info("Mueve a la izquierda.");
               for(i=co-1;(i>cd)&&libre;i--) {
                  //Miro si esa casilla esta ocupada
                  libre=!tablero.tablero[fo][i].getOcupada();
               }
            
           }
       }else if(co==cd){
           //Quiere decir que se mueve en la misma columna (VERTICALMENTE)
            System.out.println("Mueve verticalmente.");
            LogManager.info("Mueve verticalmente.");
           if(fd>fo){
               //Mueve hacia abajo
               System.out.println("Mueve hacia abajo.");
               LogManager.info("Mueve hacia abajo.");
               for(i=fo+1;(i<fd)&&libre;i++) {
                  //Miro si esa casilla esta ocupada
                  libre=!tablero.tablero[i][co].getOcupada();
               }
               
           }else if(fd<fo){
               //Mueve hacia arriba
               System.out.println("Mueve hacia arriba.");
               LogManager.info("Mueve hacia arriba.");
               for(i=fo-1;(i>fd)&&libre;i--) {
                  //Miro si esa casilla esta ocupada
                  libre=!tablero.tablero[i][co].getOcupada();
               }
           }
       }
       if(libre) return(libre);
       else{
            System.out.println("Hay fichas impidiendo el paso");
            LogManager.info("Hay fichas impidiendo el paso");
            return(libre);
       }
       
       
    }
    public Tablero amenazar_casillas(Tablero tablero,int fila, int columna){
        int i,j;
        boolean libre=true;
        
        if(this.getColor()){//FICHA NEGRA(torre)
            for(i=fila-1;(i>=0)&&libre;i--){
                tablero.tablero[i][columna].setAmenazada_por_negras(true);
                libre=!tablero.tablero[i][columna].getOcupada();
            }
            libre=true;
            for(i=fila+1;(i<=7)&&libre;i++){
                tablero.tablero[i][columna].setAmenazada_por_negras(true);
                libre=!tablero.tablero[i][columna].getOcupada();
            }
            libre=true;
            for(j=columna+1;(j<=7)&&libre;j++){
                tablero.tablero[fila][j].setAmenazada_por_negras(true);
                libre=!tablero.tablero[fila][j].getOcupada();
            }libre=true;
            for(j=columna-1;(j>=0)&&libre;j--){
                tablero.tablero[fila][j].setAmenazada_por_negras(true);
                libre=!tablero.tablero[fila][j].getOcupada();
            }
        }else{
            for(i=fila-1;(i>=0)&&libre;i--){
                tablero.tablero[i][columna].setAmenazada_por_blancas(true);
                libre=!tablero.tablero[i][columna].getOcupada();
            }
            libre=true;
            for(i=fila+1;(i<=7)&&libre;i++){
                tablero.tablero[i][columna].setAmenazada_por_blancas(true);
                libre=!tablero.tablero[i][columna].getOcupada();
            }
            libre=true;
            for(j=columna+1;(j<=7)&&libre;j++){
                tablero.tablero[fila][j].setAmenazada_por_blancas(true);
                libre=!tablero.tablero[fila][j].getOcupada();
            }libre=true;
            for(j=columna-1;(j>=0)&&libre;j--){
                tablero.tablero[fila][j].setAmenazada_por_blancas(true);
                libre=!tablero.tablero[fila][j].getOcupada();
            }libre=true;
            
        }
        return(tablero);
    }   
    
}
