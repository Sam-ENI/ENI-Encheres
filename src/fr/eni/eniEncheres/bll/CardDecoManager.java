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
	 * Retourne une liste de Card en fonction de sa cat�gorie
	 * 
	 * @param cat : l'id de la cat�gorie
	 * @return une liste de Card
	 * @throws BLLException : L'exception de la BLL
	 */
	public List<Card> getAllCardByCat(Integer cat) throws BLLException;

	/**
	 * Retourne une liste de Card en fonction de sa cat�gorie et de son nom
	 * d'article
	 * 
	 * @param saisie : le nom d'article
	 * @param cat    : l'id de la cat�gorie
	 * @return la liste de Card
	 * @throws BLLException : L'exception de la BLL
	 */
	public List<Card> getAllCardByNomAndCat(String saisie, Integer cat) throws BLLException;

	/**
	 * Retourne une liste de Card d'ench�res ouvertes
	 * 
	 * @return une liste de Card
	 * @throws BLLException : L'exception de la BLL
	 */
	public List<Card> getAlltEnchereOuvertes() throws BLLException;

	/**
	 * Retourne une liste de Carte d�taill� d'ench�res en cours selon le num�ro
	 * d'utilisateur de la session
	 * 
	 * @param no_utilisateur : le num�ro d'utilisateur de la session
	 * @return une liste de Carte d�taill�
	 * @throws BLLException : L'exception de la BLL
	 */
	public List<Card> getAllEnchereEnCours(Integer no_utilisateur) throws BLLException;

	/**
	 * Retourne une liste de Carte d�taill� d'ench�res Remport�e selon le num�ro
	 * d'utilisateur de la session
	 * 
	 * @param no_utilisateur : le num�ro d'utilisateur de la session
	 * @return une liste de Carte d�taill�
	 * @throws BLLException : L'exception de la BLL
	 */
	public List<Card> getAllEnchereRemporter(Integer no_utilisateur) throws BLLException;

	/**
	 * Retourne une liste de Carte d�taill� de ventes en cours selon le num�ro
	 * d'utilisateur de la session
	 * 
	 * @param no_utilisateur : le num�ro d'utilisateur de la session
	 * @return une liste de Carte d�taill�
	 * @throws BLLException : L'exception de la BLL
	 */
	public List<Card> getAllVentesEnCours(Integer no_utilisateur) throws BLLException;

	/**
	 * Retourne une liste de Carte d�taill� de ventes non d�but�es selon le num�ro
	 * d'utilisateur de la session
	 * 
	 * @param no_utilisateur : le num�ro d'utilisateur de la session
	 * @return une liste de Carte d�taill�
	 * @throws BLLException : L'exception de la BLL
	 */
	public List<Card> getAllVentesNonDebuter(Integer no_utilisateur) throws BLLException;

	/**
	 * Retourne une liste de Carte d�taill� de ventes termin�e selon le num�ro
	 * d'utilisateur de la session
	 * 
	 * @param no_utilisateur : le num�ro d'utilisateur de la session
	 * @return une liste de Carte d�taill�
	 * @throws BLLException : L'exception de la BLL
	 */
	public List<Card> getAllVentesTerminer(Integer no_utilisateur) throws BLLException;

	/**
	 * Concetane deux listes de Card sans ajouter de doublon
	 * 
	 * @param lstSource : la liste source
	 * @param lstAdd    : la liste a ajouter � la liste source
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
	 * Retourne une liste de Card en filtrant par la cat�gorie les card de la liste
	 * en argument
	 * 
	 * @param lst : une liste de Card
	 * @param cat : l'id de la cat�gorie
	 * @return Une liste de card
	 * @throws BLLException
	 */
	List<Card> filterByCateg(List<Card> lst, int cat) throws BLLException;
}
