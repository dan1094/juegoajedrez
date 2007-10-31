/*
 * IObserver.java
 *
 * Created on 29 de octubre de 2007, 17:42
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package controller;
import model.partida.Tablero;

/**
 *
 * @author Administrador
 */
public interface IObserver {
    
    public void update(Tablero tablero);
 
}
