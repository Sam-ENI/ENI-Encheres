package fr.eni.eniEncheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import fr.eni.eniEncheres.dal.CardDecoDAO;
import fr.eni.eniEncheres.dal.DALException;
import fr.eni.eniEncheres.dto.Card;

public class CardDecoDAOImpl implements CardDecoDAO {
	private final String SELECTALLBYNOM = ("SELECT nom_article, prix_initial, date_fin_encheres, nom FROM ENCHERES e"+
										  " INNER JOIN ARTICLES_VENDUS av ON e.no_article = av.no_article"+
										  " INNER JOIN UTILISATEURS u ON u.no_utilisateur = av.no_utilisateur"+
										  " WHERE nom_article LIKE ? ");
									 	 
	private final String SELECTALLBYCAT = ("SELECT nom_article, prix_initial, date_fin_encheres, nom FROM ENCHERES e"+
									 	  " INNER JOIN ARTICLES_VENDUS av ON e.no_article = av.no_article"+
									 	  " INNER JOIN UTILISATEURS u ON u.no_utilisateur = av.no_utilisateur"+
									 	  " INNER JOIN CATEGORIES c ON c.no_categorie = av.no_categorie"+
									 	  " WHERE av.no_categorie = ?");
	
	private final String SELECTALLBYNOMANDCAT = ("SELECT nom_article, prix_initial, date_fin_encheres, nom FROM ENCHERES e"+
												" INNER JOIN ARTICLES_VENDUS av ON e.no_article = av.no_article"+
												" INNER JOIN UTILISATEURS u ON u.no_utilisateur = av.no_utilisateur"+
												" INNER JOIN CATEGORIES c ON c.no_categorie = av.no_categorie"+
												" WHERE av.no_categorie = ?"+
												" AND nom_article LIKE ?");
										
	@Override
	public List<Card> selectAllByNomArt(String saisie) throws DALException {
		List<Card> result = new ArrayList<>();
		try(Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECTALLBYNOM);
			stmt.setString(1,"%"+saisie+"%");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
			Card card = new Card();
			card.setNomArticle(rs.getString("nom_article"));
			card.setPrixInitial(rs.getInt("prix_initial"));
			card.setDateFinEncheres((rs.getDate("date_fin_encheres")).toLocalDate());
			card.setNomVendeur(rs.getString("nom"));
			result.add(card);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Problème SQL lors de la selection des card par nomArticle");
		}
		return result;
	}

	@Override
	public List<Card> selectAllByCat(Integer cat) throws DALException {
		List<Card> result = new ArrayList<>();
		try(Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECTALLBYCAT);
			stmt.setInt(1,cat);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
			Card card = new Card();
			card.setNomArticle(rs.getString("nom_article"));
			card.setPrixInitial(rs.getInt("prix_initial"));
			card.setDateFinEncheres((rs.getDate("date_fin_encheres")).toLocalDate());
			card.setNomVendeur(rs.getString("nom"));
			result.add(card);
			}
		} catch (SQLException e) {
			throw new DALException("Problème SQL lors de la selection des card par categorie");
		}
		return result;
	}

	@Override
	public List<Card> selectAllByNomArtAndCat(String saisie, Integer cat) throws DALException {
		List<Card> result = new ArrayList<>();
		try(Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECTALLBYNOMANDCAT);
			stmt.setInt(1,cat);
			stmt.setString(2,"%"+saisie+"%");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
			Card card = new Card();
			card.setNomArticle(rs.getString("nom_article"));
			card.setPrixInitial(rs.getInt("prix_initial"));
			card.setDateFinEncheres((rs.getDate("date_fin_encheres")).toLocalDate());
			card.setNomVendeur(rs.getString("nom"));
			result.add(card);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Problème SQL lors de la selection des card par nomArticle et categorie");
		}
		return result;
	}

}
