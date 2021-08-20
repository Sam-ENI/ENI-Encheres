<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="./css/profil.css" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Votre Profil</title>
</head>
<body>
<h1>Votre Profil</h1>
	<div class="form">
		<form action="ProfilServlet" method="POST">
			<div class="center">
				<p><span class="nomChamps" >Pseudo : </span><span class="model" >${utlisateurModel.utilisateur.pseudo}</span></p>
			</div>
			<div class="center">
				<p><span class="nomChamps" >Nom : </span><span class="model" >${utlisateurModel.utilisateur.nom}</span></p>
			</div>
			<div class="center">
				<p><span class="nomChamps">Prénom : </span><span class="model" >${utlisateurModel.utilisateur.prenom}</span></p>
			</div>
			<div class="center">
				<p><span class="nomChamps">Email : </span><span class="model" >${utlisateurModel.utilisateur.email}</span></p>
			</div>
			<div class="center">
				<p><span class="nomChamps">Telephone : </span><span class="model" >${utlisateurModel.utilisateur.telephone}</span></p>
			</div>
			<div class="center">
				<p><span class="nomChamps">Rue : </span><span class="model" >${utlisateurModel.utilisateur.rue}</span></p>
			</div>
			<div class="center">
				<p><span class="nomChamps">Code Postal : </span><span class="model" >${utlisateurModel.utilisateur.codePostal}</span></p>
			</div>
			<div class="center">
				<p><span class="nomChamps">Ville : </span><span class="model" >${utlisateurModel.utilisateur.ville}</span></p>
			</div>
			<input class="modifierBtn" type="submit" name="modifierBtn" value="Modifier">
		</form>
	</div>
</body>
</html>