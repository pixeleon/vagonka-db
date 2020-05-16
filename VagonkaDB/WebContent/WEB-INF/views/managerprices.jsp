<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit prices</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="userinfo.jsp"></jsp:include>
	<jsp:include page="menu.jsp"></jsp:include>
	<h2>Цены на разные виды продукции</h2>
	<table border="1" >
       <tr>
          <th>Код размера продукта</th>
          <th>Дата цены</th>
          <th>Цена (грн.)</th>
          <th>Изменить</th>
          <th>Удалить</th>
       </tr>
       <c:forEach items="${pricesList}" var="price" >
          <tr>
             <td>${price.sizedProductId }</td>
             <td>${price.priceDate }</td>
             <td style="text-align:right">${price.price }</td>
             <td>
                <a href="editProductPrice?id=${price.sizedProductId}">Изменить</a>
             </td>
             <td>
                <a href="deleteProductPrice?id=${price.sizedProductId}">Удалить</a>
             </td>
          </tr>
       </c:forEach>
    </table>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>