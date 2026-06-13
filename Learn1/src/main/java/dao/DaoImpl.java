package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import util.MaConnection;
@Component
public class DaoImpl implements IDao {
	private MaConnection conn;
	
	public void setConn(MaConnection conn) {
		this.conn = conn;
	}

	@Override
	public void addClient(Client c) {
		try {
		Connection conn = MaConnection.getConnection(); 
		
		PreparedStatement ps = conn.prepareStatement("insert into client(nom,prenom,age) values (?,?,?)");
		//ps.setInt(1, c.getId());
		ps.setString(1, c.getNom());
		ps.setString(2, c.getPrenom());
		ps.setInt(3, c.getAge());
		
		ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void updateClient(Client c) {
		try {
			Connection conn = MaConnection.getConnection(); 
			
			PreparedStatement ps = conn.prepareStatement("Update client set nom = ?, prenom = ?, age = ? where id = ?");
			ps.setString(1, c.getNom());
			ps.setString(2, c.getPrenom());
			ps.setInt(3, c.getAge());
			ps.setInt(4, c.getId());
			
			ps.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}
	}

	@Override
	public void deleteClient(int id) {
		try {
			Connection conn = MaConnection.getConnection(); 
			
			PreparedStatement ps = conn.prepareStatement("Delete from client where id = ?");
			ps.setInt(1, id);
			
			ps.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}
		
	}

	@Override
	public List<Client> getAllClients() {
		List<Client> ListClient = new ArrayList<>();
		try {
			Connection conn = MaConnection.getConnection(); 
			PreparedStatement ps = conn.prepareStatement("select * from client");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Client c = new Client();
				c.setId(rs.getInt("id"));
	            c.setNom(rs.getString("nom"));
	            c.setPrenom(rs.getString("prenom"));
	            c.setAge(rs.getInt("age"));
				ListClient.add(c);
			};
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ListClient;
	}

	@Override
	public List<Client> serchClientByName(String nom) {
		List<Client> SeachList = new ArrayList<>();
		try {
			Connection conn = MaConnection.getConnection(); 
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM client WHERE nom LIKE ?");
			ps.setString(1, "%"+nom+"%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Client c = new Client();
				c.setId(rs.getInt("id"));
	            c.setNom(rs.getString("nom"));
	            c.setPrenom(rs.getString("prenom"));
	            c.setAge(rs.getInt("age"));
	            SeachList.add(c);
			};
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return SeachList;
	}
	
	@Override
	public Client getClientById(int id) {
	    Client c = null;
	    try {
	        Connection conn = MaConnection.getConnection();
	        PreparedStatement ps = conn.prepareStatement("SELECT * FROM client WHERE id = ?");
	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            c = new Client();
	            c.setId(rs.getInt("id"));
	            c.setNom(rs.getString("nom"));
	            c.setPrenom(rs.getString("prenom"));
	            c.setAge(rs.getInt("age"));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return c;
	}


}
