package fr.eni.eniEncheres.dal;

import fr.eni.eniEncheres.dal.jdbc.EnchereDAOImpl;

/**
 * Classe Factory de la DAO de l'ench�re
 * 
 * @author FRANDIN/AKAFFOU/BRAULT
 *
 */
public class EnchereDAOFact {
	public static EnchereDAO getInstanceDAO() {
		return new EnchereDAOImpl();

	}
}
