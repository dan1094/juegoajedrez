/*
 * Caballo.java
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
public class Caballo extends Ficha{
    
    /** Creates a new instance of Caballo */
    public Caballo(int id_ficha, boolean color){
        super(id_ficha,color);
        this.setTipo_ficha("caballo");
    }
    
    public boolean movimiento_correspondiente_ficha(Tablero tablero,int fo,int co,int fd,int cd){
       //Se debe comprobar que el movimiento es en L. Dos hacia delante y una al lado o viceversa.
       //No importa si hay fichas por el camino, ya que puede saltar.
        System.out.println("Entra en el caballo.");
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
            return(false);
        }
    }
}
