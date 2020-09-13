<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit order</title>
</head>
<body>

<jsp:include page="header.jsp"/>
<jsp:include page="userinfo.jsp"/>
<jsp:include page="menu.jsp"/>

<h2>Изменить заказ</h2>

<c:if test="${not empty order}">
    <form method="post">
        <input type="hidden" value="${order.orderId}" name="id"/>
        <label>Имя заказчика:</label><br><br>
        <input name="name" value="${order.customerName}"/><br><br>
        <label>Телефон:</label><br><br>
        <input name="phone" value="${order.customerPhone}"/><br><br>
        <label>Эл. почта:</label><br><br>
        <input name="email" value="${order.customerEmail}"/><br><br>
        <label>Текст заказа:</label><br><br>
        <input name="info" value="${order.orderInfo}"/><br><br>
        <label>Дата заказа:</label><br><br>
            ${order.orderDate}<br><br>
        <input type="submit" value="Обновить"/>
    </form>
</c:if>

<jsp:include page="footer.jsp"/>

</body>
</html>