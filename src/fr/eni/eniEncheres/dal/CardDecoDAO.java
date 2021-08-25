package fr.eni.eniEncheres.dal;

import java.util.List;


import fr.eni.eniEncheres.dto.Card;
import fr.eni.eniEncheres.dto.Card;

public interface CardDecoDAO {

	public List<Card> selectAllByNomArt(String saisie) throws DALException; 
	public List<Card> selectAllByCat(Integer cat) throws DALException;
	public List<Card> selectAllByNomArtAndCat(String saisie, Integer cat) throws DALException;
	/**
	 * Retourne une liste de Carte  détaillé d'enchères ouvertes selon le numéro d'utilisateur de la session
	 * 
	 * @return une liste de Carte détaillé
	 * @throws DALException 
	 */
	public List<Card> selectEnchereOuvertes () throws DALException ;
	/**
	 * Retourne une liste de Carte  détaillé d'enchères en cours selon le numéro d'utilisateur de la session
	 * 
	 * @param no_utilisateur : le numéro d'utilisateur de la session
	 * @return une liste de Carte détaillé
	 * @throws DALException 
	 */
	public List<Card> selectEnchereEnCours (Integer no_utilisateur) throws DALException ;
	/**
	 * Retourne une liste de Carte  détaillé d'enchères Remportée selon le numéro d'utilisateur de la session
	 * 
	 * @param no_utilisateur : le numéro d'utilisateur de la session
	 * @return une liste de Carte détaillé
	 * @throws DALException 
	 */
	public List<Card> selectEnchereRemporter (Integer no_utilisateur) throws DALException ;
	/**
	 * Retourne une liste de Carte  détaillé de ventes en cours selon le numéro d'utilisateur de la session
	 * 
	 * @param no_utilisateur : le numéro d'utilisateur de la session
	 * @return une liste de Carte détaillé
	 * @throws DALException 
	 */
	public List<Card> selectVentesEnCours (Integer no_utilisateur) throws DALException ;
	/**
	 * Retourne une liste de Carte  détaillé de ventes non débutées selon le numéro d'utilisateur de la session
	 * 
	 * @param no_utilisateur : le numéro d'utilisateur de la session
	 * @return une liste de Carte détaillé
	 * @throws DALException 
	 */
	public List<Card> selectVentesNonDebuter (Integer no_utilisateur) throws DALException ;
	/**
	 * Retourne une liste de Carte  détaillé de ventes terminée selon le numéro d'utilisateur de la session
	 * 
	 * @param no_utilisateur : le numéro d'utilisateur de la session
	 * @return une liste de Carte détaillé
	 * @throws DALException 
	 */
	public List<Card> selectVentesTerminer (Integer no_utilisateur) throws DALException ;
}
