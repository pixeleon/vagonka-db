<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Make order</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="userinfo.jsp"></jsp:include>
	<jsp:include page="menu.jsp"></jsp:include>
	<h2>Заказать вагонку, блок-хаус, фальшбрус</h2>
	<p>Здесь Вы можете оставить свой заказ на пиломатериалы.</p>
	<form action="makeorder" method="post">
	<p>Ваше имя:</p>
	<input name="name" required>
	<p>Ваш телефон:</p>
	<input name="phone" required>
	<p>Ваш e-mail:</p>
	<input name="email"  >
	<p>Текст заказа:</p>
	<textarea name="info"  rows="7" cols="50" required></textarea><br><br>
	<input type="submit" value="Отправить заказ" />
	</form>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>