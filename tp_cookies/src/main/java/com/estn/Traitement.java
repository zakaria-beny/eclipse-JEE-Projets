package com.estn;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/newUser")
public class Traitement extends HttpServlet {
	 
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bgColor = request.getParameter("bg");
		String police = request.getParameter("police");
		String livre = request.getParameter("type");
		int nbr = Integer.parseInt(request.getParameter("fav"));
		
		Cookie c = new Cookie("bgColor",bgColor);
		response.addCookie(c);
		c.setMaxAge(60*60*24);
		
		Cookie p = new Cookie("police",police);
		response.addCookie(p);
		p.setMaxAge(60*60*24);
		
		Cookie l = new Cookie("type",livre);
		response.addCookie(l);
		l.setMaxAge(60*60*24);
		
		Cookie n = new Cookie("fav",""+nbr);
		response.addCookie(n);
		n.setMaxAge(60*60*24);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>TP3</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2 align='center'>Préférences Utilisateur Bien enregistrées</h2>");
		out.println("<center><a href='acceuil'>Accueil</a></center>");
		out.println("</body>");
		out.println("</html>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
