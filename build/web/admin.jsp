<%-- 
    Document   : user
    Created on : Jan 23, 2026, 8:18:39 AM
    Author     : admin
--%>


<%@page import="java.util.List"%>
<%@page import="sample.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrator Page</title>
    </head>
    <body>
        <%
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            if (loginUser == null || !"AD".equals(loginUser.getRoleID())) {
                response.sendRedirect("login.jsp");
                return;
            }
            String search = request.getParameter("search");
            if (search == null) {
                search = "";
            }
        %>
        <h1>Welcome:<%= loginUser.getFullname()%></h1>
        <a href="MainController?action=Logout">Logout</a>
        
        <form action="createUser.jsp" method="POST">
            <input type="submit" value="Create User"/>
        </form>
        
        <form action="MainController">
            Search: <input type="text" name="search" required="" value="<%= search %>" />
            <input type="submit" name="action" value="Search"/>
        </form>

        <%
            List<UserDTO> listUser = (List<UserDTO>) request.getAttribute(
                    "LIST_USER");
            if (listUser != null && !listUser.isEmpty()) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>User ID</th>
                    <th>Full Name</th>
                    <th>Role ID</th>
                    <th>Password</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    for (UserDTO user : listUser) {
                %>
            <form action="MainController" method="POST">                
                <tr>
                    <td><%= count++%></td>
                    <td>
                        <input type="text" name="userID" value="<%= user.getUserID()%>" readonly="">
                    </td>                    
                    <td>
                        <input type="text" name="fullName" value="<%= user.getFullname()%>" required="">
                    </td>
                    <td>
                        <input type="text" name="roleID" value="<%= user.getRoleID()%>" required="">
                    </td>
                    <td><%= user.getPassword()%></td> 
                    <td>
                        <input type="submit" name="action" value="Update"/>
                        <input type="hidden" name="search" value="<%= search %>"/>                        
                    </td>
                    <td>
                        <a href="MainController?action=Delete&userID=<%= user.getUserID() %>&search=<%= search %>">Delete</a>
                    </td>
                </tr>
            </form>
                <%
                    }
                %>
            </tbody>
        </table>
        <%
        } else {
            // 3. Xử lý hiển thị thông báo lỗi
            String errorMessage = (String) request.getAttribute("ERROR_MESSAGE");
            if (errorMessage != null) {
        %>
        <%= errorMessage%>
        <%
                }
            }
        %>

    </body>
</html>