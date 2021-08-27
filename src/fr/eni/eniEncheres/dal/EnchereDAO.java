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
	 * Retourne une ench�re en fonction de son num�ro d'article
	 * 
	 * @param noArticle : le num�ro d'article
	 * @return une ench�re
	 * @throws DALException : l'exception de la DAL
	 */
	public Enchere selectEncherebyNoArticle(Integer noArticle) throws DALException;

	/**
	 * Ajoute une ench�re � la BDD
	 * 
	 * @param enchere : une ench�re
	 * @throws DALException : l'exception de la DAL
	 */
	public void insert(Enchere enchere) throws DALException;

	/**
	 * Modifie une ench�re � la BDD
	 * 
	 * @param enchere : une ench�re
	 * @throws DALException : l'exception de la DAL
	 */
	public void update(Enchere enchere) throws DALException;

	/**
	 * Supprime une ench�re � la BDD
	 * 
	 * @param enchere : une ench�re
	 * @throws DALException : l'exception de la DAL
	 */
	public void delete(Enchere enchere) throws DALException;

	/**
	 * Retourne une liste d'ench�res
	 * 
	 * @return une liste d'ench�res
	 * @throws DALException : l'exception de la DAL
	 */
	public List<Enchere> getAll() throws DALException;

}
