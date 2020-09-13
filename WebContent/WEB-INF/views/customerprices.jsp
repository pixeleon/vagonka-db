<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Prices</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="userinfo.jsp"/>
<jsp:include page="menu.jsp"/>
<h2>Цены на разные виды продукции</h2>
<table border="1">
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
    <jsp:useBean id="customerPricesList" scope="request" type="java.util.List"/>
    <c:forEach items="${customerPricesList}" var="price">
        <tr>
            <td>${price.productTypeName }</td>
            <td>${price.woodTypeName }</td>
            <td>${price.woodKindName }</td>
            <td style="text-align:right">${price.lengthFrom }</td>
            <td style="text-align:right">${price.lengthTo }</td>
            <td style="text-align:right">${price.width }</td>
            <td style="text-align:right">${price.thickness }</td>
            <td>${price.muAbbrv }</td>
            <td style="text-align:right">${price.price}</td>
        </tr>
    </c:forEach>
</table>
<jsp:include page="footer.jsp"/>
</body>
</html>