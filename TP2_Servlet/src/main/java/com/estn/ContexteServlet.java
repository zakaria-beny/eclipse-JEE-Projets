package com.estn;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/ContexteServlet")
public class ContexteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		ServletContext context = getServletContext();
		
		String webmaster = context.getInitParameter("WebMaster");
		String email = context.getInitParameter("email");
		
		out.println("<html><body>");
        out.println("<h2>Paramètres du contexte :</h2>");
        out.println("<p><b>Webmaster :</b> " + webmaster + "</p>");
        out.println("<p><b>Email :</b> " + email + "</p>");
        out.println("</body></html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
