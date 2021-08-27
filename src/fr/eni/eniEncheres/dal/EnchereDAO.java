package fr.eni.eniEncheres.dal;

import java.util.List;

import fr.eni.eniEncheres.bo.Enchere;

/**
 * Interface de la DAO de l'enchere
 * 
 * @author FRANDIN/AKAFFOU/BRAULT
 *
 */
public interface EnchereDAO {
	/**
	 * Retourne une enchère en fonction de son numéro d'article
	 * 
	 * @param noArticle : le numéro d'article
	 * @return une enchère
	 * @throws DALException : l'exception de la DAL
	 */
	public Enchere selectEncherebyNoArticle(Integer noArticle) throws DALException;

	/**
	 * Ajoute une enchère à la BDD
	 * 
	 * @param enchere : une enchère
	 * @throws DALException : l'exception de la DAL
	 */
	public void insert(Enchere enchere) throws DALException;

	/**
	 * Modifie une enchère à la BDD
	 * 
	 * @param enchere : une enchère
	 * @throws DALException : l'exception de la DAL
	 */
	public void update(Enchere enchere) throws DALException;

	/**
	 * Supprime une enchère à la BDD
	 * 
	 * @param enchere : une enchère
	 * @throws DALException : l'exception de la DAL
	 */
	public void delete(Enchere enchere) throws DALException;

	/**
	 * Retourne une liste d'enchères
	 * 
	 * @return une liste d'enchères
	 * @throws DALException : l'exception de la DAL
	 */
	public List<Enchere> getAll() throws DALException;

}
