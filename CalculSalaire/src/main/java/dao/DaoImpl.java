package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import util.MaConnection;

//@Component
@Repository
public class DaoImpl implements IDao {
	private MaConnection connection;

	public void setConnection(MaConnection connection) {
		this.connection = connection;
	}

	@Override
	public Employer getEmploer(int id) {
        Employer c = null;
		try {
			Connection connection = MaConnection.getConnection();
			PreparedStatement ps = connection.prepareStatement("select * from employer where id = ?");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				c = new Employer();
				c.setId(rs.getInt("id"));
				c.setNom(rs.getString("nom"));
	            c.setPrenom(rs.getString("prenom"));
	            c.setSalaire(rs.getDouble("salaire"));
	            c.setDate_debut(rs.getDate("date_debut"));
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return c;
		
	}

}
