/*
 * EntityIdentifierRetriever.java
 *
 * Created on 29 de septiembre de 2007, 0:06
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package model.util;

import java.sql.Connection;
/**
 *
 * @author CEU
 */
public interface EntityIdentifierRetriever {

    /**
     * Gets the generated identifier. This method must be called after
     * inserting a row in a table with a counter column.
     */
    public Long getGeneratedIdentifier(Connection connection)
        throws InternalErrorException;   

}
