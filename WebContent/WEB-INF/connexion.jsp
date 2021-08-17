<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head>
	<meta charset="ISO-8859-1">
	<link href="./css/style.css" rel="stylesheet">
	<title>Connexion</title>
	</head>
	<body>
		<div class="connex_container">
			<h1> Connexion </h1>
			<p class="error">${erreur}</p>
			<form action="ConnexionUtilisateurServlet" method="POST">
			
			<div class="login">
				<input class="psd_input" type="text" name="pseudo"
				placeholder="Pseudo" >
				<input class="psd_input" type="password" name="mdp"
				placeholder="Mot de passe" >			
			</div>
			<div class="remember">
				<label for="rememberUser">Se souvenir de moi </label>
				<input type="checkbox" name="rememberUser" >

			</div>
			<input class="btn_co" type="submit" name="Connexion" value="Connexion">

		</form>

		<a href="lienmdpperdu"> Mot de passe oubli� ?</a>
		</div>
	</body>
	</html>