<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit size</title>
</head>
<body>

<jsp:include page="header.jsp"/>
<jsp:include page="userinfo.jsp"/>
<jsp:include page="menu.jsp"/>

<h2>Изменить размеры продукции</h2>

<jsp:useBean id="product" scope="request" type="net.pixeleon.khpi.vagonkadb.beans.SizedProduct"/>
<c:if test="${not empty product}">
    <form method="post">
        <label>Код размера: ${product.sizedProductId} <input value="${product.sizedProductId}" name="id"
                                                             readonly/></label><br><br>
        <label>Код продукта: ${product.productId}</label><br><br>
        <label>Длина от (м):</label><br><br>
        <label>
            <input name="lfrom" value="${product.lengthFrom}"/>
        </label><br><br>
        <label>Длина до (м):</label><br><br>
        <label>
            <input name="lto" value="${product.lengthTo}"/>
        </label><br><br>
        <label>Ширина (мм):</label><br><br>
        <label>
            <input name="w" value="${product.width}"/>
        </label><br><br>
        <label>Толщина (мм):</label><br><br>
        <label>
            <input name="th" value="${product.thickness}"/>
        </label><br><br>
        <input type="submit" value="Обновить"/>
    </form>
</c:if>

<jsp:include page="footer.jsp"/>

</body>
</html>