/*
 * Dama.java
 *
 * Created on 19 de septiembre de 2007, 13:06
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package model.partida;



/**
 *
 * @author Pablo
 */
public class Dama extends Ficha{
    
    /**
     * Creates a new instance of Dama
     */
    public Dama(int id_ficha, boolean color){
        super(id_ficha,color);
        this.setTipo_ficha("reina");
    }
    
    public boolean movimiento_correspondiente_ficha(Tablero tablero,int filaorigen, 
        int columnaorigen, int filadestino, int columnadestino){
        //La reina es una mezcla entre el alfil y la torre.
        System.out.println("Entra en la reina.");
        int f=0, c=0;
        boolean libre=true;
        boolean recto = es_recto(filaorigen, columnaorigen, filadestino, columnadestino);
        if(recto){
            if(filadestino==filaorigen){
                //HORIZONTAL
                System.out.println("Movimiento reina horizontal");
                if(columnadestino>columnaorigen){
                    for(c=columnaorigen+1;((c<columnadestino)&&(libre));c++){
                        //HORIZONTAL DERECHA
                        System.out.println("Movimiento derecha");
                        libre=!tablero.tablero[c][filadestino].getOcupada();
                    }return(libre);
                }else if(columnadestino<columnaorigen){
                        for(c=columnaorigen-1;((c>columnadestino)&&(libre));c--){
                            //HORIZONTAL IZQUIERDA
                            System.out.println("Movimiento izquierda.");
                            libre=!tablero.tablero[c][filadestino].getOcupada();
                        }return(libre);
                }else return(false);
            }else if(columnaorigen==columnadestino){
                //VERTICAL
                System.out.println("Movimiento reina vertical");
                if(filaorigen>filadestino){
                    //VERTICAL ARRIBA
                    System.out.println("Movimiento arriba");
                    for(f=filaorigen-1;((f>filadestino)&&(libre));f--){
                        libre=!tablero.tablero[f][columnadestino].getOcupada();
                    }return(libre);
                }else if(filaorigen<filadestino){
                    //VERTICAL ABAJO
                    System.out.println("Movimiento abajo");
                    for(f=filaorigen+1;((f<filadestino)&&(libre));f++){
                        libre=!tablero.tablero[f][columnadestino].getOcupada();
                    }return(libre);
                }else return(false);
                
            }else return(false);
        }else{
            System.out.println("Movimiento reina diagonal");
         //movimiento diagonal. no recto
         //Hay 4 posibles movimientos diagonales
         int i=0, j=0;
            if((filadestino>filaorigen)&&(columnadestino>columnaorigen)){
                //Movimiento hacia abajo y a la derecha. 
                System.out.println("Mueve diagonal abajo-derecha");
                for(i=filaorigen+1,j=columnaorigen+1;(i<filadestino)&&(j<columnadestino)&&libre;i++,j++){
                        libre=!tablero.tablero[i][j].getOcupada();
                        
                }return(libre);
        } else if((filadestino>filaorigen)&&(columnadestino<columnaorigen)){
            //Movimiento hacia abajo y a la izda.
            System.out.println("Mueve diagonal abajo-izquierda");
            for(i=filaorigen+1,j=columnaorigen-1;(i<filadestino)&&(j>columnadestino)&&libre;i++,j--){
                    libre=!tablero.tablero[i][j].getOcupada();
                        
                }return(libre);
        }else if((filadestino<filaorigen)&&(columnadestino>columnaorigen)){
            //Movimiento hacia arriba y a la derecha
            System.out.println("Mueve diagonal arriba-derecha");
            for(i=filaorigen-1,j=columnaorigen+1;(i>filadestino)&&(i<columnadestino)&&libre;i--,j++){
                libre=!tablero.tablero[i][j].getOcupada();
                 }  return(libre);
        }else if((filadestino<filaorigen)&&(columnadestino<columnaorigen)){
            //Movimiento hacia arriba y a la izquierda
            System.out.println("Mueve diagonal arriba-izquierda");
            for(i=filaorigen-1,j=columnaorigen-1;(i>filadestino)&&(i>columnadestino)&&libre;i--,j--){
                libre=!tablero.tablero[i][j].getOcupada();
            }  return(libre);
        }   
        System.out.println("El movimiento no se puede realizar. Hay una ficha impidiendo " +
                "el paso.");
        return(false);
        }
        
    }
    
    public boolean es_recto(int fo, int co, int fd, int cd){
        if((fo==fd)||(co==cd)) return(true);
        else return(false);
        
    }
    public Tablero amenazar_casillas(Tablero tablero,int fila, int columna){
        int i,j;
        boolean libre=true;
        
        if(this.getColor()){//FICHA NEGRA
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
            }libre=true;
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
   
}