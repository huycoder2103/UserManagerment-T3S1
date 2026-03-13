<%-- 
    Document   : admin
    Created on : Jan 22, 2026, 10:46:08 AM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.lang.String"%>
<%@page import="fa26.t3s2.users.UserDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
        <c:if test="${sessionScope.LOGIN_USER == null || sessionScope.LOGIN_USER.roleID ne 'AD'}">
            <c:redirect url="login.jsp" />
        </c:if>

        <h1>Welcome: ${sessionScope.LOGIN_USER.fullName}</h1>
        
        <c:url var="logoutLink" value="MainController">
            <c:param name="action" value="Logout" />
        </c:url>
        <a href="${logoutLink}">Logout</a>

        <form action="MainController">
            FullName: <input type="text" name="search" value="${param.search}" required="">
            <input type="submit" name="action" value="Search">
        </form>

        <%-- 3. Hiển thị bảng danh sách User --%>
        <c:if test="${requestScope.LIST_USER != null}">
            <c:choose>
                <c:when test="${not empty requestScope.LIST_USER}">
                    <table border="1">
                        <thead>
                            <tr>
                                <th>No</th>
                                <th>UserID</th>
                                <th>FullName</th>
                                <th>RoleID</th>
                                <th>Password</th>
                                <th>Update</th>
                                <th>Delete</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="user" items="${requestScope.LIST_USER}" varStatus="counter">
                                <form action="MainController" method="POST">
                                    <tr>
                                        <td>${counter.count}</td>
                                        <td>
                                            <input type="text" name="userID" value="${user.userID}" readonly="">
                                        </td>
                                        <td>
                                            <input type="text" name="fullName" value="${user.fullName}" required="">
                                        </td>
                                        <td>
                                            <input type="text" name="roleID" value="${user.roleID}" required="">
                                        </td>
                                        <td>${user.password}</td>
                                        <td>
                                            <input type="submit" name="action" value="Update">
                                            <input type="hidden" name="search" value="${param.search}">
                                        </td>
                                        <td>
                                            <c:url var="deleteLink" value="MainController">
                                                <c:param name="action" value="Delete" />
                                                <c:param name="userID" value="${user.userID}" />
                                                <c:param name="search" value="${param.search}" />
                                            </c:url>
                                            <a href="${deleteLink}">Delete</a>
                                        </td>
                                    </tr>
                                </form>
                            </c:forEach>
                        </tbody>
                    </table>
                    <p style="color: red;">${requestScope.ERROR_MESSAGE}</p>
                </c:when>
                
                <c:otherwise>
                    <%-- Trường hợp list rỗng --%>
                    ${requestScope.EMPTY_MSG}
                </c:otherwise>
            </c:choose>
        </c:if>

    </body>
</html>
