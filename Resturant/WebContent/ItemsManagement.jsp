<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="Resturant.model.Admin" %>
<%@ page import="Resturant.dao.AdminDao" %>
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
 <a href="MenuItem.jsp">Menu</a>
 <a href="UpdateAdmin.jsp">Administrator InfoUpdate</a>
  <a href="LocationManagement.jsp">Location Management</a>
 </div>
  <div style="text-align:center">
     <form action="ItemsManagementServlet?action=AddItem" method="post" enctype="multipart/form-data ">
		<table style="border:1px solid blue" align="center">
		    <%
             Admin admin = (Admin)session.getAttribute("admin");
		     AdminDao admindao = new AdminDao();
		     Admin newadmin=admindao.getAdminInformation(admin);
		     
             %>
             <tr>
				<td align="center" colspan="2"><h1>Item List</h1></td>	
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
				<td>Item Name</td>
				<td><input type="text" name="itemname"/></td>
		    </tr>
			<tr>
				<td>Price</td>
				<td><input type="text" name="price"/></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><input class="discription" type="text" name="description"/></td>
			</tr>
			<tr>
				<td>Image</td>
				<td><input type="file" name="image"/></td>
		    </tr>
		    <tr>
				<td>Category</td>
				<td><input type="text" name="category"/></td>
			</tr>
			<tr>
				<td>Active</td>
				<td>
				<input type="radio" name="active" value="1"/>1
				<input type="radio" name="active" value="0"/>0
			     </td>
			</tr>
			<tr><td> 
					<input type="submit" name="AddItem" value="Add Item"/>
				 </td>
			</tr>
	   </table>
	</form>	</div>
	
	 <div style="text-align:center">
     <form action="ItemsManagementServlet?action=UpdateItem" method="post" enctype="multipart/form-data ">
		<table style="border:1px solid blue" align="center">
			<tr>
				<td align="center" colspan="2"> <h1>Item List</h1></td>
				
			</tr>
			  <tr>
			<td><input type="hidden" name="adminusername" value="<%=newadmin.getadminUserName() %>" /></td>
		   </tr>
		   <tr>
				<td align="center" style="color:red" colspan="2">
				<% if (request.getAttribute("message2") != null) { %>
					<h3><%= request.getAttribute("message2") %></h3>
				<%} %>			
				</td>				    
             <tr>
			<tr>
				<td>Item Name</td>
				<td><input type="text" name="itemName"/></td>
			</tr>
			<tr>
				<td>Price</td>
				<td><input type="text" name="price"/></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><input type="text" name="description"/></td>
			</tr>
			<tr>
				<td>Image</td>
				<td><input type="file" name="image"/></td>
			</tr>
			<tr>
				<td>Category</td>
				<td><input type="text" name="category"/></td>
			</tr>
			<tr>
				<td>Active</td>
				<td>
				<input type="radio" name="active" value="1"/>1
				<input type="radio" name="active" value="0"/>0
			     </td>
			</tr>
			<tr><td> 
					<input type="submit" name="UpdateItem" value="update Item"/>
				 </td>
			</tr>
	   </table>
	</form>	</div>		
   
</body>
</html>