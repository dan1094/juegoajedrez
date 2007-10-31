/*
 * MostrarTablero.java
 *
 * Created on 22 de octubre de 2007, 18:59
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package view;

import clases.*;
import controller.IObserver;
import model.partida.Tablero;
/**
 *
 * @author Alvarete
 */
public abstract class MostrarTablero implements IObserver  {
    
    /** Creates a new instance of MostrarTablero */
    public MostrarTablero() {
    }
    public abstract void update(Tablero tablero);
    
}
