<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Restaurant Delivery</title>
</head>
 <%@page import="java.util.List, java.util.ArrayList, Resturant.model.Item, Resturant.model.Admin, Resturant.dao.ItemsDao,  Resturant.model.Location,  Resturant.dao.LocationDao" %>
<style>

  body{
        background: #aed6f1 ;
       }
  .Item{
          width:600px;
          height:300px;
       }

   
</style>
  
<body>

   <div style="text-align:center">
   <h1 style="color:red">Restaurant Delivery</h1></div>
   <div style="text-align:center">
   <a href="Home.jsp">Home</a>
    <a href="UserLogin.jsp">Login</a>
   <a href="MenuItem.jsp">backToMenu</a></div>
    
   <div style="text-align:center">
   <h1>Order View</h1></div>

  
     <% 
     double sum=0;
	  List<Item> itemList=(List<Item>)session.getAttribute("cart");
      String quantity=(String)session.getAttribute("quantity");
      String username=(String)session.getAttribute("username");

      %>
      
      
    <% for(Item it:itemList){ %>
    <form action="ProcessItemServlet?action=ItemDelete" onclick="return confirm('Are you sure?')" method="post">
       <table>
       <tr> 
         <td><h1><%=it.getItemName() %></h1></td>
          <td><h1>$<%=it.getPrice() %></h1><br/>
            <td><h1><%=quantity %></h1><br/>
             <td><h1><%sum+=it.getPrice(); %></h1><br/>
          <p><%=it.getDescription() %></p><br/>
                <input type="submit" name="delete" value="delete"/>
              </td>
           </tr>
         
           </table></form>
           <%} %>
           <h1>Total:$<%=sum %></h1>
           <form action="MenuLocation.jsp">
                  <input type="hidden" name="user_name" value="<%=username%>"/>
                  <input type="submit" name="Process" value="Process"/>
           </form>    
             
         
</body>
</body>
</html>