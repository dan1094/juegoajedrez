/*
 * EnroqueActionTest.java
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
public class EnroqueActionTest extends TestCase {
    
    public EnroqueActionTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(EnroqueActionTest.class);
        
        return suite;
    }
    
}
