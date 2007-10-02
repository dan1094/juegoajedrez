/*
 * PersistentManagerInterface.java
 *
 * Created on 23 de noviembre de 2006, 21:41
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package persistence;

import java.util.List;
import model.Friend;

/**
 *
 * @author Iñigo
 */
public interface FriendDAO {
    public boolean createFriend(Friend friend);
    
    public boolean deleteFriend(String name);
    
    public Friend readFriend(String name);
    
    
    public boolean updateFriend(String name, Friend friend);
    
}
