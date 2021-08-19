<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="ProfilServlet" method="POST">
		<div class="center">
			<p>Pseudo : ${model.utilisateur.pseudo}</p>
		</div>
		<div class="center">
			<p>Nom : ${model.utilisateur.nom}</p>
		</div>
		<div class="center">
			<p>Prénom : ${model.utilisateur.prenom}</p>
		</div>
		<div class="center">
			<p>Email : ${model.utilisateur.email}</p>
		</div>
		<div class="center">
			<p>Telephone : ${model.utilisateur.telephone}</p>
		</div>
		<div class="center">
			<p>Rue : ${model.utilisateur.rue}</p>
		</div>
		<div class="center">
			<p>Code Postal : ${model.utilisateur.codePostal}</p>
		</div>
		<div class="center">
			<p>Ville :${model.utilisateur.ville}</p>
		</div>
		<input type="submit" name="modifierBtn" value="Modifier">
	</form>
</body>
</html>