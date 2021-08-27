package fr.eni.eniEncheres.dal;

import fr.eni.eniEncheres.dal.jdbc.UtilisateurDAOImpl;

/**
 * Classe Factory de la DAO de l'utilisateur
 * 
 * @author FRANDIN/AKAFFOU/BRAULT
 *
 */
public class UtilisateurDAOFact {
	public static UtilisateurDAO getInstanceDAO() {
		return new UtilisateurDAOImpl();
	}
}
