<%-- 
    Document   : shopping.jsp
    Created on : Mar 3, 2026, 7:27:26 AM
    Author     : jayke
--%>

<%@page import="sample.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         
        <h1>Wellcome to PiOn Luxury Store</h1>
        <<form action="MainController" method="POST">
            <slect name="product">
        <option value="P001-DIOR ALU-3000">DIOR ALU-3000$</option>
        <option value="P002-CHANEL SPRING-500">CHANEL SPRING-500$</option>
        <option value="P003-GUCCI PURPLE-1000">GUCCI PURPLE-1000$</option><!-- comment -->
        <option value="P004-LV GOLD LOTUS-500">LV GOLD LOTUS-500$</option>
        <option value="P005-YSL 007-100">YSL 007-100$</option>
    </slect>
    
            <input type="submit" name="action" value="Add"/>
        </form>
    </body>
    <% 
        String message=(String)request.getAttribute("MESSAGE");
        if(message==null)message="";

    %>
    <%= message %>
</html>
