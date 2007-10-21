/*
 * User.java
 *
 * Created on 14 de octubre de 2007, 23:18
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package model.user;

/**
 *
 * @author Alvarete
 */
public class UserDTO {
    private String nick=null;
    private String pass=null;
    private String nombre=null;
    private String apellido=null;
    private String email=null;
    
    /** Creates a new instance of User */
    public UserDTO(){
        
    }
    public UserDTO(String nick,String pass,String nombre,String apellido,String email) {
        this.nick = nick;
        this.pass = pass;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    public String toString() {
        return new String("Nick = " + nick + " | " +
            "contraseña = " + nombre + " | " +
            "Nombre = " + nombre + " | " +
            "apellido = " + apellido + " | " +
            "email = " + email );
    }
    
}
