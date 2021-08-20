package fr.eni.eniEncheres.bll;

public class CardDecoManagerFactory {
	private static CardDecoManager instance;
	
	public static CardDecoManager getInstance() {
		if (instance == null) {
			instance = new CardDecoManagerImpl();
		}
		return instance;
	}

}
