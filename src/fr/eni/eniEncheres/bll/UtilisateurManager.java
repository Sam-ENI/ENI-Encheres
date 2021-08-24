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
	public void deleteUtilisateur(Utilisateur utilisateur) throws BLLException;

	/**
	 * Modifie un utilisateur
	 * 
	 * @param utilisateur : un utilisateur
	 * @throws BLLException : L'exception de la BLL
	 */
	public void updateUtilisateur(Utilisateur utilisateur) throws BLLException;

	/**
	 * Retourne la liste des utilisateurs
	 * 
	 * @return la liste des utilisateurs
	 * @throws BLLException : L'exception de la BLL
	 */
	public List<Utilisateur> getAllUtilisateur() throws BLLException;

	/**
	 * Retourne un utilisateur s'il existe dans la BDD vérification par pseudo Créer
	 * une exception dans le cas contraire.
	 *
	 * 
	 * @param pseudo : Pseudo rentré par l'utilisater sur la page connexion
	 * @param mdp    : Mot de passe rentré par l'utilisater sur la page connexion
	 * @return un utilisateur si existe dans la BDD
	 * @throws BLLException : L'exception de la BLL
	 */
	public Utilisateur isUserExistPseudo(String pseudo, String mdp) throws BLLException;

	/**
	 * Retourne un utilisateur s'il existe dans la BDD vérification par email Créer
	 * une exception dans le cas contraire.
	 * 
	 * @param email: emailrentré par l'utilisater sur la page connexion
	 * @param mdp    : Mot de passe rentré par l'utilisater sur la page connexion
	 * @return un utilisateur si existe dans la BDD
	 * @throws BLLException : L'exception de la BLL
	 */
	public Utilisateur isUserExistEmail(String email, String mdp) throws BLLException;

	/**
	 * Vérification des mots de passe lors de la création du compte - Si le mot de
	 * passe et celui de confirmation sont les mêmes sinon : BLLException - Si le
	 * mot de passe est un texte alphanumérique sinon : BLLException
	 * 
	 * 
	 * @param mdp        : Mot de passe entrée par l'utilisateur
	 * @param mdpConfirm : Mot de passe de confirmation rentrée par l'utilisateur
	 * @return Vrai
	 * @throws BLLException : L'exception de la BLL
	 */
	public boolean verifInscription(String mdp, String mdpConfirm, String pseudo, String mail) throws BLLExceptionList;
}
