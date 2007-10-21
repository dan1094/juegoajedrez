/*
 * SimpleDataSource.java
 *
 * Created on 27 de septiembre de 2007, 3:52
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package model.util;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import javax.sql.DataSource;

/**
 *
 * @author CEU
 */
public class SimpleDataSource implements DataSource {
    
   /* private static final String DRIVER_CLASS_NAME_PARAMETER = 
        "SimpleDataSource/driverClassName";
    private static final String URL_PARAMETER = 
        "SimpleDataSource/url";
    private static final String USER_PARAMETER = 
        "SimpleDataSource/user";
    private static final String PASSWORD_PARAMETER = 
        "SimpleDataSource/password";*/
        
    
    private static String url;
    private static String user;
    private static String password;
        
    static {
        
      /*  try {
    
            String driverClassName = 
                ConfigurationParametersManager.getParameter(
                    DRIVER_CLASS_NAME_PARAMETER);
            url = ConfigurationParametersManager.getParameter(URL_PARAMETER);
            user = ConfigurationParametersManager.getParameter(USER_PARAMETER);
            password = ConfigurationParametersManager.getParameter(
                PASSWORD_PARAMETER);
          
            Class.forName(driverClassName);
        
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        
        try {
            String driverClassName = "com.mysql.jdbc.Driver";
            url = "jdbc:mysql://localhost:3306/ajedrez";
            user = "root";
            password = "14309294";
            Class.forName(driverClassName);
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
        
    public Connection getConnection(String username, String password)
        throws SQLException {
        
        throw new UnsupportedOperationException("Not implemented");
        
    }

    public PrintWriter getLogWriter() throws SQLException {    
        throw new UnsupportedOperationException("Not implemented");    
    }

    public void setLogWriter(PrintWriter out) throws SQLException {
        throw new UnsupportedOperationException("Not implemented");
    }

    public void setLoginTimeout(int seconds) throws SQLException {
        throw new UnsupportedOperationException("Not implemented");
    }

    public int getLoginTimeout() throws SQLException {
        throw new UnsupportedOperationException("Not implemented");
    }

    /* Test code. Uncomment for testing. */
//    public static void main (String[] args) {
//        
//        try {
//        
//            /* Trying to get a connection. */
//            System.out.println("Trying to get a connection");
//            DataSource dataSource = new SimpleDataSource();
//            Connection connection = dataSource.getConnection();
//            
//            /* Close connection. */
//            connection.close();
//            
//            /* Test OK. */
//            System.out.println("Test OK");            
//            
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        
//    }

    public <T> T unwrap(Class<T> iface) throws SQLException {
        throw new SQLException("Not implemented");
    }

    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        throw new SQLException("Not implemented");
    }

}

    

