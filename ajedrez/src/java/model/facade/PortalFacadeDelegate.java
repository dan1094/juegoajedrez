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
import model.partida.Game;
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
    
    public Game mover(int filaOrigen, int columnaOrigen,int filaDestino,int columnaDestino,Game game) 
        throws InternalErrorException;
    public boolean esTablas(Game game) throws InternalErrorException;
    
    public boolean esJaqueMate(Game game) throws InternalErrorException; 
    
    public Game nuevaPartida() throws InternalErrorException; 
    
    public Game coronar(int filaOrigen, int columnaOrigen,
            Game game, int eleccion) throws InternalErrorException;
    
}
