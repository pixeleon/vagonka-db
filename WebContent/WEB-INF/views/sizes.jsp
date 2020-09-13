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
	<jsp:include page="header.jsp"/>
	<jsp:include page="userinfo.jsp"/>
	<jsp:include page="menu.jsp"/>
	<h2>Размеры продукции</h2>
	<table border="1" >
       <tr>
          <th>Код размера</th>
          <th>Код продукции</th>
          <th>Длина от (м)</th>
          <th>Длина до (м)</th>
          <th>Ширина (мм)</th>
          <th>Толщина (мм)</th>
       </tr>
       <jsp:useBean id="productSizesList" scope="request" type="java.util.List"/>
       <c:forEach items="${productSizesList}" var="size">
          <tr>
           	<td>${size.sizedProductId }</td>
           	<td>${size.productId }</td>
             <td style="text-align:right">${size.lengthFrom }</td>
             <td style="text-align:right">${size.lengthTo }</td>
             <td style="text-align:right">${size.width }</td>
             <td style="text-align:right">${size.thickness }</td>
          </tr>
       </c:forEach>
    </table>
	<jsp:include page="footer.jsp"/>
</body>
</html>