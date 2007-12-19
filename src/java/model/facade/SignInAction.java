/*
 * SignInAction.java
 *
 * Created on 15 de octubre de 2007, 21:44
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package model.facade;

import java.sql.Connection;
import model.user.SQLUserDAO;
import model.user.SQLUserDAOFactory;
import model.user.UserDTO;
import model.util.IncorrectPasswordException;
import model.util.InstanceNotFoundException;
import model.util.InternalErrorException;
import model.util.NonTransactionalPlainAction;
import model.util.PasswordEncrypter;

/**
 *
 * @author Alvarete
 */
public class SignInAction implements NonTransactionalPlainAction {

    private String nick;
    private String password;

    public SignInAction(String nick, String password, boolean passwordIsEncrypted) {    
        
        this.nick = nick;
        
        if (passwordIsEncrypted) {
            this.password = password;
        } else {
            this.password = PasswordEncrypter.crypt(password);
        }
            
    }
    
    public Object execute(Connection connection) 
        throws IncorrectPasswordException, InstanceNotFoundException, 
            InternalErrorException {
                
        SQLUserDAO userDAO = SQLUserDAOFactory.getDAO();
        UserDTO userDTO = userDAO.find(connection, nick);

        if (!userDTO.getPass().equals(password)) {
            throw new IncorrectPasswordException(nick);
        }

        return new LoginResultDTO(userDTO.getNombre(), password);

    }
}
