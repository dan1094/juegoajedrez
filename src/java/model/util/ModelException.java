/*
 * ModelException.java
 *
 * Created on 28 de septiembre de 2007, 23:53
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package model.util;

/**
 *
 * @author CEU
 */
public abstract class ModelException extends Exception {

    protected ModelException() {}

    protected ModelException(String message) {
        super(message);
    }

}
