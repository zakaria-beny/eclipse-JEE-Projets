package com.jbdc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.model.javabeans.client;

public class DAO {

    private String url;
    private String user;
    private String password;
    private Connection conn;

    public DAO(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    protected void connect() throws SQLException {
        try {
            if (conn == null || conn.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(url, user, password);
            }
        } catch (ClassNotFoundException e) {
            throw new SQLException(e);
        }
    }

    protected void disconnect() throws SQLException {
        if (conn != null && !conn.isClosed()) conn.close();
    }

    public boolean addclient(client c) throws SQLException {
        connect();
        String sql = "INSERT INTO client (id, nom, prenom, age) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, c.getId());
        ps.setString(2, c.getNom());
        ps.setString(3, c.getPrenom());
        ps.setInt(4, c.getAge());
        boolean inserted = ps.executeUpdate() > 0;
        ps.close();
        disconnect();
        return inserted;
    }

    public boolean updateclient(client c) throws SQLException {
        connect();
        String sql = "UPDATE client SET nom=?, prenom=?, age=? WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, c.getNom());
        ps.setString(2, c.getPrenom());
        ps.setInt(3, c.getAge());
        ps.setInt(4, c.getId());
        boolean updated = ps.executeUpdate() > 0;
        ps.close();
        disconnect();
        return updated;
    }

    public boolean deleteclient(client c) throws SQLException {
        connect();
        String sql = "DELETE FROM client WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, c.getId());
        boolean deleted = ps.executeUpdate() > 0;
        ps.close();
        disconnect();
        return deleted;
    }

    public client getclient(int id) throws SQLException {
        connect();
        String sql = "SELECT * FROM client WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        client c = null;
        if (rs.next()) {
            c = new client(rs.getString("nom"), rs.getString("prenom"), id, rs.getInt("age"));
        }
        rs.close();
        ps.close();
        disconnect();
        return c;
    }

    public List<client> listAllclient() throws SQLException {
        connect();
        List<client> list = new ArrayList<>();
        String sql = "SELECT * FROM client";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            list.add(new client(rs.getString("nom"), rs.getString("prenom"), rs.getInt("id"), rs.getInt("age")));
        }
        rs.close();
        ps.close();
        disconnect();
        return list;
    }

    // ADD THIS NEW METHOD
    public List<client> searchClients(String keyword) throws SQLException {
        connect();
        List<client> list = new ArrayList<>();
        String sql = "SELECT * FROM client WHERE nom LIKE ? OR prenom LIKE ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        String searchPattern = "%" + keyword + "%";
        ps.setString(1, searchPattern);
        ps.setString(2, searchPattern);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            list.add(new client(rs.getString("nom"), rs.getString("prenom"), rs.getInt("id"), rs.getInt("age")));
        }
        rs.close();
        ps.close();
        disconnect();
        return list;
    }
}