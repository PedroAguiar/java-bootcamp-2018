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
        <a href="${pageContext.request.contextPath}/listPayment?id=<%= request.getParameter("id") %>">All my Payments</a>
    </h2>
</div>
<div align="center">
    <c:if test="${payment.name != null}">
    <form action="${pageContext.request.contextPath}/updatePayment" method="post">
        </c:if>
        <c:if test="${payment.name == null}">
        <form action="${pageContext.request.contextPath}/insertPayment" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <c:if test="${payment.name != null}">
                    <input type="hidden" name="id" value="<c:out value='${payment.id}' />"/>
                </c:if>
                <tr>
                    <th>Amount</th>
                    <td>
                        <input type="text" name="amount" size="45"
                               value="<c:out value='${payment.amount}' />"
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
