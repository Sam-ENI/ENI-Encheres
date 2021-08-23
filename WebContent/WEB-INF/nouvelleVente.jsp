<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <link href="./css/nouvelleVente.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Nouvelle Vente</title>
</head>

<body>
    <h1>ENI-Encheres</h1>

    <div class="page_cont">
        <div class="alert <c:if test="${erreur == null}"> hidden </c:if>">
            <span class="closebtn">${erreur}</span>
        </div>
        <div class="image">
            <img src="" alt="image de l'objet en vente">
        </div>
        <div>
            <form action="NouvelleVenteServlet" method="post">
             <div class="container">
                    <div class="form_cont">
                        <ul class="flex-outer">
                            <li>
                                <label for="article">Article : </label> <input type="text" name="article">

                            </li>
                            <li>
                                <label for="description">Description: </label>
                                <textarea id="textarea" name="description" rows="5" cols="33"></textarea>
                            </li>
                            <li>
                                <p>Categorie :</p>
                                <select name="categorie" id="categorie">
                                        <option value="toutes">Toutes</option>
                                        <option value="informatique">Informatique</option>
                                        <option value="ameublement">Ameublement</option>
                                        <option value="vetement">Vêtement</option>
                                        <option value="sportloisirs">Sport&Loisirs</option>
                                    </select>
                            </li>
                            <li>
                                <label for="uploader">Photo de l'article </label> <input type="submit" name="uploader" value="uploader photo">
                            </li>
                            <li>
                                <label for="miseAprix">Mise à prix : </label> <input type="number" name="miseAprix">
                            </li>
                            <li>
                                <label for="debutEnchere">Début de l'enchère :</label> <input type="date" name="dateDebutEncheres">
                            </li>
                            <li>
                                <label for="finEnchere">Fin de l'enchère : </label> <input type="date" name="dateFinEncheres">
                            </li>

                        </ul>

                    </div>
                    <h3>Retrait</h3>
                    <div class="retrait">
                        <ul class="flex-outer">
                            <li>
                                <label for="rue">Rue : </label> <input type="text" name="rue" value="${utilisateurModel.utilisateur.rue}">
                            </li>
                            <li>
                                <label for="codePostal">Code postal : </label> <input type="text" name="codePostal" value="${utilisateurModel.utilisateur.codePostal}">
                            </li>
                            <li>
                                <label for="Ville">Ville : </label> <input type="text" name="ville" value="${utilisateurModel.utilisateur.ville}">
                            </li>
                        </ul>

                    </div>

                    <div class="btn">
                        <input type="submit" name="enregister" value="Enregister">
                        <input type="submit" name="annuler" value="Annuler">
                    </div>
                </div>
            
            </form>
               
        </div>
    </div>


</body>

</html>