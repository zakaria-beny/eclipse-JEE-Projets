package presentation.controller;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import DAO.DAOImpl;
import DAO.SingletonConnection;
import metier.IMetier;
import metier.MetierImpl;

public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IMetier metier;
	
	public controller() {
		super();
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String path = request.getServletPath();
		
		if ("/acceuil.do".equals(path)) {
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			
		} else if ("/calculer.do".equals(path)) {
			int id = 0;
			try {
				id = Integer.parseInt(request.getParameter("id"));
			} catch (NumberFormatException e) {
				request.setAttribute("error", "Invalid id");
				request.getRequestDispatcher("/erreur.jsp").forward(request, response);
				return;
			}
			
			DAOImpl dao = new DAOImpl(SingletonConnection.getConnexion());
			MetierImpl metierImpl = new MetierImpl();
			metierImpl.setDao(dao);
			
			request.setAttribute("user", metierImpl.calPrime(id));
			request.getRequestDispatcher("/resultat.jsp").forward(request, response);
				
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}