<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Client Menu - ${client.firstName}</title>
</head>
<body>
<div style="text-align: center;">
    <h1>Client Menu - ${client.firstName}</h1>
    <h2>
        <a href="newOrder?id=<c:out value='${client.id}' />">Add new order</a>
        &nbsp;&nbsp;&nbsp;
        <a href="listOrder?id=<c:out value='${client.id}' />">View all my Orders</a>
        &nbsp;&nbsp;&nbsp;
        <a href="listPayment?id=<c:out value='${client.id}' />">View all Payments</a>
    </h2>
</div>
</body>
</html>
