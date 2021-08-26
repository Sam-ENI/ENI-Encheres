<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action ="EnchereServlet" method="POST">
     <%@ include file="logo.jsp"%>
	</form>
	<h3 style="color: red">${erreur}</h3>
	<c:if test="${not empty erreurs }">
	<div class="cont_alert">
			<div class = "alert" >
			<p style="font-weight:bold;">Il y a des erreurs :</p>
			<ul>
				<c:forEach items="${erreurs }" var ="e">
					<li>${e }</li>
				</c:forEach>
			</ul>
		</div>
	</div>

	</c:if>	
<form action="EnchereServlet" method="post">
	Ma proposition : <input type="number" name="montant_enchere">
	<input type="submit" name="encherir" value="Enchérir">
</form>
</body>
</html>