/*
 * GetUserProfileAction.java
 *
 * Created on 15 de octubre de 2007, 21:29
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package model.facade;

import java.sql.Connection;
import model.user.SQLUserDAO;
import model.user.SQLUserDAOFactory;
import model.util.InstanceNotFoundException;
import model.util.InternalErrorException;
import model.util.NonTransactionalPlainAction;

/**
 *
 * @author Alvarete
 */
public class GetUserAction implements NonTransactionalPlainAction {

    private String nick;
    
    public GetUserAction(String nick) {
        this.nick = nick;
    }
    
    public Object execute(Connection connection) 
        throws InstanceNotFoundException, InternalErrorException {
                
        SQLUserDAO userDAO = SQLUserDAOFactory.getDAO();
            
        return userDAO.find(connection, nick);                

    }
}