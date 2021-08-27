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
	 * Cr�dite l'utilisateur en fonction de l'article, l'enchere et son montant
	 * 
	 * @param articleModel : l'article
	 * @param enchere      : l'enchere
	 * @param montant      : le montant � cr�diter
	 * @throws BLLException : l'exception de la BLL
	 */
	public void crediterUtilsateur(ArticleVenduModel articleModel, Enchere enchere, Integer montant)
			throws BLLException;

	/**
	 * D�bite l'utilisateur en fonction de l'enchere et de son montant
	 * 
	 * @param enchere : l'enchere
	 * @param montant : le montant � d�biter
	 */
	public void debiterUtilisateur(Enchere enchere, Integer montant);

	/**
	 * Ajoute une ench�re
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
	 * Modifie une ench�re en fonction de la nouvelle enchere, l'ancienne, la saisie
	 * de l'ench�re et l'article
	 * 
	 * @param enchereModel   : la nouvelle ench�re
	 * @param enchSauvegarde : l'ancienne ench�re
	 * @param saisieEnchere  : la saisie de l'ench�re
	 * @param articleModel   : l'article
	 * @throws BLLExceptionList : la liste d'exception de la BLL
	 */
	public void updateEnchere(EnchereModel enchereModel, Enchere enchSauvegarde, String saisieEnchere,
			ArticleVenduModel articleModel) throws BLLExceptionList;

	/**
	 * Retourne une liste d'ench�res
	 * 
	 * @return une liste d'ench�res
	 * @throws BLLException : L'exception de la BLL
	 */
	public List<Enchere> getAllEnchere() throws BLLException;

	/**
	 * Retourne une ench�re en fonction de son num�ro d'article
	 * 
	 * @param noArticle : le num�ro d'article
	 * @return une ench�re
	 */
	public Enchere selectEncherebyNoArticle(Integer noArticle);

	/**
	 * V�rifie la saisie de l'ench�re retourne vrai si tout est ok SINON cr�e une
	 * exception
	 * 
	 * @param saisieEnchere : la saisie de l'ench�re
	 * @param articleModel  : l'article
	 * @return un bool�en
	 * @throws BLLExceptionList : la liste d'exception de la BLL
	 */
	public Boolean verifSaisieEnchere(String saisieEnchere, ArticleVenduModel articleModel) throws BLLExceptionList;

}
