package com.estn;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;


@WebServlet("/InfoServlet")
public class InfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public InfoServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		
		PrintWriter x = response.getWriter();
		
		x.println("<html><body>");
		x.println("<h1 align='center'>les informations du client </h1>");
		x.println("<h3>Type de la requête : "+ request.getContentType() +" </h3>");
		x.println("<h3>Protocole de la requête : "+ request.getProtocol() +" </h3>");
		x.println("<h3>Adresse IP du client : "+ request.getRemoteAddr() +" </h3>");
		x.println("<h3>Nom du client : "+ request.getRemoteHost() +" </h3>");
		x.println("<h3>Nom du serveur qui a reçu la requête : "+ request.getServerName()+" </h3>");
		x.println("<h3>Port du serveur qui a reçu la requête : "+ request.getServerPort() +" </h3>");
		x.println("<h3>scheme : "+ request.getScheme() +" </h3>");
		x.println("<h4>Liste des paramètres</h4>");
        x.println("<ul>");
        
        
        
        Enumeration<String> PNames = request.getParameterNames();
        while(PNames.hasMoreElements()) {
        	String Name = PNames.nextElement();
        	String Value = request.getParameter(Name);
        	
        	x.println("<li>nom: " + Name + " valeur: " + Value + "</li>");
        }
        
        
        x.println("</ul>");
        x.println("</body></html>");
		
		
	}

	

}
