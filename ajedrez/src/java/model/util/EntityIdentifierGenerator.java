/*
 * EntityIdentifierGenerator.java
 *
 * Created on 29 de septiembre de 2007, 0:01
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package model.util;

/**
 *
 * @author CEU
 */
import java.sql.Connection;

/**
 * Defines an interface that allows to generate identifiers for a given
 * entity.
 */
public interface EntityIdentifierGenerator {

    /**
     * Gets an identifier for a given entity.
     */
    public Long nextIdentifier(Connection connection, 
        String entityName) throws InternalErrorException;   

}
