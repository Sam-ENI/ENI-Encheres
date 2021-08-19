package fr.eni.eniEncheres.dal;

import fr.eni.eniEncheres.dal.jdbc.ArticleVenduDAOImpl;

public class ArticleVenduDAOFact {
	public static ArticleVenduDAO getInstanceDAO() {
		return new ArticleVenduDAOImpl();
		
	}
}
