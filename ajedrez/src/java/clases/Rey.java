/*
 * Rey.java
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
public class Rey extends Ficha{
    
    protected boolean puede_enrocar;
    
    /** Creates a new instance of Rey */
    public Rey(int id_ficha, boolean color){
        super(id_ficha,color);
        this.setTipo_ficha("rey");
        this.puede_enrocar=true;
  
        
    }
    
    public boolean getPuede_enrocar(){
        return(this.puede_enrocar);
    }
    public void setPuede_enrocar(boolean enrocar){
        this.puede_enrocar=enrocar;
    }
  
    /**Funcion que comprueba que el rey puede mover a la casilla destino. ESto se 
     *debe a que puede estar amenazada por una ficha del oponente*/
    public boolean esta_amenazada(Casilla casilla){
        
    return(false);
    }
    
    
    
    public boolean movimiento_correspondiente_ficha(Tablero tablero,int filaorigen, int columnaorigen, int filadestino, int columnadestino){
       //Hay que comprobar que mueve solo de uno en uno y que la posición no esta amenazada.
       
        
       return(true);
        
    }
    
    
    
}
