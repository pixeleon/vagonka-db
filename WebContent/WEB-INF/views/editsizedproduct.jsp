<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Edit size</title>
   </head>
   <body>
 
      	<jsp:include page="header.jsp"></jsp:include>
		<jsp:include page="userinfo.jsp"></jsp:include>
		<jsp:include page="menu.jsp"></jsp:include>
 
      <h2>Изменить размеры продукции</h2>
 
      <c:if test="${not empty product}">
         <form method="post">
			<input type="hidden" value="${product.sizedProductId}" name="id" />
			<label>Тип продукта: ${product.productTypeName}</label><br><br>
			<label>Дерево: ${product.woodTypeName}</label><br><br>
			<label>Сорт дерева: ${product.woodKindName}</label><br><br>
			<label>Длина от (м):</label><br><br>
			<input name="lfrom" value="${product.lengthFrom}"/><br><br>
			<label>Длина до (м):</label><br><br>
			<input name="lto" value="${product.lengthTo}"/><br><br>
			<label>Ширина(мм):</label><br><br>
			<input name="w" value="${product.width}"/><br><br>
			<label>Толщина (мм):</label><br><br>
			<input name="th" value="${product.thickness}"/><br><br>
			<input type="submit" value="Обновить" />
		</form>
      </c:if>
 
      <jsp:include page="footer.jsp"></jsp:include>
 
   </body>
</html>