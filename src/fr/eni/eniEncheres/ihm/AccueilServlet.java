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
		ArticleVenduModel articleModel = new ArticleVenduModel(new ArticleVendu(), new Retrait(), null);
		String nextPage = "/WEB-INF/index.jsp";
		System.out.println(request.getSession().getAttribute("utilisateurModel"));
		try {
			articleModel.setLstArticles(managerArticle.getAllArticleVendu());
		} catch (BLLException e1) {
			e1.printStackTrace();
		}
		Boolean hidden = false;
		if (request.getSession().getAttribute("utilisateurModel") != null) {
			hidden = true;
		}
		
		System.out.println("KKOKOOKKOKOK :" +articleModel.getLstArticles());
		request.setAttribute("articleModel", articleModel);
		request.getSession().setAttribute("hidden", hidden);
		request.getRequestDispatcher(nextPage).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nextPage = "/WEB-INF/index.jsp";
		Boolean hidden = true;

		UtilisateurModel utilisateurModel = (UtilisateurModel) request.getSession().getAttribute("utilisateurModel");
		ArticleVenduModel articleModel = new ArticleVenduModel(new ArticleVendu(), new Retrait(), null);


		
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
		if (request.getParameter("nomArticle") != null) {
			try {
				articleModel.setArticleVendu(managerArticle.getArticleByName(request.getParameter("nomArticle")));
			} catch (BLLException e) {
				e.printStackTrace();
			}
			request.getSession().setAttribute("article", articleModel);
		}
		
		// BOUTON DECONNEXION
		if (request.getParameter("deco") != null) {
			hidden = false;
			utilisateurModel = null;
		}
		
		request.getSession().setAttribute("hidden", hidden);
		request.getSession().setAttribute("utilisateurModel", utilisateurModel);

		request.getRequestDispatcher(nextPage).forward(request, response);
	}

}
