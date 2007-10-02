/*
 * startUpListener.java
 *
 * Created on 25 de noviembre de 2006, 22:31
 */

package controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;
import persistence.FriendDAOJDBCImplementation;

/**
 *
 * @author  Iñigo
 * @version
 *
 * Web application lifecycle listener.
 */

public class StartUpListener implements ServletContextListener {
    
    public void contextInitialized(ServletContextEvent evt) {
        String url,driver,user,password;
        ServletContext context = evt.getServletContext();
        url = context.getInitParameter("databaseURL");
        driver = context.getInitParameter("databaseDriver");
        user = context.getInitParameter("databaseUser");
        password = context.getInitParameter("databasePassword");
        boolean ok = FriendDAOJDBCImplementation.getJDBCPersistenceManager().setUp(url,driver,user,password);
        if (!ok) {
            context.setAttribute("persistenceMechanism","none");
        }
        
    }
    
    public void contextDestroyed(ServletContextEvent evt) {
        boolean ok = FriendDAOJDBCImplementation.getJDBCPersistenceManager().disconnect();
        if (!ok) {
            //handle the error
        }
    }
    
}
