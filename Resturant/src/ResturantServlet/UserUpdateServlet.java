package ResturantServlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Resturant.dao.UserDao;
import Resturant.model.User;

/**
 * Servlet implementation class UserUpdateServlet
 */
@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String message = "";
		User user = new User();
	    UserDao userdao = new UserDao();
		String action = request.getParameter("action");
		if("userUpdate".equals(action)){
	    String username=request.getParameter("username");
	    String fname=request.getParameter("fName");
		String lname= request.getParameter("lName");
		String password=request.getParameter("password");
		String re_password=request.getParameter("re_password");
		String gender=request.getParameter("gender");
		String address=request.getParameter("address");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		
		
		if(fname.isEmpty() ||lname.isEmpty()|| username.isEmpty()|| password.isEmpty()||re_password.isEmpty()||gender.isEmpty()||address.isEmpty()||phone.isEmpty()||email.isEmpty()) {
			message = "All fields are mandatory*";
			request.setAttribute("message", message);
			request.getRequestDispatcher("UpdateUser.jsp").forward(request, response);
			
		}else if(!password.equals(re_password)) {
			
				message = "Password and Re-enter password mismatch* ";
				request.setAttribute("message", message);
				request.getRequestDispatcher("UpdateUser.jsp").forward(request, response);
				
		}else if(!email.contains("@")){
			
			message = "Email should contain @ symbol* ";
			request.setAttribute("message", message);
			request.getRequestDispatcher("UpdateUser.jsp").forward(request, response);
			
		}else {
		
		user.setFirstName(fname);		
		user.setLastName(lname);
		user.setUserName(username);
		user.setPassword(password);
		user.setRe_password(re_password);
		user.setGender(gender);
		user.setAddress(address);
		user.setPhone(Long.parseLong(phone));
		user.setEmail(email);
		userdao.saveUserUpdateInformation(user);
		
		message = "Update Completely ";
		request.setAttribute("message", message);
		request.getRequestDispatcher("UpdateUser.jsp").forward(request, response);
		}
		
		}
	}

}
