/*
 * FacadeSuite.java
 * JUnit based test
 *
 * Created on 18 de noviembre de 2007, 20:20
 */

package model.facade;

import junit.framework.*;

/**
 *
 * @author Juanjito
 */
public class FacadeSuite extends TestCase {
    
    public FacadeSuite(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    /**
     * metodo de conjunto generado automaticamente por el modulo JUnit
     */
    public static Test suite() {
        TestSuite suite = new TestSuite("FacadeSuite");
        suite.addTest(model.facade.RegisterUserActionTest.suite());
        suite.addTest(model.facade.NuevaPartidaActionTest.suite());
        suite.addTest(model.facade.EnroqueActionTest.suite());
        suite.addTest(model.facade.ChangePasswordActionTest.suite());
        suite.addTest(model.facade.EsJaqueMateActionTest.suite());
        suite.addTest(model.facade.LoginResultDTOTest.suite());
        suite.addTest(model.facade.CoronarActionTest.suite());
        suite.addTest(model.facade.MoverActionTest.suite());
        suite.addTest(model.facade.EsTablasActionTest.suite());
        suite.addTest(model.facade.StoreUserActionTest.suite());
        suite.addTest(model.facade.PortalFacadeDelegateTest.suite());
        suite.addTest(model.facade.PlainPortalFacadeDelegateTest.suite());
        suite.addTest(model.facade.SignInActionTest.suite());
        suite.addTest(model.facade.PortalFacadeDelegateFactoryTest.suite());
        suite.addTest(model.facade.GetUserActionTest.suite());
        return suite;
    }
    
}
