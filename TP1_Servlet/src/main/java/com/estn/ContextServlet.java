package com.estn;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;


@WebServlet("/ServletContext")
public class ContextServlet implements Servlet {
	private ServletConfig Sconfig;

	@Override
	public void destroy() {}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void init(ServletConfig Sconfig) throws ServletException {
		this.Sconfig = Sconfig;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		ServletContext context = Sconfig.getServletContext();
		
		String webmaster = context.getInitParameter("WebMaster");
		String email = context.getInitParameter("email");
		
		out.println("<html><body>");
        out.println("<h2>Paramètres du contexte :</h2>");
        out.println("<p><b>Webmaster :</b> " + webmaster + "</p>");
        out.println("<p><b>Email :</b> " + email + "</p>");
        out.println("</body></html>");
		
		
	}

}
