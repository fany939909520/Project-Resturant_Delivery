package ResturantServlet;


import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Resturant.dao.ItemsDao;
import Resturant.model.Admin;
import Resturant.model.Item;







/**
 * Servlet implementation class ItemsManagementProcessServlet
 */
@WebServlet("/ItemsManagementServlet")
@MultipartConfig(maxFileSize=169999999)
public class ItemsManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	InputStream inputstream = null;
	
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
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	    String message1=" ", message2=" ";

		String action = request.getParameter("action");
		if("AddItem".equals(action)) {
		String adminusername=request.getParameter("adminusername");
		String itemname=request.getParameter("itemname");
		String price=request.getParameter("price");
		String description=request.getParameter("description");
		String category=request.getParameter("category");
		String active=request.getParameter("active");
		String image =request.getParameter("image");
		
		String imagename = image.substring(image.lastIndexOf("\\")+1);	    
	    String savepath="C:\\Users\\user\\eclipse-workspace\\Resturant\\WebContent"+File.separator+imagename;
	    File file=new File(savepath);
	    
	    FileOutputStream  out = new FileOutputStream(file);  
		out.close();
		
		
		Item item=new Item();
		ItemsDao itemsdao = new ItemsDao();

		item.setAdminUserName(adminusername);
		item.setItemName(itemname);
		item.setPrice(Double.parseDouble(price));
		item.setImage(imagename);
		item.setDescription(description);
		item.setCategory(category);
		item.setAcitve(Integer.parseInt(active));
		item.setQuantity(0);
		item.setShop("Best_Food");
		itemsdao.saveItems(item);
		
		message1 = "Add Completely ";
		request.setAttribute("message1", message1);
		request.getRequestDispatcher("ItemsManagement.jsp").forward(request, response);
		
		}else if("UpdateItem".equals(action)) {
		
		   
			String adminusername=request.getParameter("adminusername");
		      ItemsDao itDAO = new ItemsDao();
			  try {
				List<Item> itList = itDAO.getAdminDisplayItems(adminusername);
		 
			String itemname=request.getParameter("itemName");
			String price=request.getParameter("price");
			String description=request.getParameter("description");
			String category=request.getParameter("category");
			String active=request.getParameter("active");
			String image =request.getParameter("image");
			
			String imagename = image.substring(image.lastIndexOf("\\")+1);	    
		    String savepath="C:\\Users\\user\\eclipse-workspace\\Resturant\\WebContent"+File.separator+imagename;
		    File file=new File(savepath);
		    
		    FileOutputStream  out = new FileOutputStream(file);  
			out.close();
			int i=0;
			boolean flag=false;
			while(true) {
			
				if(itList.get(i).getItemName().equals(itemname)) {
					flag=true;
				}
			
				 if(flag==true){
			    	   Item item=new Item();
						ItemsDao itemsdao = new ItemsDao();
						item.setAdminUserName(adminusername);
						item.setItemName(itemname);
						item.setPrice(Double.parseDouble(price));
						item.setImage(imagename);
						item.setDescription(description);
						item.setCategory(category);
						item.setAcitve(Integer.parseInt(active));	
						item.setQuantity(0);
						item.setShop("Best_Food");
						itemsdao.UpdateItems(item);
						
						message2 = "Updated Completely ";
						request.setAttribute("message2", message2);
						
						request.getRequestDispatcher("ItemsManagement.jsp").forward(request, response);
				        break;
					}else if(flag==false &&  i==itList.size()-1) {
					 	message2 = "Item Not Found ";
						request.setAttribute("message2", message2);
						
						request.getRequestDispatcher("ItemsManagement.jsp").forward(request, response);
						break;
					}
				
				i++;
			}
		   
				
			
		
	   } catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
			  
			  }
	}

}
