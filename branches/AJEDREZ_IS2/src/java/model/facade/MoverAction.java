/*
 * MoverAction.java
 *
 * Created on 6 de noviembre de 2007, 16:03
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
public class MoverAction {
    
   private int filaOrigen;
   private int filaDestino;
   private int columnaOrigen;
   private int columnaDestino;
   private Game game;
    
    
    public MoverAction(int filaOrigen, int columnaOrigen, int filaDestino
            , int columnaDestino, Game game) {
        
        this.filaOrigen = filaOrigen;
        this.filaDestino = filaDestino;
        this.columnaOrigen = columnaOrigen;
        this.columnaDestino = columnaDestino;
        this.game = game;
       
    }
    
    public Object execute() 
        throws InstanceNotFoundException, InternalErrorException {
                
        game.mover(filaOrigen,columnaOrigen,filaDestino,columnaDestino,game.getTablero());               

        return game;
    }
}
