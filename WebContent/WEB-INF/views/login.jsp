<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="userinfo.jsp"/>
<jsp:include page="menu.jsp"/>
<h2>Login to your account</h2>
<form method="post" action="login">
    <label>Username:</label><br><br>
    <label>
        <input type="text" name="username" required/>
    </label><br><br>
    <label>Password:</label><br><br>
    <label>
        <input type="password" name="password" required/>
    </label><br><br>
    <input type="submit" value="Login"/>
</form>
<jsp:include page="footer.jsp"/>
</body>
</html>