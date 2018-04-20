<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Resturant.model.Admin" %>
<%@ page import="Resturant.dao.AdminDao" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Restaurant Delivery</title>
</head>
<style>
    body{
        background: #aed6f1 ;
     }
</style>

<body>
  <div style="text-align:center">
   <h1 style="color:red">Restaurant Delivery</h1></div>
 <div style="text-align:center">
 <a href="Home.jsp">Home</a>
 <a href="MenuItem.jsp"> Menu</a>
 <a href="ItemsManagement.jsp">Item Management</a>
 </div>
  <div style="text-align:center">
     <form action="LocationManagementServlet?action=addLocation" method="post" enctype="multipart/form-data ">
		<table style="border:1px solid blue" align="center">
		 <%
             Admin admin = (Admin)session.getAttribute("admin");
		     AdminDao admindao = new AdminDao();
		     Admin newadmin=admindao.getAdminInformation(admin);
		     
             %>
			<tr>
				<td align="center" colspan="2"> <h1>Location List</h1></td>
				
			</tr>
			<tr>
				<td align="center" style="color:red" colspan="2">
				<% if (request.getAttribute("message1") != null) { %>
					<h3><%= request.getAttribute("message1") %></h3>
				<%} %>			
				</td>				    
             <tr>
			<td><input type="hidden" name="adminusername" value="<%=newadmin.getadminUserName() %>" /></td>
		   </tr>
			<tr>
				<td>Location</td>
				<td><input type="text" name="location"/></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name="address"/></td>
			</tr>
			<tr>
				<td>City</td>
				<td><input type="text" name="city"/></td>
			</tr>
			<tr>
				<td>Staff</td>
				<td><input type="text" name="staff"/></td>
			</tr>
			<tr>
				<td>ZipCode</td>
				<td><input type="text" name="zipcode"/></td>
			</tr>
             <tr>
                 <td>Image</td>
                 <td><input type="file" name="image"/> 
                 </td>
             </tr>
			<tr><td> 
					<input type="submit" name="AddLocation" value="Add Location"/>
				 </td>
			</tr>
	   </table>
	</form>	</div>
	
	  <div style="text-align:center">
     <form action="LocationManagementServlet?action=updateLocation" method="post" enctype="multipart/form-data ">
		<table style="border:1px solid blue" align="center">
		
			<tr>
				<td align="center" colspan="2"> <h1>Location List</h1></td>
				
			</tr>
				<tr>
				<td align="center" style="color:red" colspan="2">
				<% if (request.getAttribute("message2") != null) { %>
					<h3><%= request.getAttribute("message2") %></h3>
				<%} %>			
				</td>				    
             <tr>
			  <tr>
			<td><input type="hidden" name="adminusername" value="<%=newadmin.getadminUserName() %>" /></td>
		   </tr>
			<tr>
				<td>Location</td>
				<td><input type="text" name="locationname"/></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name="address"/></td>
			</tr>
			<tr>
				<td>City</td>
				<td><input type="text" name="city"/></td>
			</tr>
			<tr>
				<td>Staff</td>
				<td><input type="text" name="staff"/></td>
			</tr>
			<tr>
				<td>ZipCode</td>
				<td><input type="text" name="zipcode"/></td>
			</tr>
             <tr>
                 <td>Image</td>
                 <td><input type="file" name="image"/> 
                 </td>
             </tr>
			<tr><td> 
					<input type="submit" name="updateLocation" value="Update Location"/>
				 </td>
			</tr>
	   </table>
	</form>	</div>
   
</body>
</html>