package com.tp4;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class formulaire
 */
@WebServlet("/formulaire")
public class formulaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public formulaire() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Addition de deux nombres</h2>");
        out.println("<form method='POST' action='formulaire'>");
        out.println("Nombre 1: <input type='text' name='val1'><br>");
        out.println("Nombre 2: <input type='text' name='val2'><br>");
        out.println("<input type='submit' value='Additionner'>");
        out.println("</form>");
    
        out.println("</body></html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
		String nb1 =request.getParameter("val1");
		String nb2 =request.getParameter("val2");
		
		try {
			int n1= Integer.parseInt(nb1);
			int n2= Integer.parseInt(nb2);
			
			int s=n1+n2;
			out.println("le resulat :"+s);
}catch (NumberFormatException e) {
    out.println("<p>Veuillez entrer des nombres valides</p>");
}
		
out.println("<h2>novelle addition</h2>");
doGet(request, response);
	}

}
