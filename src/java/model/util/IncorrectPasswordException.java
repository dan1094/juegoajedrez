/*
 * IncorrectPasswordException.java
 *
 * Created on 15 de octubre de 2007, 19:47
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package model.util;

/**
 *
 * @author Alvarete
 */
public class IncorrectPasswordException extends ModelException {

    private String nick;
    
    public IncorrectPasswordException(String nick) {
        super("Incorrect password exception => loginName = " + nick);
        this.nick = nick;
    }
    
    public String getLoginName() {
        return nick;
    }
}
