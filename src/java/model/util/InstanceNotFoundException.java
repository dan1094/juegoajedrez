/*
 * InstanceNotFoundException.java
 *
 * Created on 28 de septiembre de 2007, 23:50
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package model.util;

/**
 *
 * @author CEU
 */
public class InstanceNotFoundException extends InstanceException {

    public InstanceNotFoundException(Object key, String className) {
        super("Instance not found", key, className);
    }
    
    /* Test code. Uncomment for testing. */    
//    public final static void main(String[] args) {
//    
//        try {
//            throw new InstanceNotFoundException("TestKey",            
//                String.class.getName());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    
//    }

}
