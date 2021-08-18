<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="AccueilServlet" method="POST">

		<div class="center">
			<label class="label">Pseudo :</label> <input class="input"
				type="text" name="pseudo" value="${model.utilisateur.pseudo}"><br>
		</div>
		<div class="center">
			<label class="label">Nom :</label> <input class="input" type="text"
				name="nom" value="${model.utilisateur.nom}"><br>
		</div>
		<div class="center">
			<label class="label">Prénom :</label> <input class="input"
				type="text" name="prenom" value="${model.utilisateur.prenom}"><br>
		</div>
		<div class="center">
			<label class="label">Email :</label> <input class="input" type="text"
				name="email" value="${model.utilisateur.email}"><br>
		</div>
		<div class="center">
			<label class="label">Téléphone :</label> <input class="input"
				type="text" name="telephone" value="${model.utilisateur.telephone}"><br>
		</div>
		<div class="center">
			<label class="label">Rue :</label> <input class="input" type="text"
				name="rue" value="${model.utilisateur.rue}"><br>
		</div>
		<div class="center">
			<label class="label">Code Postal :</label> <input class="input"
				type="text" name="codePostal" value="${model.utilisateur.codePostal}"><br>
		</div>
		<div class="center">
			<label class="label">Ville :</label> <input class="input" type="text"
				name="ville" value="${model.utilisateur.ville}"><br>
		</div>
		<input type="submit" name="modifierBtn" value="Modifier">
	</form>
</body>
</html>