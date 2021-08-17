package fr.eni.eniEncheres.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.eniEncheres.bo.Utilisateur;

/**
 * Servlet implementation class CreationCompteServlet
 */
@WebServlet("/CreationCompteServlet")
public class CreationCompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreationCompteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nextPage = "/WEB-INF/incription.jsp";
		UtilisateurModel model = (UtilisateurModel) request.getSession().getAttribute("model");
		if (model == null) {
			model = new UtilisateurModel(new Utilisateur(), null);
			if (request.getParameter("creer") != null) {
				model.getUtilisateur().setNoUtilsateur(Integer.parseInt(request.getParameter("name")));
				model.getUtilisateur().setPseudo(request.getParameter("pseudo"));
				model.getUtilisateur().setNom(request.getParameter("nom"));
				model.getUtilisateur().setPrenom(request.getParameter("prenom"));
				model.getUtilisateur().setEmail(request.getParameter("email"));
				model.getUtilisateur().setTelephone(request.getParameter("telephone"));
				model.getUtilisateur().setRue(request.getParameter("rue"));
				model.getUtilisateur().setCodePostal(request.getParameter("codePostal"));
				model.getUtilisateur().setVille(request.getParameter("ville"));
				model.getUtilisateur().setMotDePasse(request.getParameter("mdp"));
				model.getUtilisateur().setCredit(Integer.parseInt(request.getParameter("credit")));
				model.getUtilisateur().setAdministrateur(Boolean.parseBoolean(request.getParameter("administrateur")));
				nextPage = "/WEB-INF/index.jsp";
				
			}
			if(request.getParameter("annuler") != null) {
				nextPage = "/WEB-INF/index.jsp";
			}
		}
		request.getSession().setAttribute("model", model);
		request.getRequestDispatcher(nextPage).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
