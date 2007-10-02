/*
 * MyDbConnector.java
 *
 * Created on 1 de octubre de 2007, 14:55
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package objects;
import java.sql.*;
import javax.naming.*;
import javax.naming.*;
import javax.sql.DataSource;
/**
 *
 * @author Juanjito
 */
public class MyDbConnector {
    
    /**
     *EL CAMPO TEST INDICA COMO VAMOS A REALIZAR LA CONEXION BASE DE DATOS.
     *SI ES TRUE OBTENDREMOS LA CONEXION CON LA BASE DE DATOS DIRECTAMENTE
     *CON JDBC. SI ES FALSE OBTENDREMOS LA CONEXION CON EL POOL DE CONEXIONES
     *DEL SERVIDOR. 
     */
    public MyDbConnector(String url, boolean test)
    {
        if(!test)//si no es para la prueba de junit
        {
            try
            {
                ctx = new InitialContext();
                myDbPool = (DataSource) ctx.lookup(url);
            }
            catch (Exception e)
            {
                e.printStackTrace();
                ctx=null;
                myDbPool=null;
            }
        }
    }
    
    public static boolean executeQuery(String query, boolean test)
    {
        Connection conn=null;
        Statement stmt=null;
        try 
        {
            conn = MyDbConnector.getConn(test);
            stmt = conn.createStatement( );
            stmt.execute(query);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return false;
        }
        finally 
        {
            if (stmt != null) {try {stmt.close();} catch (SQLException e) {}stmt=null;}
            if (conn != null) {try {conn.close();} catch (SQLException e) {}conn=null;}
        }
        return true;
    }
    
    public static boolean hasNextQuery(String query, boolean test)
    {
        boolean val=false;
        Connection conn=null;
        Statement stmt=null;
        ResultSet rset=null;
        try 
        {
            conn = MyDbConnector.getConn(test);
            stmt = conn.createStatement( );
            rset = stmt.executeQuery(query);
            if(rset.next())
                val=true;
            else
                val=false;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            val=false;
        }
        finally 
        {
            if (rset != null) {try {rset.close();} catch (SQLException e) {}rset=null;}
            if (stmt != null) {try {stmt.close();} catch (SQLException e) {}stmt=null;}
            if (conn != null) {try {conn.close();} catch (SQLException e) {}conn=null;}
        }
        return val;
    }
    
    public static int getSizeQuery(String query, boolean test)
    {
        int val=0;
        Connection conn=null;
        Statement stmt=null;
        ResultSet rset=null;
        try 
        {
            conn = MyDbConnector.getConn(test);
            stmt = conn.createStatement( );
            rset = stmt.executeQuery(query);
            while(rset.next())
            {
                val++;
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            val=-1;
        }
        finally 
        {
            if (rset != null) {try {rset.close();} catch (SQLException e) {}rset=null;}
            if (stmt != null) {try {stmt.close();} catch (SQLException e) {}stmt=null;}
            if (conn != null) {try {conn.close();} catch (SQLException e) {}conn=null;}
        }
        return val;
    }
    
    private static Context ctx = null;
    private static DataSource myDbPool = null;
    private static String urlTest = null;
        
    public static Connection getConn(boolean test)
    {
        try 
        {
            if(!test)
            {
                return myDbPool.getConnection();
            }
            else
            {
                try 
                {
                     try 
                     {
                        Class.forName("org.gjt.mm.mysql.Driver");
                     } 
                     catch (Exception ex) 
                     {
                        ex.printStackTrace();
                     } 
                     return DriverManager.getConnection("jdbc:mysql://localhost:3306/ajedrez","root","root");
                }
                catch (Exception ex) //sino puede conectar muestra una pagina donde dice que no puede conectar
                {
                     ex.printStackTrace();
                }  
            }
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    
}
