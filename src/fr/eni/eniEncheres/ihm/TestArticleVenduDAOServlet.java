package fr.eni.eniEncheres.ihm;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.eniEncheres.bo.ArticleVendu;
import fr.eni.eniEncheres.bo.Categorie;
import fr.eni.eniEncheres.bo.Enchere;
import fr.eni.eniEncheres.bo.Utilisateur;
import fr.eni.eniEncheres.dal.ArticleVenduDAO;
import fr.eni.eniEncheres.dal.ArticleVenduDAOFact;
import fr.eni.eniEncheres.dal.DALException;
import fr.eni.eniEncheres.dal.EnchereDAO;
import fr.eni.eniEncheres.dal.EnchereDAOFact;

/**
 * Servlet implementation class TestArticleVenduDAOServlet
 */
@WebServlet("/TestArticleVenduDAOServlet")
public class TestArticleVenduDAOServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestArticleVenduDAOServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//ArticleVenduDAO daoArticleVendu = ArticleVenduDAOFact.getInstanceDAO();
	//ArticleVendu articleVendu = new ArticleVendu("guitare","Fender Stratocaster", LocalDate.of(2021, 8, 20),LocalDate.of(2021, 8, 27),2500,3300,"TBE",2,2);
//		try {
//			daoArticleVendu.insert(articleVendu);
//			;
//		} catch (DALException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		request.getRequestDispatcher("/WEB-INF/profil.jsp").forward(request, response);
//	Enchere enchere1 = new Enchere( LocalDate.of(2021, 8, 20),2666,new Utilisateur(102,"lol", "dupont", "jack", "j@dd.com", "021547898", "5 des oui", "44000", "Nantes",
//			"1245", 0, false),new ArticleVendu(2, "guitare", "Fender Stratocaster",  LocalDate.of(2021, 8, 20),
//					 LocalDate.of(2021, 8, 27),2500, 3300, null, new Utilisateur(102,"lol", "dupont", "jack", "j@dd.com", "021547898", "5 des oui", "44000", "Nantes",
//								"1245", 0, false),
//					new Categorie("informatique")));
//	Enchere enchere2 = new Enchere( LocalDate.of(2021, 12, 06),3333,new Utilisateur(3589,"lol", "dupont", "jack", "j@dd.com", "021547898", "5 des oui", "44000", "Nantes",
//			"1245", 0, false),new ArticleVendu(7777, "ballon", "rouge",  LocalDate.of(2021, 12, 07),
//					 LocalDate.of(2022, 12, 06),250, 256, false, new Utilisateur(2699,"lol", "dupont", "jack", "j@dd.com", "021547898", "5 des oui", "44000", "Nantes",
//								"1245", 0, false),
//					new Categorie("informatique")));
//	LocalDate dateEnchere;
//	Integer montant_enchere;
//	Utilisateur utilisateur;
//	ArticleVendu articleVendu;
	EnchereDAO daoEnchere = EnchereDAOFact.getInstanceDAO();

	} 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
