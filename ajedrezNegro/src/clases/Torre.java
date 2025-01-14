/*
 * Torre.java
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
public class Torre extends Ficha{
    
    /**
     * Creates a new instance of Torre
     */
    public Torre(int id_ficha, boolean color){
        super(id_ficha,color);
        this.setTipo_ficha("torre");
    }
    
    public boolean movimiento_correspondiente_ficha(Tablero tablero,int fo,int co,int fd,int cd){
       //Se debe comprobar que mueve recto y que no hay fichas por el camino.
       int i=0;
       int j=0;
       boolean libre=true;
       System.out.println("Se mueve una torre.");
       
       //Hay 4 posibles movimientos. Derecha, Izquierda, Arriba y Abajo
       if((co==cd)&&(fo==fd)) {
           //El origen y el destino son iguales
           System.out.println("Origen y destino iguales. No se puede mover.");
           return(false);           
       }else if((fo!=fd)&&(co!=cd)) {
           System.out.println("Movimiento no permitido. Debe mover en linea recta.");
           return(false);
       }else if(fo==fd){
           //Quiere decir que se mueve en la misma fila (HORIZONTALMENTE)
           System.out.println("Mueve horizontalmente.");
           if(cd>co){
               //Mueve hacia la derecha
               System.out.println("Mueve a la derecha.");
               for(i=co+1;((i<cd)&&(libre));i++) {
                  //Miro si esa casilla esta ocupada
                  libre=!tablero.tablero[fo][i].getOcupada();
               }
               
           }else if(cd<co){
               //Mueve hacia la izquierda
               System.out.println("Mueve a la izquierda.");
               for(i=co-1;(i>cd)&&libre;i--) {
                  //Miro si esa casilla esta ocupada
                  libre=!tablero.tablero[fo][i].getOcupada();
               }
            
           }
       }else if(co==cd){
           //Quiere decir que se mueve en la misma columna (VERTICALMENTE)
            System.out.println("Mueve verticalmente.");
           if(fd>fo){
               //Mueve hacia abajo
               System.out.println("Mueve hacia abajo.");
               for(i=fo+1;(i<fd)&&libre;i++) {
                  //Miro si esa casilla esta ocupada
                  libre=!tablero.tablero[i][co].getOcupada();
               }
               
           }else if(fd<fo){
               //Mueve hacia arriba
               System.out.println("Mueve hacia arriba.");
               for(i=fo-1;(i>fd)&&libre;i--) {
                  //Miro si esa casilla esta ocupada
                  libre=!tablero.tablero[i][co].getOcupada();
               }
           }
       }
       if(libre) return(libre);
       else{
            System.out.println("Hay fichas impidiendo el paso");
            return(libre);
       }
       
       
    }
    
}
