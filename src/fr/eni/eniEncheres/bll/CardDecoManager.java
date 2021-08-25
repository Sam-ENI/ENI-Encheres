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
	 * Retourne une liste de Carte  d�taill� d'ench�res ouvertes selon le num�ro d'utilisateur de la session
	 * 
	 * @return une liste de Carte d�taill�
	 * @throws DALException 
	 */
	public List<Card> getAlltEnchereOuvertes () throws BLLException ;
	/**
	 * Retourne une liste de Carte  d�taill� d'ench�res en cours selon le num�ro d'utilisateur de la session
	 * 
	 * @param no_utilisateur : le num�ro d'utilisateur de la session
	 * @return une liste de Carte d�taill�
	 */
	public List<Card> getAllEnchereEnCours (Integer no_utilisateur) throws BLLException;
	/**
	 * Retourne une liste de Carte  d�taill� d'ench�res Remport�e selon le num�ro d'utilisateur de la session
	 * 
	 * @param no_utilisateur : le num�ro d'utilisateur de la session
	 * @return une liste de Carte d�taill�
	 */
	public List<Card> getAllEnchereRemporter (Integer no_utilisateur) throws BLLException;
	/**
	 * Retourne une liste de Carte  d�taill� de ventes en cours selon le num�ro d'utilisateur de la session
	 * 
	 * @param no_utilisateur : le num�ro d'utilisateur de la session
	 * @return une liste de Carte d�taill�
	 */
	public List<Card> getAllVentesEnCours (Integer no_utilisateur) throws BLLException ;
	/**
	 * Retourne une liste de Carte  d�taill� de ventes non d�but�es selon le num�ro d'utilisateur de la session
	 * 
	 * @param no_utilisateur : le num�ro d'utilisateur de la session
	 * @return une liste de Carte d�taill�
	 */
	public List<Card> getAllVentesNonDebuter (Integer no_utilisateur) throws BLLException;
	/**
	 * Retourne une liste de Carte  d�taill� de ventes termin�e selon le num�ro d'utilisateur de la session
	 * 
	 * @param no_utilisateur : le num�ro d'utilisateur de la session
	 * @return une liste de Carte d�taill�
	 */
	public List<Card> getAllVentesTerminer (Integer no_utilisateur) throws BLLException;
	List<Card> addToListIfNotExists(List<Card> lstSource, List<Card> lstAdd);
}
