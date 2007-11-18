/*
 * EsJaqueMateAction.java
 *
 * Created on 6 de noviembre de 2007, 16:54
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package model.facade;

import  model.partida.*;
import model.util.*; 


/**
 *
 * @author Administrador
 */
public class EsJaqueMateAction {
    
   private Partida partida;
   
   public EsJaqueMateAction(Partida partida)
   {
       this.partida=partida;
   
   }
    public boolean execute(Partida partida) 
        throws InstanceNotFoundException, InternalErrorException {
                
        return  partida.es_mate(partida);               

       
    }
}
