/*
 * DuplicateInstanceException.java
 *
 * Created on 28 de septiembre de 2007, 23:45
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package model.util;

/**
 *
 * @author CEU
 */
public class DuplicateInstanceException extends InstanceException {

    public DuplicateInstanceException(Object key, String className) {
        super("Duplicate instance", key, className);
    }
    
    /* Test code. Uncomment for testing. */
//    public static void main(String[] args) {
//    
//        try {
//            throw new DuplicateInstanceException("TestKey",            
//                String.class.getName());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    
//    }

}

