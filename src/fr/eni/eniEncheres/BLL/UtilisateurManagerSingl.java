package fr.eni.eniEncheres.BLL;

public class UtilisateurManagerSingl {

	private static UtilisateurManager instance;
	
	public static UtilisateurManager getInstance() {
		if (instance == null ) {
			instance = new UtilisateurManagerImpl();
		}
		return instance;
	}
	
	
}
