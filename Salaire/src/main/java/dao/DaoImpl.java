package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Component;

import util.MaConnection;

@Component
public class DaoImpl implements IDao {
	
	private MaConnection conn;
	
	public void setConn(MaConnection conn) {
		this.conn = conn;
	}


	@Override
	public Employer getEmployer(int id) {
		Employer emp = null;
		try {
			Connection conn = MaConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from employer where id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				emp = new Employer();
				emp.setId(rs.getInt("id"));
				emp.setNom(rs.getString("nom"));
				emp.setPrenom(rs.getString("prenom"));
				emp.setSalaire(rs.getDouble("salaire"));
				emp.setDate_debut(rs.getDate("date_debut"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return emp;
	}
	
}
