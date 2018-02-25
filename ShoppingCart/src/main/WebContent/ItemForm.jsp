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
        <a href="listItem">All my Items</a>
    </h2>
</div>
<div align="center">
    <c:if test="${item.name != null}">
    <form action="updateItem" method="post">
        </c:if>
        <c:if test="${item.name == null}">
        <form action="insertItem" method="post">
            </c:if>
            <table bitem="1" cellpadding="5">
                <c:if test="${item.name != null}">
                    <input type="hidden" name="id" value="<c:out value='${item.id}' />"/>
                </c:if>
                <tr>
                    <th>Name</th>
                    <td>
                        <input type="text" name="name" size="45"
                               value="<c:out value='${item.name}' />"
                        />
                    </td>
                </tr>
                <input type="hidden" name="idOrder" value="<c:out value='${idOrder}' />"/>
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
