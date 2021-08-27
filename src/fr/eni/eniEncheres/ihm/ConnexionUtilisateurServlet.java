package fr.eni.eniEncheres.ihm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.eniEncheres.bll.BLLException;
import fr.eni.eniEncheres.bll.CardDecoManager;
import fr.eni.eniEncheres.bll.CardDecoManagerFactory;
import fr.eni.eniEncheres.bll.UtilisateurManager;
import fr.eni.eniEncheres.bll.UtilisateurManagerFactory;
import fr.eni.eniEncheres.bo.ArticleVendu;
import fr.eni.eniEncheres.bo.Categorie;
import fr.eni.eniEncheres.bo.Retrait;
import fr.eni.eniEncheres.bo.Utilisateur;

/**
 * Servlet implementation class LoginUtilisateurServlet
 */
@WebServlet("/ConnexionUtilisateurServlet")
public class ConnexionUtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UtilisateurManager manager = UtilisateurManagerFactory.getInstance();
	private CardDecoManager managerCard = CardDecoManagerFactory.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConnexionUtilisateurServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nextPage = "/WEB-INF/connexion.jsp";

		request.getRequestDispatcher(nextPage).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nextPage = "/WEB-INF/connexion.jsp";
		UtilisateurModel utilisateurModel = null;
		Boolean isConnecte = false;
		ArticleVenduModel articleModel = new ArticleVenduModel(new ArticleVendu(), new Retrait(), new Categorie(), null,
				null);
		if (request.getParameter("Connexion") != null) {
			Utilisateur u = new Utilisateur();
			try {
				// on récupère le paramètre pseudoEmail et on vérifie s'il est pseudo ou email
				// puis si il existe en BDD
				if (request.getParameter("pseudoEmail").matches(".+@.+\\.[a-z]+")) {
					u = manager.isUserExistEmail(request.getParameter("pseudoEmail"), request.getParameter("mdp"));
				} else {
					u = manager.isUserExistPseudo(request.getParameter("pseudoEmail"), request.getParameter("mdp"));
				}
				if (u != null) {
					utilisateurModel = new UtilisateurModel(new Utilisateur(), null);
					nextPage = "/WEB-INF/index.jsp";
					utilisateurModel.setUtilisateur(u);
					utilisateurModel.setLstUtilisateur(manager.getAllUtilisateur());
				}
			} catch (BLLException e) {
				request.setAttribute("erreur", e.getMessage());
			}
			isConnecte = true;
			try {
				articleModel.setLstCard(managerCard.getAllCardByNom(""));
			} catch (BLLException e) {
				e.printStackTrace();
			}
		}

		if (request.getParameter("Inscription") != null) {
			nextPage = "/WEB-INF/inscription.jsp";
		}

		if (request.getParameter("logo") != null) {
			try {
				articleModel.setLstCard(managerCard.getAllCardByNom(""));
			} catch (BLLException e1) {
				e1.printStackTrace();
			}
			nextPage = "/WEB-INF/index.jsp";
		}

		request.getSession().setAttribute("isConnecte", isConnecte);
		request.setAttribute("articleModel", articleModel);
		request.getSession().setAttribute("utilisateurModel", utilisateurModel);
		request.getRequestDispatcher(nextPage).forward(request, response);
	}

}
