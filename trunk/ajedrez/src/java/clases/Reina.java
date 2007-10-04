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
    public Reina(int id_ficha, boolean color){
        super(id_ficha,color);
        this.setTipo_ficha("reina");
    }
    
    public boolean movimiento_correspondiente_ficha(Tablero tablero,int filaorigen, 
        int columnaorigen, int filadestino, int columnadestino){
        //La reina es una mezcla entre el alfil y la torre.
        boolean horizontal = es_recto(filaorigen, columnaorigen, filadestino, columnadestino);
        if(horizontal)
        {
            
        }else{
            
        }
        
       return(true);
        
    }
    
    public boolean es_recto(int fo, int co, int fd, int cd){
        if((fo==fd)||(co==cd)) return(true);
        else return(false);
        
    }
    
   
}
