/****package com.tp1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Enumeration;
*/
/**
 * Servlet implementation class MaServlet
 */
//@WebServlet("/MaServlet")

/*
public class MaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
/*
    public MaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    /*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter(); 
		 out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>MaServlet</title></head>");
        out.println("<body>");
        out.println("<h1>mime </h1>"+request.getContentType());

        out.println("<h1>client </h1>"+request.getRemoteHost());
        out.println("<h1>ip: </h1>"+request.getRemoteAddr());
        out.println("<h1>sever name  </h1>"+request.getServerName());
        out.println("<h1>server port </h1>"+request.getServerPort());
        out.println("<h1>Schema </h1>"+request.getScheme());
        out.println("<h1>pro </h1>"+request.getProtocol());
             
        Enumeration<String> paramesname=request.getParameterNames();
        
      while(paramesname.hasMoreElements()) {
    	  String nom =paramesname.nextElement();
    	  String valuer = request.getParameter(nom);
    	  out.print(nom +":"+valuer);
      }
      *//*
        out.println("</body>");
        out.println("</html>");
	}
	*/
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 *//*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
*/