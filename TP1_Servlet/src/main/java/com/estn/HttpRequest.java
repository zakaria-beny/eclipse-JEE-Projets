package com.estn;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/HttpRequest")
public class HttpRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HttpRequest() {
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
        out.println("<form action='HttpRequest' method='POST'>");
        out.println("Numbre 1: <input type='text' name='Num1'><br><br>");
        out.println("Numbre 2: <input type='text' name='Num2'><br><br>");
        out.println("<input type='submit' value='Addition'>");
        out.println("</form>");
        out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String n1 = request.getParameter("Num1");
		String n2 = request.getParameter("Num2");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		double N1=0,N2=0;
		try {
			N1 = Double.parseDouble(n1);
			N2 = Double.parseDouble(n2);
		}catch(NumberFormatException e){
			System.out.println(e);
		}
		
		/*finally {
			System.out.println("programme terminee");
		}*/
		
		double somme = N1 + N2;
		
		out.println("<html><body>");
        out.println("<h2>Résultat :</h2>");
        out.println("<p>La somme de " + n1 + " + " + n2 + " = <b>" + somme + "</b></p>");
        
        out.println("<form action='HttpRequest' method='POST'>");
        out.println("Numbre 1: <input type='text' name='Num1'><br><br>");
        out.println("Numbre 2: <input type='text' name='Num2'><br><br>");
        out.println("<input type='submit' value='Addition'>");
        out.println("</form>");
        out.println("</body></html>");
		
	}

}
