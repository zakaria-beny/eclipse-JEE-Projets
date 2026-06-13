package presentation;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import metier.IMetier;
import metier.MetierImpl;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.Client;
import dao.DaoImpl;
import dao.IDao;
import java.io.File;

@WebServlet("*.do")
public class Presentation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MetierImpl metier;

	public void init(ServletConfig config) throws ServletException {
		//DaoImpl dao = new DaoImpl();
		/*
		 * DaoImpl dao = new DaoImpl(); metier = new MetierImpl(); metier.setDao(dao);
		 */
		//metier.setDao(dao);
		/*
		 * try { String url = config.getServletContext().getRealPath("/config.text");
		 * Scanner sc = new Scanner(new File(url));
		 * 
		 * String daoClass = sc.nextLine(); Class cDao = Class.forName(daoClass); IDao
		 * dao = (IDao) cDao.getDeclaredConstructor().newInstance();
		 * 
		 * String metierClass = sc.nextLine(); Class cMetier =
		 * Class.forName(metierClass); metier = (MetierImpl)
		 * cMetier.getDeclaredConstructor().newInstance();
		 * 
		 * Method m = cMetier.getMethod("setDao", IDao.class); m.invoke(metier, dao);
		 * 
		 * }catch(Exception e) { e.getStackTrace(); }
		 */
		/*
		 * ApplicationContext ctx = new ClassPathXmlApplicationContext("springIoc.xml");
		 * metier = ctx.getBean(MetierImpl.class);
		 */
		
		ApplicationContext  ctx = new AnnotationConfigApplicationContext("dao","metier");
		metier = ctx.getBean(MetierImpl.class);
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		
		switch (path) {
	    case "/acceuil.do":
	    	List<Client> ListClients = metier.affichierTout();
	    	request.setAttribute("LsitOfClients", ListClients);
	        request.getRequestDispatcher("/vues/index.jsp").forward(request, response);
	        break;
	    case "/add.do":
	    	//int id = Integer.parseInt(request.getParameter("id"));
	    	String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            int age = Integer.parseInt(request.getParameter("age"));

            Client c = new Client();
            //c.setId(id);//auto increment
            c.setNom(nom);
            c.setPrenom(prenom);
            c.setAge(age);

            metier.ajouter(c);
            response.sendRedirect(request.getContextPath() + "/acceuil.do");
	    	break;
	    case "/update.do":
			/*
			 * int id = Integer.parseInt(request.getParameter("id"));
			 * 
			 * String newNom = request.getParameter("nom"); String newPrenom =
			 * request.getParameter("prenom"); int newAge =
			 * Integer.parseInt(request.getParameter("age"));
			 * 
			 * Client cUpdated = new Client(); cUpdated.setNom(newNom);
			 * cUpdated.setPrenom(newPrenom); cUpdated.setAge(newAge);
			 * 
			 * metier.modifier(cUpdated, id);
			 * 
			 * response.sendRedirect(request.getContextPath() + "/acceuil.do");
			 */
	    	String idStr = request.getParameter("id");
	        System.out.println("ID reçu: " + idStr); // Debug
	        if (idStr != null && !idStr.trim().isEmpty()) {
	            int idClient = Integer.parseInt(idStr);
	            Client cls = metier.afficherParId(idClient);
	            System.out.println("Client trouvé: " + (cls != null ? cls.getNom() : "null")); // Debug
	            request.setAttribute("client", cls);
	            request.getRequestDispatcher("vues/update.jsp").forward(request, response);
	        } else {
	            System.out.println("ID vide ou null"); // Debug
	            response.sendRedirect(request.getContextPath() + "/acceuil.do");
	        }
	    	
	    	break;
	    	
	    case "/submitUpdate.do":
	        int idToUpdate = Integer.parseInt(request.getParameter("id"));
	        String newNom = request.getParameter("nom");
	        String newPrenom = request.getParameter("prenom");
	        int newAge = Integer.parseInt(request.getParameter("age"));

	        Client cUpdated = new Client();
	        cUpdated.setId(idToUpdate);
	        cUpdated.setNom(newNom);
	        cUpdated.setPrenom(newPrenom);
	        cUpdated.setAge(newAge);

	        metier.modifier(cUpdated);
	        response.sendRedirect(request.getContextPath() + "/acceuil.do");
	        break;
	        
	    case "/delete.do":
	    	int id = Integer.parseInt(request.getParameter("id"));
	    	metier.supprimer(id);
	    	response.sendRedirect(request.getContextPath() + "/acceuil.do");
	    	break;    
	    
	    case "/search.do":
	    	String motsCle = request.getParameter("motsCle");
            List<Client> result = metier.affichierParNom(motsCle);
            request.setAttribute("LsitOfClients", result);
            request.getRequestDispatcher("/vues/index.jsp").forward(request, response);
            break;

	    default:
	    	response.sendRedirect("acceuil.do");
            break;
	}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
