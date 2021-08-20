package fr.eni.eniEncheres.bll;

public class ArticleVenduManagerFactory {
	private static ArticleVenduManager instance;

	public static ArticleVenduManager getInstance() {
		if (instance == null) {
			instance = new ArticleVenduManagerImpl();
		}
		return instance;
	}
}
