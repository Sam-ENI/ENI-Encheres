package fr.eni.eniEncheres.dal;

import fr.eni.eniEncheres.dal.jdbc.EnchereDAOImpl;

public class EnchereDAOFact {
	public static EnchereDAO getInstanceDAO() {
		return new EnchereDAOImpl();
		
	}
}
