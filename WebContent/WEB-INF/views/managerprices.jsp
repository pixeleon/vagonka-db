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
	<jsp:include page="header.jsp"/>
	<jsp:include page="userinfo.jsp"/>
	<jsp:include page="menu.jsp"/>
	<h2>Цены на разные виды продукции</h2>
	<table border="1" >
       <tr>
           <th>Код размера</th>
           <th>Цена (грн.)</th>
           <th>Дата обновления</th>
           <th>Кол-во</th>
           <th>Изменить</th>
           <th>Удалить</th>
       </tr>
       <jsp:useBean id="productPricesList" scope="request" type="java.util.List"/>
       <c:forEach items="${productPricesList}" var="price">
          <tr>
             <td>${price.sizedProductId }</td>
             <td style="text-align:right">${price.price }</td>
              <td style="text-align:right">${price.updateDate}</td>
              <td style="text-align:right">${price.amount}</td>
              <td>
                <a href="editProductPrice?id=${price.sizedProductId}">Изменить</a>
             </td>
             <td>
                <a href="deleteProductPrice?id=${price.sizedProductId}">Удалить</a>
             </td>
          </tr>
       </c:forEach>
    </table>
	<jsp:include page="footer.jsp"/>
</body>
</html>