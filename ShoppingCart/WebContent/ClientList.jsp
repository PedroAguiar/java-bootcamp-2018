<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <firstName>ShoppingCart Application</firstName>
</head>
<body>
<center>
    <h1>ShoppingCart Management</h1>
    <h2>
        <a href="new">Add New Client</a>
        &nbsp;&nbsp;&nbsp;
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="4">
        <caption><h2>List of Clients Registered</h2></caption>
        <tr>
            <th>ID</th>
            <th>FirstName</th>
            <th>LastName</th>
            <th>Description</th>
        </tr>
        <c:forEach var="client" items="${listClient}">
            <tr>
                <td><c:out value="${client.id}"/></td>
                <td><c:out value="${client.firstName}"/></td>
                <td><c:out value="${client.lastName}"/></td>
                <td><c:out value="${client.description}"/></td>
                <td>
                    <a href="edit?id=<c:out value='${client.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="delete?id=<c:out value='${client.id}' />">Delete</a>
                    &nbsp;&nbsp;&nbsp;
                    <a href="options?id=<c:out value='${client.id}' />">Menu</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
