<%--
  Created by IntelliJ IDEA.
  User: Leonardo
  Date: 24/2/2018
  Time: 04:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <name>ShoppingCart Application</name>
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
        <a href="newItem?id=<%= request.getParameter("id") %>">Add New Item</a>
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
                    <a href="editItem?id=<c:out value='${item.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="deleteItem?id=<c:out value='${item.id}' />">Delete</a>
                    &nbsp;&nbsp;&nbsp;
                    <a href="optionsItem?id=<c:out value='${item.id}' />">Menu</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
