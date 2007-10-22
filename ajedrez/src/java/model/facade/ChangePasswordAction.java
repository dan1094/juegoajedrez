/*
 * ChangePasswordAction.java
 *
 * Created on 15 de octubre de 2007, 21:22
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
import model.util.PasswordEncrypter;
import model.util.TransactionalPlainAction;

/**
 *
 * @author Alvarete
 */
public class ChangePasswordAction implements TransactionalPlainAction {

    private String nick;
    private String oldEncryptedPassword;
    private String newEncryptedPassword;

    public ChangePasswordAction(String nick, String oldClearPassword,
        String newClearPassword) {
        
        this.nick = nick;
        this.oldEncryptedPassword = PasswordEncrypter.crypt(oldClearPassword);
        this.newEncryptedPassword = PasswordEncrypter.crypt(newClearPassword);
            
    }

    /**
     *
     * @return <code>null</code>
     */
    public Object execute(Connection connection) 
        throws InstanceNotFoundException, IncorrectPasswordException,
        InternalErrorException {
                
        SQLUserDAO userDAO = SQLUserDAOFactory.getDAO();
        UserDTO userDTO = userDAO.find(connection, nick);
            
        if (!userDTO.getPass().equals(
            oldEncryptedPassword)) {
            throw new IncorrectPasswordException(nick);
        }

        userDTO.setPass(newEncryptedPassword);
        userDAO.update(connection, userDTO);

        return null;            

    }

}
