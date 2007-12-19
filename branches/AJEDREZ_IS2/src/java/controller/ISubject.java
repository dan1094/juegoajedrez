/*
 * ISubject.java
 *
 * Created on 29 de octubre de 2007, 17:46
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
public interface ISubject {
    
    /** Creates a new instance of ISubject */
    public void addObserver(IObserver obs);
    public void removeObserver(IObserver obs);
    public void notifyObserver();
    
    
}
