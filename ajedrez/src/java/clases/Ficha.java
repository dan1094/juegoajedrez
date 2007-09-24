/*
 * Ficha.java
 *
 * Created on 19 de septiembre de 2007, 12:50
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package clases;


/**
 *
 * @author Pablo
 */
public abstract class Ficha {
    
    protected boolean color;
    protected Long id_ficha;
 
    
    public boolean getColor(){
        return(this.color);
    }
    
    public void setColor(boolean color){
        //color=true -> BLANCAS
        //color=false -> NEGRAS
        this.color=color;
    }
    
    public Long getId_ficha(){
        return(this.id_ficha);
    }
    
    public void setId_ficha(Long id_ficha){
        this.id_ficha=id_ficha;
    }
    
    
}