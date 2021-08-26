<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>

<head>
    <link href="./css/enchere.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Nouvelle Vente</title>
</head>

<body>
    <form action="EnchereServlet" method="POST">
        <%@ include file="logo.jsp"%>
    </form>

    <div class="page_cont">
        <c:if test="${not empty erreurs }">
            <div class="cont_alert">
                <div class="alert">
                    <p style="font-weight: bold;">Il y a des erreurs :</p>
                    <ul>
                        <c:forEach items="${erreurs}" var="e">
                            <li>${e}</li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </c:if>
        <div class="cont_reste">
            <div class="image">
                <img src="" alt="image de l'objet en vente">
            </div>
            <div>
                <form action="EnchereServlet" method="post">
                    <div class="container">
                        <div class="form_cont">
                            <ul class="flex-outer">
                            <li>
                                 <div class="boxTitre"> 
                                    <h3>${enchere.articleVendu.nomArticle}</h3>
                                </div>
                            </li>
                                <li class="desc">
                                    <div class="text_area">${enchere.articleVendu.description}</div>
                                </li>
                                <li>
                                    <h3>Categorie :</h3>
                                    <p>${enchere.articleVendu.categorie.libelle}</p>
                                </li>
                                <li>
                                    <h3>Meilleur offre :</h3>
                                    <p>${enchere.montant_enchere} pts par ${enchere.utilisateur.pseudo}</p>
                                </li>
                                <li>
                                    <h3>Mise à prix : </h3>
                                    <p>${enchere.articleVendu.miseAprix} points</p>
                                </li>
                                <li>
                                    <h3>Fin de l'enchère : </h3>
                                    <p>${enchere.articleVendu.dateFinEncheres}</p>
                                </li>
                                <li>
                                    <h3>Retrait : </h3>
                                    <p>${retrait.rue} <br>${retrait.code_postal} ${retrait.ville}</p>
                                </li>
                                <li>
                                    <h3>Vendeur : </h3>
                                    <p>${enchere.articleVendu.utilisateur.pseudo}</p>
                                </li>
                                <li>
                                    <h3>Ma proposition : </h3>
                                    <input type="number" name="montant_enchere">
                                </li>
                            </ul>
                        </div>


                        <div class="btn">
                            <input type="submit" name="encherir" value="Encherir">
                        </div>
                    </div>

                </form>

            </div>
        </div>

    </div>


</body>

</html>