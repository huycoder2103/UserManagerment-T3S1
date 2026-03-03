<%-- 
    Document   : user
    Created on : Jan 23, 2026, 8:13:10 AM
    Author     : ADMIN
--%>

<%@page import="sample.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>USER Page</title>
    </head>
    <body>
        <%
//            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
//            if(loginUser==null || !"US".equals(loginUser.getRoleID())){
//                response.sendRedirect("login.jsp");
//                return;
//            }                
        %>
        User ID:<%= loginUser.getUserID() %><br>
        Full Name:<%= loginUser.getFullname()%><br>
        Role ID:<%= loginUser.getRoleID()%><br>
        Password:<%= loginUser.getPassword()%>
        <form action="POST">
            <a href="MainController?action=Logout">Logout</a>
        </form>  
        <a href="shopping.jsp">PiOn Luxury Store</a>
    </body>
</html>
