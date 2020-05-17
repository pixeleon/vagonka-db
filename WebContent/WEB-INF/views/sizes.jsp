<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sizes</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="userinfo.jsp"></jsp:include>
	<jsp:include page="menu.jsp"></jsp:include>
	<h2>Размеры продукции</h2>
	<table border="1" >
       <tr>
          <th>Код</th>
          <th>Тип</th>
          <th>Дерево</th>
          <th>Сорт</th>
          <th>Длина от (м)</th>
          <th>Длина до (м)</th>
          <th>Ширина (мм)</th>
          <th>Толщина (мм)</th>
          <th>Ед. изм.</th>
          <th>Изменить</th>
       </tr>
       <c:forEach items="${productSizesList}" var="product" >
          <tr>
           	<td>${product.sizedProductId }</td>
           	<td>${product.productTypeName }</td>
             <td>${product.woodTypeName }</td>
             <td>${product.woodKindName }</td>
             <td style="text-align:right">${product.lengthFrom }</td>
             <td style="text-align:right">${product.lengthTo }</td>
             <td style="text-align:right">${product.width }</td>
             <td style="text-align:right">${product.thickness }</td>
             <td>${product.muAbbrv }</td>
             <td>
                <a href="editSizedProduct?id=${product.sizedProductId}">Изменить</a>
             </td>
          </tr>
       </c:forEach>
    </table>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>