package ResturantServlet;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Resturant.dao.UserDao;

import Resturant.model.User;


/**
 * Servlet implementation class Login
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
    	RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
    	rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		final HttpSession session =request.getSession();
		
		
		String action = request.getParameter("action1");
		if("userLogin".equals(action)){
	    UserDao userdao = new UserDao();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		User user = userdao.getUserValidate(username,password);
		
		if(username.equals(user.getUserName()) &&
		   password.equals(user.getPassword())) {
			
			session.setAttribute("username", username);
			
			RequestDispatcher re=request.getRequestDispatcher("MenuItem.jsp");
			re.forward(request, response);
	
		}else{
			
			request.setAttribute("message", "Login Error");
			RequestDispatcher dis = request.getRequestDispatcher("UserLogin.jsp");
			dis.forward(request, response);
		
		}
	
		   
		}		
	
	}
}
