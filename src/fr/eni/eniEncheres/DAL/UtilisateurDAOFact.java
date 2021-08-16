package fr.eni.eniEncheres.DAL;

public class UtilisateurDAOFact {
	public static UtilisateurDAO getInstanceDAO() {
		return new UtilisateurDAOMock();
	}
}
