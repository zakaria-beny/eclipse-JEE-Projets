package dao;

import java.sql.SQLException;
import java.util.List;

public interface IFriendsDao {
  boolean  addfriend(Friends f)throws SQLException; 
  boolean removefriend(long id )throws SQLException;
          List<Friends> listAllFriends() throws SQLException;
    
		  Friends getFriends(String nom) throws SQLException;
		  boolean editfriend(String nom, String prenom, long age, long numero, Long id) throws SQLException;
          
}
