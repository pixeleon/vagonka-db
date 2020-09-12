<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update price</title>
</head>
<body>

<jsp:include page="header.jsp"/>
<jsp:include page="userinfo.jsp"/>
<jsp:include page="menu.jsp"/>

<h2>Изменить цену</h2>

<jsp:useBean id="price" scope="request" type="net.pixeleon.khpi.vagonkadb.beans.SizedProductPrice"/>
<c:if test="${not empty price}">
    <form method="POST" action="editProductPrice">
        <input type="hidden" name="id" value="${price.sizedProductId}"/>
        <table border="0">
            <tr>
                <td>Код размера продукции:</td>
                <td>${price.sizedProductId}</td>
            </tr>
            <tr>
                <td>Дата последнего обновления:</td>
                <td>${price.updateDate}</td>
            </tr>
            <tr>
                <td>Цена (грн.):</td>
                <td><label>
                    <input type="text" name="price" value="${price.price}"/>
                </label></td>
            </tr>
            <tr>
                <td>Количество на складе:</td>
                <td><label>
                    <input type="number" min="0" name="amount" value="${price.amount}">
                </label></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Обновить"/>
                </td>
            </tr>
        </table>
    </form>
</c:if>

<jsp:include page="footer.jsp"/>

</body>
</html>