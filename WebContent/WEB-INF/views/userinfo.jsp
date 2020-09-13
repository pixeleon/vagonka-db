<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<p>
    <c:if test="${sessionScope.loginedUser != null}">
        <b>User: </b> <i>${sessionScope.loginedUser.username}</i> | <a href="products">Products</a> | <a href="sizes">Sizes</a> |
        <a href="managerprices">Prices</a> | <a href="orders">Orders</a> | <a href="logout">Logout</a>
    </c:if>
    <c:if test="${sessionScope.loginedUser == null}">
        <b>Not logged in </b> <i>${sessionScope.loginedUser}</i> | <a href="login">Login</a>
    </c:if>
</p>
<hr>
