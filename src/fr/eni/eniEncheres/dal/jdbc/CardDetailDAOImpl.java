package fr.eni.eniEncheres.dal.jdbc;

import java.util.List;

import fr.eni.eniEncheres.dal.CardDetailDAO;
import fr.eni.eniEncheres.dto.CardDetail;

public class CardDetailDAOImpl implements CardDetailDAO{

	private final String SELECT_ENCHERE_OUVERTES_BY_NO_UTILISATEUR =  "SELECT nom_article, description, libelle, montant_enchere, u1.pseudo AS pseudo_enchereur,"  
			+ " date_fin_encheres, prix_initial, r.rue, r.code_postal, r.ville, u2.pseudo AS pseudo_vendeur FROM ENCHERES e"
			+ "INNER JOIN ARTICLES_VENDUS av ON av.no_article = e.no_article"
			+ "INNER JOIN UTILISATEURS u2 ON u2.no_utilisateur = av.no_utilisateur"
			+ "INNER JOIN RETRAITS r ON av.no_article = r.no_article"
			+ "INNER JOIN CATEGORIES c ON c.no_categorie = av.no_categorie"
			+ "INNER JOIN UTILISATEURS u1 ON u1.no_utilisateur = e.no_utilisateur"
			+ "WHERE av.date_fin_encheres > SYSDATETIME() '";
	
	private final String SELECT_ENCHERE_EN_COURS_BY_NO_UTILISATEUR = "SELECT nom_article, description, libelle, montant_enchere, u1.pseudo AS pseudo_enchereur, date_fin_encheres, prix_initial, r.rue, r.code_postal, r.ville, u2.pseudo AS pseudo_vendeur FROM ENCHERES e\r\n" + 
			"INNER JOIN ARTICLES_VENDUS av ON av.no_article = e.no_article\r\n" + 
			"INNER JOIN UTILISATEURS u2 ON u2.no_utilisateur = av.no_utilisateur\r\n" + 
			"INNER JOIN RETRAITS r ON av.no_article = r.no_article\r\n" + 
			"INNER JOIN CATEGORIES c ON c.no_categorie = av.no_categorie\r\n" + 
			"INNER JOIN UTILISATEURS u1 ON u1.no_utilisateur = e.no_utilisateur\r\n" + 
			"WHERE av.date_fin_encheres > SYSDATETIME()  AND  e.no_utilisateur = ?";
	
	private final String SELECT_ENCHERE_REMPORTER_BY_NO_UTILISATEUR = "SELECT nom_article, description, libelle, montant_enchere, u1.pseudo AS pseudo_enchereur, date_fin_encheres, prix_initial, r.rue, r.code_postal, r.ville, u2.pseudo AS pseudo_vendeur FROM ENCHERES e\r\n" + 
			"INNER JOIN ARTICLES_VENDUS av ON av.no_article = e.no_article\r\n" + 
			"INNER JOIN UTILISATEURS u2 ON u2.no_utilisateur = av.no_utilisateur\r\n" + 
			"INNER JOIN RETRAITS r ON av.no_article = r.no_article\r\n" + 
			"INNER JOIN CATEGORIES c ON c.no_categorie = av.no_categorie\r\n" + 
			"INNER JOIN UTILISATEURS u1 ON u1.no_utilisateur = e.no_utilisateur\r\n" + 
			"WHERE av.date_fin_encheres < SYSDATETIME()  AND  e.no_utilisateur = ?";
	
	private final String SELECT_VENTE_EN_COURS_BY_NO_UTILISATEUR = "SELECT nom_article, description, libelle, montant_enchere, u1.pseudo AS pseudo_enchereur, date_fin_encheres, prix_initial, r.rue, r.code_postal, r.ville, u2.pseudo AS pseudo_vendeur FROM ENCHERES e\r\n" + 
			"INNER JOIN ARTICLES_VENDUS av ON av.no_article = e.no_article\r\n" + 
			"INNER JOIN UTILISATEURS u2 ON u2.no_utilisateur = av.no_utilisateur\r\n" + 
			"INNER JOIN RETRAITS r ON av.no_article = r.no_article\r\n" + 
			"INNER JOIN CATEGORIES c ON c.no_categorie = av.no_categorie\r\n" + 
			"INNER JOIN UTILISATEURS u1 ON u1.no_utilisateur = e.no_utilisateur\r\n" + 
			"WHERE av.date_fin_encheres > SYSDATETIME()  AND  av.no_utilisateur = ?";
	
	private final String SELECT_VENTE_NON_DEBUTER_BY_NO_UTILISATEUR = "SELECT nom_article, description, libelle, montant_enchere, u1.pseudo AS pseudo_enchereur, date_fin_encheres, prix_initial, r.rue, r.code_postal, r.ville, u2.pseudo AS pseudo_vendeur FROM ENCHERES e\r\n" + 
			"INNER JOIN ARTICLES_VENDUS av ON av.no_article = e.no_article\r\n" + 
			"INNER JOIN UTILISATEURS u2 ON u2.no_utilisateur = av.no_utilisateur\r\n" + 
			"INNER JOIN RETRAITS r ON av.no_article = r.no_article\r\n" + 
			"INNER JOIN CATEGORIES c ON c.no_categorie = av.no_categorie\r\n" + 
			"INNER JOIN UTILISATEURS u1 ON u1.no_utilisateur = e.no_utilisateur\r\n" + 
			"WHERE av.date_debut_encheres > SYSDATETIME()  AND  av.no_utilisateur = ?";
	
	private final String SELECT_VENTE_TERMINER_BY_NO_UTILISATEUR = "SELECT nom_article, description, libelle, montant_enchere, u1.pseudo AS pseudo_enchereur, date_fin_encheres, prix_initial, r.rue, r.code_postal, r.ville, u2.pseudo AS pseudo_vendeur FROM ENCHERES e\r\n" + 
			"INNER JOIN ARTICLES_VENDUS av ON av.no_article = e.no_article\r\n" + 
			"INNER JOIN UTILISATEURS u2 ON u2.no_utilisateur = av.no_utilisateur\r\n" + 
			"INNER JOIN RETRAITS r ON av.no_article = r.no_article\r\n" + 
			"INNER JOIN CATEGORIES c ON c.no_categorie = av.no_categorie\r\n" + 
			"INNER JOIN UTILISATEURS u1 ON u1.no_utilisateur = e.no_utilisateur\r\n" + 
			"WHERE av.date_fin_encheres < SYSDATETIME()  AND  av.no_utilisateur = ?";
	
	@Override
	public List<CardDetail> selectEnchereOuvertes(Integer no_utilisateur) {
		return null;
	}

	@Override
	public List<CardDetail> selectEnchereEnCours(Integer no_utilisateur) {
		return null;
	}

	@Override
	public List<CardDetail> selectEnchereRemporter(Integer no_utilisateur) {
		return null;
	}

	@Override
	public List<CardDetail> selectVentesEnCours(Integer no_utilisateur) {
		return null;
	}

	@Override
	public List<CardDetail> selectVentesNonDebuter(Integer no_utilisateur) {
		return null;
	}

	@Override
	public List<CardDetail> selectVentesTerminer(Integer no_utilisateur) {
		return null;
	}

}
