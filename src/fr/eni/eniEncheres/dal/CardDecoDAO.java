package fr.eni.eniEncheres.dal;

import java.util.List;

import fr.eni.eniEncheres.dto.Card;

/**
 * Interface DAO de la Card
 * 
 * @author FRANDIN/AKAFFOU/BRAULT
 *
 */
public interface CardDecoDAO {
	/**
	 * Retourne une liste de Card en fonction du nom d'article
	 * 
	 * @param saisie : le nom d'article
	 * @return une liste de card
	 * @throws DALException : l'exception de la DAL
	 */
	public List<Card> selectAllByNomArt(String saisie) throws DALException;

	/**
	 * Retourne une liste de Card en fonction de la catégorie
	 * 
	 * @param cat : l'id de la catégorie
	 * @return une liste de card
	 * @throws DALException : l'exception de la DAL
	 */
	public List<Card> selectAllByCat(Integer cat) throws DALException;

	/**
	 * Retourne une liste de Card en fonction de la catégorie et du nom d'article
	 * 
	 * @param saisie : le nom d'article
	 * @param cat    : l'id de la catégorie
	 * @return une liste de card
	 * @throws DALException : l'exception de la DAL
	 */
	public List<Card> selectAllByNomArtAndCat(String saisie, Integer cat) throws DALException;

	/**
	 * Retourne une liste de Carte détaillé d'enchères ouvertes selon le numéro
	 * d'utilisateur de la session
	 * 
	 * @return une liste de Carte détaillé
	 * @throws DALException
	 */
	public List<Card> selectEnchereOuvertes() throws DALException;

	/**
	 * Retourne une liste de Carte détaillé d'enchères en cours selon le numéro
	 * d'utilisateur de la session
	 * 
	 * @param no_utilisateur : le numéro d'utilisateur de la session
	 * @return une liste de Carte détaillé
	 * @throws DALException
	 */
	public List<Card> selectEnchereEnCours(Integer no_utilisateur) throws DALException;

	/**
	 * Retourne une liste de Carte détaillé d'enchères Remportée selon le numéro
	 * d'utilisateur de la session
	 * 
	 * @param no_utilisateur : le numéro d'utilisateur de la session
	 * @return une liste de Carte détaillé
	 * @throws DALException
	 */
	public List<Card> selectEnchereRemporter(Integer no_utilisateur) throws DALException;

	/**
	 * Retourne une liste de Carte détaillé de ventes en cours selon le numéro
	 * d'utilisateur de la session
	 * 
	 * @param no_utilisateur : le numéro d'utilisateur de la session
	 * @return une liste de Carte détaillé
	 * @throws DALException
	 */
	public List<Card> selectVentesEnCours(Integer no_utilisateur) throws DALException;

	/**
	 * Retourne une liste de Carte détaillé de ventes non débutées selon le numéro
	 * d'utilisateur de la session
	 * 
	 * @param no_utilisateur : le numéro d'utilisateur de la session
	 * @return une liste de Carte détaillé
	 * @throws DALException
	 */
	public List<Card> selectVentesNonDebuter(Integer no_utilisateur) throws DALException;

	/**
	 * Retourne une liste de Carte détaillé de ventes terminée selon le numéro
	 * d'utilisateur de la session
	 * 
	 * @param no_utilisateur : le numéro d'utilisateur de la session
	 * @return une liste de Carte détaillé
	 * @throws DALException
	 */
	public List<Card> selectVentesTerminer(Integer no_utilisateur) throws DALException;
}
