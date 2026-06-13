package com.ilcs;




import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/Hello")
public class MaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public MaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
	IOException {
	
		 PrintWriter out = response.getWriter();

	        out.println("<!DOCTYPE html>");
	        out.println("<html>");
	        out.println("<head><title>MaServlet</title></head>");
	        out.println("<body>");
	        out.println("<h1>Bonjour le mondet </h1>");
	        out.println("<p>la date d'aujourd'hui"+ LocalDate.now()+"</p>");
	        out.println("</body>");
	        out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
