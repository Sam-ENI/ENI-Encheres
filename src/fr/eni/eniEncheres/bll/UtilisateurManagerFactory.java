package fr.eni.eniEncheres.bll;

/**
 * Classe Factory de l'utilisateur
 * 
 * @author FRANDIN/AKAFFOU/BRAULT
 *
 */
public class UtilisateurManagerFactory {

	private static UtilisateurManager instance;

	public static UtilisateurManager getInstance() {
		if (instance == null) {
			instance = new UtilisateurManagerImpl();
		}
		return instance;
	}

}
