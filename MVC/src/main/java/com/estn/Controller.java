package com.estn;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ClientModel;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.Period;

import entites.Employe;




@WebServlet("*.php")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String path = request.getServletPath();
		
		if ("/acceuil.php".equals(path)) 
		{
			request.getRequestDispatcher("vues/index.html").forward(request, response);
		}
		else if ("/calculate.php".equals(path)) {
		    try {
		        String id = request.getParameter("id_emp");

		        Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/employe_db","root","");
		        PreparedStatement ps = conn.prepareStatement("SELECT * FROM employer WHERE id = ?");

		        ps.setInt(1, Integer.parseInt(id));

		        ResultSet rs = ps.executeQuery();
		        if (rs.next()) {
		        	
		            Employe emp = new Employe();
		            emp.setId(rs.getInt("id"));
		            emp.setNom(rs.getString("nom"));
		            emp.setPrenom(rs.getString("prenom"));
		            emp.setSalaire(rs.getDouble("salaire"));
		            emp.setDate_debut(rs.getDate("date_debut"));

		            Period p = Period.between(emp.getDate_debut().toLocalDate(), LocalDate.now());
		            double prime = (p.getYears() * emp.getSalaire()) + 500.0;
		            
		            ClientModel cm = new ClientModel();
		            
		            cm.setNom(rs.getString("nom"));
		            cm.setPrenom(rs.getString("prenom"));
		            cm.setPrime(prime);

		            request.setAttribute("employe", emp);
		            request.setAttribute("prime", cm.getPrime());
		            request.getRequestDispatcher("vues/resultat.jsp").forward(request, response);
		         }
		            
		        
		    } catch (Exception e) {
		        throw new ServletException(e);
		    }
		}

		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
