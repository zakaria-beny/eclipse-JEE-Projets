package DAO;

import java.sql.SQLException;

public interface IDAO {
	
	public User get(int id)throws SQLException;

}
