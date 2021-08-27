package fr.eni.eniEncheres.bll;

import java.util.List;

import fr.eni.eniEncheres.bo.Enchere;
import fr.eni.eniEncheres.ihm.ArticleVenduModel;
import fr.eni.eniEncheres.ihm.EnchereModel;

/**
 * Interface de l'enchere
 * 
 * @author FRANDIN/AKAFFOU/BRAULT
 *
 */
public interface EnchereManager {
	/**
	 * Crédite l'utilisateur en fonction de l'article, l'enchere et son montant
	 * 
	 * @param articleModel : l'article
	 * @param enchere      : l'enchere
	 * @param montant      : le montant à créditer
	 * @throws BLLException : l'exception de la BLL
	 */
	public void crediterUtilsateur(ArticleVenduModel articleModel, Enchere enchere, Integer montant)
			throws BLLException;

	/**
	 * Débite l'utilisateur en fonction de l'enchere et de son montant
	 * 
	 * @param enchere : l'enchere
	 * @param montant : le montant à débiter
	 */
	public void debiterUtilisateur(Enchere enchere, Integer montant);

	/**
	 * Ajoute une enchère
	 * 
	 * @param enchere : l'enchere
	 * @throws BLLException : l'exception de la BLL
	 */
	public void addEnchere(Enchere enchere) throws BLLException;

	/**
	 * Supprime l'enchere
	 * 
	 * @param enchere : l'enchere
	 * @throws BLLException : l'exception de la BLL
	 */
	public void deleteEnchere(Enchere enchere) throws BLLException;

	/**
	 * Modifie une enchère en fonction de la nouvelle enchere, l'ancienne, la saisie
	 * de l'enchère et l'article
	 * 
	 * @param enchereModel   : la nouvelle enchère
	 * @param enchSauvegarde : l'ancienne enchère
	 * @param saisieEnchere  : la saisie de l'enchère
	 * @param articleModel   : l'article
	 * @throws BLLExceptionList : la liste d'exception de la BLL
	 */
	public void updateEnchere(EnchereModel enchereModel, Enchere enchSauvegarde, String saisieEnchere,
			ArticleVenduModel articleModel) throws BLLExceptionList;

	/**
	 * Retourne une liste d'enchères
	 * 
	 * @return une liste d'enchères
	 * @throws BLLException : L'exception de la BLL
	 */
	public List<Enchere> getAllEnchere() throws BLLException;

	/**
	 * Retourne une enchère en fonction de son numéro d'article
	 * 
	 * @param noArticle : le numéro d'article
	 * @return une enchère
	 */
	public Enchere selectEncherebyNoArticle(Integer noArticle);

	/**
	 * Vérifie la saisie de l'enchère retourne vrai si tout est ok SINON crée une
	 * exception
	 * 
	 * @param saisieEnchere : la saisie de l'enchère
	 * @param articleModel  : l'article
	 * @return un booléen
	 * @throws BLLExceptionList : la liste d'exception de la BLL
	 */
	public Boolean verifSaisieEnchere(String saisieEnchere, ArticleVenduModel articleModel) throws BLLExceptionList;

}
