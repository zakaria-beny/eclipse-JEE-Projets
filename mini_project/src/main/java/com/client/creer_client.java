package com.client;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import com.client.bean.*;

/**
 * Servlet implementation class creer_client
 */
@WebServlet("/creer_client")
public class creer_client extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public creer_client() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nom= request.getParameter("nom_client");
        String tele= request.getParameter("tele_client");
        String id_clnt= request.getParameter("id_client");
        String date= request.getParameter("date_client");
        String mess;
        if(
           nom.trim().isEmpty() || tele.trim().isEmpty() || id_clnt.trim().isEmpty() || date.trim().isEmpty()){
            mess="u have to full formulaire";
            request.setAttribute("mess", mess);
            this.getServletContext().getRequestDispatcher("/inscription.jsp").forward(request, response);
        }else {
            mess="welcom to your information ";
            Client client = new Client();
            client.setNom_cli(nom);
            client.setDate_nais(date);
            client.setId_client(Integer.parseInt(id_clnt));
            client.setNum_tele(Integer.parseInt(tele));
       
            request.setAttribute("mess", mess);
            request.setAttribute("client", client);
            this.getServletContext().getRequestDispatcher("/infoclientjsp.jsp").forward(request, response);
        }
	
	}

}