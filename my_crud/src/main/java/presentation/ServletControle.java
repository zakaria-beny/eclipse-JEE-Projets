package presentation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import Service.IFriendService;
import dao.Friends;


@WebServlet("*.do")
public class ServletControle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private IFriendService FriendImpl ;
  
    public ServletControle() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
              String path =request.getServletPath();
              Friends friends = new Friends();
              switch (path) {
              case "accuiel.do":{
            	  try {
					List<Friends> friend = FriendImpl.listAllFriends(); 
					request.getRequestDispatcher("/index.jsp").forward(request, response);

				  } catch (SQLException e) {
					
					e.printStackTrace();
				  }  
            	  
              }
              case "noveaux.do":
            	  
                int id =Integer.parseInt(request.getParameter("id"));
                int age =Integer.parseInt(request.getParameter("age"));
                
            	  request.getRequestDispatcher("/index.jsp").forward(request, response);

              }
              
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
