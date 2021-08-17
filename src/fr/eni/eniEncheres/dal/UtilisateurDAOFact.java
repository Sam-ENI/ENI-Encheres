package fr.eni.eniEncheres.dal;

public class UtilisateurDAOFact {
	public static UtilisateurDAO getInstanceDAO() {
		return new UtilisateurDAOImpl();
	}
}
