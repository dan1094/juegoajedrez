/*
 * PlainAction.java
 *
 * Created on 29 de septiembre de 2007, 0:17
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
 * The base interface of all plain actions. A plain action is an bussiness
 * action executed with plain Java classes, using JDBC as database accesss
 * technology.
 */ 
public interface PlainAction {

    Object execute(Connection connection) throws ModelException,
        InternalErrorException;

}
