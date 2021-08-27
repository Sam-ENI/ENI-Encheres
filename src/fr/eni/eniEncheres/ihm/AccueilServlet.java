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
import fr.eni.eniEncheres.bll.EnchereManager;
import fr.eni.eniEncheres.bll.EnchereManagerFact;
import fr.eni.eniEncheres.bo.ArticleVendu;
import fr.eni.eniEncheres.bo.Categorie;
import fr.eni.eniEncheres.bo.Enchere;
import fr.eni.eniEncheres.bo.Retrait;
import fr.eni.eniEncheres.dto.Card;

/**
 * Servlet implementation class AccueilServlet
 */
@WebServlet("/AccueilServlet")
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleVenduManager managerArticle = ArticleVenduManagerFactory.getInstance();
	private CardDecoManager managerCard = CardDecoManagerFactory.getInstance();
	private EnchereManager enchereManager = EnchereManagerFact.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AccueilServlet() {
		super();
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
		UtilisateurModel utilisateurModel = (UtilisateurModel) request.getSession().getAttribute("utilisateurModel");
		String nextPage = "/WEB-INF/index.jsp";
		try {
			articleModel.setLstCard(managerCard.getAllCardByNom(""));
		} catch (BLLException e1) {
			e1.printStackTrace();
		}
		Boolean isConnecte = false;
		if (request.getSession().getAttribute("utilisateurModel") != null) {
			isConnecte = true;
		}

		request.setAttribute("defaultCard", defaultCard);
		request.setAttribute("articleModel", articleModel);

		request.getSession().setAttribute("utilisateurModel", utilisateurModel);
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
		String lstvide = null;
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
				articleModel.setArticleVendu(
						managerArticle.getArticleVenduById(Integer.parseInt(request.getParameter("idArticle"))));
				request.setAttribute("retrait",
						managerArticle.getRetraitByNoArticle(Integer.parseInt(request.getParameter("idArticle"))));
			} catch (BLLException e) {
				e.printStackTrace();
			}
			Enchere t = enchereManager.selectEncherebyNoArticle(Integer.parseInt(request.getParameter("idArticle")));

			request.getSession().setAttribute("article", articleModel);
			request.getSession().setAttribute("enchere", t);
			nextPage = "/WEB-INF/encheres.jsp";
		}

		// BOUTON RECHERCHER
		if (request.getParameter("rechecher") != null) {
			List<Card> lstAchats = new ArrayList<>();
			List<Card> lstVentes = new ArrayList<>();

			try {

				List<Card> lstCard = new ArrayList<>();

				// Si un nom est choisie et la catégorie est pas égale à "toutes"
				if (request.getParameter("nomArticle") != null && request.getParameter("categorie").equals("toutes")) {
					lstCard = managerCard.getAllCardByNom(request.getParameter("nomArticle"));
				}

				// SI une catégorie est choisie et est pas égale à "toutes"
				if (request.getParameter("categorie") != null && !request.getParameter("categorie").equals("toutes")
						&& request.getParameter("nomArticle").length() == 0) {
					List<Card> c = managerCard.getAllCardByCat(Integer.parseInt(request.getParameter("categorie")));
					lstCard = managerCard.addToListIfNotExists(lstCard, c);
				}

				// SI il y a un nom et une catégorie choisi
				if (request.getParameter("categorie") != null && !request.getParameter("categorie").equals("toutes")
						&& request.getParameter("nomArticle").length() != 0) {
					lstCard = managerCard.addToListIfNotExists(lstCard, managerArticle.getListArticleByCatAndName(
							request.getParameter("nomArticle"), Integer.parseInt(request.getParameter("categorie"))));
				}

				/* BOUTON ACHATS */
				if (request.getParameter("choixFiltre").equals("achats") && utilisateurModel != null
						&& (request.getParameter("encheresOuvertes") != null
								|| request.getParameter("encheresEnCours") != null
								|| request.getParameter("encheresRemporte") != null)) {
					// Enchères ouvertes
					if (request.getParameter("encheresOuvertes") != null) {
						List<Card> c = managerCard.getAlltEnchereOuvertes();
						lstAchats = managerCard.addToListIfNotExists(lstAchats, c);
					}
					// Mes enchères en cours
					if (request.getParameter("encheresEnCours") != null) {
						List<Card> c = managerCard
								.getAllEnchereEnCours(utilisateurModel.getUtilisateur().getNoUtilisateur());
						lstAchats = managerCard.addToListIfNotExists(lstAchats, c);

					}
					// Mes enchères remportées
					if (request.getParameter("encheresRemporte") != null) {
						List<Card> c = managerCard
								.getAllEnchereRemporter(utilisateurModel.getUtilisateur().getNoUtilisateur());
						lstAchats = managerCard.addToListIfNotExists(lstAchats, c);
					}
					lstAchats = managerCard.filterByNomContains(lstAchats, request.getParameter("nomArticle"));
					if (!request.getParameter("categorie").equals("toutes")) {
						lstAchats = managerCard.filterByCateg(lstAchats,
								Integer.parseInt(request.getParameter("categorie")));
					}
					lstCard = lstAchats;
				}

				/* BOUTON VENTE */
				if (request.getParameter("choixFiltre").equals("ventes")) {
					// Mes ventes en cours
					if (request.getParameter("venteEnCours") != null) {
						List<Card> c = managerCard
								.getAllVentesEnCours(utilisateurModel.getUtilisateur().getNoUtilisateur());
						lstVentes = managerCard.addToListIfNotExists(lstVentes, c);
					}
					// Mes ventes non débutées
					if (request.getParameter("venteNonDebute") != null) {
						List<Card> c = managerCard
								.getAllVentesNonDebuter(utilisateurModel.getUtilisateur().getNoUtilisateur());
						lstVentes = managerCard.addToListIfNotExists(lstVentes, c);
					}
					// Mes ventes terminées
					if (request.getParameter("venteTerminer") != null) {
						List<Card> c = managerCard
								.getAllVentesTerminer(utilisateurModel.getUtilisateur().getNoUtilisateur());
						lstVentes = managerCard.addToListIfNotExists(lstVentes, c);
					}
					lstVentes = managerCard.filterByNomContains(lstVentes, request.getParameter("nomArticle"));

					if (!request.getParameter("categorie").equals("toutes")) {
						lstVentes = managerCard.filterByCateg(lstVentes,
								Integer.parseInt(request.getParameter("categorie")));
					}
					lstCard = lstVentes;
				}

				// SI AUCUN RESULAT TROUVER AFFICHE MESSAGE
				if (lstCard.size() == 0) {
					// SI il y a un nom dans la barre de recherche
					lstvide = "Aucun résulat trouvé ! <br>        Liste des enchères : ";
					lstCard = managerCard.getAllCardByNom("");
				}

				articleModel.setLstCard(lstCard);

			} catch (BLLException e) {
				e.printStackTrace();
			}
			if (request.getSession().getAttribute("utilisateurModel") != null)
				isConnecte = true;
			else
				isConnecte = false;

		}

		// BOUTON DECONNEXION
		if (request.getParameter("deco") != null) {
			try {
				articleModel.setLstCard(managerCard.getAllCardByNom(""));
			} catch (BLLException e1) {
				e1.printStackTrace();
			}
			isConnecte = false;
			utilisateurModel = null;
		}

		if (request.getParameter("logo") != null) {
			try {
				articleModel.setLstCard(managerCard.getAllCardByNom(""));
			} catch (BLLException e1) {
				e1.printStackTrace();
			}
			if (utilisateurModel != null)
				isConnecte = true;
			else
				isConnecte = false;
			nextPage = "/WEB-INF/index.jsp";
		}

		request.setAttribute("lstvide", lstvide);
		request.setAttribute("articleModel", articleModel);
		request.getSession().setAttribute("isConnecte", isConnecte);
		request.getSession().setAttribute("utilisateurModel", utilisateurModel);
		request.getRequestDispatcher(nextPage).forward(request, response);
	}

}
