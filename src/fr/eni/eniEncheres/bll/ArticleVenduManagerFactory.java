package fr.eni.eniEncheres.bll;

/**
 * Classe Factory du manager de l'article
 * 
 * @author FRANDIN/AKAFFOU/BRAULT
 *
 */
public class ArticleVenduManagerFactory {
	private static ArticleVenduManager instance;

	public static ArticleVenduManager getInstance() {
		if (instance == null) {
			instance = new ArticleVenduManagerImpl();
		}
		return instance;
	}
}
