package fr.eni.eniEncheres.IHM;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.eniEncheres.BLL.BLLException;
import fr.eni.eniEncheres.BLL.UtilisateurManager;
import fr.eni.eniEncheres.BLL.UtilisateurManagerSingl;
import fr.eni.eniEncheres.BO.Utilisateur;

/**
 * Servlet implementation class LoginUtilisateurServlet
 */
@WebServlet("/ConnexionUtilisateurServlet")
public class ConnexionUtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UtilisateurManager manager = UtilisateurManagerSingl.getInstance();
	Utilisateur u1 = new Utilisateur("lol", "dupont", "jack", "j@dd.com", "021547898", "5 des oui", "44000", "Nantes",
			"1245", 0, false);

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

		try {
			manager.addUtilisateur(u1);
		} catch (BLLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String nextPage = "/WEB-INF/connexion.jsp";
		UtilisateurModel model = (UtilisateurModel) request.getSession().getAttribute("model");
		if (model == null) {
			model = new UtilisateurModel(new Utilisateur(), null);
		}
		
		
		if (request.getParameter("Connexion") != null) {
			try {
				if(manager.isUserExist(request.getParameter("pseudo"), request.getParameter("mdp")));
					nextPage = "/WEB-INF/index.jsp";
			} catch (BLLException e) {
				request.setAttribute("erreur", e.getMessage());
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
		doGet(request, response);
	}

}
