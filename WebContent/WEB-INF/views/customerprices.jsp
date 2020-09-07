<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Prices</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="userinfo.jsp"></jsp:include>
	<jsp:include page="menu.jsp"></jsp:include>
	<h2>Цены на разные виды продукции</h2>
	<table border="1" >
       <tr>
          <th>Продукция</th>
          <th>Дерево</th>
          <th>Сорт</th>
          <th>Длина от (м)</th>
          <th>Длина до (м)</th>
          <th>Ширина (мм)</th>
          <th>Толщина (мм)</th>
          <th>Ед. изм.</th>
           <th>Цена (грн.)</th>
       </tr>
       <c:forEach items="${productPricesList}" var="productprice" >
          <tr>
             <td>${productprice.productTypeName }</td>
             <td>${productprice.woodTypeName }</td>
             <td>${productprice.woodKindName }</td>
             <td style="text-align:right">${productprice.lengthFrom }</td>
             <td style="text-align:right">${productprice.lengthTo }</td>
             <td style="text-align:right">${productprice.width }</td>
             <td style="text-align:right">${productprice.thickness }</td>
             <td>${productprice.muAbbrv }</td>
              <td style="text-align:right">${productprice.price}</td>
          </tr>
       </c:forEach>
    </table>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>