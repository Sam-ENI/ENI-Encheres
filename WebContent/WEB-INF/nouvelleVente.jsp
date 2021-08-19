<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nouvelle Vente</title>
</head>
<body>
	<div class="image">
		<img src="" alt="image de l'objet en vente">
	</div>
	<form action ="NouvelleVenteServlet" method="post">
	<div>
		
			<label for="article">Article : </label> <input type="text"
				name="article"> <label for="description">Description
				: </label>
			<textarea id="textarea" name="description" rows="5" cols="33"></textarea>
			<div class="cat">
				<p>Categorie :</p>
				<select name="categorie" id="categorie">
					<option value="toutes">Toutes</option>
					<option value="informatique">Informatique</option>
					<option value="ameublement">Ameublement</option>
					<option value="vetement">Vêtement</option>
					<option value="sportloisirs">Sport&Loisirs</option>
				</select>
			</div>
			<label for="uploader">Photo de l'article </label> <input type="submit" name="uploader" value="uploader photo"> 
			<label for="miseAprix">Mise à prix : </label>  <input type="number" name="miseAprix">
			<label for="debutEnchere">Début de l'enchère</label> <input type="date" name="dateDebutEncheres"> 
			<label for="finEnchere">Fin de l'enchère</label> <input type="date" name="dateFinEncheres">
	</div>
	<div class="retrait">
		<h3>Retrait</h3>
		<label for="rue">Rue : </label> <input type="text"> <label
			for="codePostal">Code postal :</label> <label for="Ville">Ville
			:</label> <input type="submit" name="enregister" value="enregister">
		<input type="submit" name="annuler" value="annuler">

	</div>
	</form>
</body>
</html>