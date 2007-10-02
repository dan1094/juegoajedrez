/*
 * PersistFactoryAjedrez.java
 *
 * Created on 2 de octubre de 2007, 15:17
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package persistencia;

/**
 *
 * @author Juanjito
 */
public class PersistFactoryAjedrez {
    
    private boolean test = false;
    /** Creates a new instance of PersistFactoryAjedrez */
    public PersistFactoryAjedrez(boolean test) {
        setTest(test);
    }
    public UsuarioDAOAjedrez getUsuarioDAOAjedrez()
    {
        return new UsuarioDAOMysqlAjedrez(isTest());
    }
    
    public boolean isTest() {
        return test;
    }

    public void setTest(boolean test) {
        this.test = test;
    }
}
