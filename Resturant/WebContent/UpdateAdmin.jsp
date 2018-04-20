<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="Resturant.model.Admin" %>
<%@ page import="Resturant.dao.AdminDao" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<<style>
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
     <form action="AdminUpdateServlet?action=adminUpdate" method="post">
		<table style="border:1px solid blue" align="center">
		<%
        Admin admin = (Admin)session.getAttribute("admin");
		AdminDao admindao = new AdminDao();
		Admin newadmin=admindao.getAdminInformation(admin);
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
				<td><input type="text" name="username" value="<%=newadmin.getadminUserName() %>" /></td>
			</tr>
			<tr>
				<td>First Name</td>
				<td><input type="text" name="fName" value="<%=newadmin.getFirstName() %>" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lName" value="<%=newadmin.getLastName() %>"/></td>
			</tr>
			
			<tr>
				<td>Password</td>
				<td><input type="text" name="password" value="<%=newadmin.getPassword() %>"/></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="text" name="re_password" value="<%=newadmin.getRe_password() %>"/></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td>
				<%if("Male".equals(newadmin.getGender())){%>
					<input type="radio" name="gender" value="Male" checked/>Male 
					<input type="radio" name="gender" value="Female"/>Female
				<%}else if("Female".equals(newadmin.getGender())){%>
					<input type="radio" name="gender" value="Male"/>Male 
					<input type="radio" name="gender" value="Female" checked/>Female
				<% } %>
				
			     </td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name="address" value="<%=newadmin.getAddress() %>"/></td>
			</tr>
			<tr>
				<td>Phone</td>
				<td><input type="text" name="phone" value="<%=newadmin.getPhone() %>" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" value="<%=newadmin.getEmail() %>"/></td>
			</tr>
			<tr>
				 <td>   
					<input type="submit" name="Update Info" value="Update Info"/>
				 </td>
			</tr>
	   </table>
	</form>	</div>	
</html>