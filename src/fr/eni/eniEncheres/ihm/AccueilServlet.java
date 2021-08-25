package fr.eni.eniEncheres.ihm;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.eniEncheres.bll.ArticleVenduManager;
import fr.eni.eniEncheres.bll.ArticleVenduManagerFactory;
import fr.eni.eniEncheres.bll.BLLException;
import fr.eni.eniEncheres.bll.CardDecoManager;
import fr.eni.eniEncheres.bll.CardDecoManagerFactory;
import fr.eni.eniEncheres.bll.UtilisateurManager;
import fr.eni.eniEncheres.bll.UtilisateurManagerFactory;
import fr.eni.eniEncheres.bo.ArticleVendu;
import fr.eni.eniEncheres.bo.Categorie;
import fr.eni.eniEncheres.bo.Retrait;
import fr.eni.eniEncheres.dto.Card;

/**
 * Servlet implementation class AccueilServlet
 */
@WebServlet("/AccueilServlet")
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurManager manager = UtilisateurManagerFactory.getInstance();
	private ArticleVenduManager managerArticle = ArticleVenduManagerFactory.getInstance();
	private CardDecoManager managerCard = CardDecoManagerFactory.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AccueilServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArticleVenduModel articleModel = new ArticleVenduModel(new ArticleVendu(), new Retrait(), new Categorie(), null,
				null);
		Boolean defaultCard = true;

		String nextPage = "/WEB-INF/index.jsp";
		try {
			articleModel.setLstArticles(managerArticle.getAllArticleVendu());
		} catch (BLLException e1) {
			e1.printStackTrace();
		}
		Boolean isConnecte = false;
		if (request.getSession().getAttribute("utilisateurModel") != null) {
			isConnecte = true;
		}

		request.setAttribute("defaultCard", defaultCard);
		request.setAttribute("articleModel", articleModel);
		request.getSession().setAttribute("isConnecte", isConnecte);
		request.getRequestDispatcher(nextPage).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nextPage = "/WEB-INF/index.jsp";
		Boolean isConnecte = true;
		Boolean defaultCard = true;

		UtilisateurModel utilisateurModel = (UtilisateurModel) request.getSession().getAttribute("utilisateurModel");
		ArticleVenduModel articleModel = new ArticleVenduModel(new ArticleVendu(), new Retrait(), new Categorie(), null,
				null);

		if (request.getParameter("insci/connex") != null) {
			nextPage = "/WEB-INF/connexion.jsp";
		}

		if (request.getParameter("profil") != null) {
			nextPage = "/WEB-INF/profil.jsp";
		}

		if (request.getParameter("vente") != null) {
			nextPage = "/WEB-INF/nouvelleVente.jsp";
		}

		// CLICK SUR NOM D'UN ARTICLE
		if (request.getParameter("btn_Article") != null) {
			try {
				articleModel.setArticleVendu(managerArticle.getArticleByName(request.getParameter("btn_Article")));
			} catch (BLLException e) {
				e.printStackTrace();
			}
			request.getSession().setAttribute("article", articleModel);

			nextPage = "/WEB-INF/encheres.jsp";
		}

		// BOUTON RECHERCHER
		if (request.getParameter("rechecher") != null) {
			try {
				System.out.println("OK");
				List<Card> lstCard = new ArrayList<>();

				System.out.println("LST 1 " + articleModel.getLstCard());
				// SI une catégorie est choisie
				if (request.getParameter("categorie") != null && !request.getParameter("categorie").equals("toutes")) {
					lstCard = managerCard.addToListIfNotExists(lstCard,
							managerArticle.getListArticleByCat(Integer.parseInt(request.getParameter("categorie"))));
				}

				// SI il y a un nom et une catégorie choisi
				if (request.getParameter("categorie") != null && !request.getParameter("categorie").equals("toutes")
						&& request.getParameter("nomArticle") != null) {
					lstCard = managerCard.addToListIfNotExists(lstCard, managerArticle.getListArticleByCatAndName(
							request.getParameter("nomArticle"), Integer.parseInt(request.getParameter("categorie"))));
				}

				/* BOUTON ACHATS */
				if (request.getParameter("choixFiltre").equals("achats") && utilisateurModel != null ) {
					// Enchères ouvertes
					if (request.getParameter("encheresOuvertes") != null) {
						lstCard = managerCard.getAlltEnchereOuvertes();
					}
					// Mes enchères en cours
					if (request.getParameter("encheresEnCours") != null) {
						lstCard = managerCard.getAllEnchereEnCours(utilisateurModel.getUtilisateur().getNoUtilisateur());
					}
					// Mes enchères remportées
					if (request.getParameter("encheresRemporte") != null) {
						lstCard = managerCard.getAllEnchereRemporter(utilisateurModel.getUtilisateur().getNoUtilisateur());
					}

				}

				/* BOUTON VENTE */
				if (request.getParameter("choixFiltre").equals("ventes")) {
					// Mes ventes en cours
					if (request.getParameter("venteEnCours") != null) {
						lstCard = managerCard.getAllVentesEnCours(utilisateurModel.getUtilisateur().getNoUtilisateur());
					}
					// Mes ventes non débutées
					if (request.getParameter("venteNonDebute") != null) {
						lstCard = managerCard .getAllVentesNonDebuter(utilisateurModel.getUtilisateur().getNoUtilisateur());
					}
					// Mes ventes terminées
					if (request.getParameter("venteTerminer") != null) {
						lstCard = managerCard.getAllVentesTerminer(utilisateurModel.getUtilisateur().getNoUtilisateur());
					}
				}
				System.out.println("LST 2 " + lstCard);

				if (lstCard.isEmpty() ) {
					// SI il y a un nom dans la barre de recherche
					request.setAttribute("lstvide", "Aucune enchère trouvé ! <br> Liste des enchères");
				}
				lstCard=managerArticle.getListArticleByName(request.getParameter("nomArticle"));

				articleModel.setLstCard(lstCard);

			} catch (BLLException e) {
				e.printStackTrace();
			}
			defaultCard = false;
			if (request.getSession().getAttribute("utilisateurModel") != null) {
				isConnecte = true;
			}
			else
				isConnecte = false;

		}

		// BOUTON DECONNEXION
		if (request.getParameter("deco") != null) {
			isConnecte = false;
			utilisateurModel = null;
		}
		request.setAttribute("defaultCard", defaultCard);
		request.setAttribute("articleModel", articleModel);
		request.getSession().setAttribute("isConnecte", isConnecte);
		request.getSession().setAttribute("utilisateurModel", utilisateurModel);
		request.getRequestDispatcher(nextPage).forward(request, response);
	}

}
