<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Orders</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="userinfo.jsp"></jsp:include>
	<jsp:include page="menu.jsp"></jsp:include>
	<h2>Заказы</h2>
	<table border="1" >
       <tr>
          <th>Код заказа</th>
          <th>Имя заказчика</th>
          <th>Номер телефона</th>
          <th>Эл. почта</th>
          <th>Текст заказа</th>
          <th>Дата заказа</th>
          <th>Изменить</th>
          <th>Удалить</th>
       </tr>
       <c:forEach items="${ordersList}" var="order" >
          <tr>
             <td>${order.orderId}</td>
             <td>${order.customerName}</td>
             <td>${order.customerPhone}</td>
             <td>${order.customerEmail}</td>
             <td>${order.orderInfo}</td>
             <td>${order.orderDate}</td>
             <td>
                <a href="editorder?id=${order.orderId}">Изменить</a>
             </td>
             <td>
                <a href="deleteorder?id=${order.orderId}">Удалить</a>
             </td>
          </tr>
       </c:forEach>
    </table><br>
	<a href="report">Загрузить список заказов</a>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>