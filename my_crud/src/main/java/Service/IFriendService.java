package Service;

import dao.IFriendsDao;

import java.sql.SQLException;
import java.util.List;

import dao.FreindsImplDao;
import dao.Friends;


public interface IFriendService {
	
	boolean saveFriend() throws SQLException;
	boolean updateFriend(long id,String nom,String prenom ,long age ,long numero) throws SQLException;
	boolean removeFriend(long id) throws SQLException;
	 List<Friends> listAllFriends() throws SQLException;
	  Friends getFriends( String nom)throws SQLException;
	  



	
	

}
