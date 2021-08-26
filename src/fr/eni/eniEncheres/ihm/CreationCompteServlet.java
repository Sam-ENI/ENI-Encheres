package fr.eni.eniEncheres.ihm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.eniEncheres.bll.BLLException;
import fr.eni.eniEncheres.bll.BLLExceptionList;
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

		request.getRequestDispatcher(nextPage).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nextPage = "/WEB-INF/inscription.jsp";
		UtilisateurModel utilisateurModel = null;


		if (request.getParameter("creer") != null) {
			try {
			utilisateurModel = new UtilisateurModel(new Utilisateur(), null);
			try {
				if (manager.verifInscription(request.getParameter("mdp"), request.getParameter("confirmation"), request.getParameter("pseudo"), request.getParameter("email"))) {
					utilisateurModel.getUtilisateur().setPseudo(request.getParameter("pseudo"));
					utilisateurModel.getUtilisateur().setNom(request.getParameter("nom"));
					utilisateurModel.getUtilisateur().setPrenom(request.getParameter("prenom"));
					utilisateurModel.getUtilisateur().setEmail(request.getParameter("email"));
					utilisateurModel.getUtilisateur().setTelephone(request.getParameter("telephone"));
					utilisateurModel.getUtilisateur().setRue(request.getParameter("rue"));
					utilisateurModel.getUtilisateur().setCodePostal(request.getParameter("codePostal"));
					utilisateurModel.getUtilisateur().setVille(request.getParameter("ville"));
					utilisateurModel.getUtilisateur().setMotDePasse(request.getParameter("mdp"));
					utilisateurModel.getUtilisateur().setCredit(0);
					utilisateurModel.getUtilisateur().setAdministrateur(false);
					request.getSession().setAttribute("utilisateurModel", utilisateurModel);
					Boolean isConnecte = true;
					request.setAttribute("isConnecte", isConnecte);
					manager.addUtilisateur(utilisateurModel.getUtilisateur());
					utilisateurModel.setLstUtilisateur(manager.getAllUtilisateur());
					nextPage = "/WEB-INF/index.jsp";
				}
			} catch (BLLExceptionList e) {
				request.setAttribute("erreurs", e.getMessages());
				nextPage = "/WEB-INF/inscription.jsp";
				e.printStackTrace();
			}

			} catch (BLLException e) {
				// TODO Auto-generated catch block
				request.setAttribute("erreur", e.getMessage());
			}
			
		}
		if (request.getParameter("annuler") != null) {
			nextPage = "/WEB-INF/index.jsp";
			Boolean isConnecte = false;
			request.getSession().setAttribute("isConnecte", isConnecte);
		}

		request.getRequestDispatcher(nextPage).forward(request, response);
	}

}
