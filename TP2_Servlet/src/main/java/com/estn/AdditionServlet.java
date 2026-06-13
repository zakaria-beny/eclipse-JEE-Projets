package com.estn;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AdditionServlet")
public class AdditionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
        out.println("<h1>Addition de deux nombres</h1>");
        out.println("<form action='AdditionServlet' method='POST'>");
        out.println("Numbre 1: <input type='text' name='Num1'><br><br>");
        out.println("Numbre 2: <input type='text' name='Num2'><br><br>");
        out.println("<input type='submit' value='Addition'>");
        out.println("</form>");
        out.println("</body></html>");
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int n1 = Integer.parseInt(request.getParameter("Num1"));
		int n2 = Integer.parseInt(request.getParameter("Num2"));
		
		int resultat = n1 + n2;
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		out.println("<html><body>");
		out.println("<h1>Addition de deux nombres</h1>");
        out.println("<h2>Résultat :</h2>");
        out.println("<p>La somme de " + n1 + " + " + n2 + " = <b>" + resultat + "</b></p>");
        
        out.println("<form action='AdditionServlet' method='POST'>");
        out.println("Numbre 1: <input type='text' name='Num1'><br><br>");
        out.println("Numbre 2: <input type='text' name='Num2'><br><br>");
        out.println("<input type='submit' value='Addition'>");
        out.println("</form>");
        out.println("</body></html>");
		
	}
	

}
