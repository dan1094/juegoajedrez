/*
 * AbstractPersistenceManager.java
 *
 * Created on 23 de noviembre de 2006, 20:57
 */

package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import model.Friend;

public class FriendDAOJDBCImplementation implements FriendDAO {
    
    
    private Statement statment = null;
    private Connection conexion = null;
    private ResultSet resulset = null;
    private static FriendDAOJDBCImplementation persistenceManager = null;
    
    
    /** Creates a new instance of AbstractPersistenceManager */
    private FriendDAOJDBCImplementation() {
        
    }
    
    public static FriendDAOJDBCImplementation  getJDBCPersistenceManager(){
        if (persistenceManager == null) {
            persistenceManager = new FriendDAOJDBCImplementation();
                    } 
        return persistenceManager;
    }
    public boolean setUp(String url, String driver, String user, String password){
                try {
            
            //Registramos el manejador
            Class.forName(driver);
            //Establecemos una conexión con la base de datoshubo
            conexion = DriverManager.getConnection(url, user, password);
            statment = conexion.createStatement();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
                return true;
    }
    
    public boolean disconnect(){
        try {
            conexion.close();
            statment.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean createFriend(Friend friend){
        String query=null;
        try {
            
            query = "insert into\"FRIENDS\" values('"+
                    friend.getName()+"','"+
                    friend.getAddress()+"','"+
                    friend.getPhone()+"','"+
                    friend.getComments()+"',"+
                    friend.getAge()+","+
                    friend.getFriendshipLevel()+")";
            statment.executeUpdate(query);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean deleteFriend(String name){
        String query=null;
        query = "delete from \"FRIENDS\" where NAME = '"+
                name+"'";
        try {
            statment.executeUpdate(query);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        
        
    }
    
    public boolean updateFriend(String name, Friend friend) {
        String query=null;
        query = "update \"FRIENDS\" SET NAME ='"+
                friend.getName()+"',ADDRESS = '"+ 
                friend.getAddress()+"',PHONE = '"+
                friend.getPhone()+"',AGE = "+
                friend.getAge()+", FRIENDSHIP_LEVEL = "+
                friend.getFriendshipLevel()+", COMMENTS = '"+
                friend.getComments()+"'where NAME = '"+
                name+"'";
        try {
            statment.executeUpdate(query);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        
        
    }
    public Friend readFriend(String name){
               String query=null;
        query = "select *"+
                "from \"FRIENDS\" where NAME ='"+
                name+"'";
        ResultSet rs = null;
        Friend friend = null;
        try {
            rs = statment.executeQuery(query);
            if(rs.next()){
            friend = new Friend();
            friend.setAddress(rs.getString("ADDRESS"));
            friend.setComments(rs.getString("COMMENTS"));
            friend.setPhone(rs.getString("PHONE"));
            friend.setName(rs.getString("NAME"));
            friend.setAge(rs.getInt("AGE"));
            friend.setFriendshipLevel(rs.getInt("FRIENDSHIP_LEVEL"));
            
            }
          
        } catch (SQLException ex) {
            ex.printStackTrace();
            friend = null;
            
        }finally{
            if(rs != null)
            
                try {
                    rs.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
        }
        return friend;
    }
}
