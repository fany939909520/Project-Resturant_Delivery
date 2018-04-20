<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="Resturant.model.User" %>
<%@ page import="Resturant.dao.UserDao" %>
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
 </div>
  <div style="text-align:center">
     <form action="UserUpdateServlet?action=userUpdate" method="post">
		<table style="border:1px solid blue" align="center">
		<%
        User user = (User)session.getAttribute("user");
		UserDao userdao = new UserDao();
		User newuser=userdao.getUserInformation(user);
        %>
			<tr>
				<td align="center" colspan="2"> <h1>User Update</h1></td>
			</tr>
			<tr>
				<td align="center" style="color:red" colspan="2">
				<% if (request.getAttribute("message") != null) { %>
					<h3><%= request.getAttribute("message") %></h3>
				<%} %>			
				</td>				
			</tr>
			<tr>
				<td>User Name</td>
				<td><input type="text" name="username" value="<%=newuser.getUserName() %>" /></td>
			</tr>
			<tr>
				<td>First Name</td>
				<td><input type="text" name="fName" value="<%=newuser.getFirstName() %>" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lName" value="<%=newuser.getLastName() %>"/></td>
			</tr>
			
			<tr>
				<td>Password</td>
				<td><input type="text" name="password" value="<%=newuser.getPassword() %>"/></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="text" name="re_password" value="<%=newuser.getRe_password() %>"/></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td>
				<%if("Male".equals(newuser.getGender())){%>
					<input type="radio" name="gender" value="Male" checked/>Male 
					<input type="radio" name="gender" value="Female"/>Female
				<%}else if("Female".equals(newuser.getGender())){%>
					<input type="radio" name="gender" value="Male"/>Male 
					<input type="radio" name="gender" value="Female" checked/>Female
				<% } %>
				
			     </td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name="address" value="<%=newuser.getAddress() %>"/></td>
			</tr>
			<tr>
				<td>Phone</td>
				<td><input type="text" name="phone" value="<%=newuser.getPhone() %>" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" value="<%=newuser.getEmail() %>"/></td>
			</tr>
			<tr>
				 <td>   
					<input type="submit" name="Update Info" value="Update Info"/>
				 </td>
			</tr>
	   </table>
	</form>	</div>	
</html>