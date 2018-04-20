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
 <h1>Restaurant Delivery</h1></div>
 <div style="text-align:center">
 <a href="Home.jsp">Home</a>
 <a href="Menu.jsp"> Menu</a>
 <a href="Login.jsp">Login</a>
 <a href="UserRegistration.jsp">Register?</a></div>
<% String username=(String)request.getParameter("username"); %>
 <form action="PaymentProcessServlet?action=payment" method="post">
		<table style="border:3px solid blue" align="center">
			<tr>
				<td align="center" colspan="2"> <h1>Payment Information</h1></td>				
			</tr>
			<tr>
				<td align="center" style="color:red" colspan="2">All fields are mandatory*</td>				
			</tr>
			<tr>
				<td>Credit Card</td>
				<td><input type="text" name="CreaditCard"/></td>
			</tr>
			<tr>
				<td>Secure Number</td>
				<td><input type="text" name="SecureNumber"/></td>
			</tr>
			<tr>
				<td>ZipCode</td>
				<td><input type="text" name="ZipCode"/></td>
			</tr>
			<tr>
			<tr>
				
				<td><input type="hidden" name="user_name" value=<%=username %>/></td>
			</tr>
			 <td><div style="text-align:center"><input type="submit" name="submit" value="process"/></div></td>
			</tr>									
		</table>
		
		</form>	
</body>
</html>