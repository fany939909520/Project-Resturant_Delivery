<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
 <a href="Menu.jsp"> Menu</a>
 <a href="UserLogin.jsp">User Login</a>
 </div>
  <div style="text-align:center">
     <form action="UserRegistrationServlet?action=userRegister" method="post">
		<table style="border:1px solid blue" align="center">
			<tr>
				<td align="center" colspan="2"> <h1>User Register</h1></td>
				
			</tr>
			<tr>
				<td align="center" style="color:red" colspan="2">
				<% if (request.getAttribute("message") != null) { %>
					<h3><%= request.getAttribute("message") %></h3>
				<%} %>			
				</td>				
			</tr>
			<tr>
				<td>First Name</td>
				<td><input type="text" name="fName"/></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lName"/></td>
			</tr>
			<tr>
				<td>User Name</td>
				<td><input type="text" name="username"/></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"/></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="re_password"/></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td>
				<input type="radio" name="gender" value="Male"/>Male 
				<input type="radio" name="gender" value="Female"/>Female
			     </td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name="address"/></td>
			</tr>
			<tr>
				<td>Phone</td>
				<td><input type="text" name="phone"/></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email"/></td>
			</tr>
			<tr>
				<td colspan="1">	
				   	<a  href="AdminRegistration.jsp">Administrator?</a>
				 </td>
				 <td>   
					<input type="submit" name="Login" value="Login"/>
				 </td>
			</tr>
	   </table>
	</form>	</div>	
</body>
</html>