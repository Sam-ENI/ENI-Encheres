package fr.eni.eniEncheres.dal;

import java.util.List;


import fr.eni.eniEncheres.dto.Card;
import fr.eni.eniEncheres.dto.Card;

public interface CardDecoDAO {

	public List<Card> selectAllByNomArt(String saisie) throws DALException; 
	public List<Card> selectAllByCat(Integer cat) throws DALException;
	public List<Card> selectAllByNomArtAndCat(String saisie, Integer cat) throws DALException;
	/**
	 * Retourne une liste de Carte  d�taill� d'ench�res ouvertes selon le num�ro d'utilisateur de la session
	 * 
	 * @return une liste de Carte d�taill�
	 * @throws DALException 
	 */
	public List<Card> selectEnchereOuvertes () throws DALException ;
	/**
	 * Retourne une liste de Carte  d�taill� d'ench�res en cours selon le num�ro d'utilisateur de la session
	 * 
	 * @param no_utilisateur : le num�ro d'utilisateur de la session
	 * @return une liste de Carte d�taill�
	 * @throws DALException 
	 */
	public List<Card> selectEnchereEnCours (Integer no_utilisateur) throws DALException ;
	/**
	 * Retourne une liste de Carte  d�taill� d'ench�res Remport�e selon le num�ro d'utilisateur de la session
	 * 
	 * @param no_utilisateur : le num�ro d'utilisateur de la session
	 * @return une liste de Carte d�taill�
	 * @throws DALException 
	 */
	public List<Card> selectEnchereRemporter (Integer no_utilisateur) throws DALException ;
	/**
	 * Retourne une liste de Carte  d�taill� de ventes en cours selon le num�ro d'utilisateur de la session
	 * 
	 * @param no_utilisateur : le num�ro d'utilisateur de la session
	 * @return une liste de Carte d�taill�
	 * @throws DALException 
	 */
	public List<Card> selectVentesEnCours (Integer no_utilisateur) throws DALException ;
	/**
	 * Retourne une liste de Carte  d�taill� de ventes non d�but�es selon le num�ro d'utilisateur de la session
	 * 
	 * @param no_utilisateur : le num�ro d'utilisateur de la session
	 * @return une liste de Carte d�taill�
	 * @throws DALException 
	 */
	public List<Card> selectVentesNonDebuter (Integer no_utilisateur) throws DALException ;
	/**
	 * Retourne une liste de Carte  d�taill� de ventes termin�e selon le num�ro d'utilisateur de la session
	 * 
	 * @param no_utilisateur : le num�ro d'utilisateur de la session
	 * @return une liste de Carte d�taill�
	 * @throws DALException 
	 */
	public List<Card> selectVentesTerminer (Integer no_utilisateur) throws DALException ;
}
