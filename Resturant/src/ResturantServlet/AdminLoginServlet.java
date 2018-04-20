package ResturantServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Resturant.dao.AdminDao;
import Resturant.model.Admin;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dis = request.getRequestDispatcher("Location.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		final HttpSession session =request.getSession();
		
		String action = request.getParameter("action2");
		if("adminLogin".equals(action)){
		    AdminDao admindao = new AdminDao();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			Admin admin = admindao.getAdminValidate(username,password);
			
			if(username.equals(admin.getadminUserName()) &&
			   password.equals(admin.getPassword())) {	
				
				session.setAttribute("admin", admin);
				
				RequestDispatcher re=request.getRequestDispatcher("ItemsManagement.jsp");
				re.forward(request, response);
		       
			
			}else {	
				request.setAttribute("message", "Login Error");
				RequestDispatcher dis = request.getRequestDispatcher("AdminLogin.jsp");
				dis.forward(request, response);
			
	}}
	}

}
