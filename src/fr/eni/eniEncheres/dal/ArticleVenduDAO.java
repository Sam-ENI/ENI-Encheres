package fr.eni.eniEncheres.dal;

import java.util.List;

import fr.eni.eniEncheres.bo.ArticleVendu;
import fr.eni.eniEncheres.bo.Categorie;
import fr.eni.eniEncheres.bo.Retrait;

/**
 * Interface du DAO de l'article
 * 
 * @author FRANDIN/AKAFFOU/BRAULT
 *
 */
public interface ArticleVenduDAO {
	/**
	 * Ajoute un article à la BDD
	 * 
	 * @param articleVendu : un article
	 * @throws DALException : l'exception de la DAL
	 */
	public void insert(ArticleVendu articleVendu) throws DALException;

	/**
	 * Ajoute un retrait à la BDD
	 * 
	 * @param retrait : un retrait
	 * @throws DALException : l'exception de la DAL
	 */
	public void insertRetrait(Retrait retrait) throws DALException;

	/**
	 * Supprime un article à la BDD
	 * 
	 * @param articleVendu : un article
	 * @throws DALException : l'exception de la DAL
	 */
	public void delete(ArticleVendu articleVendu) throws DALException;

	/**
	 * Retourne une liste d'article
	 * 
	 * @return une liste d'article
	 * @throws DALException : l'exception de la DAL
	 */
	public List<ArticleVendu> getAll() throws DALException;

	/**
	 * Retourne une catégorie en fonction de son numéro
	 * 
	 * @param numeroCategorie : l'id de la catégorie
	 * @return la catégorie
	 * @throws DALException : l'exception de la DAL
	 */
	public Categorie selectCategorieByNumeroCategorie(Integer numeroCategorie) throws DALException;

	/**
	 * Retourne un article en fonction de son id
	 * 
	 * @param id : l'id de l'article
	 * @return l'article
	 * @throws DALException : l'exception de la DAL
	 */
	public ArticleVendu getArticleVenduById(int id) throws DALException;

	/**
	 * Retourne un retrait en fonction de son numéro article
	 * 
	 * @param noArticle : l'id de l'article
	 * @return le retrait
	 * @throws DALException : l'exception de la DAL
	 */
	public Retrait getRetraitByNoArticle(Integer noArticle) throws DALException;
}
