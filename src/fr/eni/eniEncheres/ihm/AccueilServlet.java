package fr.eni.eniEncheres.ihm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.eniEncheres.bll.ArticleVenduManager;
import fr.eni.eniEncheres.bll.ArticleVenduManagerFactory;
import fr.eni.eniEncheres.bll.BLLException;
import fr.eni.eniEncheres.bll.UtilisateurManager;
import fr.eni.eniEncheres.bll.UtilisateurManagerFactory;
import fr.eni.eniEncheres.bo.ArticleVendu;
import fr.eni.eniEncheres.bo.Categorie;
import fr.eni.eniEncheres.bo.Retrait;

/**
 * Servlet implementation class AccueilServlet
 */
@WebServlet("/AccueilServlet")
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurManager manager = UtilisateurManagerFactory.getInstance();
	private ArticleVenduManager managerArticle = ArticleVenduManagerFactory.getInstance();

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
		ArticleVenduModel articleModel = new ArticleVenduModel(new ArticleVendu(), new Retrait(), new Categorie(), null, null);
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
		ArticleVenduModel articleModel = new ArticleVenduModel(new ArticleVendu(), new Retrait(), new Categorie(),  null, null);

		
		
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
				articleModel.setArticleVendu(managerArticle.getArticleByName(request.getParameter("nomArticle")));
			} catch (BLLException e) {
				e.printStackTrace();
			}
			request.getSession().setAttribute("article", articleModel);
		
			nextPage = "/WEB-INF/encheres.jsp";
		}
		
		// BOUTON RECHERCHER
		if (request.getParameter("rechecher") != null) {
			
			try {
				// SI il y a un nom dans la barre de recherche
				articleModel.setLstCardbyName(managerArticle.getListArticleByName(request.getParameter("nomArticle")));
				// SI une cat�gorie est choisie
				if (request.getParameter("categorie") != null && !request.getParameter("categorie").equals("toutes")) 
					articleModel.setLstCardbyName(managerArticle.getListArticleByCat(Integer.parseInt(request.getParameter("categorie"))));
				
				// SI il y a un nom et une cat�gorie choisi
				if (request.getParameter("categorie") != null && !request.getParameter("categorie").equals("toutes") && request.getParameter("nomArticle") != null ) 
					articleModel.setLstCardbyName(managerArticle.getListArticleByCatAndName(request.getParameter("nomArticle"),Integer.parseInt(request.getParameter("categorie"))));
				
				
			} catch (BLLException e) {
				e.printStackTrace();
			}
			defaultCard = false;
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
