<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="java.util.List, java.util.ArrayList, Resturant.model.User, Resturant.model.Location, Resturant.model.Admin, Resturant.dao.LocationDao" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
  body{
        background: #aed6f1 ;
       }
  .Location{
          width:600px;
          height:300px;
       }

   
</style>
  
<body>

   <div style="text-align:center">
   <h1 style="color:red">Restaurant Delivery</h1></div>
   <div style="text-align:center">
   <a href="Home.jsp">Home</a>
   <a href="OrderView.jsp">Order List</a>
    <a href="UserLogin.jsp">Login</a>
    <a href="UserRegistration.jsp">Register?</a></div>
   <div style="text-align:center">
   <h1>Location</h1></div>
   <div style="text-align:right">
   <a href="Payment.jsp">Process Order</a></div>
     <% 
      
      //User user = (User)session.getAttribute("user");
      LocationDao itDAO = new LocationDao();
	  List<Location> itList = itDAO.getLocations("ee");
      String username=request.getParameter("user_name");

      %>
    <% for(Location it:itList){ %>
    <form action="ProcessLocationServlet?action=Location" method="post">
       <table>
       <tr> 
         <td> <img class="Location" src="<%=it.getImage()%>" ></td>
         <td><h1><%=it.getLocationName() %></h1></td>
          <td><h1><%=it.getAddress()%>, <%=it.getCity() %>,<%=it.getZipCode() %></h1><br/>
                <input type="hidden" name="admin_name" value="<%=it.getAdminUsername() %>"/>
                <input type="hidden" name="Location_name" value="<%=it.getLocationName()%>"/>
                 <input type="hidden" name="username" value="<%=username%>"/>
                <input type="submit"  name="Add to Location"
                 value="add to Location"/>
              </td>
           </tr>
           </table></form>
           <%} %>
       
           
</body>
</html>