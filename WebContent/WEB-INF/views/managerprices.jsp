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
           <th>Код</th>
           <th>Продукция</th>
           <th>Дерево</th>
           <th>Сорт</th>
           <th>Длина от (м)</th>
           <th>Длина до (м)</th>
           <th>Ширина (мм)</th>
           <th>Толщина (мм)</th>
           <th>Ед. изм.</th>
           <th>Цена (грн.)</th>
           <th>Дата цены</th>
           <th>Кол-во</th>
           <th>Изменить</th>
           <th>Удалить</th>
       </tr>
       <c:forEach items="${managerPricesList}" var="product">
          <tr>
             <td>${product.sizedProductId }</td>
              <td>${product.productTypeName}</td>
              <td>${product.woodTypeName}</td>
              <td>${product.woodKindName}</td>
              <td>${product.lengthFrom}</td>
              <td>${product.lengthTo}</td>
              <td>${product.width}</td>
              <td>${product.thickness}</td>
              <td>${product.muAbbrv}</td>
             <td style="text-align:right">${product.price }</td>
              <td>${product.priceDate}</td>
              <td>${product.amount}</td>
              <td>
                <a href="editProductPrice?id=${product.sizedProductId}">Изменить</a>
             </td>
             <td>
                <a href="deleteProductPrice?id=${product.sizedProductId}">Удалить</a>
             </td>
          </tr>
       </c:forEach>
    </table>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>