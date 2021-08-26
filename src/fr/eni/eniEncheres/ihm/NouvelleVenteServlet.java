package fr.eni.eniEncheres.ihm;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.eniEncheres.bll.ArticleVenduManagerFactory;
import fr.eni.eniEncheres.bll.BLLException;
import fr.eni.eniEncheres.bll.CardDecoManager;
import fr.eni.eniEncheres.bll.CardDecoManagerFactory;
import fr.eni.eniEncheres.bll.EnchereManager;
import fr.eni.eniEncheres.bll.EnchereManagerFact;
import fr.eni.eniEncheres.bll.ArticleVenduManager;
import fr.eni.eniEncheres.bo.ArticleVendu;
import fr.eni.eniEncheres.bo.Categorie;
import fr.eni.eniEncheres.bo.Enchere;
import fr.eni.eniEncheres.bo.Retrait;
import fr.eni.eniEncheres.bo.Utilisateur;
import fr.eni.eniEncheres.dal.EnchereDAOFact;

/**
 * Servlet implementation class NouvelleVenteServlet
 */
@WebServlet("/NouvelleVenteServlet")
public class NouvelleVenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleVenduManager manager = ArticleVenduManagerFactory.getInstance();
	private EnchereManager enchereManager = EnchereManagerFact.getInstance();
	private CardDecoManager managerCard = CardDecoManagerFactory.getInstance();

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
		UtilisateurModel utilisateurModel = (UtilisateurModel) request.getSession().getAttribute("utilisateurModel");
		request.setAttribute("utilisateurModel", utilisateurModel);
		request.getRequestDispatcher(nextPage).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nextPage = "/WEB-INF/nouvelleVente.jsp";
		ArticleVenduModel articleVenduModel = new ArticleVenduModel(new ArticleVendu(), new Retrait(), new Categorie(),
				null, null);
		UtilisateurModel utilisateurModel = (UtilisateurModel) request.getSession().getAttribute("utilisateurModel");
		EnchereModel enchereModel = new EnchereModel(new Enchere( LocalDateTime.now(),0,new Utilisateur(),new ArticleVendu()),null);
		ArticleVenduModel articleModel = new ArticleVenduModel(new ArticleVendu(), new Retrait(), new Categorie(), null,
				null);

		if (request.getParameter("enregister") != null) {
			System.out.println(request.getParameter("utilisateurModel"));
			System.out.println((request.getParameter("categorie")).getClass());

			articleVenduModel.getArticleVendu().setNomArticle(request.getParameter("article"));
			articleVenduModel.getArticleVendu().setDescription(request.getParameter("description"));
			// conversion String en LocalDate
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String date = request.getParameter("dateDebutEncheres");
			
			LocalDate localDate = LocalDate.parse(date, formatter);
			LocalDateTime ldt = localDate.atStartOfDay();
			
			articleVenduModel.getArticleVendu().setDateDebutEncheres(localDate);
			String date2 = request.getParameter("dateFinEncheres");
			LocalDate localDate2 = LocalDate.parse(date2, formatter);
			articleVenduModel.getArticleVendu().setDateFinEncheres(localDate2);
			articleVenduModel.getArticleVendu().setMiseAprix(Integer.parseInt(request.getParameter("miseAprix")));
			// articleVenduModel.getArticleVendu().setPrixVente(Integer.parseInt(request.getParameter("prixVente")));
			articleVenduModel.getArticleVendu().setEtatVente(false);
			articleVenduModel.getArticleVendu().setUtilisateur(utilisateurModel.getUtilisateur());
			switch (request.getParameter("categorie")) {
			case "informatique":
				System.out.println("C RENTRERRRRRR");
				try {
					articleVenduModel.getArticleVendu().setCategorie(manager.getCategById(1));
				} catch (BLLException e1) {
					e1.printStackTrace();
				}
				break;
			case "ameublement":
				try {
					articleVenduModel.getArticleVendu().setCategorie(manager.getCategById(2));
				} catch (BLLException e1) {
					e1.printStackTrace();
				}

				break;
			case "vetement":
				try {
					articleVenduModel.getArticleVendu().setCategorie(manager.getCategById(3));
				} catch (BLLException e1) {
					e1.printStackTrace();
				}

				break;
			case "sportloisirs":
				try {
					articleVenduModel.getArticleVendu().setCategorie(manager.getCategById(4));
				} catch (BLLException e1) {
					e1.printStackTrace();
				}
				break;
				
			}
			System.out.println(localDate);
			//enchereModel
			enchereModel.getEnchere().setDateEnchere(ldt);
			enchereModel.getEnchere().setMontant_enchere(Integer.parseInt(request.getParameter("miseAprix")));
			enchereModel.getEnchere().setUtilisateur(utilisateurModel.getUtilisateur());
			enchereModel.getEnchere().setArticleVendu(articleVenduModel.getArticleVendu());
			System.out.println(enchereModel + " " + "nouvelleServlet");
			
			
			
			System.out.println(articleVenduModel);
			try {
				manager.addArticleVendu(articleVenduModel.getArticleVendu());
				articleVenduModel.setLstArticles(manager.getAllArticleVendu());
				enchereManager.addEnchere(enchereModel.getEnchere());
				enchereModel.setLstEncheres(enchereManager.getAllEnchere());
			} catch (BLLException e) {
				e.printStackTrace();
			}

			// CREATION RETRAIT DE l'ARTICLE
			articleVenduModel.getRetrait().setRue(request.getParameter("rue"));
			articleVenduModel.getRetrait().setCode_postal(request.getParameter("codePostal"));
			articleVenduModel.getRetrait().setVille(request.getParameter("ville"));
			articleVenduModel.getRetrait().setArticleVendu(articleVenduModel.getArticleVendu());
			
			//request.getSession().setAttribute("enchereModel", enchereModel);
			 nextPage = "/WEB-INF/index.jsp";
		//	 request.setAttribute("utilisateurModel", utilisateurModel);
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
		
		request.getRequestDispatcher(nextPage).forward(request, response);
	}
}
