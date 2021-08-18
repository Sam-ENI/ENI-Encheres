package fr.eni.eniEncheres.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.eniEncheres.bo.Utilisateur;

/**
 * Servlet implementation class AccueilServlet
 */
@WebServlet("/AccueilServlet")
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccueilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = "/WEB-INF/index.jsp";
		Boolean hidden = false;
		if (request.getSession().getAttribute("model") != null ) {
			hidden = true;
		}
		request.getSession().setAttribute("hidden", hidden);
		request.getRequestDispatcher(nextPage).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = "/WEB-INF/index.jsp";
		Boolean hidden = false;
		System.out.println(request.getSession().getAttribute("model"));
//		if (request.getSession().getAttribute("model") != null ) {
//			hidden = true;
//		}
		
		if (request.getParameter("insci/connex") != null) {
			nextPage = "/WEB-INF/connexion.jsp";
		}
		if (request.getParameter("profil") != null) {
			nextPage = "/WEB-INF/profil.jsp";
		}
		if (request.getParameter("modifierBtn") != null) {
		
			nextPage = "/WEB-INF/profil.jsp";
		}
//		request.getSession().setAttribute("hidden", hidden);
		request.getRequestDispatcher(nextPage).forward(request, response);	}
		
	
}
