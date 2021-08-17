package fr.eni.eniEncheres.DAL;

import java.util.List;

import fr.eni.eniEncheres.BLL.BLLException;
import fr.eni.eniEncheres.BO.Utilisateur;

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

}
