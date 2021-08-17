<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
<meta charset="ISO-8859-1">
<link href="./css/index.css" rel="stylesheet">
<title>Accueil</title>
</head>

<body>

	<h1>Bienvenue</h1>






	<header>
		<h1 class="logo">ENI-Encheres</h1>
		
		<form action="AccueilServlet" method="POST">
			
			<!-- Si utilisateur déconnectée-->
			<!-- on cache le bouton "S'inscrire - Se connecter" -->
			<input class="link <c:if test="${hidden == true}"> hidden </c:if>"
				type="submit" name="insci/connex" value="S'inscrire - Se connecter">
			
			<!-- Si utilisateur connectée -->
			<nav class="nav  link <c:if test="${hidden == false}"> hidden </c:if>">
				<input type="submit" name="Encheres" value="Enchères"> <input
					type="submit" name="vente" value="Vendre un article"> <input
					type="submit" name="profil" value="Mon profil"> <input
					type="submit" name="deco" value="Déconnexion">
			</nav>
			<!-- FIN -->
		</form>
	</header>

	<h1>Liste des enchères</h1>
	<form action="AccueilServlet">
		<div class="cont_rech">
			<div class="left_cont_rech">
				<div class="filtre_cat">
					<div class="filtre">
						<h2>Filtres :</h2>
						<input type="text" name="nomArticle"
							placeholder="Le nom de l'article contient">
					</div>
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

					<!-- Si utilisateur connectée -->

					<div class="listFilter <c:if test="${hidden == false}"> hidden </c:if>">
						<div class="achats">
							<input type="radio" name="choixFiltre" id="achats" value="achats">
							<label for="achats">Achats</label>
							<div class="chekbox_cont">
								<div class="box">
									<input type="checkbox" name="encheresOuvertes"
										id="encheresOuvertes"> <label for="encheresOuvertes">Enchères
										ouvertes</label>
								</div>
								<div class="box">
									<input type="checkbox" name="encheresEnCours"
										id="encheresEnCours"> <label for="encheresEnCours">Mes
										enchères en cours</label>
								</div>
								<div class="box">
									<input type="checkbox" name="encheresRemporte"
										id="encheresRemporte"> <label for="encheresRemporte">Mes
										enchères remportées</label>
								</div>
							</div>
						</div>
						<div class="Ventes">
							<input type="radio" name="choixFiltre" id="ventes" value="ventes">
							<label for="ventes">Mes ventes</label>
							<div class="chekbox_cont">
								<div class="box">
									<input type="checkbox" name="venteEnCours" id="venteEnCours">
									<label for="venteEnCours">Mes ventes en cours</label>
								</div>
								<div class="box">
									<input type="checkbox" name="venteNonDebute"
										id="venteNonDebute"> <label for="venteNonDebute">Mes
										ventes non débutées</label>
								</div>
								<div class="box">
									<input type="checkbox" name="venteTerminer" id="venteTerminer">
									<label for="venteTerminer">Mes ventes terminées</label>
								</div>
							</div>
						</div>
					</div>
					<!-- FIN -->
				</div>
			</div>
			<div class="right_cont_rech">
				<input type="submit" name="rechecher" value="Rechercher">
			</div>
		</div>

		<!-- UNE card enchères -->

		<div class="cont_card">
			<div class="card">
				<img src="" alt="Image de l'objet">
				<div>
					<p class="nomArticle">[Nom de l'article]</p>
					<p>Prix : [Prix de l'article] points</p>
					<p>Fin de l'enchère : [Date fin enchères]</p>
					<form action="profilServlet">
						Vendeur : <input class="link" type="submit" name="pseudoVendeur"
							value="[PSEUDO VENDEUR]" />
					</form>
				</div>
			</div>



		</div>


	</form>

	
</body>

</html>