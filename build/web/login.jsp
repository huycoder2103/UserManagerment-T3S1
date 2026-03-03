<%-- 
    Document   : login
    Created on : Jan 20, 2026, 8:09:56 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <form action="MainController" method="POST">
            User ID<input type="text" name="userID" required=""/><br>
            Password<input type="password" name="password" required=""/><br>
            <input type="submit" name="action" value="Login"/>
            <input type="reset" value="Reset"/>
        </form>
        <%
          String errorMessage = (String) request.getAttribute("ERROR_MESSAGE");
          if(errorMessage==null) errorMessage="";          
        %>
        <%= errorMessage %>
        
        
    </body>
</html>
