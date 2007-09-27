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
    
    protected Long id_ficha;
    protected boolean color;
    protected String tipo_ficha;
    
    
    
    
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
    
    public String getTipo_ficha(){
        return(this.tipo_ficha);
    }
    
    public void setTipo_ficha(String tipo_ficha){
        this.tipo_ficha=tipo_ficha;
    }
    
    public abstract boolean movimiento_correspondiente_ficha(int filaorigen, int columnaorigen, int filadestino, int columnadestino);
    
    public boolean dentro(int fil, int col){
        if(fil>=1&&fil<=8&&col<=8&&col>=1) return(true);
        else return(false);
    }
    
        
}