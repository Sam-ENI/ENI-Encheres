<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="./css/modifierprofil.css" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Modification profil ENI-Enchères</title>
</head>
<body>
<h1>ENI Enchères</h1>
<h2 class="titre"> Modifier votre profil </h2>
<c:if test="${not empty erreurs }">
		<div class = "alert" style="color:red; font-weight:bold;">
			Il y a des erreurs :
			<ul>
				<c:forEach items="${erreurs }" var ="e">
					<li style="color: red;font-weight:bold;">${e }</li>
				</c:forEach>
			</ul>
		</div>
	</c:if>	
        
        <div class="sucess <c:if test="${msgModif == null}"> hidden </c:if>">
            <span class="closebtn">${msgModif}</span>
        </div>
	<div class="msgModif">${msgModif}</div>
	<div class="msgErreur">${erreur}</div>
<form class="form" action="ModifierProfilServlet" method="POST">
		<div class="container">
			<ul class="flex-outer">
				<li>
					<label class="label">Pseudo :</label> <input class="input"
						type="text" name="pseudo" value="${utilisateurModel.utilisateur.pseudo}"><br>
				</li>
				<li>
					<label class="label">Prénom :</label> <input class="input"
						type="text" name="prenom" value="${utilisateurModel.utilisateur.prenom}"><br>
				</li>
				<li>
					<label class="label">Téléphone :</label> <input class="input"
						type="text" name="telephone" value="${utilisateurModel.utilisateur.telephone}"><br>
				</li>
				<li>
					<label class="label">Code Postal :</label> <input class="input"
						type="text" name="codePostal" value="${utilisateurModel.utilisateur.codePostal}"><br>
				</li>
				<li>
					<label class="label">Mot de passe :</label> <input class="input"
						type="password" name="mdp"><br>
				</li>
			</ul>


			
			
			<ul class="flex-outer">
				<li>
					<label class="label">Nom :</label> <input class="input" type="text"
						name="nom"><br>
				</li>
				<li>
					<label class="label">Email :</label> <input class="input"
						type="text" name="email"><br>
				</li>
				<li>
					<label class="label">Rue :</label> <input class="input" type="text"
						name="rue" value="${utilisateurModel.utilisateur.rue}"><br>
				</li>
				<li>
					<label class="label">Ville :</label> <input class="input"
						type="text" name="ville" value="${utilisateurModel.utilisateur.ville}"><br>
				</li>
				<li>
					<label class="label">Confirmation :</label> <input class="input"
						type="password" name="confirmation"><br>
				</li>
				<li class="credit">
					<p>Crédit : </p>
					<p> ${model.utilisateur.credit} points </p>
				</li>
			</ul>
			
		</div>
		<div class="btn">
			<input class="btn_enregistrer" type="submit" name="enregistrer" value="Enregistrer">
			<input class="btn_supprimer" type="submit" name="supprimerCompte"
				value="Supprimer mon compte">
		</div>
</form>

</body>
</html>