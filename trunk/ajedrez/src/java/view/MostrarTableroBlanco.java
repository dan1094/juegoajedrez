/*
 * MostrarTableroBlanco.java
 *
 * Created on 23 de octubre de 2007, 12:18
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package view;

import model.partida.Partida;
import org.me.hello.*;



/**
 *
 * @author Administrador
 */
public class MostrarTableroBlanco extends MostrarTablero{
    
    /**
     * Creates a new instance of MostrarTableroBlanco
     */
    private  VistaTablero VistaTablero;
    
    public MostrarTableroBlanco() {
        
        //VistaTablero = new VistaTablero();
    }
    public void update(Partida partida)
    {
        VistaTableroPieza vistaTableroPieza = new VistaTableroPieza();
             
        vistaTableroPieza.init(vistaTableroPieza);
             
    }
    public void borrar(Partida partida)
    {
        VistaTableroPieza vistaTableroPieza = new VistaTableroPieza();
             
        vistaTableroPieza.hideBoard();
        
    }
   
    
}
