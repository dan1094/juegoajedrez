/*
 * PortalFacadeDelegate.java
 *
 * Created on 15 de octubre de 2007, 19:43
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package model.facade;

import java.io.Serializable;
import model.partida.Partida;
import model.user.UserDTO;
import model.util.DuplicateInstanceException;
import model.util.IncorrectPasswordException;
import model.util.InstanceNotFoundException;
import model.util.InternalErrorException;

/**
 *
 * @author Alvarete
 */
public interface PortalFacadeDelegate extends Serializable {

    public void registerUser(UserDTO userDTO)
        throws DuplicateInstanceException, InternalErrorException;

    public LoginResultDTO signIn(String nick, String password,
        boolean passwordIsEncrypted)
        throws InstanceNotFoundException, IncorrectPasswordException,
            InternalErrorException;
        
    public UserDTO getUser() throws InternalErrorException;
    
    public void storeUser(UserDTO userDTO)
        throws InternalErrorException;

    public void changePassword(String oldPassword, String newPassword) 
        throws IncorrectPasswordException, InternalErrorException;
    
    public Partida mover(int filaOrigen, int columnaOrigen,int filaDestino,int columnaDestino,Partida partida) 
        throws InternalErrorException;
    public boolean esTablas(Partida partida) throws InternalErrorException;
    
    public boolean esJaqueMate(Partida partida) throws InternalErrorException; 
    
    public Partida nuevaPartida() throws InternalErrorException; 
    
    public Partida coronar(int filaOrigen, int columnaOrigen,
            Partida partida, int eleccion) throws InternalErrorException;
    
}
