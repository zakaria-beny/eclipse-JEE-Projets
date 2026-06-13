package com.estn;

import jakarta.servlet.ServletException;
import java.sql.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class traitement
 */
@WebServlet("/traitement")
public class traitement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public traitement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String nom = request.getParameter("nom");
        String  prenom = request.getParameter("prenom");
        String id = request.getParameter("id");
        String salaire = request.getParameter("salaire");
        String datedebut= request.getParameter("salaire");

        


        
        
String url="jdbc:mysql://localhost:3307/dbclient";
String user_name="root";
String user_pwd="";

try {
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn=DriverManager.getConnection(url,user_name,user_pwd);
	 PreparedStatement ps = conn.prepareStatement("SELECT * FROM client WHERE nom LIKE ? OR prenom LIKE ? OR salaire LIKE ? OR id LIKE ? OR datedebut LIKE?");
	 ps.setString(1, nom);
	 ps.setString(2, prenom);
	 ps.setString(3, salaire);
	 ps.setString(4, id);
	 ps.setString(5, datedebut);

	 ResultSet rs=ps.executeQuery();
	    while(rs.next()){
	
	          out.println( rs.getInt("id") );  
	          out.println(  rs.getString("nom")  ); 
	         
	          out.println(rs.getString("prenom"));
	          out.println( rs.getInt("salaire") );
	            
	            
	    }
} catch (SQLException e) {
	
	e.printStackTrace();
} catch(ClassNotFoundException e){ e.printStackTrace(); }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
