<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<link href="./css/inscription.css" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Inscription ENI-Enchères</title>
</head>

<body>
	<div class="page_cont">
	<div class="cont_logo">
			<form action="CreationCompteServlet" method="POST">
			<%@ include file="logo.jsp"%>
		</form>
	</div>

		<h2>Mon Profil</h2>
		<c:if test="${not empty erreurs }">
			<div class="cont_alert">
				<div class="alert">
					<p style="font-weight: bold;">Il y a des erreurs :</p>
					<ul>
						<c:forEach items="${erreurs }" var="e">
							<li>${e }</li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</c:if>
		<form class="form" action="CreationCompteServlet" method="POST">

			<div class="cnt">
				<div class=container>
					<ul class="flex-outer">

						<li class="center"><label class="label">Pseudo :</label> <input
							class="input" type="text" name="pseudo"><br></li>
						<li class="center"><label class="label">Prénom :</label> <input
							class="input" type="text" name="prenom"><br></li>
						<li class="center"><label class="label">Téléphone :</label> <input
							class="input" type="text" name="telephone"><br></li>
						<li class="center"><label class="label">Code Postal :</label>
							<input class="input" type="text" name="codePostal"><br>
						</li>
						<li class="center"><label class="label">Nom :</label> <input
							class="input" type="text" name="nom"><br></li>
						<li class="center"><label class="label">Email :</label> <input
							class="input" type="text" name="email"><br></li>
						<li class="center"><label class="label">Rue :</label> <input
							class="input" type="text" name="rue"><br></li>
						<li class="center"><label class="label">Ville :</label> <input
							class="input" type="text" name="ville"><br></li>
						<li class="center"><label class="label">Mot de passe
								:</label> <input class="input" type="password" name="mdp"><br>
						</li>
						<li class="center"><label class="label">Confirmation
								du mot de passe :</label> <input class="input" type="password"
							name="confirmation"><br></li>
					</ul>
				</div>
			</div>

			<div class=btn_form>
				<input class="btn_creer" type="submit" name="creer" value="Créer">
				<input class="btn_annuler" type="submit" name="annuler"
					value="Annuler">
			</div>
		</form>

	</div>








</body>

</html>