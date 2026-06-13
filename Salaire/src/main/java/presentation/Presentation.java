package presentation;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import metier.MetierImpl;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import dao.DaoImpl;
import dao.Employer;
import dao.IDao;


@WebServlet("*.do")
public class Presentation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MetierImpl metier;
   
	public void init(ServletConfig config) throws ServletException {
		/*
		 * DaoImpl dao = new DaoImpl(); metier = new MetierImpl(); metier.setDao(dao);
		 */
		
		/*
		 * try { String Rp = config.getServletContext().getRealPath("config.txt");
		 * Scanner s = new Scanner(new File(Rp));
		 * 
		 * String daoClass = s.nextLine(); Class cdao = Class.forName(daoClass); IDao
		 * dao = (IDao) cdao.getDeclaredConstructor().newInstance();
		 * 
		 * String metierClass = s.nextLine(); Class cmetier =
		 * Class.forName(metierClass); metier = (MetierImpl)
		 * cmetier.getDeclaredConstructor().newInstance();
		 * 
		 * Method m = cmetier.getMethod("setDao", IDao.class); m.invoke(metier, dao);
		 * 
		 * } catch(Exception e) {e.printStackTrace();}
		 */
		/*
		 * ApplicationContext c = new ClassPathXmlApplicationContext("spring.xml");
		 * metier = c.getBean(MetierImpl.class);
		 */
		
		ApplicationContext c =
				new AnnotationConfigApplicationContext("dao","metier");
		metier = c.getBean(MetierImpl.class);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		
		if("/home.do".equals(path)) {
			request.getRequestDispatcher("vues/index.html").forward(request, response);
		}else if("/calcul.do".equals(path)) {
			int id = Integer.parseInt(request.getParameter("id"));
			Employer employer = metier.affchierPrime(id);
			
			request.setAttribute("emp", employer);
			request.setAttribute("prime", employer.getSalaire());
			request.getRequestDispatcher("vues/response.jsp").forward(request, response);
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
