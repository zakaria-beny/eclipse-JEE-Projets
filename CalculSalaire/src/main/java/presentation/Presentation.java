package presentation;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import metier.IMetier;
import metier.MetierImpl;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
		 * try { String configPath =
		 * config.getServletContext().getRealPath("/config.txt"); Scanner scanner = new
		 * Scanner(new File(configPath));
		 * 
		 * String daoClass = scanner.nextLine(); Class cdao = Class.forName(daoClass);
		 * IDao dao = (IDao) cdao.getDeclaredConstructor().newInstance();
		 * 
		 * String metierClass = scanner.nextLine(); Class cmetier =
		 * Class.forName(metierClass); metier = (MetierImpl)
		 * cmetier.getDeclaredConstructor().newInstance();
		 * 
		 * Method mtd = cmetier.getMethod("setDao", IDao.class); mtd.invoke(metier,
		 * dao);
		 * 
		 * }catch(Exception e) { e.printStackTrace(); }
		 */
		
		/*
		 * ApplicationContext context = new
		 * ClassPathXmlApplicationContext("springIoc.xml"); metier =
		 * context.getBean(MetierImpl.class);
		 */
		ApplicationContext ctx = new AnnotationConfigApplicationContext("dao","metier");
		metier = ctx.getBean(MetierImpl.class);
		
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getServletPath();
		
		if("/acceuil.do".equals(path)) {
			request.getRequestDispatcher("vues/index.html").forward(request, response);;
		}else if("/calcul.do".equals(path)) {
			int id = Integer.parseInt(request.getParameter("id"));
			Employer emp = metier.affchierEmp(id);
			
			request.setAttribute("emp", emp);
			request.setAttribute("prime", emp.getSalaire());
			request.getRequestDispatcher("vues/result.jsp").forward(request, response);
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
