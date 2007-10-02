/*
 * Usuario.java
 *
 * Created on 30 de septiembre de 2007, 17:13
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package clases;

import objects.*;
import persistencia.PersistFactoryAjedrez;
/**
/**
 *
 * @author Miguel1
 */
public class Usuario {
    
    private int id_usuario=-1;
    private String nombre=null;
    private String email=null;
    private String pass=null;
    //private String fecha_registro=null;
    private String nick=null;
    private boolean valid = false;
    
    
    /** Creates a new instance of Usuario */
    public Usuario() {
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

  /*  public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }*/

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
    
}
