<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
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