/*
 * PortalFacadeDelegateFactoryTest.java
 * JUnit based test
 *
 * Created on 18 de noviembre de 2007, 20:20
 */

package model.facade;

import junit.framework.*;
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
 * @author Juanjito
 */
public class PortalFacadeDelegateFactoryTest extends TestCase {
    
    public PortalFacadeDelegateFactoryTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(PortalFacadeDelegateFactoryTest.class);
        
        return suite;
    }

    /**
     * Prueba del metodo getDelegate , de la clase model.facade.PortalFacadeDelegateFactory.
     */
    public void testGetDelegate() throws Exception {
        System.out.println("getDelegate");
        
        PortalFacadeDelegate expResult = null;
        PortalFacadeDelegate result = PortalFacadeDelegateFactory.getDelegate();
        assertEquals(expResult, result);
        
        // TODO revisar el cadigo de prueba generado y eliminar la llamada predeterminada que falta.
        fail("El caso de prueba es un prototipo.");
    }

    /**
     * Prueba del metodo main , de la clase model.facade.PortalFacadeDelegateFactory.
     */
    public void testMain() {
        System.out.println("main");
        
        String[] args = null;
        
        PortalFacadeDelegateFactory.main(args);
        
        // TODO revisar el cadigo de prueba generado y eliminar la llamada predeterminada que falta.
        fail("El caso de prueba es un prototipo.");
    }
    
}
