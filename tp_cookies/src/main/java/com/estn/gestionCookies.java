package com.estn;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/acceuil")
public class gestionCookies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bgColor = null;
		String police = null;
		String type = null;
		int nbr = 0;
		
		Cookie[] cookies = request.getCookies();
		if(cookies!=null) {
		for (int i = 0; i < cookies.length; i++) {
			
			if (cookies[i].getName().equals("bgColor")) { 
				bgColor = cookies[i].getValue();
			}
			
			if (cookies[i].getName().equals("police")) { 
				police = cookies[i].getValue();
			}
			
			if (cookies[i].getName().equals("type")) { 
				type = cookies[i].getValue();
			}
			
			if (cookies[i].getName().equals("fav")) { 
				 nbr = Integer.parseInt(cookies[i].getValue());
			}
		}
		}
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Accueil</title>");
		out.println("</head>");
		out.println("<body bgcolor='" + bgColor + "'>");
		out.println("<font color='" + police + "'>");
		out.println("<h2 align='center'>Bienvenue</h2>");
		out.println("<center>Votre nombre préféré est : " + nbr + "</center><br><br>");
		
		if(bgColor==null && police==null && nbr==0 && type==null) {
			response.sendRedirect(request.getContextPath() + "/index.html");
			return;
		}

		if (type.equals("Programmation")) {
		    out.println("<p>Programmation en Java, Claude Delannoy</p>");
		    out.println("<p>Spring in Action, Rod Johnson</p>");
		} else if (type.equals("Sécurité")) {
		    out.println("<p>Sécurité Réseaux, Claude Delannoy</p>");
		    out.println("<p>CyberSecurity, Rod Johnson</p>");
		} else if (type.equals("Ingénierie")) {
		    out.println("<p>MDA en Action, Claude Delannoy</p>");
		    out.println("<p>CyberSecurity, Rod Johnson</p>");
		}
		

		out.println("</font>");
		out.println("</body>");
		out.println("</html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
