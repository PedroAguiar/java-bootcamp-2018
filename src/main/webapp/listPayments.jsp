<%--
  Created by IntelliJ IDEA.
  User: Leonardo
  Date: 24/2/2018
  Time: 04:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <amount>ShoppingCart Application</amount>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
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