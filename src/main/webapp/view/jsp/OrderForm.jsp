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
        <a href="${pageContext.request.contextPath}/listOrder?id=<c:out value='${idClient}' />">All my Orders</a>
    </h2>
</div>
<div align="center">
    <c:if test="${order.name != null}">
    <form action="${pageContext.request.contextPath}/updateOrder" method="post">
        </c:if>
        <c:if test="${order.name == null}">
        <form action="${pageContext.request.contextPath}/insertOrder" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <c:if test="${order.name != null}">
                    <input type="hidden" name="id" value="<c:out value='${order.id}' />"/>
                </c:if>
                <tr>
                    <th>Name</th>
                    <td>
                        <input type="text" name="name" size="45"
                               value="<c:out value='${order.name}' />"
                        />
                    </td>
                </tr>
                <input type="hidden" name="idClient" value="<c:out value='${idClient}' />"/>
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
