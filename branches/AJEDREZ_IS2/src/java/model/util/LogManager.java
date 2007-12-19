/*
 * LogManager.java
 *
 * Created on 15 de noviembre de 2007, 11:58
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package model.util;

import java.net.URL;
import org.apache.log4j.*;
import org.apache.log4j.helpers.Loader;

/**
 *
 * @author Eduardo
 */
public class LogManager {
    
    private static Logger logger;
    
    /** Creates a new instance of LogConfigurationManager */
    /*public LogManager() {
    }*/
    
    static {
        try {
            URL url = Loader.getResource("LogConfiguration.properties");
            PropertyConfigurator.configure(url);
            logger = Logger.getLogger(LogManager.class);
            System.out.println ("LogManager - [" + url.toString() + "] Logger inicializado.");
            } catch (Exception e) {
                    BasicConfigurator.configure();
                    logger = Logger.getLogger(LogManager.class);
                    System.out.println ("LogManager - Excepcion al inicializar el log: " + e.toString());
            }
    }
    
    public static void info (String mensaje) {
        try{
            if(logger.isInfoEnabled()) {
                logger.info(mensaje);
            }
        } catch (Exception e) {
            System.out.println("LogManager - Excepcion en el log: " + e.toString());
        }
    }
    
}
