<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Update price</title>
   </head>
   <body>
 
      	<jsp:include page="header.jsp"></jsp:include>
		<jsp:include page="userinfo.jsp"></jsp:include>
		<jsp:include page="menu.jsp"></jsp:include>
 
      <h2>Изменить цену</h2>
 
      <c:if test="${not empty price}">
         <form method="POST" action="editProductPrice">
            <input type="hidden" name="id" value="${price.sizedProductId}" />
            <table border="0">
               <tr>
                  <td>Код размера продукции: </td>
                  <td>${price.sizedProductId}</td>
               </tr>
               <tr>
                  <td>Дата цены: </td>
                  <td>${price.priceDate}</td>
               </tr>
               <tr>
                  <td>Цена (грн.): </td>
                  <td><input type="text" name="price" value="${price.price}" /></td>
               </tr>
               <tr>
                  <td colspan = "2">
                      <input type="submit" value="Обновить" />
                  </td>
               </tr>
            </table>
         </form>
      </c:if>
 
      <jsp:include page="footer.jsp"></jsp:include>
 
   </body>
</html>