package ResturantServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Resturant.dao.LocationDao;
import Resturant.dao.OrderDao;
import Resturant.model.Location;
import Resturant.model.Order;

/**
 * Servlet implementation class PaymentProcessServlet
 */
@WebServlet("/PaymentProcessServlet")
public class PaymentProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getParameter("action");
		
		HttpSession session= request.getSession();	
	    if(action.equals("payment")) {
	    String creditcard=request.getParameter("CreaditCard");
	    String securenumber=request.getParameter("SecureNumber");
	    String zipcode=request.getParameter("ZipCode");
	    String username=request.getParameter("user_name"); 
        Order order=new Order();
        order.setUser_name(username);
        order.setCredit_Card_Number(Integer.parseInt(creditcard));
        order.setSecure_code(Integer.parseInt(securenumber));
        order.setCardzipCode(Long.parseLong(zipcode));
        
        session.setAttribute("username", username);
    
        request.getRequestDispatcher("OrderReceipt.jsp").forward(request, response);
	}
	}
}
