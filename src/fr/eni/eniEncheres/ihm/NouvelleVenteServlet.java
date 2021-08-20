package fr.eni.eniEncheres.ihm;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.eniEncheres.bll.ArticleVenduManagerFactory;
import fr.eni.eniEncheres.bll.BLLException;
import fr.eni.eniEncheres.bll.ArticleVenduManager;
import fr.eni.eniEncheres.bo.ArticleVendu;
import fr.eni.eniEncheres.bo.Retrait;

/**
 * Servlet implementation class NouvelleVenteServlet
 */
@WebServlet("/NouvelleVenteServlet")
public class NouvelleVenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleVenduManager manager = ArticleVenduManagerFactory.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NouvelleVenteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nextPage = "/WEB-INF/nouvelleVente.jsp";
		request.getRequestDispatcher(nextPage).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nextPage = "/WEB-INF/nouvelleVente.jsp";
		ArticleVenduModel articleVenduModel = new ArticleVenduModel(new ArticleVendu(), new Retrait(), null);
		UtilisateurModel utilisateurModel = (UtilisateurModel) request.getSession().getAttribute("utilisateurModel");

		if (request.getParameter("enregister") != null) {
			System.out.println(request.getParameter("categorie"));
			System.out.println((request.getParameter("categorie")).getClass());
			articleVenduModel.getArticleVendu().setNomArticle(request.getParameter("article"));
			articleVenduModel.getArticleVendu().setDescription(request.getParameter("description"));
			// conversion String en LocalDate
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String date = request.getParameter("dateDebutEncheres");
			LocalDate localDate = LocalDate.parse(date, formatter);
			articleVenduModel.getArticleVendu().setDateDebutEncheres(localDate);

			String date2 = request.getParameter("dateFinEncheres");
			LocalDate localDate2 = LocalDate.parse(date2, formatter);
			articleVenduModel.getArticleVendu().setDateFinEncheres(localDate2);
			articleVenduModel.getArticleVendu().setMiseAprix(Integer.parseInt(request.getParameter("miseAprix")));
			// articleVenduModel.getArticleVendu().setPrixVente(Integer.parseInt(request.getParameter("prixVente")));
			articleVenduModel.getArticleVendu().setEtatVente(false);
			articleVenduModel.getArticleVendu().setNoUtilisateur(utilisateurModel.getUtilisateur().getNoUtilisateur());
			articleVenduModel.getRetrait().setRue(request.getParameter("rue"));
			articleVenduModel.getRetrait().setCode_postal(request.getParameter("codePostal"));
			articleVenduModel.getRetrait().setVille(request.getParameter("ville"));
			articleVenduModel.getRetrait().setNoArticle(articleVenduModel.getArticleVendu().getNoArticle());

			switch (request.getParameter("categorie")) {
			case "informatique":
				articleVenduModel.getArticleVendu().setNoCategorie(1);

				break;
			case "ameublement":
				articleVenduModel.getArticleVendu().setNoCategorie(2);

				break;
			case "vetement":
				articleVenduModel.getArticleVendu().setNoCategorie(3);

				break;
			case "sportloisirs":
				articleVenduModel.getArticleVendu().setNoCategorie(4);

				break;

			}
			try {
				manager.addArticleVendu(articleVenduModel.getArticleVendu());
			} catch (BLLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				articleVenduModel.setLstArticles(manager.getAllArticleVendu());
			} catch (BLLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher(nextPage).forward(request, response);
		}
		System.out.println(articleVenduModel.getArticleVendu());

	}

}
