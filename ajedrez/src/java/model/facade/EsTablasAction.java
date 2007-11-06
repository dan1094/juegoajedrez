/*
 * EsTablasAction.java
 *
 * Created on 6 de noviembre de 2007, 17:12
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
public class EsTablasAction {
    
   private Partida partida;
   
   public EsTablasAction(Partida partida)
   {
       this.partida=partida;
   
   }
    public boolean execute() 
        throws InstanceNotFoundException, InternalErrorException {
                
        return  partida.son_tablas();               

       
    }
    
    
}
