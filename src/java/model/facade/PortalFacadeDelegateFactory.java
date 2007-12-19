/*
 * PortalFacadeDelegateFactory.java
 *
 * Created on 15 de octubre de 2007, 20:27
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package model.facade;

import java.sql.Connection;
import javax.sql.DataSource;
import model.user.SQLUserDAO;
import model.user.SQLUserDAOFactory;
import model.user.UserDTO;
import model.util.ConfigurationParametersManager;
import model.util.DataSourceLocator;
import model.util.GlobalNames;
import model.util.InternalErrorException;
import model.util.SimpleDataSource;

/**
 *
 * @author Alvarete
 */
public final class PortalFacadeDelegateFactory {
    //Coge los paramatros del fichero ConfigurationParamters 
    /*
    private final static String DELEGATE_CLASS_NAME_PARAMETER =
        "PortalFacadeDelegateFactory/delegateClassName";
    */

    private final static Class delegateClass = getDelegateClass();
    
    private PortalFacadeDelegateFactory() {}
    
    private static Class getDelegateClass() {
    
        Class theClass = null;
    
        try {
         /*
         String delegateClassName = 
                ConfigurationParametersManager.getParameter(
                    DELEGATE_CLASS_NAME_PARAMETER);
            
                    
            theClass = Class.forName(delegateClassName);
          */
            theClass = Class.forName("model.facade.PlainPortalFacadeDelegate");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return theClass;
        
    }
    
            
    public static PortalFacadeDelegate getDelegate() 
        throws InternalErrorException {
        
        try {        
            return (PortalFacadeDelegate) delegateClass.newInstance();
        } catch (Exception e) {
            throw new InternalErrorException(e);
        }
    }

    /* 
     * Test code. Uncomment for testing. Test this class and any class
     * implementing "PortalFacadeDelegate".
     */         
    public static void main (String[] args) {
    
        try {

            /* Create a simple data source. */            

            DataSource dataSource = new SimpleDataSource();
            
            /* Add "dataSource" to "DataSourceLocator" */
            DataSourceLocator.addDataSource(GlobalNames.MYPORTAL_DATA_SOURCE,
                dataSource);
            System.out.println("El datasource es: " + GlobalNames.MYPORTAL_DATA_SOURCE);
                
            /* Create an "PortalFacadeDelegate". */
            PortalFacadeDelegate delegate =
                PortalFacadeDelegateFactory.getDelegate();

            /* Test "PortalFacadeDelegate::registerUser". */
            System.out.println("Test for 'PortalFacadeDelegate::registerUser'");
            UserDTO userDTO = 
                new UserDTO("alvarete","alvpass","Alvaro", "Torroba Lombera",
                    "alvarotorroba@hotmail.com");
            delegate.registerUser(userDTO);
            System.out.println("User registered");

            /* Test "UserFacadeDelegate::login". */
            System.out.println("Test for 'PortalFacadeDelegate::signIn'");
            LoginResultDTO loginResultDTO = 
                delegate.signIn("alvarete", "alvpass", false);
            System.out.println("SignIn with clear password successful: " + 
                loginResultDTO);
            loginResultDTO = delegate.signIn("alvarete", 
                loginResultDTO.getEncryptedPassword(), true);
            System.out.println("SignIn with encrypted password successful: " +
                loginResultDTO);
                                
            /* Test "PortalFacadeDelegate::getUserProfile". */
            System.out.println("Test for " +
                "'PortalFacadeDelegate::getUserProfile'");
            userDTO = delegate.getUser();
            System.out.println("User profile: " + userDTO);
            
            /* Test "PortalFacadeDelegate::storeUser". */
            System.out.println(
                "Test for 'PortalFacadeDelegate::storeUser'");
            userDTO.setNombre("Alvarito");
            userDTO.setApellido("Torrobita Lomberita");
            userDTO.setEmail("alvaritotorrobita@hotmail.com");
            delegate.storeUser(userDTO);
            System.out.println("Updated user details: " +
                delegate.getUser());
                
            /* Test "PortalFacadeDelegate::changePassword". */
            System.out.println("Test for " +
                "'PortalFacadeDelegate::changePassword'");
            delegate.changePassword("alvpass", "passalv");
            System.out.println("New encrypted password: " + 
                delegate.getUser().getPass());

            
            /* Remove user profile. */
            System.out.println("Removing user");
            SQLUserDAO dao = SQLUserDAOFactory.getDAO();
            Connection connection = dataSource.getConnection();
            dao.remove(connection, "alvarete");
                                    
            /* Tests OK. */
            System.out.println("Tests OK !!!!");

        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
