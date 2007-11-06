/*
 * PlainPortalFacadeDelegate.java
 *
 * Created on 15 de octubre de 2007, 21:06
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package model.facade;

import javax.sql.DataSource;
import model.partida.Partida;
import model.user.UserDTO;
import model.util.DataSourceLocator;
import model.util.DuplicateInstanceException;
import model.util.GlobalNames;
import model.util.IncorrectPasswordException;
import model.util.InstanceNotFoundException;
import model.util.InternalErrorException;
import model.util.PlainActionProcessor;

/**
 *
 * @author Alvarete
 */
public final class PlainPortalFacadeDelegate implements PortalFacadeDelegate {

    private String nick;
    
    /** Creates a new instance of PlainPortalFacadeDelegale */
    public PlainPortalFacadeDelegate() {
        nick = null;
    }

    public void registerUser(UserDTO userDTO)
        throws DuplicateInstanceException, 
               InternalErrorException {

        try {
        
            RegisterUserAction action = new RegisterUserAction(userDTO);
                
            PlainActionProcessor.process(getDataSource(), action);
            this.nick = nick;
            
        } catch (DuplicateInstanceException e) {
            throw e;
        } catch (InternalErrorException e) {
            throw e;
        } catch (Exception e) {
            throw new InternalErrorException(e);
        }
            
    }

    public LoginResultDTO signIn(String nick, String password,
        boolean passwordIsEncrypted)
        throws InstanceNotFoundException, IncorrectPasswordException,
            InternalErrorException {

        try {
        
            SignInAction action = new SignInAction(nick, 
                password, passwordIsEncrypted);
                
            LoginResultDTO loginResultDTO = 
                (LoginResultDTO) PlainActionProcessor.process(getDataSource(),
                    action);
            this.nick = nick;
            
            return loginResultDTO;
            
        } catch (IncorrectPasswordException e) {
            throw e;
        } catch (InstanceNotFoundException e) {
            throw e;
        } catch (InternalErrorException e) {
            throw e;
        } catch (Exception e) {
            throw new InternalErrorException(e);
        }
                            
    }
        
    public UserDTO getUser() throws InternalErrorException {

        try {
        
            GetUserAction action = new GetUserAction(nick);
                
            return (UserDTO) PlainActionProcessor.process(getDataSource(),
                action);
            
        } catch (InstanceNotFoundException e) {
            throw new InternalErrorException(e);
        } catch (InternalErrorException e) {
            throw e;
        } catch (Exception e) {
            throw new InternalErrorException(e);
        }
    
    }
    
    public void storeUser(UserDTO userDTO)
        throws InternalErrorException {

        try {
        
            StoreUserAction action =  new StoreUserAction(userDTO);
                
            PlainActionProcessor.process(getDataSource(), action);
            
        } catch (InstanceNotFoundException e) {
            throw new InternalErrorException(e);
        } catch (InternalErrorException e) {
            throw e;
        } catch (Exception e) {
            throw new InternalErrorException(e);
        }
     
    }

    public void changePassword(String oldClearPassword, String newClearPassword) 
        throws IncorrectPasswordException, InternalErrorException {

        try {
        
            ChangePasswordAction action = new ChangePasswordAction(nick, 
                oldClearPassword, newClearPassword);
                
            PlainActionProcessor.process(getDataSource(), action);
            
        } catch (IncorrectPasswordException e) {
            throw e;
        } catch (InstanceNotFoundException e) {
            throw new InternalErrorException(e);
        } catch (InternalErrorException e) {
            throw e;
        } catch (Exception e) {
            throw new InternalErrorException(e);
        }
    
    }
    
    public Partida mover(int filaOrigen, int columnaOrigen,int filaDestino,int columnaDestino,Partida partida) 
        throws InternalErrorException
    {
        try
        {
            MoverAction moverAction = new MoverAction(filaOrigen,columnaOrigen,filaDestino,columnaDestino,partida);
        
            return (Partida) moverAction.execute();
            
        } catch (InternalErrorException e) {
            throw e;
        } catch (Exception e) {
            throw new InternalErrorException(e);
        }
    }
    public boolean esTablas(Partida partida) throws InternalErrorException 
    {
         try
        {
            EsTablasAction esTablasAction = new EsTablasAction(partida);
        
            return esTablasAction.execute();
            
        } catch (InternalErrorException e) {
            throw e;
        } catch (Exception e) {
            throw new InternalErrorException(e);
        }
    }

    public boolean esJaqueMate(Partida partida) throws InternalErrorException 
    {
         try
        {
            EsJaqueMateAction esJaqueMateAction = new EsJaqueMateAction(partida);
        
            return esJaqueMateAction.execute();
            
        } catch (InternalErrorException e) {
            throw e;
        } catch (Exception e) {
            throw new InternalErrorException(e);
        }
    }
    
   
    
    private DataSource getDataSource() throws InternalErrorException {
        return DataSourceLocator.getDataSource(
            GlobalNames.MYPORTAL_DATA_SOURCE);       
    }

   
   
    
}
