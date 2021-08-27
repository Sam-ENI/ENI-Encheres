package fr.eni.eniEncheres.dal;

import java.util.List;

import fr.eni.eniEncheres.bo.Utilisateur;

/**
 * Interface de la DAO de l'utilisateur
 * 
 * @author FRANDIN/AKAFFOU/BRAULT
 *
 */
public interface UtilisateurDAO {

	/**
	 * Ajoute un utilisateur dans la BDD
	 * 
	 * @param utilisateur : un utilisateur
	 * @throws DALException : L'exception de la DAL
	 */
	public void insert(Utilisateur utilisateur) throws DALException;

	/**
	 * Modifie un utilisateur dans la BDD
	 * 
	 * @param utilisateur : un utilisateur
	 * @throws DALException : L'exception de la DAL
	 */
	public void update(Utilisateur utilisateur) throws DALException;

	/**
	 * Supprime un utilisateur dans la BDD
	 * 
	 * @param utilisateur : un utilisateur
	 * @throws DALException : L'exception de la DAL
	 */
	public void delete(Utilisateur utilisateur) throws DALException;

	/**
	 * Retourne la liste des utilisateurs de la BDD
	 * 
	 * @return la liste des utilisateurs
	 * @throws DALException : L'exception de la DAL
	 */
	public List<Utilisateur> getAll() throws DALException;

	/**
	 * Retourne un utilisateur en fonction de son id
	 * 
	 * @param nbUtilisateur : l'id de l'utilisateur
	 * @return l'utilisateur
	 * @throws DALException : L'exception de la DAL
	 */
	Utilisateur getByID(int nbUtilisateur) throws DALException;

}
