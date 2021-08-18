package fr.eni.eniEncheres.bll;

public class UtilisateurManagerFactory {

	private static UtilisateurManager instance;
	
	public static UtilisateurManager getInstance() {
		if (instance == null ) {
			instance = new UtilisateurManagerImpl();
		}
		return instance;
	}
	
	
}
