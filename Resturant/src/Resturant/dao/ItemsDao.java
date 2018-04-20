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


public class ItemsDao {
	 
      public void saveItems(Item item) {
    	Connection conn = null;
  		PreparedStatement stmt = null;
  		String SAVE = "INSERT INTO "
  				+ "Item_Information( Admin_User_name, Item_name, Item_Price, Item_Image, Item_Description, Item_Active, Item_Category, Item_Quantity, shop) " 
  				+ "VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
  	
  		OracleConnection oracle = new OracleConnection();
  		
  		try {
  			conn = oracle.getConnection();
  			stmt = conn.prepareStatement(SAVE);
  		
  			stmt.setString(1, item.getAdminUserName());
  			stmt.setString(2, item.getItemName());
  			stmt.setBigDecimal(3, new BigDecimal(item.getPrice()));
  			stmt.setString(4, item.getImage());
  			stmt.setString(5, item.getDescription());
  			stmt.setInt(6, item.isAcitve());
  			stmt.setString(7, item.getCategory());
  			stmt.setInt(8, item.getQuantity());
  			stmt.setString(9, item.getShop());
  		
  			stmt.executeUpdate();
  			stmt.close();
  	
  	
  			
  		} catch (ClassNotFoundException | IOException | SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
  		}
      
      public void UpdateItems(Item item) {
      	Connection conn = null;
    		PreparedStatement stmt = null;
         
          
    		String SAVE = "UPDATE "
					+ "Item_Information SET Admin_User_name=?, Item_Price=?, Item_Image=?, "
					+ "Item_Description=?, Item_Active=?, Item_Category=?, Item_Quantity=?, Shop=? " 
					+ "WHERE Item_name = ?";
    	
    		OracleConnection oracle = new OracleConnection();
    		
    		try {
    			conn = oracle.getConnection();
    			stmt = conn.prepareStatement(SAVE);   		
    			stmt.setString(1, item.getAdminUserName());
    			stmt.setBigDecimal(2, new BigDecimal(item.getPrice()));
    			stmt.setString(3, item.getImage());
    			stmt.setString(4, item.getDescription());
    			stmt.setInt(5, item.isAcitve());
    			stmt.setString(6, item.getCategory());
    			stmt.setInt(7, item.getQuantity());
    			stmt.setString(8, item.getShop());
    			stmt.setString(9, item.getItemName());
    			stmt.executeUpdate();
    			stmt.close();
    	
    	
    			
    		} catch (ClassNotFoundException | IOException | SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		}
      public Item getItem(String itemname) throws ClassNotFoundException, IOException, SQLException
    	{
      	    Connection conn = null;
    		PreparedStatement stmt = null;
    		ResultSet resultSet = null;
    		Item item = new Item();
    
    		OracleConnection oracle = new OracleConnection();
    		try
    		{
    			conn = oracle.getConnection();
    			stmt = conn.prepareStatement("SELECT * FROM Item_Information WHERE Item_name = ?");
    			stmt.setString(1, itemname);
    			resultSet = stmt.executeQuery(); 			
    			

    			while(resultSet.next()){
    				item.setItemName(resultSet.getString(2));
    				item.setPrice(resultSet.getDouble(3));
    				item.setImage(resultSet.getString(4));
    				item.setDescription(resultSet.getString(5));
    				item.setAcitve(resultSet.getInt(6));
    				item.setCategory(resultSet.getString(7));
    				item.setQuantity(resultSet.getInt(8));	
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
    		return item;
    	}
      
      public void updatedQuantity( String itemname, int quantity) throws ClassNotFoundException, IOException, SQLException {
    	  Connection conn = null;
  		PreparedStatement stmt = null;
  		ResultSet resultSet = null;
  		Item item = new Item();
  
  		OracleConnection oracle = new OracleConnection();
  		try
  		{
  			conn = oracle.getConnection();
  			stmt = conn.prepareStatement("UPDATE Item_Information SET Item_Quantity = ?"
  					+ "WHERE Item_name = ?");
  			item.setQuantity(quantity);
  			
  	
  			resultSet = stmt.executeQuery(); 			
  		
  			while(resultSet.next()){
  				stmt.setInt(1, item.getQuantity());
    			stmt.setString(2, itemname);
  			
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

  	}
    
      
      public List<Item> getAdminDisplayItems(String adminusername) throws ClassNotFoundException, IOException, SQLException
    	{
      	  Connection conn = null;
    		PreparedStatement stmt = null;
    		ResultSet resultSet = null;
    		Item item = null;
    		List<Item> ItemList;
    		OracleConnection oracle = new OracleConnection();
    		try
    		{
    			conn = oracle.getConnection();
    			stmt = conn.prepareStatement("SELECT * FROM Item_Information WHERE Admin_User_name = ?");
    			stmt.setString(1, adminusername);
    			resultSet = stmt.executeQuery(); 			
    			
    			ItemList = new ArrayList<Item>();
    			while(resultSet.next()){
    				item = new Item();
    			    item.setItemName(resultSet.getString(2));
    				item.setPrice(resultSet.getDouble(3));
    				item.setImage(resultSet.getString(4));
    				item.setDescription(resultSet.getString(5));
    				item.setAcitve(resultSet.getInt(6));
    				item.setCategory(resultSet.getString(7));
    				ItemList.add(item);
    				
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
    		return ItemList;
    	}
      public List<Item> getUserDisplayItems(String shop) throws ClassNotFoundException, IOException, SQLException
  	{
    	  Connection conn = null;
  		PreparedStatement stmt = null;
  		ResultSet resultSet = null;
  		Item item = null;
  		List<Item> ItemList;
  		OracleConnection oracle = new OracleConnection();
  		try
  		{
  			conn = oracle.getConnection();
  			stmt = conn.prepareStatement("SELECT * FROM Item_Information WHERE Shop = ?");
  			stmt.setString(1, shop);
  			resultSet = stmt.executeQuery(); 			
  			
  			ItemList = new ArrayList<Item>();
  			while(resultSet.next()){
  				item = new Item();
  			    item.setItemName(resultSet.getString(2));
  				item.setPrice(resultSet.getDouble(3));
  				item.setImage(resultSet.getString(4));
  				item.setDescription(resultSet.getString(5));
  				item.setAcitve(resultSet.getInt(6));
  				item.setCategory(resultSet.getString(7));
  				ItemList.add(item);
  				
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
  		return ItemList;
  	}
}
