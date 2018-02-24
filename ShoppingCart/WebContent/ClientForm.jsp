<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <firstName>ShoppingCart Application</firstName>
</head>
<body>
<div style="text-align: center;">
    <h1>ShoppingCart Management</h1>
    <h2>
        <a href="new">Add New Client</a>
        &nbsp;&nbsp;&nbsp;
        <a href="/">All Menu Client</a>

    </h2>
</div>
<div align="center">
    <c:if test="${client != null}">
    <form action="update" method="post">
        </c:if>
        <c:if test="${client == null}">
        <form action="insert" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${client != null}">
                            Edit Client
                        </c:if>
                        <c:if test="${client == null}">
                            Add New Client
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${client != null}">
                    <input type="hidden" name="id" value="<c:out value='${client.id}' />"/>
                </c:if>
                <tr>
                    <th>First Name:</th>
                    <td>
                        <input type="text" name="firstName" size="45"
                               value="<c:out value='${client.firstName}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Last Name:</th>
                    <td>
                        <input type="text" name="lastName" size="45"
                               value="<c:out value='${client.lastName}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Description:</th>
                    <td>
                        <input type="text" name="description" size="50"
                               value="<c:out value='${client.description}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save"/>
                    </td>
                </tr>
            </table>
        </form>
</div>
</body>
</html>
