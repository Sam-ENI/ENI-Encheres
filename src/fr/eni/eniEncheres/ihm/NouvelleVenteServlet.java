package fr.eni.eniEncheres.ihm;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NouvelleVenteServlet
 */
@WebServlet("/NouvelleVenteServlet")
public class NouvelleVenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		ArticleVenduModel articleVenduModel = new ArticleVenduModel();
		UtilisateurModel utilisateurModel = (UtilisateurModel)request.getSession().getAttribute("utlisateurModel");

		if (request.getParameter("enregister") != null) {
			articleVenduModel.getArticleVendu().setNomArticle(request.getParameter("nomArticle"));
			articleVenduModel.getArticleVendu().setDescription(request.getParameter("description"));
			// conversion String en LocalDate 
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String date = request.getParameter("dateDebutEncheres");
			LocalDate localDate = LocalDate.parse(date, formatter);
			articleVenduModel.getArticleVendu().setDateDebutEncheres(localDate);
			
			String date2 = request.getParameter("dateFinEncheres");
			LocalDate localDate2 = LocalDate.parse(date, formatter);
			//articleVenduModel.getArticleVendu().setFinEncheres(localDate);
			articleVenduModel.getArticleVendu().setMiseAprix(Integer.parseInt(request.getParameter("miseAprix")));
		}

	}

}
