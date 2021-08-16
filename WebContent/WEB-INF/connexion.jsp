<@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="/css/style.css" rel="stylesheet">
<title>Connexion</title>
</head>
<body>
	<div class="connex_container">
		<h3> Connexion </h3>
		<form action="UtilisateurServlet" method="POST">
		
		<div class="pseudo">
			<label for="pseudo">Pseudo :	</label>
			<input type="text" name="pseudo" value="${model.Utilisateur.pseudo}">
		</div>
		<div class="mdp">
			<label for="mdp">Mot de passe :	</label>
			<input type="password" name="mdp">
		</div>
			<input class="btn_co" type="submit" name="Connexion" value="Connexion">
	</form>
	</div>
</body>
</html>