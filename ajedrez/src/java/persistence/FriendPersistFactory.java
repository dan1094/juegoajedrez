/*
 * PersistFactory.java
 *
 * Created on 23 de noviembre de 2006, 20:53
 */

package persistence;

import model.Friend;

public class FriendPersistFactory {
    FriendDAOJDBCImplementation persistenceManager = null;
    /** Creates a new instance of PersistFactory */
    public FriendPersistFactory() {
    }

    public static FriendDAO getFriendDAO(String persistenceMechanism){
        
        if (persistenceMechanism == null){
            return null ;
        }
        else if  (persistenceMechanism.equals("JDBC")){
            return FriendDAOJDBCImplementation.getJDBCPersistenceManager();
        }
        //Add here all the other persistence mechanisms
        else{
            return null;
        }
    }
}
