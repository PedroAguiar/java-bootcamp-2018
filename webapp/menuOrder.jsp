<%--
  Created by IntelliJ IDEA.
  User: Leonardo
  Date: 24/2/2018
  Time: 04:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Menu Orden n° ${order.id}</title>
</head>
<body>
<div style="text-align: center;">
    <h1> Menu Orden n° ${order.id}</h1>
    <h2>
        <a href="newItem?id=<c:out value='${order.id}' />">Add Item</a>
        &nbsp;&nbsp;&nbsp;
        <a href="newPayment?id=<c:out value='${order.id}' />">Pay this Order</a>
        &nbsp;&nbsp;&nbsp;
        <a href="listItem?id=<%= request.getParameter("id") %>">View All Items</a>
        &nbsp;&nbsp;&nbsp;
        <a href="listOrder?id=<c:out value='${order.idClient}' />">Back to All my Orders</a>
    </h2>
</div>
</body>
</html>