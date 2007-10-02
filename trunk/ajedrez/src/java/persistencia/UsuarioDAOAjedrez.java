/*
 * UsuarioDAOAjedrez.java
 *
 * Created on 2 de octubre de 2007, 15:20
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package persistencia;

import clases.Usuario;

/**
 *
 * @author Juanjito
 */
public interface UsuarioDAOAjedrez {
    
    public Usuario createUsuario(Usuario usuario);
    
    public int deleteUsuario(int id);
    
    public Usuario readUsuario(int id);
    
    public Usuario readUsuario(String nick, String password);
    
    public boolean existsUsuario(String usuario, String password);
    
    public int updateUsuario(Usuario usuario, int id);
}
