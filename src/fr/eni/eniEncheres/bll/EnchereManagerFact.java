package fr.eni.eniEncheres.bll;

public class EnchereManagerFact {
	private static EnchereManager instance;
	
	public static EnchereManager getInstance() {
	if (instance == null) {
		instance = new EnchereManagerImpl();
	}
	return instance;
	}
}
