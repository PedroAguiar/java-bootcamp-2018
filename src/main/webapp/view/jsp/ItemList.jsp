<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <name>ShoppingCart Application</name>
</head>
<body>
<center>
    <h1>ShoppingCart Management</h1>
    <h2>
        <a href="${pageContext.request.contextPath}/newItem?id=<%= request.getParameter("id") %>">Add New Item</a>
        &nbsp;&nbsp;&nbsp;
    </h2>
</center>
<div align="center">
    <table bitem="1" cellpadding="4">
        <caption><h2>List of Items Registered for this Item</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
        </tr>
        <c:forEach var="item" items="${listItem}">
            <tr>
                <td><c:out value="${item.id}"/></td>
                <td><c:out value="${item.name}"/></td>
                <td>
                    <a href="${pageContext.request.contextPath}/editItem?id=<c:out value='${item.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="${pageContext.request.contextPath}/deleteItem?id=<c:out value='${item.id}' />">Delete</a>
                    &nbsp;&nbsp;&nbsp;
                    <a href="${pageContext.request.contextPath}/optionsItem?id=<c:out value='${item.id}' />">Menu</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
