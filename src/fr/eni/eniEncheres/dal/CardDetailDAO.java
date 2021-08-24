package fr.eni.eniEncheres.dal;

import java.time.LocalDate;
import java.util.List;

import fr.eni.eniEncheres.dto.CardDetail;

public interface CardDetailDAO {

	/**
	 * Retourne une liste de Carte  d�taill� d'ench�res ouvertes selon le num�ro d'utilisateur de la session
	 * 
	 * @param no_utilisateur : le num�ro d'utilisateur de la session
	 * @return une liste de Carte d�taill�
	 */
	public List<CardDetail> selectEnchereOuvertes (Integer no_utilisateur) ;
	/**
	 * Retourne une liste de Carte  d�taill� d'ench�res en cours selon le num�ro d'utilisateur de la session
	 * 
	 * @param no_utilisateur : le num�ro d'utilisateur de la session
	 * @return une liste de Carte d�taill�
	 */
	public List<CardDetail> selectEnchereEnCours (Integer no_utilisateur) ;
	/**
	 * Retourne une liste de Carte  d�taill� d'ench�res Remport�e selon le num�ro d'utilisateur de la session
	 * 
	 * @param no_utilisateur : le num�ro d'utilisateur de la session
	 * @return une liste de Carte d�taill�
	 */
	public List<CardDetail> selectEnchereRemporter (Integer no_utilisateur) ;
	/**
	 * Retourne une liste de Carte  d�taill� de ventes en cours selon le num�ro d'utilisateur de la session
	 * 
	 * @param no_utilisateur : le num�ro d'utilisateur de la session
	 * @return une liste de Carte d�taill�
	 */
	public List<CardDetail> selectVentesEnCours (Integer no_utilisateur) ;
	/**
	 * Retourne une liste de Carte  d�taill� de ventes non d�but�es selon le num�ro d'utilisateur de la session
	 * 
	 * @param no_utilisateur : le num�ro d'utilisateur de la session
	 * @return une liste de Carte d�taill�
	 */
	public List<CardDetail> selectVentesNonDebuter (Integer no_utilisateur) ;
	/**
	 * Retourne une liste de Carte  d�taill� de ventes termin�e selon le num�ro d'utilisateur de la session
	 * 
	 * @param no_utilisateur : le num�ro d'utilisateur de la session
	 * @return une liste de Carte d�taill�
	 */
	public List<CardDetail> selectVentesTerminer (Integer no_utilisateur) ;

}
