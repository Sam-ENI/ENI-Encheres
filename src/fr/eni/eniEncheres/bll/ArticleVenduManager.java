package fr.eni.eniEncheres.bll;

import java.util.List;

import fr.eni.eniEncheres.bo.ArticleVendu;
import fr.eni.eniEncheres.bo.Categorie;
import fr.eni.eniEncheres.bo.Retrait;
import fr.eni.eniEncheres.dto.Card;

/**
 * Interface du manager de l'article
 * 
 * @author FRANDIN/AKAFFOU/BRAULT
 *
 */
public interface ArticleVenduManager {
	/**
	 * Ajoute un article
	 * 
	 * @param articleVendu : l'article
	 * @throws BLLException : l'exception de la BLL
	 */
	public void addArticleVendu(ArticleVendu articleVendu) throws BLLException;

	/**
	 * Supprime un article
	 * 
	 * @param articleVendu : l'article
	 * @throws BLLException : l'exception de la BLL
	 */
	public void deleteArticleVendu(ArticleVendu articleVendu) throws BLLException;

	/**
	 * Retourne une liste d'article
	 * 
	 * @throws BLLException : l'exception de la BLL
	 */
	public List<ArticleVendu> getAllArticleVendu() throws BLLException;

	/**
	 * Retourne un article en fonction de son nom
	 * 
	 * @param string : nom de l'article
	 * @return un article
	 * @throws BLLException : l'exception de la BLL
	 */
	public ArticleVendu getArticleByName(String string) throws BLLException;

	/**
	 * Retourne une catégorie en fonction de son numéro de catégorie
	 * 
	 * @param id : le numéro de catégorie
	 * @return La catégorie
	 * @throws BLLException : l'exception de la BLL
	 */
	public Categorie getCategById(int id) throws BLLException;

	/**
	 * Retourne une liste de Card en fonction du nom de l'article
	 * 
	 * @param name : nom de l'article
	 * @return une Card
	 * @throws BLLException : l'exception de la BLL
	 */
	public List<Card> getListArticleByName(String name) throws BLLException;

	/**
	 * Retourne une liste de Card en fonction de l'id de la catégorie
	 * 
	 * @param cat : l'id de la catégorie
	 * @return une liste de Card
	 * @throws BLLException : l'exception de la BLL
	 */
	public List<Card> getListArticleByCat(Integer cat) throws BLLException;

	/**
	 * Retourne une liste de Card en fonction de l'id de la catégorie et du nom de
	 * l'article
	 * 
	 * @param name : nom de l'article
	 * @param cat  : l'id de la catégorie
	 * @return une liste de Card
	 * @throws BLLException : l'exception de la BLL
	 */
	public List<Card> getListArticleByCatAndName(String name, Integer cat) throws BLLException;

	/**
	 * Retourne un article en fonction de son numéro d'article
	 * 
	 * @param id : le numéro d'article
	 * @return un article
	 * @throws BLLException : l'exception de la BLL
	 */
	ArticleVendu getArticleVenduById(int id) throws BLLException;

	/**
	 * Retourne un retrait en fonction de son numéro d'article
	 * 
	 * @param id : le numéro d'article
	 * @return Un retrait
	 * @throws BLLException : l'exception de la BLL
	 */
	public Retrait getRetraitByNoArticle(int id) throws BLLException;

	/**
	 * 
	 * Vérification de l'ajout d'un nouvel article Retourne Vrai si tout est ok
	 * SINON crée une exeception
	 * 
	 * @param nom        : le nom de l'article
	 * @param desc       : la description de l'article
	 * @param prixDepart : le prix de départ de l'article
	 * @param dateDepart : la date de départ de l'article
	 * @param dateFin    : la date de fin de l'article
	 * @param rue        : rue de retrait
	 * @param cp         : code postal de retrait
	 * @param ville      : ville de retrait
	 * @return Un boolean
	 * @throws BLLExceptionList : Liste d'exception de la BLL
	 */
	public Boolean verifNouvelArticle(String nom, String desc, String prixDepart, String dateDepart, String dateFin,
			String rue, String cp, String ville) throws BLLExceptionList;

	/**
	 * Ajoute un retrait
	 * 
	 * @param retrait : le retrait
	 * @throws BLLException : l'exception de la BLL
	 */
	public void addRetrait(Retrait retrait) throws BLLException;
}
