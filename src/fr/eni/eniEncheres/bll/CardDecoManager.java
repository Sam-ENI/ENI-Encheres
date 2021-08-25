package fr.eni.eniEncheres.bll;

import java.util.List;

import fr.eni.eniEncheres.dal.DALException;
import fr.eni.eniEncheres.dto.Card;
import fr.eni.eniEncheres.dto.Card;

public interface CardDecoManager {

	public List<Card> getAllCardByNom(String saisie) throws BLLException;
	public List<Card> getAllCardByCat(Integer cat) throws BLLException;
	public List<Card> getAllCardByNomAndCat(String saisie, Integer cat) throws BLLException;
	
	/**
	 * Retourne une liste de Carte  détaillé d'enchères ouvertes selon le numéro d'utilisateur de la session
	 * 
	 * @return une liste de Carte détaillé
	 * @throws DALException 
	 */
	public List<Card> getAlltEnchereOuvertes () throws BLLException ;
	/**
	 * Retourne une liste de Carte  détaillé d'enchères en cours selon le numéro d'utilisateur de la session
	 * 
	 * @param no_utilisateur : le numéro d'utilisateur de la session
	 * @return une liste de Carte détaillé
	 */
	public List<Card> getAllEnchereEnCours (Integer no_utilisateur) throws BLLException;
	/**
	 * Retourne une liste de Carte  détaillé d'enchères Remportée selon le numéro d'utilisateur de la session
	 * 
	 * @param no_utilisateur : le numéro d'utilisateur de la session
	 * @return une liste de Carte détaillé
	 */
	public List<Card> getAllEnchereRemporter (Integer no_utilisateur) throws BLLException;
	/**
	 * Retourne une liste de Carte  détaillé de ventes en cours selon le numéro d'utilisateur de la session
	 * 
	 * @param no_utilisateur : le numéro d'utilisateur de la session
	 * @return une liste de Carte détaillé
	 */
	public List<Card> getAllVentesEnCours (Integer no_utilisateur) throws BLLException ;
	/**
	 * Retourne une liste de Carte  détaillé de ventes non débutées selon le numéro d'utilisateur de la session
	 * 
	 * @param no_utilisateur : le numéro d'utilisateur de la session
	 * @return une liste de Carte détaillé
	 */
	public List<Card> getAllVentesNonDebuter (Integer no_utilisateur) throws BLLException;
	/**
	 * Retourne une liste de Carte  détaillé de ventes terminée selon le numéro d'utilisateur de la session
	 * 
	 * @param no_utilisateur : le numéro d'utilisateur de la session
	 * @return une liste de Carte détaillé
	 */
	public List<Card> getAllVentesTerminer (Integer no_utilisateur) throws BLLException;
	List<Card> addToListIfNotExists(List<Card> lstSource, List<Card> lstAdd);
}
