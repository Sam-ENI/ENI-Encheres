<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="./css/inscription.css" rel="stylesheet">
<title>Inscription ENI-Enchères</title>
</head>
<body>

	<h1>ENI-ENCHERES</h1>
	<h2>Mon Profil</h2>
	<h3 style="color: red">${erreur}</h3>
	<form class="form" action="CreationCompteServlet" method="POST">
		<div class=doubleForm>
			<div class="form1">

				<div class="center">
					<label class="label">Pseudo :</label> <input class="input"
						type="text" name="pseudo"><br>
				</div>
				<div class="center">
					<label class="label">Prénom :</label> <input class="input"
						type="text" name="prenom"><br>
				</div>
				<div class="center">
					<label class="label">Téléphone :</label> <input class="input"
						type="text" name="telephone"><br>
				</div>
				<div class="center">
					<label class="label">Code Postal :</label> <input class="input"
						type="text" name="codePostal"><br>
				</div>
				<div class="center">
					<label class="label">Mot de passe :</label> <input class="input"
						type="password" name="mdp"><br>
				</div>
			</div>
			<div class="form2">
				<div class="center">
					<label class="label">Nom :</label> <input class="input" type="text"
						name="nom"><br>
				</div>
				<div class="center">
					<label class="label">Email :</label> <input class="input"
						type="text" name="email"><br>
				</div>
				<div class="center">
					<label class="label">Rue :</label> <input class="input" type="text"
						name="rue"><br>
				</div>
				<div class="center">
					<label class="label">Ville :</label> <input class="input"
						type="text" name="ville"><br>
				</div>
				<div class="center">
					<label class="label">Confirmation :</label> <input class="input"
						type="password" name="confirmation"><br>
				</div>
			</div>
		</div>
		<div class=btn_form>
			<input class="btn_creer" type="submit" name="creer" value="Créer">
			<input class="btn_annuler" type="submit" name="annuler"
				value="Annuler">
		</div>
	</form>



</body>
</html>