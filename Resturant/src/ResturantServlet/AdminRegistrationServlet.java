package ResturantServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Resturant.dao.AdminDao;

import Resturant.model.Admin;


/**
 * Servlet implementation class AdminRegistrationServlet
 */
@WebServlet("/AdminRegistrationServlet")
public class AdminRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher re=request.getRequestDispatcher("Login.jsp");
		re.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String message = "";
		
		
		String action = request.getParameter("action");
		if("adminRegister".equals(action)){
		int i=0;
	    Admin admin=new Admin();
		AdminDao admindao = new AdminDao();
		String fname=request.getParameter("fName");
		String lname=request.getParameter("lName");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String re_password=request.getParameter("re_password");
		String gender=request.getParameter("gender");
		String address=request.getParameter("address");
		String phones=request.getParameter("phone");
		String email=request.getParameter("email");
	
		
		if(fname.isEmpty() ||lname.isEmpty()|| username.isEmpty()|| password.isEmpty()||
				re_password.isEmpty()||gender.isEmpty()||address.isEmpty()||phones.isEmpty()||email.isEmpty()) {
			message = "All fields are mandatory*";
			request.setAttribute("message", message);
			request.getRequestDispatcher("AdminRegistration.jsp").forward(request, response);
			
		}else if(!password.equals(re_password)) {
			
				message = "Password and Re-enter password mismatch* ";
				request.setAttribute("message", message);
				request.getRequestDispatcher("AdminRegistration.jsp").forward(request, response);
				
		}else if(!email.contains("@")){
			
			message = "Email should contain @ symbol* ";
			request.setAttribute("message", message);
			request.getRequestDispatcher("AdminRegistration.jsp").forward(request, response);
			
		}else {
		//String[] phones = phone.split("");//5678999
		
		admin.setFirstName(fname);		
		admin.setLastName(lname);
		admin.setadminUserName(username);
		admin.setPassword(password);
		admin.setRe_password(re_password);
		admin.setGender(gender);
		admin.setAddress(address);
		admin.setPhone(Long.parseLong(phones));
		admin.setEmail(email);
		admindao.saveAdmin_Information(admin);
		
		
		RequestDispatcher send=request.getRequestDispatcher("AdminLogin.jsp");
		send.forward(request, response);
		}
	
	}}
}
