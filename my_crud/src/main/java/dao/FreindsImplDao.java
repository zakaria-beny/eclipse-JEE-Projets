package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import unite.MyConnection;

public class FreindsImplDao implements IFriendsDao {
private Connection c;
		MyConnection conn =new MyConnection();
	@Override
	public boolean addfriend(Friends f) throws SQLException {
		
		 c=conn.getConnection();
		PreparedStatement ps =c.prepareStatement("INSERT INTO FRIENDS (NOM, PRENOM, NUMERO, AGE) VALUES (?, ?, ?, ?)");
		ps.setString(1, f.getNom());
		ps.setString(2, f.getPrenom());
		ps.setLong(3, f.getNumero());
		ps.setLong(4, f.getAge());
		 int  a=ps.executeUpdate();
		return a >0;
		



		
	}

	@Override
	public boolean editfriend(String nom, String prenom, long age, long numero,Long id) throws SQLException {
		 c=conn.getConnection();
		PreparedStatement ps =c.prepareStatement("UPDATE FRIENDS SET NOM=?, PRENOM=?, AGE=?, NUMERO=? WHERE ID=?");
		ps.setString(1, nom);
		ps.setString(2, prenom);
		ps.setLong(3, age);
		ps.setLong(4, numero);

		ps.setLong(5, id);
		 int e=ps.executeUpdate();
		return e>0;
	}

	@Override
	public boolean removefriend(long id) throws SQLException {
		   c=conn.getConnection();
			PreparedStatement ps =c.prepareStatement(" DELETE FROM FRIENDS WHERE ID =?");
			ps.setLong(1, id);
			int r=ps.executeUpdate();
			return r>0;
		
	}

	@Override
	public List<Friends> listAllFriends() throws SQLException {
		c=conn.getConnection();
		PreparedStatement ps =c.prepareStatement(" SELECT * FROM FRIENDS");
		List<Friends> allFriends = new ArrayList<>();
		
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			Friends f1 = new Friends();
		f1.setNom(rs.getString("nom"));
		f1.setPrenom(rs.getString("prenom"));
		f1.setAge(rs.getLong("age"));
		f1.setNumero(rs.getLong("numero"));
		allFriends.add(f1);
		

		}

		return allFriends;
	}

	@Override
	public Friends getFriends(String nom) throws SQLException {
		c=conn.getConnection();
		Friends f2 = null;
		PreparedStatement ps =c.prepareStatement(" SELECT * FROM FRIENDS WHERE NOM like ? ");
		ps.setString(1,nom);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			 f2 = new Friends();
		f2.setNom(rs.getString("nom"));
		f2.setPrenom(rs.getString("prenom"));
		f2.setAge(rs.getLong("age"));
		f2.setNumero(rs.getLong("numero"));
		f2.setId (rs.getLong("id"));
		
	}
return f2 ;
}}
