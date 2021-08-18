<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link href="./css/connexion.css" rel="stylesheet">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>Connexion</title>
	</head>
	<body>
		<div class="connex_container">
			<h1> Connexion </h1>
			<div class="alert <c:if test="${erreur == null}"> hidden </c:if>">
				<span class="closebtn">${erreur}</span>
			</div>
			<form action="ConnexionUtilisateurServlet" method="POST">
			
			<div class="login">
				<input class="psd_input" type="text" name="pseudoEmail"
				placeholder="Pseudo" >
				<input class="psd_input" type="password" name="mdp"
				placeholder="Mot de passe" >			
			</div>
			
			<div class="submit_cont">
				<input class="btn_co" type="submit" name="Connexion" value="Connexion">
				<div class="right_submit_cont">
					<div class="remember">
						<input type="checkbox" name="rememberUser">
						<label for="rememberUser">Se souvenir de moi </label>

					</div>
					<a href="lienmdpperdu"> Mot de passe oublié ?</a>
				</div>
			</div>
			<div class="btn_cont">
				<input class="btn_insc" type="submit" name="Inscription" value="Créer un compte">
			</div>


		</form>

		</div>
	</body>
	</html>