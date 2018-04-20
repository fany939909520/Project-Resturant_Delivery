package ResturantServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Resturant.dao.ItemsDao;
import Resturant.dao.LocationDao;
import Resturant.dao.OrderDao;
import Resturant.model.Item;
import Resturant.model.Location;
import Resturant.model.Order;

/**
 * Servlet implementation class ProcessLocationServlet
 */
@WebServlet("/ProcessLocationServlet")
public class ProcessLocationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessLocationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		Location location =null;
		String action = request.getParameter("action");
		String username=request.getParameter("username");
		HttpSession session= request.getSession();
		
	
	    if(action.equals("Location")) {
	    String locationname=request.getParameter("Location_name");
        LocationDao locationdao =new LocationDao();
        try {
        	location=locationdao.getLocationByLocationname(locationname);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
   
      Order orderLo = new Order();
      OrderDao orderdao = new OrderDao();
      orderLo.setUser_name(username);
      orderLo.setAdmin_User_name(location.getAdminUsername());
      orderLo.setLocation_name(location.getLocationName());
      orderLo.setAddress(location.getAddress());
      orderLo.setCity(location.getCity());
      orderLo.setAddresszipcode(location.getZipCode());
      orderdao.saveUserOrderLocation(orderLo);
      session.setAttribute("username", username);
	  
      request.getRequestDispatcher("Payment.jsp").forward(request, response);
	
	    }
	}
}
