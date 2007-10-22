/*
 * LoginResultDTO.java
 *
 * Created on 15 de octubre de 2007, 21:02
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package model.facade;

import java.io.Serializable;

/**
 *
 * @author Alvarete
 */
public class LoginResultDTO implements Serializable {

    private String nombre;
    private String encryptedPassword;

    public LoginResultDTO(String nombre, String encryptedPassword) {
        
        this.setNombre(nombre);
        this.setEncryptedPassword(encryptedPassword);

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }
    
    public String toString() {
        return new String("Nombre = " + nombre + " | " +
            "encryptedPassword = " + encryptedPassword );
    }
    
}