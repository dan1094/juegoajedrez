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
       int i=fo;
       int j=co;
       boolean libre=true;
       
       
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
           if(cd>co){
               //Mueve hacia la derecha
               for(i=co+1;(i<cd)&&libre;i++) {
                  //Miro si esa casilla esta ocupada
                  libre=!tablero.tablero[fo][i].getOcupada();
               }
               //Devolvemos libre, porque puede haber dos posibilidades:
               //(1) que salga del for por llegar al final-> libre=true
               //(2) que salga del for porque encontro ficha -> libre=false
               return(libre);
           }else if(cd<co){
               //Mueve hacia la izquierda
               for(i=co-1;(i>cd)&&libre;i++) {
                  //Miro si esa casilla esta ocupada
                  libre=!tablero.tablero[fo][i].getOcupada();
               }
               //Igual que el caso anterior
               return(libre);
           }
       }else if(co==cd){
           //Quiere decir que se mueve en la misma columna (VERTICALMENTE)
           if(fd>fo){
               //Mueve hacia abajo
               for(i=fo+1;(i<fd)&&libre;i++) {
                  //Miro si esa casilla esta ocupada
                  libre=!tablero.tablero[i][co].getOcupada();
               }
               //Devolvemos libre, porque puede haber dos posibilidades:
               //(1) que salga del for por llegar al final-> libre=true
               //(2) que salga del for porque encontro ficha -> libre=false
               return(libre);
           }else if(fd<fo){
               //Mueve hacia arriba
               for(i=fo-1;(i>fd)&&libre;i++) {
                  //Miro si esa casilla esta ocupada
                  libre=!tablero.tablero[i][co].getOcupada();
               }
               //Igual que el caso anterior
               return(libre);
           }
       }
        return(false);
    }
    
}
