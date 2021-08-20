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
           <input class="link <c:if test="${hidden == true}"> hidden </c:if>" type="submit" name="insci/connex" value="S'inscrire - Se connecter">

			<!-- Si utilisateur connectée -->
			<nav class="nav  <c:if test="${hidden == false}"> hidden </c:if>">
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
        <form action="AccueilServlet">
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
                <div class="card">
                    <img src="./img/horloge.jpg" alt="" style="object-fit:contain;
                    width:100%;
                    height:200px;
                    border: solid 1px #CCC">
                    <div class="textArticle">
                        <input class="link nomArticle" type="submit" name="pseudoVendeur" value="[NOM ARTICLE]" />

                        <div class="box_card">
                            <p> Prix : </p>
                            <p> [Prix de l'article] points</p>
                        </div>
                        <div class="box_card">
                            <p> Fin de l'enchère : </p>
                            <p>[Date fin enchères]</p>

                        </div>

                        <form action="AccueilServlet">
                            <div class="vendeur box_card">
                                <p>Vendeur : </p>
                                <input class="link btn_vendeur" type="submit" name="pseudoVendeur" value="[PSEUDO VENDEUR]" />
                            </div>
                        </form>
                    </div>
                </div>
                <!--  TEST C/C -->

                <div class="card">
                    <img src="./img/hand.png" alt="" style="object-fit:contain;
                    width:100%;
                    height:200px;
                    border: solid 1px #CCC">
                    <div class="textArticle">
                        <input class="link nomArticle" type="submit" name="pseudoVendeur" value="[NOM ARTICLE]" />
                        <p> Prix : [Prix de l'article] points</p>
                        <p> Fin de l'enchère : [Date fin enchères]</p>

                        <form action="AccueilServlet">
                            <div class="vendeur">
                                <label for="pseudoVendeur">Vendeur : </label>
                                <input class="link btn_vendeur" type="submit" name="pseudoVendeur" value="[PSEUDO VENDEUR]" />
                            </div>
                        </form>
                    </div>
                </div>

                <div class="card">
                    <img src="./img/montre.jpg" alt="" style="object-fit:contain;
                    width:100%;
                    height:200px;
                    border: solid 1px #CCC">
                    <div class="textArticle">
                        <input class="link nomArticle" type="submit" name="pseudoVendeur" value="[NOM ARTICLE]" />
                        <p> Prix : [Prix de l'article] points</p>
                        <p> Fin de l'enchère : [Date fin enchères]</p>

                        <form action="AccueilServlet">
                            <div class="vendeur">
                                <label for="pseudoVendeur">Vendeur : </label>
                                <input class="link btn_vendeur" type="submit" name="pseudoVendeur" value="[PSEUDO VENDEUR]" />
                            </div>
                        </form>
                    </div>
                </div>

                <div class="card">
                    <img src="./img/robinet.jpg" alt="" style="object-fit:contain;
                    width:100%;
                    height:200px;
                    border: solid 1px #CCC">
                    <div class="textArticle">
                        <input class="link nomArticle" type="submit" name="pseudoVendeur" value="[NOM ARTICLE]" />
                        <p> Prix : [Prix de l'article] points</p>
                        <p> Fin de l'enchère : [Date fin enchères]</p>

                        <form action="AccueilServlet">
                            <div class="vendeur">
                                <label for="pseudoVendeur">Vendeur : </label>
                                <input class="link btn_vendeur" type="submit" name="pseudoVendeur" value="[PSEUDO VENDEUR]" />
                            </div>
                        </form>
                    </div>
                </div>

                <div class="card">
                    <img src="./img/orange.jpg" alt="" style="object-fit:contain;
                    width:100%;
                    height:200px;
                    border: solid 1px #CCC">
                    <div class="textArticle">
                        <input class="link nomArticle" type="submit" name="pseudoVendeur" value="[NOM ARTICLE]" />
                        <p> Prix : [Prix de l'article] points</p>
                        <p> Fin de l'enchère : [Date fin enchères]</p>

                        <form action="AccueilServlet">
                            <div class="vendeur">
                                <label for="pseudoVendeur">Vendeur : </label>
                                <input class="link btn_vendeur" type="submit" name="pseudoVendeur" value="[PSEUDO VENDEUR]" />
                            </div>
                        </form>
                    </div>
                </div>

                <div class="card">
                    <img src="./img/tournevis.jpg" alt="" style="object-fit:contain;
                    width:100%;
                    height:200px;
                    border: solid 1px #CCC">
                    <div class="textArticle">
                        <input class="link nomArticle" type="submit" name="pseudoVendeur" value="[NOM ARTICLE]" />
                        <p> Prix : [Prix de l'article] points</p>
                        <p> Fin de l'enchère : [Date fin enchères]</p>

                        <form action="AccueilServlet">
                            <div class="vendeur">
                                <label for="pseudoVendeur">Vendeur : </label>
                                <input class="link btn_vendeur" type="submit" name="pseudoVendeur" value="[PSEUDO VENDEUR]" />
                            </div>
                        </form>
                    </div>
                </div>
 
                <div class="card">
                    <img src="./img/jsp.jpg" alt="" style="object-fit:contain;
                    width:100%;
                    height:200px;
                    border: solid 1px #CCC">
                    <div class="textArticle">
                        <input class="link nomArticle" type="submit" name="pseudoVendeur" value="[NOM ARTICLE]" />
                        <p> Prix : [Prix de l'article] points</p>
                        <p> Fin de l'enchère : [Date fin enchères]</p>

                        <form action="AccueilServlet">
                            <div class="vendeur">
                                <label for="pseudoVendeur">Vendeur : </label>
                                <input class="link btn_vendeur" type="submit" name="pseudoVendeur" value="[PSEUDO VENDEUR]" />
                            </div>
                        </form>
                    </div>
                </div>
                <!-- FFFIINNN  TEST-->
            </div>
        </form>
    </div>
</body>

</html>