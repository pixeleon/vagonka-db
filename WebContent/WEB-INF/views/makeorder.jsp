<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Make order</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="userinfo.jsp"/>
<jsp:include page="menu.jsp"/>
<h2>Заказать вагонку, блок-хаус, фальшбрус</h2>
<p>Здесь Вы можете оставить свой заказ на пиломатериалы.</p>
<form action="makeorder" method="post">
    <p>Ваше имя:</p>
    <label>
        <input name="name" required>
    </label>
    <p>Ваш телефон:</p>
    <label>
        <input name="phone" required>
    </label>
    <p>Ваш e-mail:</p>
    <label>
        <input name="email">
    </label>
    <p>Текст заказа:</p>
    <label>
        <textarea name="info" rows="7" cols="50" required></textarea>
    </label><br><br>
    <input type="submit" value="Отправить заказ"/>
</form>
<jsp:include page="footer.jsp"/>
</body>
</html>