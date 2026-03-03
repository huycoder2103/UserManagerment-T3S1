<%-- 
    Document   : shopping
    Created on : Mar 3, 2026, 7:27:00 AM
    Author     : hoadoan
--%>

<%@page import="fa26.t3s2.users.UserDTO"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PiOn Store </title>
    </head>
    <body>
        
        <h1>Welcome to PiOn LUXURY Store</h1>
        <form action="MainController" method="POST">
            <select name="product">
                <option value="P001-DIOR ALU-3000">DIOR ALU-3000$</option>
                <option value="P002-CHANEL SPRING-5000">CHANEL SPRING-5000$</option>
                <option value="P003-GUCCI BUBBLE-1000">GUCCI BUBBLE-1000$</option>
                <option value="P004-LV GOLD LOTUS-500 ">LV GOLD LOTUS-500$</option>
                <option value="P005-YSL 007-10">YSL 007-10$</option>
            </select>
            <input type="submit" name="action" value="Add"/>
            <input type="submit" name="action" value="View"/>
        </form>
        <%
            String message=(String) request.getAttribute("MESSAGE");
            if(message== null) message="";
        %>
        <%= message %>
    </body>
</html>
