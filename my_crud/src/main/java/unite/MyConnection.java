package unite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	private static Connection connection;
	
static {
	try {	
		
		Class.forName("com.mysql.jbdc.Driver");
		connection =DriverManager.getConnection("jdbc:mysql://localhost:3307/dbclient","root","");
	} catch (SQLException | ClassNotFoundException e) {
	
		e.printStackTrace();
	}
	
}

public MyConnection() {}

public Connection getConnection() {
	return connection;
}

}
