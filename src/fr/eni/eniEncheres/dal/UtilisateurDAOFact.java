package fr.eni.eniEncheres.dal;

import fr.eni.eniEncheres.dal.jdbc.UtilisateurDAOImpl;

public class UtilisateurDAOFact {
	public static UtilisateurDAO getInstanceDAO() {
		return new UtilisateurDAOImpl();
	}
}
