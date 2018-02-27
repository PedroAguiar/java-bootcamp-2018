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
        <a href="newOrder?id=<%= request.getParameter("id") %>">Add New Order</a>
        &nbsp;&nbsp;&nbsp;
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="4">
        <caption><h2>List of Orders Registered for this Client</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
        </tr>
        <c:forEach var="order" items="${listOrder}">
            <tr>
                <td><c:out value="${order.id}"/></td>
                <td><c:out value="${order.name}"/></td>
                <td>
                    <a href="editOrder?id=<c:out value='${order.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="deleteOrder?id=<c:out value='${order.id}' />">Delete</a>
                    &nbsp;&nbsp;&nbsp;
                    <a href="optionsOrder?id=<c:out value='${order.id}' />">Menu</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="newPayment?id=<c:out value='${order.id}' />">Pay this Order</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
