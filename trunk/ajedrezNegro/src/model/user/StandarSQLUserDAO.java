/*
 * StandarSQLUseProfileDAO.java
 *
 * Created on 14 de octubre de 2007, 23:31
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package model.user;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.util.*;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Alvarete
 */
public class StandarSQLUserDAO implements SQLUserDAO{
    
    public void create(Connection connection, UserDTO userDTO)
        throws DuplicateInstanceException, InternalErrorException {
        
        /* Check if the user already exists. */
        if (exists(connection, userDTO.getNick())) {
            throw new DuplicateInstanceException(userDTO.getNick(),
                UserDTO.class.getName());
        }

        PreparedStatement preparedStatement = null;
    
        try {

            /* Create "preparedStatement". */
            System.out.println("Vamos a meter un usuario");
            String queryString = "INSERT INTO Usuario" +
                " (nick, password, nombre, apellido, email)" +
                " VALUES (?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(queryString);    
            
            /* Fill "preparedStatement". */
            int i = 1;
            preparedStatement.setString(i++, userDTO.getNick());
            preparedStatement.setString(i++, userDTO.getPass());
            preparedStatement.setString(i++, userDTO.getNombre());
            preparedStatement.setString(i++, userDTO.getApellido());
            preparedStatement.setString(i++, userDTO.getEmail());
                        
            /* Execute query. */
            int insertedRows = preparedStatement.executeUpdate();
        
            if (insertedRows == 0) {
                throw new SQLException("Can not add row to table" +
                    " 'Usuario'");
            }

            if (insertedRows > 1) {
                throw new SQLException("Duplicate row for nick name = '" + 
                    userDTO.getNick() + "' in table 'Usuario'");
            }
        
        } catch (SQLException e) {
            throw new InternalErrorException(e);
        } finally {
            GeneralOperations.closeStatement(preparedStatement);
        }    
        
    }

    public boolean exists(Connection connection, String nick) 
        throws InternalErrorException {
        
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            /* Create "preparedStatement". */
            String queryString = "SELECT nick FROM Usuario" +
                " WHERE nick = ?";
            preparedStatement = connection.prepareStatement(queryString);
            
            /* Fill "preparedStatement". */
            int i = 1;
            preparedStatement.setString(i++, nick);
            
            /* Execute query. */
            resultSet = preparedStatement.executeQuery();

            return resultSet.next();
            
        } catch (SQLException e) {
            throw new InternalErrorException(e);    
        } finally {
            GeneralOperations.closeResultSet(resultSet);
            GeneralOperations.closeStatement(preparedStatement);
        }
        
    }
    public UserDTO find(Connection connection, String nick)
        throws InstanceNotFoundException, InternalErrorException {
        
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            /* Create "preparedStatement". */
            String queryString = "SELECT password, nombre, apellido," +
                " email FROM Usuario WHERE nick = ?";
            preparedStatement = connection.prepareStatement(queryString);
            
            /* Fill "preparedStatement". */
            int i = 1;
            preparedStatement.setString(i++, nick);
            
            /* Execute query. */
            resultSet = preparedStatement.executeQuery();
            
            if (!resultSet.next()) {
                throw new InstanceNotFoundException(nick,
                    UserDTO.class.getName());
            }

            /* Get results. */
            i = 1;
            String password = resultSet.getString(i++);
            String nombre = resultSet.getString(i++);
            String apellido = resultSet.getString(i++);
            String email = resultSet.getString(i++);
            UserDTO userDTO= 
                    new UserDTO(nick,password, nombre, apellido, email);
            
            /* Return the value object. */
            return userDTO;
            
        } catch (SQLException e) {
            throw new InternalErrorException(e);    
        } finally {
            GeneralOperations.closeResultSet(resultSet);
            GeneralOperations.closeStatement(preparedStatement);
        }    
        
    }
    public void update(Connection connection, UserDTO userDTO) 
        throws InstanceNotFoundException, InternalErrorException {
        
        PreparedStatement preparedStatement = null;

        try {

            /* Create "preparedStatement". */
            String queryString = "UPDATE Usuario" +
                " SET password = ?, nombre = ?, apellido = ?," +
                " email = ?  WHERE nick = ?";
            preparedStatement = connection.prepareStatement(queryString);
            
            /* Fill "preparedStatement". */
            int i = 1;
            preparedStatement.setString(i++, userDTO.getPass());
            preparedStatement.setString(i++, userDTO.getNombre());
            preparedStatement.setString(i++, userDTO.getApellido());
            preparedStatement.setString(i++, userDTO.getEmail());    
            preparedStatement.setString(i++, userDTO.getNick());
            
            /* Execute query. */
            int updatedRows = preparedStatement.executeUpdate();

            if (updatedRows == 0) {
                throw new InstanceNotFoundException(
                    userDTO.getNick(), 
                    UserDTO.class.getName());
            }

            if (updatedRows > 1) {
                throw new SQLException("Duplicate row for nick name = '" + 
                    userDTO.getNick() + "' in table 'Usuario'");
            }        
            
        } catch (SQLException e) {
            throw new InternalErrorException(e);    
        } finally {
            GeneralOperations.closeStatement(preparedStatement);
        }            
        
    }
        
    public void remove(Connection connection, String nick) 
        throws InstanceNotFoundException, InternalErrorException {
    
        PreparedStatement preparedStatement = null;
        
        try {

            /* Create "preparedStatement". */
            String queryString = "DELETE FROM Usuario WHERE" +
                " nick = ?";
            preparedStatement = connection.prepareStatement(queryString);
            
            /* Fill "preparedStatement". */
            int i = 1;
            preparedStatement.setString(i++, nick);
            
            /* Execute query. */
            int removedRows = preparedStatement.executeUpdate();

            if (removedRows == 0) {
                throw new InstanceNotFoundException(nick,
                    UserDTO.class.getName());
            }

        } catch (SQLException e) {
            throw new InternalErrorException(e);    
        } finally {
            GeneralOperations.closeStatement(preparedStatement);
        }    
    
    }
    
}

