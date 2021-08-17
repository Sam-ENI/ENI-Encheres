package fr.eni.eniEncheres.BLL;

import java.util.List;

import fr.eni.eniEncheres.BO.Utilisateur;

public interface UtilisateurManager {

	/**
	 * Ajoute un utilisateur au Manager
	 * 
	 * @param utilisateur : un utilisateur
	 * @throws BLLException : L'exception de la BLL
	 */
	public void addUtilisateur(Utilisateur utilisateur) throws BLLException;
	/**
	 * Supprime un utilisateur
	 * 
	 * @param utilisateur : un utilisateur
	 * @throws BLLException : L'exception de la BLL
	 */
	public void deleteUtilisateur(Utilisateur utilisateur)throws BLLException;
	/**
	 * Modifie un utilisateur
	 * 
	 * @param utilisateur : un utilisateur
	 * @throws BLLException : L'exception de la BLL
	 */
	public void updateUtilisateur(Utilisateur utilisateur)throws BLLException;
	/**
	 * Retourne la liste des utilisateurs
	 * 
	 * @return la liste des utilisateurs
	 * @throws BLLException : L'exception de la BLL
	 */
	public List<Utilisateur> getAllUtilisateur()throws BLLException;
	/**
	 *	Retourne vrai si l'utilisateur existe dans la BDD,
	 * 	Créer une exception dans le cas contraire. 
	 *
	 * 
	 * @param pseudo : Pseudo rentré par l'utilisater sur la page connexion
	 * @param mdp : Mot de passe rentré par l'utilisater sur la page connexion
	 * @return Vrai si l'utilisateur existe dans la BDD 
	 * @throws BLLException : L'exception de la BLL
	 */
	public boolean isUserExist(String pseudo, String mdp) throws BLLException;
}
