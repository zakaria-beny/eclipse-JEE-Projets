package DAO;

import java.sql.*;

public class SingletonConnection {
    private static Connection connexion;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3307/employedb?";
            String user = "root";
            String pwd = "";

            connexion = DriverManager.getConnection(url, user, pwd);
            System.out.println("Connexion MySQL OK");

        } catch (Exception e) {
            System.out.println("Erreur connexion MySQL : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static Connection getConnexion() {
        return connexion;
    }
}
