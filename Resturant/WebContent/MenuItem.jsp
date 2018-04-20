<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="java.util.List, java.util.ArrayList, Resturant.model.User, Resturant.model.Item, Resturant.model.Admin, Resturant.dao.ItemsDao" %>
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
  .item{
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
   <h1>Menu Item</h1></div>
   <div style="text-align:right">
   <a href="MenuLocation.jsp">Process Order</a></div>
     <% 
      
      String username = (String)session.getAttribute("username");
     
      ItemsDao itDAO = new ItemsDao();
	  List<Item> itList = itDAO.getUserDisplayItems("Best_Food");
	 

      %>
    <% for(Item it:itList){ %>
    <form action="ProcessItemServlet?action=Item" method="post">
       <table>
       <tr> 
         <td> <img class="item" src="<%=it.getImage()%>" ></td>
         <td><h1><%=it.getItemName() %></h1></td>
          <td><h1>$<%=it.getPrice() %></h1><br/>
          <p><%=it.getDescription() %></p><br/>
                <input type="hidden" name="admin_name" value="<%=it.getAdminUserName()%>"/>
                 <input type="hidden" name="user_name" value="<%=username%>"/>
                <input type="hidden" name="item_name" value="<%=it.getItemName()%>"/>
                <input type="submit"  name="Add to Order"
                 value="add to order"/>
              </td>
           </tr>
           </table></form>
           <%} %>
         
       
           
</body>
</html>