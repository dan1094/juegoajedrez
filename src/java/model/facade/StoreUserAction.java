/*
 * StoreUserAction.java
 *
 * Created on 15 de octubre de 2007, 22:39
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package model.facade;

import java.sql.Connection;
import model.user.SQLUserDAO;
import model.user.SQLUserDAOFactory;
import model.user.UserDTO;
import model.util.InstanceNotFoundException;
import model.util.InternalErrorException;
import model.util.TransactionalPlainAction;

/**
 *
 * @author Alvarete
 */
public class StoreUserAction implements TransactionalPlainAction {

    private UserDTO userDTO;
    
    public StoreUserAction(UserDTO userDTO) {
        
        this.userDTO = userDTO;
        
    }
    public Object execute(Connection connection) 
        throws InstanceNotFoundException, InternalErrorException {
                
        SQLUserDAO userDAO = SQLUserDAOFactory.getDAO();       
        userDAO.update(connection, userDTO);
        
        return null;            

    }

}
