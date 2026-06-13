package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOImpl implements IDAO {
	
	private final Connection connection;
	
	public DAOImpl() {
		this.connection = null;

	}

	public DAOImpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public User get(int id) throws SQLException {
		User user =  new User();

		Connection conn = this.connection != null ? this.connection : SingletonConnection.getConnexion();

		String sql = "SELECT * FROM users WHERE id = ?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					user.setId(rs.getInt("id"));
					user.setNom(rs.getString("nom"));
					user.setPrenom(rs.getString("prenom"));
					user.setSalaire(rs.getLong("salaire"));
					user.setDate_debut(rs.getDate("date_debut"));
				}
			}
		}
		return user;
	}
	
}