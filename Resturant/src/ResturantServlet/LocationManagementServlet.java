package ResturantServlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Resturant.dao.LocationDao;

import Resturant.model.Location;

/**
 * Servlet implementation class LocationManagementServlet
 */
@WebServlet("/LocationManagementServlet")
public class LocationManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	InputStream inputstream = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocationManagementServlet() {
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
	
		String message1 = " ",message2=" ";
		
		String action = request.getParameter("action");
		if("addLocation".equals(action)) {
		String adminusername=request.getParameter("adminusername");	
		String locationname=request.getParameter("location");
		String address=request.getParameter("address");
		String city=request.getParameter("city");
		String staff=request.getParameter("staff");
		String zipCode=request.getParameter("zipcode");
	    String image=request.getParameter("image");
		
		String imagename = image.substring(image.lastIndexOf("\\")+1);	    
	    String savepath="C:\\Users\\user\\eclipse-workspace\\Resturant\\WebContent"+File.separator+imagename;
	    File file=new File(savepath);
	    
	    FileOutputStream  out = new FileOutputStream(file);  
		out.close();
		
		
		
		Location location=new Location();
		LocationDao locationdao = new LocationDao();
		location.setAdminUsername(adminusername);
		location.setLocationName(locationname);
		location.setAddress(address);
		location.setCity(city);
		location.setNumberOfStaff(Integer.parseInt(staff));
		location.setZipCode(Long.parseLong(zipCode));
	    location.setImage(imagename);
		locationdao.saveLocation(location);
		
		message1 = "Add Completely ";
		request.setAttribute("message1", message1);
		request.getRequestDispatcher("LocationManagement.jsp").forward(request, response);
		
		}else if("updateLocation".equals(action)) {

			String adminusername=request.getParameter("adminusername");
		      LocationDao loDAO = new LocationDao();
			  try {
				List<Location> loList =loDAO.getLocations(adminusername);

				String locationname=request.getParameter("locationname");
				String address=request.getParameter("address");
				String city=request.getParameter("city");
				String staff=request.getParameter("staff");
				String zipCode=request.getParameter("zipcode");
			    String image=request.getParameter("image");
			
			String imagename = image.substring(image.lastIndexOf("\\")+1);	    
		    String savepath="C:\\Users\\user\\eclipse-workspace\\Resturant\\WebContent"+File.separator+imagename;
		    File file=new File(savepath);
		    
		    FileOutputStream  out = new FileOutputStream(file);  
			out.close();
			int i=0;
			boolean flag=false;
			while(true) {
			
				if((loList.get(i).getLocationName()).equals(locationname)) {
					flag=true;
				}
			
				 if(flag==true){
			    	   Location location=new Location();
						LocationDao lodao = new LocationDao();
						location.setAdminUsername(adminusername);
						location.setLocationName(locationname);
						location.setAddress(address);
						location.setCity(city);
						location.setNumberOfStaff(Integer.parseInt(staff));
						location.setZipCode(Long.parseLong(zipCode));
					    location.setImage(imagename);		
						lodao.UpdateLocation(location);
						message2 = "Updated Completely ";
						request.setAttribute("message2", message2);
						
						request.getRequestDispatcher("LocationManagement.jsp").forward(request, response);
				        break;
					}else if(flag==false &&  i==loList.size()-1) {
					 	message2 = "Location Not Found ";
						request.setAttribute("message2", message2);
						
						request.getRequestDispatcher("LocationManagement.jsp").forward(request, response);
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
