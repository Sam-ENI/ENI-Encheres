package fr.eni.eniEncheres.ihm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.eniEncheres.bll.BLLException;
import fr.eni.eniEncheres.bll.UtilisateurManager;
import fr.eni.eniEncheres.bll.UtilisateurManagerFactory;
import fr.eni.eniEncheres.bo.Utilisateur;

/**
 * Servlet implementation class LoginUtilisateurServlet
 */
@WebServlet("/ConnexionUtilisateurServlet")
public class ConnexionUtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UtilisateurManager manager = UtilisateurManagerFactory.getInstance();
	Utilisateur u1 = new Utilisateur("lol", "dupont", "jack", "j@dd.com", "021547898", "5 des oui", "44000", "Nantes",
			"1245", 0, false);
	private int cpt = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConnexionUtilisateurServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nextPage = "/WEB-INF/connexion.jsp";

		request.getRequestDispatcher(nextPage).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// AJOUT D'UN ADMIN
		try {
			if (cpt == 0) {
				manager.addUtilisateur(u1);
				cpt++;
			}
		} catch (BLLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String nextPage = "/WEB-INF/connexion.jsp";
		UtilisateurModel utlisateurModel = null;

		if (request.getParameter("Connexion") != null) {
			Utilisateur u = new Utilisateur();
			try {
				// on r�cup�re le param�tre pseudoEmail et on v�rifie s'il est pseudo ou email puis si il existe en BDD
				if (request.getParameter("pseudoEmail").matches(".+@.+\\.[a-z]+")) {
					u = manager.isUserExistEmail(request.getParameter("pseudoEmail"), request.getParameter("mdp"));
				} else {
					u = manager.isUserExistPseudo(request.getParameter("pseudoEmail"), request.getParameter("mdp"));
				}
				if (u != null) {
					utlisateurModel = new UtilisateurModel(new Utilisateur(), null);
					nextPage = "/WEB-INF/index.jsp";
					utlisateurModel.setUtilisateur(u);
					utlisateurModel.setLstUtilisateur(manager.getAllUtilisateur());
				}
			} catch (BLLException e) {
				request.setAttribute("erreur", e.getMessage());
			}
			Boolean hidden = true;
			request.getSession().setAttribute("hidden", hidden);

		}

		if (request.getParameter("Inscription") != null) {
			nextPage = "/WEB-INF/inscription.jsp";
		}

		request.getSession().setAttribute("utlisateurModel", utlisateurModel);
		request.getRequestDispatcher(nextPage).forward(request, response);	}

}
