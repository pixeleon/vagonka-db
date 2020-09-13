<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="userinfo.jsp"></jsp:include>
	<jsp:include page="menu.jsp"></jsp:include>
	<h2>Продукция</h2>
	<table border="1" >
       <tr>
          <th>Код</th>
          <th>Тип</th>
          <th>Дерево</th>
          <th>Сорт</th>
          <th>Ед. изм.</th>
       </tr>
       <jsp:useBean id="productList" scope="request" type="java.util.List"/>
       <c:forEach items="${productList}" var="product">
          <tr>
             <td>${product.productId }</td>
             <td>${product.productTypeName }</td>
             <td>${product.woodTypeName }</td>
             <td>${product.woodKindName }</td>
             <td>${product.muAbbrv }</td>
          </tr>
       </c:forEach>
    </table>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>