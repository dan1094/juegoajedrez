/*
 * RegisterUserAction.java
 *
 * Created on 15 de octubre de 2007, 21:31
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package model.facade;

import java.sql.Connection;
import model.user.SQLUserDAO;
import model.user.SQLUserDAOFactory;
import model.user.UserDTO;
import model.util.DuplicateInstanceException;
import model.util.InstanceNotFoundException;
import model.util.InternalErrorException;
import model.util.PasswordEncrypter;
import model.util.TransactionalPlainAction;

/**
 *
 * @author Alvarete
 */
public class RegisterUserAction implements TransactionalPlainAction {

    
    private UserDTO userDTO;

    public RegisterUserAction(UserDTO userDTO) {
        
        this.userDTO = userDTO;
        this.userDTO.setPass(PasswordEncrypter.crypt(this.userDTO.getPass()));
    }
        

    public Object execute(Connection connection) 
        throws InstanceNotFoundException, DuplicateInstanceException, 
               InternalErrorException {
                
        SQLUserDAO userDAO = SQLUserDAOFactory.getDAO();
        userDAO.create(connection, userDTO);
            
        return null;            
    }    
}
