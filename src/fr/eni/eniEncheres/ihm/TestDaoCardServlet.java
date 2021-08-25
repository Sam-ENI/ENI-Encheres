package fr.eni.eniEncheres.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.eniEncheres.bo.Utilisateur;
import fr.eni.eniEncheres.dal.CardDecoDAO;
import fr.eni.eniEncheres.dal.CardDecoDAOFact;
import fr.eni.eniEncheres.dal.DALException;
import fr.eni.eniEncheres.dal.UtilisateurDAO;
import fr.eni.eniEncheres.dal.UtilisateurDAOFact;

/**
 * Servlet implementation class TestDaoCardServlet
 */
@WebServlet("/TestDaoCardServlet")
public class TestDaoCardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static UtilisateurDAO dao = UtilisateurDAOFact.getInstanceDAO();
	static CardDecoDAO daoC = CardDecoDAOFact.getInstanceDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestDaoCardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Utilisateur chucky = dao.getByID(109);
			Utilisateur brady = dao.getByID(110);
			Utilisateur josh44 = dao.getByID(107);
		} catch (DALException e) {
			e.printStackTrace();
		}
		
		System.out.println("---------------------------------------");
		System.out.println("Enchères Ouvertes ");
		try {
			System.out.println(daoC.selectEnchereOuvertes());
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("---------------------------------------");
		
		System.out.println("---------------------------------------");
		System.out.println("Mes Enchères en cours  ");
		try {
			System.out.println("Chuky - 109 :");
			System.out.println(daoC.selectEnchereEnCours(109));
			System.out.println("Brady - 110 :");
			System.out.println(daoC.selectEnchereEnCours(110));
		} catch (DALException e) {
			e.printStackTrace();
		}
		System.out.println("---------------------------------------");
		
		
		System.out.println("---------------------------------------");
		System.out.println("Mes Enchères remportée  ");
		try {
			System.out.println("Brady - 110 :");
			System.out.println(daoC.selectEnchereRemporter(110));
		} catch (DALException e) {
			e.printStackTrace();
		}
		System.out.println("---------------------------------------");
		
		System.out.println("---------------------------------------");
		System.out.println("Mes ventes en cours  ");
		try {
			System.out.println("chuky - 109 :");
			System.out.println(daoC.selectVentesEnCours(109));
			System.out.println("josh44 - 107 :");
			System.out.println(daoC.selectVentesEnCours(107));
		} catch (DALException e) {
			e.printStackTrace();
		}
		System.out.println("---------------------------------------");
		
		System.out.println("---------------------------------------");
		System.out.println("Mes ventes non débutées");
		try {
			System.out.println("chuky - 109 :");
			System.out.println(daoC.selectVentesEnCours(109));
			System.out.println("josh44 - 107 :");
			System.out.println(daoC.selectVentesEnCours(107));
		} catch (DALException e) {
			e.printStackTrace();
		}
		System.out.println("---------------------------------------");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
