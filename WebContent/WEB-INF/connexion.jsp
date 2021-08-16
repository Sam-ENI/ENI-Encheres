<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="/css/style.css" rel="stylesheet">
<title>Connexion</title>
</head>
<body>
	
	<div class="connex_container">
		<h3> Connexion </h3>
		<form action="ConnexionUtilisateurServlet" method="POST">
		Pseudo : <input type="text" name="pseudo" value="${model.Utilisateur.pseudo}">
		Mot de passe : <input type="password" name="mdp">
		<input type="submit" name="Connexion" value="Connexion">
	</form>
	</div>

</body>
</html>