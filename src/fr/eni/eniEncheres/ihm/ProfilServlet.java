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
import fr.eni.eniEncheres.bo.ArticleVendu;
import fr.eni.eniEncheres.bo.Categorie;
import fr.eni.eniEncheres.bo.Retrait;

/**
 * Servlet implementation class ProfilServlet
 */
@WebServlet("/ProfilServlet")
public class ProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CardDecoManager managerCard = CardDecoManagerFactory.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProfilServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nextPage = "/WEB-INF/profil.jsp";
		UtilisateurModel utilisateurModel = (UtilisateurModel) request.getSession().getAttribute("utilisateurModel");
		request.getSession().setAttribute("utilisateurModel", utilisateurModel);
		request.getRequestDispatcher(nextPage).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nextPage = "/WEB-INF/profil.jsp";
		UtilisateurModel utilisateurModel = (UtilisateurModel) request.getSession().getAttribute("utilisateurModel");
		ArticleVenduModel articleModel = new ArticleVenduModel(new ArticleVendu(), new Retrait(), new Categorie(), null,
				null);
		// BOUTON MODIFIER
		if (request.getParameter("modifierBtn") != null) {
			nextPage = "/WEB-INF/modifierProfil.jsp";
		}
		if (request.getParameter("logo") != null) {
			try {
				articleModel.setLstCard(managerCard.getAllCardByNom(""));
			} catch (BLLException e1) {
				e1.printStackTrace();
			}
			nextPage = "/WEB-INF/index.jsp";
		}

		request.setAttribute("articleModel", articleModel);

		request.getSession().setAttribute("utilisateurModel", utilisateurModel);
		request.getRequestDispatcher(nextPage).forward(request, response);
	}

}
