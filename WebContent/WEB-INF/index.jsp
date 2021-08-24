<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <link href="./css/index.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Accueil</title>
</head>

<body>
	<div class="page_cont">
	<header>
		<h1 class="logo">ENI-Encheres</h1>
		<form action="AccueilServlet" method="POST">
			<!-- Si utilisateur déconnectée-->
			<!-- on cache le bouton "S'inscrire - Se connecter" -->
           <input class="link <c:if test="${isConnecte == true}"> hidden </c:if>" type="submit" name="insci/connex" value="S'inscrire - Se connecter">

			<!-- Si utilisateur connectée -->
			<nav class="nav  <c:if test="${isConnecte == false}"> hidden </c:if>">
                    <input type="submit" name="Encheres" value="Enchères">
                    <input type="submit" name="vente" value="Vendre un article">
                    <input type="submit" name="profil" value="Mon profil">
                    <input type="submit" name="deco" value="Déconnexion">
                </nav>
			<!-- FIN -->
		</form>
	</header>
  <div class="intro">
            <img src="./img/background.jpg" alt="background header">
            <div class="txt_head">
                <h1>DONNER UNE SECONDE VIE À VOS OBJETS</h1>
                <span> Gagner des points en mettant en enchères vos objets, pour obtenir toutes sortes d'objets !
                </span>
            </div>
        </div>

        <h1 class="titre">Liste des enchères</h1>
        <form action="AccueilServlet" method="post">
            <div class="cont_rech">
                <div class="left_cont_rech">
                    <div class="filtre_cat">
                        <div class="filtre">
                            <input class="searchTxt" type="text" name="nomArticle" placeholder="Le nom de l'article contient">
                            <img src="./img/loupe.PNG" alt="Loupe">
                        </div>
                        <div class="desc">RECHERCHE AVANCEÉ</div>
                        <div class="cat">
                            <p>Catégorie :</p>
                            <select class="selectcat" name="categorie" id="categorie">
                                <option value="toutes">Toutes</option>
                                <option value="1">Informatique</option>
                                <option value="2">Ameublement</option>
                                <option value="3">Vêtement</option>
                                <option value="4">Sport&Loisirs</option>
                            </select>
                        </div>

                        <!-- Si utilisateur connectée -->
                        <div class="listFilter <c:if test="${isConnecte == false}"> hidden </c:if>">
                            <div class="achats">
                                <input type="radio" name="choixFiltre" id="achats" value="achats">
                                <label for="achats">Achats</label>
                                <div class="chekbox_cont">
                                    <div class="box">
                                        <input type="checkbox" name="encheresOuvertes" id="encheresOuvertes">
                                        <label for="encheresOuvertes">Enchères ouvertes</label>
                                    </div>
                                    <div class="box">
                                        <input type="checkbox" name="encheresEnCours" id="encheresEnCours">
                                        <label for="encheresEnCours">Mes enchères en cours</label>
                                    </div>
                                    <div class="box">
                                        <input type="checkbox" name="encheresRemporte" id="encheresRemporte">
                                        <label for="encheresRemporte">Mes enchères remportées</label>
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
                                        <input type="checkbox" name="venteNonDebute" id="venteNonDebute">
                                        <label for="venteNonDebute">Mes ventes non débutées</label>
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
                    <div class="footer_search">
                        <input type="submit" name="rechecher" value="RECHERCHER">
                    </div>

                </div>

            </div>

            <!-- UNE card enchères -->
            <div class="cont_card">      
            
            
          <c:if test="${defaultCard == true}">
          <c:forEach items="${articleModel.lstArticles}" var="article" varStatus = "status">
                <div class="card">
                    <img src="./img/horloge.jpg" alt="" style="object-fit:contain;
                    width:100%;
                    height:200px;
                    border: solid 1px #CCC">
                    <div class="textArticle">
                        <input  class="link nomArticle" type="submit" name="btn_Article" value="${article.nomArticle}" />
                        <div class="box_card">
                            <p> Prix : </p>
                            <p> ${article.miseAprix} points</p>
                        </div>
                        <div class="box_card">
                            <p> Fin de l'enchère : </p>
                            <p>${article.dateFinEncheres}</p>
                        </div>
                            <div class="vendeur box_card">
                                <p>Vendeur : </p>
                                <input class="link btn_vendeur" type="submit" name="pseudoVendeur" value="${article.utilisateur.pseudo}" />
                            </div>
                    </div>
                </div>
            </c:forEach>
			</c:if>
		<c:if test="${defaultCard == false}">
          <c:forEach items="${articleModel.lstCardbyName}" var="article" varStatus = "status">
                <div class="card">
                    <img src="./img/horloge.jpg" alt="" style="object-fit:contain;
                    width:100%;
                    height:200px;
                    border: solid 1px #CCC">
                    <div class="textArticle">
                        <input  class="link nomArticle" type="submit" name="btn_Article" value="${article.nomArticle}" />
                        <div class="box_card">
                            <p> Prix : </p>
                            <p> ${article.prixInitial} points</p>
                        </div>
                        <div class="box_card">
                            <p> Fin de l'enchère : </p>
                            <p>${article.dateFinEncheres}</p>
                        </div>
                            <div class="vendeur box_card">
                                <p>Vendeur : </p>
                                <input class="link btn_vendeur" type="submit" name="pseudoVendeur" value="${nomVendeur}" />
                            </div>
                    </div>
                </div>
            </c:forEach>
			</c:if>
            </div>
        </form>
    </div>
</body>


	<!-- Code JS pour désactiver les checkbox en fonction des bouton radio achats/ventes -->
	<script>
		// Example starter JavaScript for disabling form submissions if there are invalid fields
		(function() {
			'use strict';

			window
					.addEventListener(
							'load',
							function() {
								checkAchats();
								checkVentes();
								achats.addEventListener('change', function(
										event) {
									checkAchats();
								}, false);
								ventes.addEventListener('change', function(
										event) {
									checkVentes();
								}, false);

								function checkAchats() {
									//id radio button achats
									var achats = document
											.getElementById('achats');
									if (achats.checked) {
										//id des checkbox
										document.getElementById('venteEnCours').disabled = true;
										document.getElementById('venteNonDebute').disabled = true;
										document.getElementById('venteTerminer').disabled = true;
										document.getElementById('encheresEnCours').disabled = false;
										document.getElementById('encheresOuvertes').disabled = false;
										document.getElementById('encheresRemporte').disabled = false;
									}
								}
								function checkVentes() {
									//id radio button ventes
									var ventes = document
											.getElementById('ventes');
									if (ventes.checked) {
										//id des checkbox
										document.getElementById('venteEnCours').disabled = false;
										document.getElementById('venteNonDebute').disabled = false;
										document.getElementById('venteTerminer').disabled = false;
										document.getElementById('encheresEnCours').disabled = true;
										document.getElementById('encheresOuvertes').disabled = true;
										document.getElementById('encheresRemporte').disabled = true;
									}
								}
							}, false);
		})();
	</script>

</html>