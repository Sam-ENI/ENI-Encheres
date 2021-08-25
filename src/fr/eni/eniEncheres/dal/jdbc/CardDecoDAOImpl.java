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
import fr.eni.eniEncheres.dto.Card;

public class CardDecoDAOImpl implements CardDecoDAO {
	private final String SELECT_ALL_BY_NOM = ("SELECT nom_article, montant_enchere, date_fin_encheres, u.pseudo FROM ENCHERES e"
			+ " INNER JOIN ARTICLES_VENDUS av ON e.no_article = av.no_article"
			+ " INNER JOIN UTILISATEURS u ON u.no_utilisateur = av.no_utilisateur" + " WHERE nom_article LIKE ? ");

	private final String SELECT_ALL_BY_CAT = ("SELECT nom_article, montant_enchere, date_fin_encheres, u.pseudo FROM ENCHERES e"
			+ " INNER JOIN ARTICLES_VENDUS av ON e.no_article = av.no_article"
			+ " INNER JOIN UTILISATEURS u ON u.no_utilisateur = av.no_utilisateur"
			+ " INNER JOIN CATEGORIES c ON c.no_categorie = av.no_categorie" + " WHERE av.no_categorie = ?");

	private final String SELECT_ALL_BY_NOM_AND_CAT = ("SELECT nom_article, montant_enchere, date_fin_encheres, u.pseudo FROM ENCHERES e"
			+ " INNER JOIN ARTICLES_VENDUS av ON e.no_article = av.no_article"
			+ " INNER JOIN UTILISATEURS u ON u.no_utilisateur = av.no_utilisateur"
			+ " INNER JOIN CATEGORIES c ON c.no_categorie = av.no_categorie" + " WHERE av.no_categorie = ?"
			+ " AND nom_article LIKE ?");

	private final String SELECT_ENCHERE_OUVERTES = "SELECT nom_article, montant_enchere, date_fin_encheres, pseudo FROM ENCHERES e"
			+ " INNER JOIN ARTICLES_VENDUS av ON e.no_article = av.no_article"
			+ " INNER JOIN UTILISATEURS u ON u.no_utilisateur = av.no_utilisateur"
			+ " WHERE av.date_fin_encheres > SYSDATETIME()  AND av.date_debut_encheres < SYSDATETIME()";

	private final String SELECT_ENCHERE_EN_COURS_BY_NO_UTILISATEUR = "SELECT nom_article, montant_enchere, date_fin_encheres, pseudo FROM ENCHERES e"
			+ " INNER JOIN ARTICLES_VENDUS av ON av.no_article = e.no_article"
			+ " INNER JOIN UTILISATEURS u ON u.no_utilisateur = av.no_utilisateur"
			+ " WHERE av.date_fin_encheres > SYSDATETIME() AND av.date_debut_encheres < SYSDATETIME() AND  e.no_utilisateur = ?";

	private final String SELECT_ENCHERE_REMPORTER_BY_NO_UTILISATEUR = "SELECT nom_article, montant_enchere, date_fin_encheres, pseudo FROM ENCHERES e"
			+ " INNER JOIN ARTICLES_VENDUS av ON av.no_article = e.no_article"
			+ " INNER JOIN UTILISATEURS u ON u.no_utilisateur = av.no_utilisateur"
			+ " WHERE av.date_fin_encheres < SYSDATETIME()  AND  e.no_utilisateur = ?";

	private final String SELECT_VENTE_EN_COURS_BY_NO_UTILISATEUR = "SELECT nom_article, montant_enchere, date_fin_encheres, pseudo FROM ENCHERES e"
			+ " INNER JOIN ARTICLES_VENDUS av ON av.no_article = e.no_article"
			+ " INNER JOIN UTILISATEURS u ON u.no_utilisateur = av.no_utilisateur"
			+ " WHERE av.date_fin_encheres > SYSDATETIME() AND av.date_debut_encheres < SYSDATETIME()  AND  av.no_utilisateur = ?";

	private final String SELECT_VENTE_NON_DEBUTER_BY_NO_UTILISATEUR = "SELECT nom_article, montant_enchere, date_fin_encheres, pseudo FROM ENCHERES e"
			+ " INNER JOIN ARTICLES_VENDUS av ON av.no_article = e.no_article"
			+ " INNER JOIN UTILISATEURS u ON u.no_utilisateur = av.no_utilisateur"
			+ " WHERE av.date_debut_encheres > SYSDATETIME()  AND  av.no_utilisateur = ?";

	private final String SELECT_VENTE_TERMINER_BY_NO_UTILISATEUR = "SELECT nom_article, montant_enchere, date_fin_encheres, pseudo FROM ENCHERES e"
			+ " INNER JOIN ARTICLES_VENDUS av ON av.no_article = e.no_article"
			+ " INNER JOIN UTILISATEURS u ON u.no_utilisateur = av.no_utilisateur"
			+ " WHERE av.date_fin_encheres < SYSDATETIME()  AND  av.no_utilisateur = ?";

	@Override
	public List<Card> selectAllByNomArt(String saisie) throws DALException {
		List<Card> result = new ArrayList<>();
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_ALL_BY_NOM);
			stmt.setString(1, "%" + saisie + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Card card = new Card();
				card.setNomArticle(rs.getString("nom_article"));
				card.setPrixInitial(rs.getInt("montant_enchere"));
				card.setDateFinEncheres((rs.getDate("date_fin_encheres")).toLocalDate());
				card.setNomVendeur(rs.getString("pseudo"));
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
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_ALL_BY_CAT);
			stmt.setInt(1, cat);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Card card = new Card();
				card.setNomArticle(rs.getString("nom_article"));
				card.setPrixInitial(rs.getInt("montant_enchere"));
				card.setDateFinEncheres((rs.getDate("date_fin_encheres")).toLocalDate());
				card.setNomVendeur(rs.getString("pseudo"));
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
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_ALL_BY_NOM_AND_CAT);
			stmt.setInt(1, cat);
			stmt.setString(2, "%" + saisie + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Card card = new Card();
				card.setNomArticle(rs.getString("nom_article"));
				card.setPrixInitial(rs.getInt("montant_enchere"));
				card.setDateFinEncheres((rs.getDate("date_fin_encheres")).toLocalDate());
				card.setNomVendeur(rs.getString("pseudo"));
				result.add(card);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Problème SQL lors de la selection des card par nomArticle et categorie");
		}
		return result;
	}

	@Override
	public List<Card> selectEnchereOuvertes() throws DALException {
		List<Card> result = new ArrayList<>();
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_ENCHERE_OUVERTES);
			System.out.println(stmt);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Card card = new Card();
				card.setNomArticle(rs.getString("nom_article"));
				card.setPrixInitial(rs.getInt("montant_enchere"));
				card.setDateFinEncheres((rs.getDate("date_fin_encheres")).toLocalDate());
				card.setNomVendeur(rs.getString("pseudo"));
				result.add(card);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Problème SQL lors de la selection des enchères ouvertes");
		}
		return result;
	}

	@Override
	public List<Card> selectEnchereEnCours(Integer no_utilisateur) throws DALException {
		List<Card> result = new ArrayList<>();
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_ENCHERE_EN_COURS_BY_NO_UTILISATEUR);
			stmt.setInt(1, no_utilisateur);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Card card = new Card();

				card.setNomArticle(rs.getString("nom_article"));
				card.setPrixInitial(rs.getInt("montant_enchere"));
				card.setDateFinEncheres((rs.getDate("date_fin_encheres")).toLocalDate());
				card.setNomVendeur(rs.getString("pseudo"));

				result.add(card);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Problème SQL lors de la selection des enchères En cours ");
		}
		return result;
	}

	@Override
	public List<Card> selectEnchereRemporter(Integer no_utilisateur) throws DALException {
		List<Card> result = new ArrayList<>();
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_ENCHERE_REMPORTER_BY_NO_UTILISATEUR);
			stmt.setInt(1, no_utilisateur);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Card card = new Card();

				card.setNomArticle(rs.getString("nom_article"));
				card.setPrixInitial(rs.getInt("montant_enchere"));
				card.setDateFinEncheres((rs.getDate("date_fin_encheres")).toLocalDate());
				card.setNomVendeur(rs.getString("pseudo"));

				result.add(card);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Problème SQL lors de la selection des enchères remportée ");
		}
		return result;
	}

	@Override
	public List<Card> selectVentesEnCours(Integer no_utilisateur) throws DALException {
		List<Card> result = new ArrayList<>();
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_VENTE_EN_COURS_BY_NO_UTILISATEUR);
			stmt.setInt(1, no_utilisateur);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Card card = new Card();

				card.setNomArticle(rs.getString("nom_article"));
				card.setPrixInitial(rs.getInt("montant_enchere"));
				card.setDateFinEncheres((rs.getDate("date_fin_encheres")).toLocalDate());
				card.setNomVendeur(rs.getString("pseudo"));

				result.add(card);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Problème SQL lors de la selection des ventes en cours ");
		}
		return result;
	}

	@Override
	public List<Card> selectVentesNonDebuter(Integer no_utilisateur) throws DALException {
		List<Card> result = new ArrayList<>();
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_VENTE_NON_DEBUTER_BY_NO_UTILISATEUR);
			stmt.setInt(1, no_utilisateur);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Card card = new Card();

				card.setNomArticle(rs.getString("nom_article"));
				card.setPrixInitial(rs.getInt("montant_enchere"));
				card.setDateFinEncheres((rs.getDate("date_fin_encheres")).toLocalDate());
				card.setNomVendeur(rs.getString("pseudo"));

				result.add(card);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Problème SQL lors de la selection des ventes non débutée ");
		}
		return result;
	}

	@Override
	public List<Card> selectVentesTerminer(Integer no_utilisateur) throws DALException {
		List<Card> result = new ArrayList<>();
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_VENTE_TERMINER_BY_NO_UTILISATEUR);
			stmt.setInt(1, no_utilisateur);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Card card = new Card();

				card.setNomArticle(rs.getString("nom_article"));
				card.setPrixInitial(rs.getInt("montant_enchere"));
				card.setDateFinEncheres((rs.getDate("date_fin_encheres")).toLocalDate());
				card.setNomVendeur(rs.getString("pseudo"));

				result.add(card);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Problème SQL lors de la selection des ventes terminée ");
		}
		return result;
	}

}
