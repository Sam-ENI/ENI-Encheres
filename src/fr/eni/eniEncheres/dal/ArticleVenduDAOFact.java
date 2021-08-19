package fr.eni.eniEncheres.dal;

import fr.eni.eniEncheres.dal.jdbc.ArticleVenduImpl;

public class ArticleVenduDAOFact {
	public static ArticleVenduDAO getInstanceDAO() {
		return new ArticleVenduImpl();
		
	}
}
