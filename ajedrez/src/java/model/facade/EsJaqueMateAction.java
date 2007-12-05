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
    
   private Game game;
   
   public EsJaqueMateAction(Game game)
   {
       this.game=game;
   
   }
    public boolean execute(Game game) 
        throws InstanceNotFoundException, InternalErrorException {
                
        return  game.es_mate(game);               

       
    }
}
