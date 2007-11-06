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
   private Partida partida;
    
    
    public MoverAction(int filaOrigen, int columnaOrigen, int filaDestino
            , int columnaDestino, Partida partida) {
        
        this.filaOrigen = filaOrigen;
        this.filaDestino = filaDestino;
        this.columnaOrigen = columnaOrigen;
        this.columnaDestino = columnaDestino;
        this.partida = partida;
       
    }
    
    public Object execute() 
        throws InstanceNotFoundException, InternalErrorException {
                
        partida.mover(filaOrigen,columnaOrigen,filaDestino,columnaDestino,partida.getTablero());               

        return partida;
    }
}
