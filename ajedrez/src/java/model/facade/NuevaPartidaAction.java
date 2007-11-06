/*
 * NuevaPartidaAction.java
 *
 * Created on 6 de noviembre de 2007, 19:17
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package model.facade;

import model.partida.Partida;
import model.util.InstanceNotFoundException;
import model.util.InternalErrorException;

/**
 *
 * @author Alvarete
 */
public class NuevaPartidaAction {
    /** Creates a new instance of NuevaPartidaAction */
    public NuevaPartidaAction() {
    }
    public Object execute() 
        throws InstanceNotFoundException, InternalErrorException {
        Partida partida =  new Partida();           
        return partida;
    }
    
}
