/*
 * UsuarioDAOMysqlAjedrez.java
 *
 * Created on 2 de octubre de 2007, 15:21
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */


package persistencia;

import clases.Usuario;
import java.sql.*;
import objects.Config;
import objects.MyDbConnector;
/**
 *
 * @author Juanjito
 */
public class UsuarioDAOMysqlAjedrez implements UsuarioDAOAjedrez {
    
    private boolean test = false;
    
    /** Creates a new instance of UsuarioDAOMysql */
    public UsuarioDAOMysqlAjedrez(boolean test) 
    {
        setTest(test);
    }

    public Usuario createUsuario(Usuario usuario) 
    {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try 
        {
            conn = MyDbConnector.getConn(test);
            ps = conn.prepareStatement("INSERT INTO usuario " +
                                       "(nombre,email,pass,nick) ");
            ps.setString(1,usuario.getNombre());
            ps.setString(2,usuario.getEmail());
            ps.setString(3,usuario.getPass());
            ps.setString(4,usuario.getNick());
            //ps.setString(4,Config.getKey());
            ps.execute();
            //Obtenemos la clave generada para asociarla al id del documento.
           /* rs = ps.getGeneratedKeys();
            if(rs.next())
            {
                usuario.setId_usuario(rs.getInt(1));
            }*/
        }
        catch (SQLException ex)
        {   
              ex.printStackTrace();
        }
        finally 
        {
            if (rs != null){try {rs.close();} catch (SQLException ex) {ex.printStackTrace();}}
            if (ps != null){try {ps.close();} catch (SQLException ex) {ex.printStackTrace();}}
            if (conn != null) {try {conn.close();} catch (SQLException ex) {ex.printStackTrace();}}
        }
        return usuario;
    }

    public int deleteUsuario(int id) 
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        try 
        {
            conn = MyDbConnector.getConn(test);
            
            stmt = conn.prepareStatement(
            "DELETE FROM usuario " +
            "WHERE id_usuario = ?");
            
            stmt.clearParameters();
            stmt.setInt(1,id);
            return stmt.executeUpdate();
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        finally
        {
            if(stmt != null){try {stmt.close();} catch (SQLException ex) {ex.printStackTrace();}}
            if (conn != null) {try {conn.close();} catch (SQLException ex) {ex.printStackTrace();}}
        }
        return 0;
    }

    public Usuario readUsuario(int id) 
    {
        Usuario usuario = new Usuario();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try 
        {
            conn = MyDbConnector.getConn(test);
            ps = conn.prepareStatement("SELECT * FROM usuario WHERE id_usuario = ?");
            ps.setInt(1,id);
            rs = ps.executeQuery();
            if (rs.next())
            {
                usuario.setNick(rs.getString("nick"));
                usuario.setId_usuario(rs.getInt("id_usuario"));
                usuario.setEmail(rs.getString("email"));
                usuario.setValid(true);
            }
        }
        catch (SQLException ex) //sino puede conectar muestra una pagina donde dice que no puede conectar
        {
            ex.printStackTrace();
        }
        finally 
        {
            if (rs != null){try {rs.close();} catch (SQLException ex) {ex.printStackTrace();}}
            if (ps != null) {try {ps.close();} catch (SQLException ex) {ex.printStackTrace();}}
            if (conn != null) {try {conn.close();} catch (SQLException ex) {ex.printStackTrace();}}
        }
        return usuario;
    }
    
    public Usuario readUsuario(String nick, String password)
    {
        Usuario usuario = new Usuario();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try 
        {
            conn = MyDbConnector.getConn(test);
            ps = conn.prepareStatement("SELECT * FROM usuario WHERE " +
                                       " nick = ? AND pass = AES_ENCRYPT(?,?) ");
            ps.setString(1, nick);
            ps.setString(2, password);
            ps.setString(3, Config.getKey());
            rs = ps.executeQuery();
            if (rs.next())
            {
                usuario.setNick(rs.getString("nick"));
                usuario.setId_usuario(rs.getInt("id_usuario"));
                usuario.setEmail(rs.getString("email"));
                usuario.setValid(true);
            }
        }
        catch (SQLException ex) //sino puede conectar muestra una pagina donde dice que no puede conectar
        {
            ex.printStackTrace();
        }
        finally 
        {
            if (rs != null){try {rs.close();} catch (SQLException ex) {ex.printStackTrace();}}
            if (ps != null) {try {ps.close();} catch (SQLException ex) {ex.printStackTrace();}}
            if (conn != null) {try {conn.close();} catch (SQLException ex) {ex.printStackTrace();}}
        }
        return usuario;
    }
    
    public boolean existsUsuario(String usuario, String password)
    {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try 
        {
            conn = MyDbConnector.getConn(test);
            ps = conn.prepareStatement("SELECT * FROM usuario WHERE nick = ? AND pass = AES_ENCRYPT(?,?)");
            ps.setString(1, usuario);
            ps.setString(2, password);
            ps.setString(3, Config.getKey());
            rs = ps.executeQuery();
            if (rs.next())
            {
                return true;
            }
        }
        catch (SQLException ex) //sino puede conectar muestra una pagina donde dice que no puede conectar
        {
            ex.printStackTrace();
        }
        finally 
        {
            if (rs != null){try {rs.close();} catch (SQLException ex) {ex.printStackTrace();}}
            if (ps != null) {try {ps.close();} catch (SQLException ex) {ex.printStackTrace();}}
            if (conn != null) {try {conn.close();} catch (SQLException ex) {ex.printStackTrace();}}
        }
        return false;
    }

    public int updateUsuario(Usuario usuario, int id) 
    {
        Connection conn = null;
        PreparedStatement ps = null;
        try 
        {
            conn = MyDbConnector.getConn(test);
            ps = conn.prepareStatement("UPDATE usuario SET nick = ?, email = ?, " +
                    "pass = AES_ENCRYPT(?,?) WHERE id_usuario = ? ");
            
            ps.setString(1,usuario.getNombre());
            ps.setString(2,usuario.getEmail());
            ps.setString(3,usuario.getPass());
            ps.setString(4,usuario.getNick());
            ps.setString(5, Config.getKey());
            ps.setInt(6, id);
            return ps.executeUpdate();
        }
        catch (SQLException ex) //sino puede conectar muestra una pagina donde dice que no puede conectar
        {   
              ex.printStackTrace();
        }
        finally 
        {
            if (ps != null){try {ps.close();} catch (SQLException ex) {ex.printStackTrace();}}
            if (conn != null) {try {conn.close();} catch (SQLException ex) {ex.printStackTrace();}}
        }
        return 0;
    }

    public boolean isTest() {
        return test;
    }

    public void setTest(boolean test) {
        this.test = test;
    }
    
}
