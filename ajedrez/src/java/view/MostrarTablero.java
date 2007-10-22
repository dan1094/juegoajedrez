/*
 * MostrarTablero.java
 *
 * Created on 22 de octubre de 2007, 18:59
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package view;

import clases.*;
/**
 *
 * @author Alvarete
 */
public class MostrarTablero {
    
    /** Creates a new instance of MostrarTablero */
    public MostrarTablero() {
    }
    public void mostrar(Tablero tablero){
        Casilla casillaAux;
        Ficha fichaAux;
        System.out.println("     a    b    c    d    e    f    g    h  ");
        for(int i=0;i<8;i++){
            System.out.println("  ·········································");
            System.out.print((i+1)+" ·"); 
            for(int j=0;j<8;j++){
                casillaAux = tablero.getCasilla(i,j);
                //Hay ficha por lo tanto imprimimos su contenido
                if(casillaAux.getOcupada()){
                    fichaAux = casillaAux.getFicha();
                    String tipoFicha = fichaAux.getTipo_ficha();
                    if(tipoFicha=="rey"){
                        System.out.print(" K");
                    }else if(tipoFicha=="reina"){
                        System.out.print(" Q");
                    }else if(tipoFicha=="alfil"){
                        System.out.print(" A");
                    }else if(tipoFicha=="torre"){
                        System.out.print(" T");
                    }else if(tipoFicha=="caballo"){
                        System.out.print(" C");
                    }
                    else if(tipoFicha=="peon"){
                        System.out.print(" P");
                    }
                    if(fichaAux.getColor())//Si es negro
                        System.out.print("n ");
                    else System.out.print("b ");
                }
                //No hay ficha por lo tanto imprimimos cuatro espacios en blanco
                else{
                    System.out.print("    ");
                }
                System.out.print("·");
            }
            System.out.println();
        }
        System.out.println("  ·········································");
    }
    
}
