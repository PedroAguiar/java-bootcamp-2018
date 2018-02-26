<%--
  Created by IntelliJ IDEA.
  User: Leonardo
  Date: 24/2/2018
  Time: 04:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Client Menu - ${client.firstName}</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
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
