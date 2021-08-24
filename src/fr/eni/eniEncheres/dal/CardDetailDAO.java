package fr.eni.eniEncheres.dal;

import java.time.LocalDate;
import java.util.List;

import fr.eni.eniEncheres.dto.CardDetail;

public interface CardDetailDAO {

	/**
	 * Retourne une liste de Carte  détaillé d'enchères ouvertes selon le numéro d'utilisateur de la session
	 * 
	 * @param no_utilisateur : le numéro d'utilisateur de la session
	 * @return une liste de Carte détaillé
	 */
	public List<CardDetail> selectEnchereOuvertes (Integer no_utilisateur) ;
	/**
	 * Retourne une liste de Carte  détaillé d'enchères en cours selon le numéro d'utilisateur de la session
	 * 
	 * @param no_utilisateur : le numéro d'utilisateur de la session
	 * @return une liste de Carte détaillé
	 */
	public List<CardDetail> selectEnchereEnCours (Integer no_utilisateur) ;
	/**
	 * Retourne une liste de Carte  détaillé d'enchères Remportée selon le numéro d'utilisateur de la session
	 * 
	 * @param no_utilisateur : le numéro d'utilisateur de la session
	 * @return une liste de Carte détaillé
	 */
	public List<CardDetail> selectEnchereRemporter (Integer no_utilisateur) ;
	/**
	 * Retourne une liste de Carte  détaillé de ventes en cours selon le numéro d'utilisateur de la session
	 * 
	 * @param no_utilisateur : le numéro d'utilisateur de la session
	 * @return une liste de Carte détaillé
	 */
	public List<CardDetail> selectVentesEnCours (Integer no_utilisateur) ;
	/**
	 * Retourne une liste de Carte  détaillé de ventes non débutées selon le numéro d'utilisateur de la session
	 * 
	 * @param no_utilisateur : le numéro d'utilisateur de la session
	 * @return une liste de Carte détaillé
	 */
	public List<CardDetail> selectVentesNonDebuter (Integer no_utilisateur) ;
	/**
	 * Retourne une liste de Carte  détaillé de ventes terminée selon le numéro d'utilisateur de la session
	 * 
	 * @param no_utilisateur : le numéro d'utilisateur de la session
	 * @return une liste de Carte détaillé
	 */
	public List<CardDetail> selectVentesTerminer (Integer no_utilisateur) ;

}
