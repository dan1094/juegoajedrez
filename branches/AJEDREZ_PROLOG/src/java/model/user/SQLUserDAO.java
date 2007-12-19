/*
 * SQLUserDAO.java
 *
 * Created on 14 de octubre de 2007, 23:51
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package model.user;

import model.util.*;
import java.sql.Connection;

/**
 *
 * @author Alvarete
 */

public interface SQLUserDAO {

    public void create(Connection connection, UserDTO userDTO)
        throws DuplicateInstanceException, InternalErrorException;
        
    public boolean exists(Connection connection, String nick)
        throws InternalErrorException;
        
    public UserDTO find(Connection connection, String nick)
        throws InstanceNotFoundException, InternalErrorException;
        
    public void update(Connection connection, UserDTO userDTO) 
        throws InstanceNotFoundException, InternalErrorException;
        
    public void remove(Connection connection, String nick) 
        throws InstanceNotFoundException, InternalErrorException;

}
