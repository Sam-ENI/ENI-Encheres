package fr.eni.eniEncheres.ihm;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.eniEncheres.bll.BLLException;
import fr.eni.eniEncheres.bll.BLLExceptionList;
import fr.eni.eniEncheres.bll.CardDecoManager;
import fr.eni.eniEncheres.bll.CardDecoManagerFactory;
import fr.eni.eniEncheres.bll.EnchereManager;
import fr.eni.eniEncheres.bll.EnchereManagerFact;
import fr.eni.eniEncheres.bo.ArticleVendu;
import fr.eni.eniEncheres.bo.Enchere;
import fr.eni.eniEncheres.bo.Utilisateur;

/**
 * Servlet implementation class EncheresServlet
 */
@WebServlet("/EnchereServlet")
public class EnchereServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EnchereManager enchereManager = EnchereManagerFact.getInstance();
	private CardDecoManager managerCard = CardDecoManagerFactory.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EnchereServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nextPage = "/WEB-INF/encheres.jsp";
		request.getRequestDispatcher(nextPage).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nextPage = "/WEB-INF/encheres.jsp";
		EnchereModel enchereModel = new EnchereModel(
				new Enchere(LocalDateTime.now(), 0, new Utilisateur(), new ArticleVendu()), null);
		ArticleVenduModel articleModel = (ArticleVenduModel) request.getSession().getAttribute("article");
		UtilisateurModel utilisateurModel = (UtilisateurModel) request.getSession().getAttribute("utilisateurModel");
		Enchere enchSauvegarde = null;

		if (request.getParameter("encherir") != null) {
		
			enchSauvegarde = enchereManager.selectEncherebyNoArticle(articleModel.getArticleVendu().getNoArticle());
			try {
				if (enchereManager.verifSaisieEnchere(request.getParameter("montant_enchere"),articleModel)) {
					

					enchereModel.getEnchere().setDateEnchere(LocalDateTime.now());
					enchereModel.getEnchere()
							.setMontant_enchere(Integer.parseInt(request.getParameter("montant_enchere")));
					enchereModel.getEnchere().setUtilisateur(utilisateurModel.getUtilisateur());
					enchereModel.getEnchere().setArticleVendu(articleModel.getArticleVendu());
					// daoAticle.getArticleVenduById(Integer.parseInt(rs.getString("no_article")))

					enchereManager.updateEnchere(enchereModel ,enchSauvegarde, request.getParameter("montant_enchere"),articleModel);

					enchereManager.crediterUtilsateur(articleModel, enchSauvegarde,
							enchSauvegarde.getMontant_enchere());

					enchereManager.debiterUtilisateur(enchereModel.getEnchere(),
							Integer.parseInt(request.getParameter("montant_enchere")));
				}
			} catch (BLLExceptionList e) {
				System.out.println(e);
				request.setAttribute("erreurs", e.getMessages());
				e.printStackTrace();
			}catch (BLLException e) {
				System.out.println(e);
				request.setAttribute("erreur", e.getMessage());
				e.printStackTrace();
			}

		}
		request.setAttribute("enchSauvegarde", enchSauvegarde);
		nextPage = "/WEB-INF/encheres.jsp";
		if (request.getParameter("logo") != null) {
			try {
				articleModel.setLstCard(managerCard.getAllCardByNom(""));
			} catch (BLLException e1) {
				e1.printStackTrace();
			}
			nextPage = "/WEB-INF/index.jsp";
		}
		
		request.setAttribute("articleModel", articleModel);
		
		request.getRequestDispatcher(nextPage).forward(request, response);
	}

}
