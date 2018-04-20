package Resturant.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Resturant.model.Admin;
import Resturant.model.User;


public class AdminDao {
	public void saveAdmin_Information(Admin admin) {
		Connection conn = null;
		PreparedStatement stmt = null;

		String SAVE = "INSERT INTO "
				+ "Admin_Information( Admin_User_name, AdminFirst_name, AdminLast_name, Admin_Pass_word, Admin_Re_Enter_Password, Admin_gender, Admin_Address, Admin_Phone, Admin_Email) " 
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
		OracleConnection oracle = new OracleConnection();
		
		try {
			conn = oracle.getConnection();
			stmt = conn.prepareStatement(SAVE);
			
			stmt.setString(1, admin.getadminUserName());
			stmt.setString(2, admin.getFirstName());
			stmt.setString(3, admin.getLastName());
			stmt.setString(4, admin.getPassword());
			stmt.setString(5, admin.getRe_password());
			stmt.setString(6, admin.getGender());
			stmt.setString(7, admin.getAddress());
			stmt.setLong(8, admin.getPhone());
			stmt.setString(9, admin.getEmail());
		
			stmt.executeUpdate();
			stmt.close();
			System.out.println("Success");
	
			
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		
		public Admin getAdminValidate(String username, String password) {
			Admin admin=new Admin();
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet result = null;
			String SEARCH = "SELECT * FROM Admin_Information "
					+ "WHERE Admin_User_name = ? and Admin_Pass_word = ?";
			OracleConnection oracle = new OracleConnection();
			try {
				conn = oracle.getConnection();
				stmt = conn.prepareStatement(SEARCH);
				stmt.setString(1, username);
				stmt.setString(2, password);
				result = stmt.executeQuery();
				while(result.next()) {
					
					admin.setadminUserName(result.getString(1));
					admin.setPassword(result.getString(4));
				}
				
			} catch (ClassNotFoundException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			return admin;
		}
		
		public Admin getAdminInformation(Admin admin) {

			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet result = null;
			String SEARCH = "SELECT * FROM Admin_Information "
					+ "WHERE Admin_User_name = ?";
			OracleConnection oracle = new OracleConnection();
			try {
				conn = oracle.getConnection();
				stmt = conn.prepareStatement(SEARCH);
				stmt.setString(1, admin.getadminUserName());
				result = stmt.executeQuery();
				while(result.next()) {
					
					admin.setadminUserName(result.getString(1));
					admin.setFirstName(result.getString(2));
					admin.setLastName(result.getString(3));
					admin.setPassword(result.getString(4));
					admin.setRe_password(result.getString(5));
					admin.setGender(result.getString(6));
					admin.setAddress(result.getString(7));
					admin.setPhone(result.getLong(8));
					admin.setEmail(result.getString(9));
				}
				
			} catch (ClassNotFoundException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			return admin;
		} 
		
		public void saveAdminUpdateInformation(Admin admin) {
			Connection conn = null;
			PreparedStatement stmt = null;

			String SAVE = "UPDATE "
					+ "Admin_Information SET AdminFirst_Name=? , AdminLast_Name=?, Admin_Pass_Word=?, Admin_Re_Enter_Password=?,"
					+ " Admin_Gender=?, Admin_Address=?, Admin_Phone=?, Admin_Email=? " 
					+ "WHERE Admin_User_name = ?";
		
			OracleConnection oracle = new OracleConnection();
			
			try {
				conn = oracle.getConnection();
				stmt = conn.prepareStatement(SAVE);
				
				stmt.setString(1, admin.getFirstName());
				stmt.setString(2, admin.getLastName());
				stmt.setString(3, admin.getPassword());
				stmt.setString(4, admin.getRe_password());
				stmt.setString(5, admin.getGender());
				stmt.setString(6, admin.getAddress());
				stmt.setLong(7, admin.getPhone());
				stmt.setString(8, admin.getEmail());
				stmt.setString(9, admin.getadminUserName());
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
}
