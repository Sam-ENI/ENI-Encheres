<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<<<<<<< HEAD
=======
	<form action="ProfilServlet" method="POST">
>>>>>>> branch 'main' of https://github.com/Sam-ENI/ENI-Encheres.git

	<form action="ProfilServlet" method="POST">
		<div class="center">
			<p>value="${model.utilisateur.pseudo}"</p>
		</div>
		<div class="center">
			<p>value="${model.utilisateur.nom}"</p>
		</div>
		<div class="center">
			<p>value="${model.utilisateur.prenom}"</p>
		</div>
		<div class="center">
			<p>value="${model.utilisateur.email}"</p>
		</div>
		<div class="center">
			<p>value="${model.utilisateur.telephone}"</p>
		</div>
		<div class="center">
			<p>value="${model.utilisateur.rue}"</p>
		</div>
		<div class="center">
			<p>value="${model.utilisateur.codePostal}"</p>
		</div>
		<div class="center">
			<p>value="${model.utilisateur.ville}"</p>
		</div>
		<input type="submit" name="modifierBtn" value="Modifier">
	</form>
</body>
</html>