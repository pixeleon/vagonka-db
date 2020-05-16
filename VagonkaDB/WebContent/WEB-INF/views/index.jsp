<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset="
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vagonka</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="userinfo.jsp"></jsp:include>
	<jsp:include page="menu.jsp"></jsp:include>
	<ul >
		<li><a href="vagonka-smereka">Вагонка смерека</a>
	  	<li><a href="vagonka-sosna.jsp">Вагонка сосна</a>
	  	<li><a href="vagonka-lipa.jsp">Вагонка липа</a>
	  	<li><a href="vagonka-olkha.jsp">Вагонка ольха</a>
	  	<li><a href="doska-pola.jsp">Доска пола</a>
	  	<li><a href="blok-khaus.jsp">Блок хаус</a>
	  	<li><a href="falshbrus.jsp">Фальш брус</a>
	  	<li><a href="terras-doska.jsp">Террасная доска</a>
	  	<li><a href="palub-doska.jsp">Палубная доска</a>
	  </ul>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>