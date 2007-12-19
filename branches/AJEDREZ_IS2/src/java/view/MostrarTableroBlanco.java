/*
 * MostrarTableroBlanco.java
 *
 * Created on 23 de octubre de 2007, 12:18
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package view;

import model.partida.Game;
import org.me.hello.VistaTablero;
import org.me.hello.VistaTableroPieza;


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
        
        VistaTablero = new VistaTablero();
    }
    public void update(Game game)
    {
        VistaTableroPieza vistaTableroPieza = new VistaTableroPieza();
             
        vistaTableroPieza.init(vistaTableroPieza);
             
    }
    public void borrar(Game game)
    {
        VistaTableroPieza vistaTableroPieza = new VistaTableroPieza();
             
       // vistaTableroPieza.hideBoard();
        
    }
   
    
}
