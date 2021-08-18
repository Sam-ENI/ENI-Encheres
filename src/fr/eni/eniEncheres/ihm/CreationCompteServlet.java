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
 * Servlet implementation class CreationCompteServlet
 */
@WebServlet("/CreationCompteServlet")
public class CreationCompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurManager manager = UtilisateurManagerFactory.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreationCompteServlet() {
		super();
		// TODO Auto-generated constructor stubz
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nextPage = "/WEB-INF/inscription.jsp";
		UtilisateurModel model = null;


		if (request.getParameter("creer") != null) {
			try {
			model = new UtilisateurModel(new Utilisateur(), null);
			if (manager.verifInscription(request.getParameter("mdp"), request.getParameter("confirmation"), request.getParameter("pseudo"), request.getParameter("email"))) {
				model.getUtilisateur().setPseudo(request.getParameter("pseudo"));
				model.getUtilisateur().setNom(request.getParameter("nom"));
				model.getUtilisateur().setPrenom(request.getParameter("prenom"));
				model.getUtilisateur().setEmail(request.getParameter("email"));
				model.getUtilisateur().setTelephone(request.getParameter("telephone"));
				model.getUtilisateur().setRue(request.getParameter("rue"));
				model.getUtilisateur().setCodePostal(request.getParameter("codePostal"));
				model.getUtilisateur().setVille(request.getParameter("ville"));
				model.getUtilisateur().setMotDePasse(request.getParameter("mdp"));
				model.getUtilisateur().setCredit(0);
				model.getUtilisateur().setAdministrateur(false);
				request.getSession().setAttribute("model", model);
				Boolean hidden = true;
				request.setAttribute("hidden", hidden);
				manager.addUtilisateur(model.getUtilisateur());
				model.setLstUtilisateur(manager.getAllUtilisateur());
				nextPage = "/WEB-INF/index.jsp";
			}

			} catch (BLLException e) {
				// TODO Auto-generated catch block
				request.setAttribute("erreur", e.getMessage());
			}
			
		}
		if (request.getParameter("annuler") != null) {
			nextPage = "/WEB-INF/index.jsp";
			Boolean hidden = false;
			request.getSession().setAttribute("hidden", hidden);
		}

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
