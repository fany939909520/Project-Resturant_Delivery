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
 * Servlet implementation class AdminUpdateServlet
 */
@WebServlet("/AdminUpdateServlet")
public class AdminUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

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
	   Admin admin = new Admin();
	    AdminDao admindao = new AdminDao();
		
		String action = request.getParameter("action");
		if("adminUpdate".equals(action)){
		
		String fname=request.getParameter("fName");
		String lname=request.getParameter("lName");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String re_password=request.getParameter("re_password");
		String gender=request.getParameter("gender");
		String address=request.getParameter("address");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		
		if(fname.isEmpty() ||lname.isEmpty()|| username.isEmpty()|| password.isEmpty()||
				re_password.isEmpty()||gender.isEmpty()||address.isEmpty()||phone.isEmpty()||email.isEmpty()) {
			message = "All fields are mandatory*";
			request.setAttribute("message", message);
			request.getRequestDispatcher("UpdateAdmin.jsp").forward(request, response);
			
		}else if(!password.equals(re_password)) {
			
				message = "Password and Re-enter password mismatch* ";
				request.setAttribute("message", message);
				request.getRequestDispatcher("UpdateAdmin.jsp").forward(request, response);
				
		}else if(!email.contains("@")){
			
			message = "Email should contain @ symbol* ";
			request.setAttribute("message", message);
			request.getRequestDispatcher("UpdateAdmin.jsp").forward(request, response);
			
		}else {
		
		admin.setFirstName(fname);		
		admin.setLastName(lname);
		admin.setadminUserName(username);
		admin.setPassword(password);
		admin.setRe_password(re_password);
		admin.setGender(gender);
		admin.setAddress(address);
		admin.setPhone(Long.parseLong(phone));
		admin.setEmail(email);
		admindao.saveAdminUpdateInformation(admin);
		
		message = "Update Completely ";
		request.setAttribute("message", message);
		RequestDispatcher send=request.getRequestDispatcher("UpdateAdmin.jsp");
		send.forward(request, response);
		}
	}
	}
}
