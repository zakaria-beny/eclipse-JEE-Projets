package com.tp2;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/SimpleServlet")
public class SimpleServlet  implements Servlet {
	private static final long serialVersionUID = 1L;
       
   
    public SimpleServlet() {
        super();
    }
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

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
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		arg1.setContentType("text/html");
		PrintWriter out=arg1.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<h1>hhhhhhh</h1>");
		out.print("</body></html>");
	}

}
