/*
 * Reina.java
 *
 * Created on 19 de septiembre de 2007, 13:06
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package clases;

/**
 *
 * @author Pablo
 */
public class Reina extends Ficha{
    
    /** Creates a new instance of Reina */
    public Reina() {
    }
    
    
    
    public boolean movimiento_correspondiente_ficha(Tablero tablero,int filaorigen, int columnaorigen, int filadestino, int columnadestino){
       //La reina es una mezcla entre el alfil y la torre.
        
        
       
        
       return(true);
        
    }
    
    public boolean diagonal_libre(Tablero tablero, int fo, int co, int fd, int cd){
        //Para comprobar que es diagonal, debemos sumar a la fila y a la columna
        //a la vez el mismo numero. Sumar y restar el mismo numero. Restar el mismo numero.
        //Restar y sumar el mismo numero.
        int i=fo;
        int j=co;
        boolean libre=true;
        
        //Hay 4 posibles movimientos diagonales
        //Movimiento hacia abajo y a la derecha.  
        if((fd>fo)&&(cd>co)){
          
                for(i=fo,j=co;(i<fd)&&(i<cd)&&super.dentro(i,j)&&libre;i++,j++){
                //Mientras la casilla consultada este dentro del tablero, mientras
                //sea menor que el destino y mientras este vacia
                Casilla cas=tablero.getCasilla(i,j);
                libre=!cas.getOcupada();
                 }  return(libre);
        }
        
        //Movimiento hacia abajo y a la izda. 
        else if((fd>fo)&&(cd<co)){
                for(i=fo,j=co;(i<fd)&&(i>cd)&&super.dentro(i,j)&&libre;i++,j--){
                //Mientras la casilla consultada este dentro del tablero, mientras
                //sea menor que el destino y mientras este vacia
                Casilla cas=tablero.getCasilla(i,j);
                libre=!cas.getOcupada();
                 }  return(libre);
        }
        //Movimiento hacia arriba y a la derecha
        else if((fd<fo)&&(cd>co)){
            for(i=fo,j=co;(i>fd)&&(i<cd)&&super.dentro(i,j)&&libre;i--,j++){
                //Mientras la casilla consultada este dentro del tablero, mientras
                //sea menor que el destino y mientras este vacia
                Casilla cas=tablero.getCasilla(i,j);
                libre=!cas.getOcupada();
                 }  return(libre);
        }
         //Movimiento hacia arriba y a la izquierda
        else if((fd<fo)&&(cd<co)){
            for(i=fo,j=co;(i>fd)&&(i>cd)&&super.dentro(i,j)&&libre;i--,j--){
                //Mientras la casilla consultada este dentro del tablero, mientras
                //sea menor que el destino y mientras este vacia
                Casilla cas=tablero.getCasilla(i,j);
                libre=!cas.getOcupada();
                 }  return(libre);
        }   
            
        return(false);
    }
    
}
