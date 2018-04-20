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
    <a href="AdminLogin.jsp">Admin Login</a>
   </div>
   <div style="text-align:center">
   <form action="UserLoginServlet?action1=userLogin" method="post">
		<table style="border:3px solid blue" align="center">
			<tr>
				<th align="center" colspan="3">User Login</th>				
			</tr>
			<tr><td align="center" style="color:red" colspan="2">
				<% if (request.getAttribute("message") != null) { %>
					<h3><%= request.getAttribute("message") %></h3>
				<%} %>			
				</td>	</tr>
			<tr>
				<td>User Name</td>
				<td><input type="text" name="username"/></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"/></td>
			</tr>
			<tr>
				<td colspan="2">
				    <a href="UserRegistration.jsp">Register?</a>
					<input type="submit" name="Login" value="Login"/>
				</td>
			</tr>
	   </table>
	</form></div>		
</body>
</html>