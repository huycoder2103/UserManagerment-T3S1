<%-- 
    Document   : createUser
    Created on : Feb 27, 2026, 7:34:55 AM
    Author     : ADMIN
--%>

<%@page import="sample.user.UserError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create User Page</title>
    </head>
    <body>
        <%
            UserError userError = (UserError) request.getAttribute("USER_ERROR");
            if(userError == null) userError = new UserError();
            String search = request.getParameter("search");
            if (search == null) search = "";
        %>
        <h1>Input your information</h1>
        <form action="MainController" method="POST">
            UserID:<input type="text" name="userID" required="" value="<%= request.getParameter("userID") == null ? "" : request.getParameter("userID") %>"/><%=userError.getUserID()%>
            </br>Full Name<input type="text" name="fullName" required="" value="<%= request.getParameter("fullName") == null ? "" : request.getParameter("fullName") %>"/><%=userError.getFullname()%>
            </br><select name="roleID">
                <option value="US">US</option>
                <option value="AD">AD</option>
                <option value="ST">ST</option>
            </select>
            </br>Password:<input type="password" name="password" required=""/>
            </br>Confirm<input type="password" name="confirm" required=""/><%=userError.getConfirm()%>
            </br><input type="submit" name="action" value="Create"/>
            <input type="reset" value="Reset"/>            
        </form>
        <%=userError.getError()%>
    </body>
</html>
