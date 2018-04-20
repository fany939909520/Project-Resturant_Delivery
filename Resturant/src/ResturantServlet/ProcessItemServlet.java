package ResturantServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Resturant.dao.ItemsDao;
import Resturant.model.Item;




/**
 * Servlet implementation class ProcessItemOrder
 */
@WebServlet("/ProcessItemServlet")
public class ProcessItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext SC = null;
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
		
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	
   public int isExisting(String itemname, List<Item> cart) {
    	 for(int i=0; i<cart.size(); i++) 
    		 if(cart.get(i).getItemName()==itemname)
    			 return i;
    	 return -1;
     }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String  	
		Integer quantity=0;
		
		String username = request.getParameter("user_name");
	
		String action = request.getParameter("action");
		Map<String, Integer> itemMap=new HashMap<String, Integer>();
		ItemsDao itemdao = new ItemsDao();
		HttpSession session= request.getSession();
		session.setAttribute("username", username);
	
		
	    if(action.equals("Item")) {
	    	if(session.getAttribute("cart")==null) {
	    		List<Item> cart =new ArrayList<Item>();
	    		String itemname=request.getParameter("item_name");
	    		
	    		Item item=null;
				try {
					item = itemdao.getItem(itemname);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
	    		cart.add(item);
	    		itemMap.put(itemname, 1);
	    		session.setAttribute("quantity", String.valueOf(itemMap.get(itemname)));
	    		session.setAttribute("cart", cart);
	    	}else {
	    		List<Item> cart =(List<Item>)session.getAttribute("cart");
	    		
	    		String itemname=(String)request.getParameter("item_name");
	    		
	    		int index=isExisting(itemname,cart);
	    		
	    		if(index==-1) {
	    			Item item=null;
					try {
						item = itemdao.getItem(itemname);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	    		cart.add(item);
	    		itemMap.put(itemname, 1);
	    		}else {
	    			System.out.println("item"+ itemMap.get(itemname));
	    		    quantity=itemMap.get(itemname)+1;
	    			itemMap.put(itemname, quantity);
	    		}
	    		session.setAttribute("quantity", String.valueOf(itemMap.get(itemname)));
	    		session.setAttribute("cart", cart);
	    		request.getRequestDispatcher("OrderView.jsp").forward(request, response);
	    	}
	    }else if(action.equals("ItemDelete")) {
	    	List<Item> cart =(List<Item>)session.getAttribute("cart");
	    	String itemname=(String)request.getParameter("item_name");
	    	int index=isExisting(itemname,cart);
	    	cart.remove(index);
	    	request.getRequestDispatcher("OrderView.jsp").forward(request, response);
	    }
	    

	}
}
