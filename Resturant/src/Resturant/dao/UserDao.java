package Resturant.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Resturant.model.User;


public class UserDao {
	public void saveUser_Information(User user) {
		Connection conn = null;
		PreparedStatement stmt = null;

		String SAVE = "INSERT INTO "
				+ "User_Information( User_Name, FirstName, LastName, Pass_Word, Re_Enter_Password, Gender, Address, Phone, Email) " 
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
		OracleConnection oracle = new OracleConnection();
		
		try {
			conn = oracle.getConnection();
			stmt = conn.prepareStatement(SAVE);
			
			stmt.setString(1, user.getUserName());
			stmt.setString(2, user.getFirstName());
			stmt.setString(3, user.getLastName());
			stmt.setString(4, user.getPassword());
			stmt.setString(5, user.getRe_password());
			stmt.setString(6, user.getGender());
			stmt.setString(7, user.getAddress());
			stmt.setLong(8, user.getPhone());
			stmt.setString(9, user.getEmail());
		
			stmt.executeUpdate();
			stmt.close();
	
			
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			try
			{
				stmt.close();
				conn.close();
			}
			catch (SQLException e)
			{
				
			}
		}
		
	}
	
	public User getUserValidate(String username, String password) {
		User user = new User();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		String SEARCH = "SELECT * FROM user_information "
				+ "WHERE user_name = ? and pass_word = ?";
		OracleConnection oracle = new OracleConnection();
		try {
			conn = oracle.getConnection();
			stmt = conn.prepareStatement(SEARCH);
			stmt.setString(1, username);
			stmt.setString(2, password);
			result = stmt.executeQuery();
			while(result.next()) {
				
				user.setUserName(result.getString(1));
				user.setPassword(result.getString(4));
			}
			
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return user;
	} 
	
	public User getUserInformation(User user) {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		String SEARCH = "SELECT * FROM user_information "
				+ "WHERE user_name = ?";
		OracleConnection oracle = new OracleConnection();
		try {
			conn = oracle.getConnection();
			stmt = conn.prepareStatement(SEARCH);
			stmt.setString(1, user.getUserName());
			result = stmt.executeQuery();
			while(result.next()) {
				
				user.setUserName(result.getString(1));
				user.setFirstName(result.getString(2));
				user.setLastName(result.getString(3));
				user.setPassword(result.getString(4));
				user.setRe_password(result.getString(5));
				user.setGender(result.getString(6));
				user.setAddress(result.getString(7));
				user.setPhone(result.getLong(8));
				user.setEmail(result.getString(9));
			}
			
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return user;
	} 
	
	public void saveUserUpdateInformation(User user) {
		Connection conn = null;
		PreparedStatement stmt = null;

		String SAVE = "UPDATE "
				+ "User_Information SET FirstName=? , LastName=?, Pass_Word=?, Re_Enter_Password=?, Gender=?, Address=?, Phone=?, Email=? " 
				+ "WHERE User_name = ?";
	
		OracleConnection oracle = new OracleConnection();
		
		try {
			conn = oracle.getConnection();
			stmt = conn.prepareStatement(SAVE);
			
			stmt.setString(1, user.getFirstName());
			stmt.setString(2, user.getLastName());
			stmt.setString(3, user.getPassword());
			stmt.setString(4, user.getRe_password());
			stmt.setString(5, user.getGender());
			stmt.setString(6, user.getAddress());
			stmt.setLong(7, user.getPhone());
			stmt.setString(8, user.getEmail());
			stmt.setString(9, user.getUserName());
			stmt.executeUpdate();
			stmt.close();
	        System.out.println("Success");
			
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			try
			{
				stmt.close();
				conn.close();
			}
			catch (SQLException e)
			{
				
			}
		}
		
	}
	
	public User getUserInformationByName(String username) {
		User user = new User();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		String SEARCH = "SELECT * FROM user_information "
				+ "WHERE user_name = ? ";
		OracleConnection oracle = new OracleConnection();
		try {
			conn = oracle.getConnection();
			stmt = conn.prepareStatement(SEARCH);
			stmt.setString(1, username);
			result = stmt.executeQuery();
			while(result.next()) {
				
				user.setFirstName(result.getString(2));
				user.setLastName(result.getString(3));
				user.setPassword(result.getString(4));
				user.setRe_password(result.getString(5));
				user.setGender(result.getString(6));
				user.setAddress(result.getString(7));
				user.setPhone(result.getLong(8));
				user.setEmail(result.getString(9));
			}
			
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return user;
	} 
	
	
}
