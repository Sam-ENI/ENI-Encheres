<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modification du profil</title>
</head>
<body>
<h1>ENI Enchères</h1>

<form class="form" action="ModifierProfilServlet" method="POST">
		<div class=doubleForm>
			<div class="form1">

				<div class="center">
					<label class="label">Pseudo :</label> <input class="input"
						type="text" name="pseudo" value="${utlisateurModel.utilisateur.pseudo}"><br>
				</div>
				<div class="center">
					<label class="label">Prénom :</label> <input class="input"
						type="text" name="prenom" value="${utlisateurModel.utilisateur.prenom}"><br>
				</div>
				<div class="center">
					<label class="label">Téléphone :</label> <input class="input"
						type="text" name="telephone" value="${utlisateurModel.utilisateur.telephone}"><br>
				</div>
				<div class="center">
					<label class="label">Code Postal :</label> <input class="input"
						type="text" name="codePostal" value="${utlisateurModel.utilisateur.codePostal}"><br>
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
						name="rue" value="${utlisateurModel.utilisateur.rue}"><br>
				</div>
				<div class="center">
					<label class="label">Ville :</label> <input class="input"
						type="text" name="ville" value="${utlisateurModel.utilisateur.ville}"><br>
				</div>
				<div class="center">
					<label class="label">Confirmation :</label> <input class="input"
						type="password" name="confirmation"><br>
				</div>
			</div>
		</div>
		<div class=btn_form>
			<input class="btn_enregistrer" type="submit" name="enregistrer" value="Enregistrer">
			<input class="btn_supprimer" type="submit" name="supprimerCompte"
				value="Supprimer mon compte">
		</div>
	</form>
	<div class="msgModif">${msgModif}</div>
	<div class="msgErreur">${erreur}</div>
</body>
</html>