<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription ENI-Enchères</title>
</head>
<body>

<h1>ENI-ENCHERES</h1>
<h2>Mon Profil</h2>
<div class="form">
		<form action ="CreationCompteServlet" method="POST">
			<div class="form1">
				<label class="label">Pseudo :</label>
					<input type="text" name="pseudo">
				<label class="label">Prénom :</label>
					<input type="text" name="prenom">
				<label class="label">Téléphone :</label>
					<input type="text" name="telephone">
				<label class="label">Code Postal :</label>
					<input type="text" name="codePostal">
				<label class="label">Mot de passe :</label>
					<input type="password" name="mdp">
			</div>
			<div class="form2">
				<label class="label" >Nom :</label>
					<input type="text" name="nom">
				<label class="label">Email :</label>
					<input type="text" name="email">
				<label class="label">Rue :</label>
					<input type="text" name="rue">
				<label class="label">Ville :</label>
					<input type="text" name="ville">
				<label class="label">Confirmation :</label>
					<input type="password" name="confirmation">
			</div>
			<div class=btn_form>
				<input type="submit" name="creer" value="Créer">
				<input type="submit" name="annuler" value="Annuler">
			</div>
		</form>
</div>


</body>
</html>