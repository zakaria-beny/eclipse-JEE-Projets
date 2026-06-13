package Service;

import java.sql.SQLException;
import java.util.List;

import dao.Friends;
import dao.IFriendsDao;

public class FriendImpl  implements IFriendService{
private IFriendsDao FreindsImplDao;
Friends friend = new Friends();

	@Override
	public boolean saveFriend(Friends f) throws SQLException {	
		return f.addfriend(friend);
	}

	@Override
	public boolean updateFriend(long id, String nom, String prenom, long age, long numero) throws SQLException {
		
		return FreindsImplDao.editfriend(nom, prenom, age, numero, id);
	}

	@Override
	public boolean removeFriend(long id) throws SQLException {
		
		return FreindsImplDao.removefriend(id);
	}

	@Override
	public List<Friends> listAllFriends() throws SQLException {
		
		return FreindsImplDao.listAllFriends();
	}

	@Override
	public Friends getFriends(String nom) throws SQLException {
		
		return FreindsImplDao.getFriends(nom);
	}

	

}
