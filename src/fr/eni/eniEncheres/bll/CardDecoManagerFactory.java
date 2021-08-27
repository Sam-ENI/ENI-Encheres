package fr.eni.eniEncheres.bll;

/**
 * Classe de la Factory du manager de la Card
 * 
 * @author FRANDIN/AKAFFOU/BRAULT
 *
 */
public class CardDecoManagerFactory {
	private static CardDecoManager instance;

	public static CardDecoManager getInstance() {
		if (instance == null) {
			instance = new CardDecoManagerImpl();
		}
		return instance;
	}

}
