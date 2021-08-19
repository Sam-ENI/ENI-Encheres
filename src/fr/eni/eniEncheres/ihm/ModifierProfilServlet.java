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

/**
 * Servlet implementation class ModifierProfilServlet
 */
@WebServlet("/ModifierProfilServlet")
public class ModifierProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurManager manager = UtilisateurManagerFactory.getInstance();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierProfilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = "/WEB-INF/modifierProfil.jsp";

		request.getRequestDispatcher(nextPage).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = "/WEB-INF/modifierProfil.jsp";
		boolean hidden =  true;
		UtilisateurModel model = (UtilisateurModel) request.getSession().getAttribute("model");
		
		// MODIFIER PROFIL
		if(request.getParameter("enregistrer")!= null) {
			try {
				if(manager.verifInscription(request.getParameter("mdp"), request.getParameter("confirmation"),request.getParameter("nom"),request.getParameter("email"))) {
					model.getUtilisateur().setPseudo(request.getParameter("pseudo"));
					model.getUtilisateur().setPrenom(request.getParameter("prenom"));
					model.getUtilisateur().setTelephone(request.getParameter("telephone"));
					model.getUtilisateur().setCodePostal(request.getParameter("codePostal"));
					model.getUtilisateur().setMotDePasse(request.getParameter("mdp"));
					model.getUtilisateur().setNom(request.getParameter("nom"));
					model.getUtilisateur().setEmail(request.getParameter("email"));
					model.getUtilisateur().setRue(request.getParameter("rue"));
					model.getUtilisateur().setVille(request.getParameter("ville"));
					manager.updateUtilisateur(model.getUtilisateur());
					request.setAttribute("msgModif", "Votre profil à été modifié");
					nextPage = "/WEB-INF/modifierProfil.jsp";	
				}
			} catch (BLLException e) {
				request.setAttribute("erreur", e.getMessage());;
			}
		}
		
		// BOUTON SUPPRIMER LE COMPTE
		if (request.getParameter("supprimerCompte")!= null) {
			try {
				manager.deleteUtilisateur(model.getUtilisateur());
				hidden = false;
				model = null;
				nextPage = "/WEB-INF/index.jsp";
			} catch (BLLException e) {
				e.printStackTrace();
			}
		}
		
		request.getSession().setAttribute("hidden", hidden);
		request.getSession().setAttribute("model", model);
		request.getRequestDispatcher(nextPage).forward(request, response);

	}

}
