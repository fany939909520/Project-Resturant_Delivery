package Resturant.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import Resturant.model.Order;

public class OrderDao {
    public void saveUserOrderLocation(Order order) {
    	Connection conn = null;
  		PreparedStatement stmt = null;

  		String SAVE = "INSERT INTO "
  				+ "Order_Information(Admin_User_name, User_name, Item_name, Item_Price, Item_Image,"
  				+ "Item_Quantity, Location_name, Address, City, Zipcode) " 
  				+ "VALUES(?,?,?,?,?,?, ?,?,?,?)";
  	 
  		OracleConnection oracle = new OracleConnection();

  		try {
  			conn = oracle.getConnection();
  			stmt = conn.prepareStatement(SAVE);
  			stmt.setString(1, order.getAdmin_User_name());
  			stmt.setString(2, order.getUser_name());
  			stmt.setString(3, "null");
  			stmt.setDouble(4, 1);
  			stmt.setString(5, "null");
  			stmt.setInt(6, 1);
  			stmt.setString(7, order.getLocation_name());
  			stmt.setString(8, order.getAddress());
  			stmt.setString(9, order.getCity());
  			stmt.setLong(10, order.getAddresszipcode());
         	  		
  			stmt.executeUpdate();
  			stmt.close();
  		} catch (ClassNotFoundException | IOException | SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
  		}
      
    public void saveUserOrderItem(Order order) {
    	Connection conn = null;
  		PreparedStatement stmt = null;

  		String SAVE = "INSERT INTO "
  				+ "Order_Information(Admin_User_name, User_name, Item_name, Item_Price, Item_Image,"
  				+ "Item_Quantity, Location_name, Address, City, Zipcode) " 
  				+ "VALUES(?,?,?,?,?,?, ?,?,?,?)";
  	 
  		OracleConnection oracle = new OracleConnection();

  		try {
  			conn = oracle.getConnection();
  			stmt = conn.prepareStatement(SAVE);
  			stmt.setString(1, "null");
  			stmt.setString(2, "null");
  			stmt.setString(3, "null");
  			stmt.setDouble(4, 1);
  			stmt.setString(5, "null");
  			stmt.setInt(6, 1);
  			stmt.setString(7, order.getLocation_name());
  			stmt.setString(8, order.getAddress());
  			stmt.setString(9, order.getCity());
  			stmt.setLong(10, order.getAddresszipcode());
         	  		
  			stmt.executeUpdate();
  			stmt.close();
  		} catch (ClassNotFoundException | IOException | SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
  		}
      

    
    public void saveUserPaymentInformation() {
    	Connection conn = null;
  		PreparedStatement stmt = null;

  		String SAVE = "INSERT INTO "
  				+ "PaymentCredit(user_name, Credit_Card_Number,"
  				+ "Secure_code, ZipCode) " 
  				+ "VALUES(?, ?, ?, ?)";
  	    Order order = new Order();
  		OracleConnection oracle = new OracleConnection();

  		try {
  			conn = oracle.getConnection();
  			stmt = conn.prepareStatement(SAVE);

  			stmt.setString(1, order.getUser_name());
  			stmt.setInt(2, order.getCredit_Card_Number());
  			stmt.setInt(3, order.getSecure_code());
  			stmt.setLong(4, order.getAddresszipcode());
  			
         	  		
  			stmt.executeUpdate();
  			stmt.close();
  		
  	
  			
  		} catch (ClassNotFoundException | IOException | SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
  		}
    	
    public Order getUserOrderInformation(String username) throws SQLException, ClassNotFoundException, IOException {
    	Connection conn = null;
  		PreparedStatement stmt = null;
  		ResultSet resultSet = null;
  		String SAVE = "SELECT * FROM Order_Information WHERE"
  				+ "User_name = ?";
  	 
  		OracleConnection oracle = new OracleConnection();
        Order order = null;
  		try {
  			conn = oracle.getConnection();
  			stmt = conn.prepareStatement(SAVE);
  			stmt.setString(1, username);
			resultSet = stmt.executeQuery(); 			
			
			
			while(resultSet.next()){
				order=new Order();
				order.setAdmin_User_name(resultSet.getString(1));
				order.setItemname(resultSet.getString(3));
				order.setItem_price(resultSet.getDouble(4));
				order.setItem_image(resultSet.getString(5));
				order.setItem_quantity(resultSet.getInt(6));
				order.setLocation_name(resultSet.getString(7));
				order.setAddress(resultSet.getString(8));
				order.setCity(resultSet.getString(9));
				order.setAddresszipcode(resultSet.getLong(10));

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
		return order;
	}
}
