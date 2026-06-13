package com.estn;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;


//@WebServlet("/SimpleServlet")
public class SimpleServlet implements Servlet {

	@Override
	public void destroy() {}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void init(ServletConfig arg0) throws ServletException {}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		
		PrintWriter out = res.getWriter();
		
		out.println("<html><body>");
		out.println("<h2>Hello World</h2>");
		out.println("</body></html>");
		
	}
	
  

}
