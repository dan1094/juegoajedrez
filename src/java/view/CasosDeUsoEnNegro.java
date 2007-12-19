/*
 * CasosDeUsoEnNegro.java
 *
 * Created on 16 de octubre de 2007, 18:33
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import javax.sql.DataSource;
import model.facade.LoginResultDTO;
import model.facade.PortalFacadeDelegate;
import model.facade.PortalFacadeDelegateFactory;
import model.user.SQLUserDAO;
import model.user.SQLUserDAOFactory;
import model.user.UserDTO;
import model.util.DataSourceLocator;
import model.util.GlobalNames;
import model.util.SimpleDataSource;
/**
 *
 * @author Alvarete
 */
public class CasosDeUsoEnNegro {
    DataSource dataSource;
    PortalFacadeDelegate delegate;
    private UserDTO usuario;
    
    public CasosDeUsoEnNegro(){
        try {
            /* Create a simple data source. */    
            dataSource = new SimpleDataSource();
        
            /* Add "dataSource" to "DataSourceLocator" */
            DataSourceLocator.addDataSource(GlobalNames.MYPORTAL_DATA_SOURCE,
                dataSource);
            /* Create an "PortalFacadeDelegate". */
            delegate = PortalFacadeDelegateFactory.getDelegate();
            usuario = new UserDTO();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public UserDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UserDTO usuario) {
        this.usuario = usuario;
    }
    public int elegirOpcion(){
         int eleccion=0;
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
        try {
            System.out.println("Que desea hacer");
            System.out.println("1.- Crear usuario");
            System.out.println("2.- Login");
            //Leemos el numero
            eleccion = Integer.parseInt(in.readLine());
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Entrada incorrecta");
        } finally {
            return(eleccion);
        }
     }
    public int elegirOpcionLogado(){
        int eleccion=0;
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
          try {
            System.out.println("Que desea hacer");
            System.out.println("1.- Ver usuario");
            System.out.println("2.- Modificar");
            System.out.println("3.- Cambiar Contraseña");
            System.out.println("4.- Borrar usuario");
            //Leemos el numero
            eleccion = Integer.parseInt(in.readLine());
            return(eleccion);
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Entrada incorrecta");
        } finally {
            return(eleccion);
        }  
    }
    public void registrarUsuario(){
        try{
        String nick, pass,nombre,apellido,email;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("REGISTRO DE USUARIO");
        System.out.println("Introduzca el nick:");
        nick = in.readLine();
        System.out.println("Introduzca el password:");
        pass = in.readLine();
        System.out.println("Introduzca el nombre:");
        nombre = in.readLine();
        System.out.println("Introduzca el apellido:");
        apellido = in.readLine();
        System.out.println("Introduzca el email:");
        email = in.readLine();
        usuario.setNick(nick);
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setEmail(email);
        usuario.setPass(pass);
        delegate.registerUser(usuario);
        System.out.println("Usuario registrado");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void login(){
        try{
        String nick, pass;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("LOGIN DE USUARIO");
        System.out.println("Introduzca el nick:");
        nick = in.readLine();
        System.out.println("Introduzca el password:");
        pass = in.readLine();
        LoginResultDTO loginResultDTO = 
        delegate.signIn(nick, pass, false);
        System.out.println("Login realizado con exito ");
        this.opcionesLogado();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void guardarUsuario(){
        
        try{
            System.out.println("MODIFICAR USUARIO");
            String nombre,apellido,email;
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("REGISTRO DE USUARIO");
            System.out.println("Introduzca el nombre:");
            nombre = in.readLine();
            System.out.println("Introduzca el apellido:");
            apellido = in.readLine();
            System.out.println("Introduzca el email:");
            email = in.readLine();
            usuario.setNombre(nombre);
            usuario.setApellido(apellido);
            usuario.setEmail(email);
            usuario.setNick(delegate.getUser().getNick());
            usuario.setPass(delegate.getUser().getPass());
            delegate.storeUser(usuario);
            System.out.println("Updated user: " + delegate.getUser());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void cambiarContrasena(){
        try{
            System.out.println("MODIFICAR USUARIO");
            String passAnt,passNew;
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("REGISTRO DE USUARIO");
            System.out.println("Introduzca su antigua contraseña:");
            passAnt = in.readLine();
            System.out.println("Introduzca su nueva contraseña:");
            passNew = in.readLine();
            delegate.changePassword(passAnt, passNew);
            System.out.println("New encrypted password: " + 
            delegate.getUser().getPass());
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void borrarUsuario(){
        try{
            System.out.println("BORRANDO USUARIO");
            SQLUserDAO dao = SQLUserDAOFactory.getDAO();
            Connection connection = dataSource.getConnection();
            dao.remove(connection, delegate.getUser().getNick());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void verUsuario(){
        try{
            System.out.println("DATOS DEL USUARIO");
            usuario = delegate.getUser();
            System.out.println("User profile: " + usuario);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    public void casosDeUso(){
        int opcion=this.elegirOpcion();
        switch (opcion){
            case 1:
                this.registrarUsuario();
                break;
            case 2:
                this.login();
                break;
            default: return;
        }
    }

    private void opcionesLogado() {
        int opcion = this.elegirOpcionLogado();
        switch (opcion){
            case 1:this.verUsuario();
                   break;
            case 2:this.guardarUsuario();
                   break;
            case 3:this.cambiarContrasena();
                   break;
            case 4:this.borrarUsuario();
                   break;
            default: System.out.println("Error, opción mal introducida");
        }
    }
  
}
