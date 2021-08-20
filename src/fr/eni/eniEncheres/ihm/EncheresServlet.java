package fr.eni.eniEncheres.ihm;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.eniEncheres.bo.Enchere;

/**
 * Servlet implementation class EncheresServlet
 */
@WebServlet("/EncheresServlet")
public class EncheresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EncheresServlet() {
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
		EncheresModel encheresModel = new EncheresModel(new Enchere(), null);
		UtilisateurModel utilisateurModel = (UtilisateurModel) request.getSession().getAttribute("utilisateurModel");

		if (request.getParameter("encherir") != null) {
			encheresModel.getEnchere().setDateEnchere(LocalDate.now());
			encheresModel.getEnchere().setMontant_enchere(Integer.parseInt(request.getParameter("montant_enchere")));
			encheresModel.getEnchere().getUtilisateur()
					.setNoUtilisateur(utilisateurModel.getUtilisateur().getNoUtilisateur());
			// encheresModel.getEnchere().setNoArticle(noArticle);
		}
	}

}
