/*
 * Alfil.java
 *
 * Created on 19 de septiembre de 2007, 13:05
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package clases;


/**
 *
 * @author Pablo
 */
public class Alfil extends Ficha{
    
    /** Creates a new instance of Alfil */
    public Alfil(int id_ficha, boolean color){
        super(id_ficha,color);
        this.setTipo_ficha("alfil");
    }
    
    public boolean movimiento_correspondiente_ficha(Tablero tablero, int fo, int co, int fd, int cd){
        //Para comprobar que es diagonal, debemos sumar a la fila y a la columna
        //a la vez el mismo numero. Sumar y restar el mismo numero. Restar el mismo numero.
        //Restar y sumar el mismo numero.
       System.out.println("Mueve un alfil.");
        int i=fo;
        int j=co;
        boolean libre=true;
        
        //Hay 4 posibles movimientos diagonales
        if((fd>fo)&&(cd>co)){
            //Movimiento hacia abajo y a la derecha. 
            System.out.println("Mueve diagonal abajo-derecha");
            for(i=fo+1,j=co+1;(i<fd)&&(j<cd)&&libre;i++,j++) libre=!tablero.tablero[i][j].getOcupada();
        } else if((fd>fo)&&(cd<co)){
                   //Movimiento hacia abajo y a la izda.
                    System.out.println("Mueve diagonal abajo-izquierda");
                    for(i=fo+1,j=co-1;(i<fd)&&(j>cd)&&libre;i++,j--)  libre=!tablero.tablero[i][j].getOcupada();
                }else if((fd<fo)&&(cd>co)){
                         //Movimiento hacia arriba y a la derecha
                          System.out.println("Mueve diagonal arriba-derecha");
                          for(i=fo-1,j=co+1;(i>fd)&&(j<cd)&&libre;i--,j++) libre=!tablero.tablero[i][j].getOcupada();                  
                      }else if((fd<fo)&&(cd<co)){
                                //Movimiento hacia arriba y a la izquierda
                                System.out.println("Mueve diagonal arriba-izquierda");
                                for(i=fo-1,j=co-1;(i>fd)&&(i>cd)&&libre;i--,j--)  libre=!tablero.tablero[i][j].getOcupada();
                            }else return(false);
        if(libre) return(libre);
        else {
             System.out.println("El movimiento no se puede realizar. Hay una ficha impidiendo " +
                "el paso.");
             return(false);
        }
    
    
    }    
    
}