/*
 * CoronarAction.java
 *
 * Created on 6 de noviembre de 2007, 16:48
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
public class CoronarAction {
    
    private int filaOrigen;
    private int columnaOrigen;
    private int filaDestino;
    private int columnaDestino;
    private Game game;
    private int eleccion;
    
    
    public CoronarAction(int filaOrigen, int columnaOrigen,
            Game game, int eleccion) {
        
        this.filaOrigen = filaOrigen;
        this.columnaOrigen = columnaOrigen;       
        this.game = game;
        this.eleccion = eleccion;
       
    }
    
    public Object execute() 
        throws InstanceNotFoundException, InternalErrorException {
                
        game.cambio_ficha(game,eleccion,filaOrigen,columnaOrigen,filaDestino,columnaDestino);               

        return game;
    }
    
}
