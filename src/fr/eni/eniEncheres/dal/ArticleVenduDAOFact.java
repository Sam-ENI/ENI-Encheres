package fr.eni.eniEncheres.dal;

import fr.eni.eniEncheres.dal.jdbc.ArticleVenduDAOImpl;

/**
 * Classe Factory de la DAO de l'article
 * 
 * @author FRANDIN/AKAFFOU/BRAULT
 *
 */
public class ArticleVenduDAOFact {
	public static ArticleVenduDAO getInstanceDAO() {
		return new ArticleVenduDAOImpl();

	}
}
