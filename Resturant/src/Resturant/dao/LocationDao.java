package Resturant.dao;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Resturant.model.Item;
import Resturant.model.Location;

public class LocationDao {
	      public void saveLocation(Location location) {
	    	Connection conn = null;
	  		PreparedStatement stmt = null;

	  		String SAVE = "INSERT INTO "
	  				+ "Location_Information( Admin_User_name, Admin_Location_name, Admin_Address, Admin_City, Admin_Number_staff, Admin_ZipCode, Admin_Image) " 
	  				+ "VALUES(?, ?, ?, ?, ?, ?, ?)";
	  	
	  		OracleConnection oracle = new OracleConnection();
	  		///////////??
	  		try {
	  			conn = oracle.getConnection();
	  			stmt = conn.prepareStatement(SAVE);
	  			stmt.setString(1, location.getAdminUsername());
	  			stmt.setString(2, location.getLocationName());
	  			stmt.setString(3, location.getAddress());
	  			stmt.setString(4,  location.getCity());
	  			stmt.setInt(5, location.getNumberOfStaff());
	  			stmt.setLong(6, location.getZipCode());
	  			stmt.setString(7, location.getImage());
             	  		
	  			stmt.executeUpdate();
	  			stmt.close();
	  		
	  	
	  			
	  		} catch (ClassNotFoundException | IOException | SQLException e) {
	  			// TODO Auto-generated catch block
	  			e.printStackTrace();
	  		}
	  		}
	      

	      public void UpdateLocation(Location location) {
	      	Connection conn = null;
	    		PreparedStatement stmt = null;
	         
	          
	    		String SAVE = "UPDATE "
						+ "Location_Information SET Admin_User_name=?, Admin_Address=?, "
						+ "Admin_City=?, Admin_Number_staff=?,Admin_ZipCode=?, Admin_Image=? " 
						+ "WHERE  Admin_Location_name=?";
	    	
	    		OracleConnection oracle = new OracleConnection();
	    		
	    		try {
	    			conn = oracle.getConnection();
	    			stmt = conn.prepareStatement(SAVE);   		
	    			stmt.setString(1, location.getAdminUsername());	
	    			stmt.setString(2, location.getAddress());
	    			stmt.setString(3,location.getCity());
	    			stmt.setInt(4, location.getNumberOfStaff());
	    			stmt.setLong(5, location.getZipCode());
	    			stmt.setString(6, location.getImage());
	    			stmt.setString(7, location.getLocationName());
	    		
	    			stmt.executeUpdate();
	    			stmt.close();
	    	
	    	
	    			
	    		} catch (ClassNotFoundException | IOException | SQLException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
	    		}
	      
	      public List<Location> getLocations(String LocationListname) throws ClassNotFoundException, IOException, SQLException
	    	{
	      	  Connection conn = null;
	    		PreparedStatement stmt = null;
	    		ResultSet resultSet = null;
	    		Location location = null;
	    		List<Location> locationList;
	    		OracleConnection oracle = new OracleConnection();
	    		try
	    		{
	    			conn = oracle.getConnection();
	    			stmt = conn.prepareStatement("SELECT * FROM Location_Information WHERE LocationList= ?");
	    			stmt.setString(1, LocationListname);
	    			resultSet = stmt.executeQuery(); 			
	    			
	    			locationList = new ArrayList<Location>();
	    			while(resultSet.next()){
	    				location = new Location();
	    				location.setAdminUsername(resultSet.getString(2));
	    			    location.setLocationName(resultSet.getString(3)); 
	    			    location.setAddress(resultSet.getString(4));
	    				location.setCity(resultSet.getString(5));
	    				location.setNumberOfStaff(resultSet.getInt(6));
	    				location.setZipCode(resultSet.getLong(7));
	    				location.setImage(resultSet.getString(8));
	    				locationList.add(location);
	    				
	    			}
	    			
	    			stmt.close();
	    		}
	    	
	    		finally
	    		{
	    			try
	    			{
	    				resultSet.close();
	    				stmt.close();
	    				conn.close();
	    			}
	    			catch (SQLException e)
	    			{
	    			}
	    		}
	    		return locationList;
	    	}
	      
	      
	      public Location getLocationByLocationname(String Locationname) throws ClassNotFoundException, IOException, SQLException
	    	{
	      	  Connection conn = null;
	    		PreparedStatement stmt = null;
	    		ResultSet resultSet = null;
	    		Location location = null;
	    		
	    		OracleConnection oracle = new OracleConnection();
	    		try
	    		{
	    			conn = oracle.getConnection();
	    			stmt = conn.prepareStatement("SELECT * FROM Location_Information WHERE Admin_Location_Name= ?");
	    			stmt.setString(1, Locationname);
	    			resultSet = stmt.executeQuery(); 			
	    			
	    			
	    			while(resultSet.next()){
	    				location = new Location();
	    				location.setAdminUsername(resultSet.getString(2));
	    			    location.setLocationName(resultSet.getString(3)); 
	    			    location.setAddress(resultSet.getString(4));
	    				location.setCity(resultSet.getString(5));
	    				location.setNumberOfStaff(resultSet.getInt(6));
	    				location.setZipCode(resultSet.getLong(7));
	    				location.setImage(resultSet.getString(8));
	
	    			}
                      	stmt.close();
	    		}
	    	
	    		finally
	    		{
	    			try
	    			{
	    				resultSet.close();
	    				stmt.close();
	    				conn.close();
	    			}
	    			catch (SQLException e)
	    			{
	    			}
	    		}
	    		return location;
	    	}
}
