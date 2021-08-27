package fr.eni.eniEncheres.bll;

/**
 * Classe Factory du manager de l'enchère
 * 
 * @author FRANDIN/AKAFFOU/BRAULT
 *
 */
public class EnchereManagerFact {
	private static EnchereManager instance;

	public static EnchereManager getInstance() {
		if (instance == null) {
			instance = new EnchereManagerImpl();
		}
		return instance;
	}
}
