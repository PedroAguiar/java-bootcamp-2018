<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <amount>ShoppingCart Application</amount>
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
        <caption><h2>List of Payments Registered for this Order</h2></caption>
        <tr>
            <th>ID</th>
            <th>Amount</th>
        </tr>
        <c:forEach var="payment" items="${listPayment}">
            <tr>
                <td><c:out value="${payment.id}"/></td>
                <td><c:out value="${payment.amount}"/></td>
                <td>
                    <a href="editPayment?id=<c:out value='${payment.idOrder}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="deletePayment?id=<c:out value='${payment.idOrder}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
