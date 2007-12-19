/*
 * MissingConfigurationParameterException.java
 *
 * Created on 28 de septiembre de 2007, 21:37
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package model.util;

/**
 *
 * @author CEU
 */
public class MissingConfigurationParameterException extends Exception {

    private String parameterName;

    public MissingConfigurationParameterException(String parameterName) {
        super("Missing configuration parameter: '" + parameterName + "'");
        this.parameterName = parameterName;
    }
    
    public String getParameterName() {
        return parameterName;
    }
    
    /* Test code. Uncomment for testing. */
//    public static void main (String[] args) {
//    
//        try {
//            throw new MissingConfigurationParameterException("TestParameter");
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
//        
//    }    

}

