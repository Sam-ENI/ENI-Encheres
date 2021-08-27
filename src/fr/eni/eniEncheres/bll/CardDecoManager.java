package fr.eni.eniEncheres.bll;

import java.util.List;

import fr.eni.eniEncheres.dto.Card;

/**
 * Interface du manager de Card
 * 
 * @author FRANDIN/AKAFFOU/BRAULT
 *
 */
public interface CardDecoManager {

	/**
	 * Retourne une liste de Card en fonction du nom d'article
	 * 
	 * @param saisie : nom d'article
	 * @return une liste de Card
	 * @throws BLLException : L'exception de la BLL
	 */
	public List<Card> getAllCardByNom(String saisie) throws BLLException;

	/**
	 * Retourne une liste de Card en fonction de sa catégorie
	 * 
	 * @param cat : l'id de la catégorie
	 * @return une liste de Card
	 * @throws BLLException : L'exception de la BLL
	 */
	public List<Card> getAllCardByCat(Integer cat) throws BLLException;

	/**
	 * Retourne une liste de Card en fonction de sa catégorie et de son nom
	 * d'article
	 * 
	 * @param saisie : le nom d'article
	 * @param cat    : l'id de la catégorie
	 * @return la liste de Card
	 * @throws BLLException : L'exception de la BLL
	 */
	public List<Card> getAllCardByNomAndCat(String saisie, Integer cat) throws BLLException;

	/**
	 * Retourne une liste de Card d'enchères ouvertes
	 * 
	 * @return une liste de Card
	 * @throws BLLException : L'exception de la BLL
	 */
	public List<Card> getAlltEnchereOuvertes() throws BLLException;

	/**
	 * Retourne une liste de Carte détaillé d'enchères en cours selon le numéro
	 * d'utilisateur de la session
	 * 
	 * @param no_utilisateur : le numéro d'utilisateur de la session
	 * @return une liste de Carte détaillé
	 * @throws BLLException : L'exception de la BLL
	 */
	public List<Card> getAllEnchereEnCours(Integer no_utilisateur) throws BLLException;

	/**
	 * Retourne une liste de Carte détaillé d'enchères Remportée selon le numéro
	 * d'utilisateur de la session
	 * 
	 * @param no_utilisateur : le numéro d'utilisateur de la session
	 * @return une liste de Carte détaillé
	 * @throws BLLException : L'exception de la BLL
	 */
	public List<Card> getAllEnchereRemporter(Integer no_utilisateur) throws BLLException;

	/**
	 * Retourne une liste de Carte détaillé de ventes en cours selon le numéro
	 * d'utilisateur de la session
	 * 
	 * @param no_utilisateur : le numéro d'utilisateur de la session
	 * @return une liste de Carte détaillé
	 * @throws BLLException : L'exception de la BLL
	 */
	public List<Card> getAllVentesEnCours(Integer no_utilisateur) throws BLLException;

	/**
	 * Retourne une liste de Carte détaillé de ventes non débutées selon le numéro
	 * d'utilisateur de la session
	 * 
	 * @param no_utilisateur : le numéro d'utilisateur de la session
	 * @return une liste de Carte détaillé
	 * @throws BLLException : L'exception de la BLL
	 */
	public List<Card> getAllVentesNonDebuter(Integer no_utilisateur) throws BLLException;

	/**
	 * Retourne une liste de Carte détaillé de ventes terminée selon le numéro
	 * d'utilisateur de la session
	 * 
	 * @param no_utilisateur : le numéro d'utilisateur de la session
	 * @return une liste de Carte détaillé
	 * @throws BLLException : L'exception de la BLL
	 */
	public List<Card> getAllVentesTerminer(Integer no_utilisateur) throws BLLException;

	/**
	 * Concetane deux listes de Card sans ajouter de doublon
	 * 
	 * @param lstSource : la liste source
	 * @param lstAdd    : la liste a ajouter à la liste source
	 * @return une liste de Card
	 */
	List<Card> addToListIfNotExists(List<Card> lstSource, List<Card> lstAdd);

	/**
	 * Retourne une liste de Card en filtrant par le nom d'article les card de la
	 * liste en argument
	 * 
	 * @param lst    : une liste de Card
	 * @param saisie : le nom d'article
	 * @return Une liste de card
	 */
	List<Card> filterByNomContains(List<Card> lst, String saisie);

	/**
	 * Retourne une liste de Card en filtrant par la catégorie les card de la liste
	 * en argument
	 * 
	 * @param lst : une liste de Card
	 * @param cat : l'id de la catégorie
	 * @return Une liste de card
	 * @throws BLLException
	 */
	List<Card> filterByCateg(List<Card> lst, int cat) throws BLLException;
}
