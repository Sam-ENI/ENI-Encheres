package fr.eni.eniEncheres.bll;

import java.util.List;

import fr.eni.eniEncheres.bo.Utilisateur;

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
	 * 	Cr�er une exception dans le cas contraire. 
	 *
	 * 
	 * @param pseudo : Pseudo rentr� par l'utilisater sur la page connexion
	 * @param mdp : Mot de passe rentr� par l'utilisater sur la page connexion
	 * @return Vrai si l'utilisateur existe dans la BDD 
	 * @throws BLLException : L'exception de la BLL
	 */
	public Utilisateur isUserExist(String pseudo, String mdp) throws BLLException;
	/**
	 * V�rification des mots de passe lors de la cr�ation du compte
	 *  - Si le mot de passe et celui de confirmation sont les m�mes sinon : BLLException
	 *  - Si le mot de passe est un texte alphanum�rique sinon : BLLException
	 *  
	 * 
	 * @param mdp : Mot de passe entr�e par l'utilisateur
	 * @param mdpConfirm : Mot de passe de confirmation rentr�e par l'utilisateur
	 * @return Vrai
	 * @throws BLLException : L'exception de la BLL
	 */
	public boolean verifInscription(String mdp, String mdpConfirm, String pseudo, String mail) throws BLLException;
}
