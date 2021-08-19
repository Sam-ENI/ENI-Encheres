package fr.eni.eniEncheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.eni.eniEncheres.bo.ArticleVendu;
import fr.eni.eniEncheres.bo.Utilisateur;
import fr.eni.eniEncheres.dal.ArticleVenduDAO;
import fr.eni.eniEncheres.dal.DALException;

public class ArticleVenduImpl implements ArticleVenduDAO {
	private final String INSERT = "INSERT INTO ARTICLES_VENDUS(nom_article,description, date_debut_encheres,date_fin_encheres, prix_initial,prix_vente,no_utilisateur,no_categorie) VALUES (?,?,?,?,?,?,?,?)";
	private final String UPDATE = "UPDATE ARTICLES_VENDUS SET nom_article=?,description=?, date_debut_encheres=?,date_fin_encheres=?, prix_initial=?,prix_vente=?,no_utilisateur=?,no_categorie=? WHERE no_article = ?";
	private final String DELETE = "DELETE FROM ARTICLES_VENDUS WHERE no_article =?";
	private final String SELECT = "SELECT nom_article,description, date_debut_encheres,date_fin_encheres, prix_initial,prix_vente,no_utilisateur,no_categorie FROM ARTICLES_VENDUS";

	@Override
	public void insert(ArticleVendu articleVendu) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1,articleVendu.getNomArticle());
			stmt.setString(2,articleVendu.getDescription());
			// conversion LocalDate en java.sql.date
			java.sql.Date jsd = java.sql.Date.valueOf(articleVendu.getDateDebutEncheres());
			stmt.setDate(3,jsd);
			java.sql.Date jsd2 = java.sql.Date.valueOf(articleVendu.getDateFinEncheres());
			stmt.setDate(4,jsd2 );
			stmt.setInt(5,articleVendu.getMiseAprix());
			stmt.setInt(6,articleVendu.getPrixVente());
			stmt.setInt(7,articleVendu.getNoUtilisateur());
			stmt.setInt(8,articleVendu.getNoCategorie());
		

			int nb = stmt.executeUpdate();
			if (nb > 0) {
				ResultSet rs = stmt.getGeneratedKeys();
				if (rs.next()) {
					articleVendu.setNoArticle(rs.getInt(1));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Problème SQL lors de l'insertion");
		}

	}

	@Override
	public void update(ArticleVendu articleVendu) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(ArticleVendu articleVendu) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(DELETE);
			stmt.setInt(1, articleVendu.getNoArticle());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Problème SQL");
		}


	}

	@Override
	public List<ArticleVendu> getAll() throws DALException {
		List<ArticleVendu> result = new ArrayList<ArticleVendu>();
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				ArticleVendu articleVendu = new ArticleVendu();
				articleVendu.setNoArticle(rs.getInt("no_article"));
				articleVendu.setNomArticle(rs.getString("nom_article"));
				articleVendu.setDescription(rs.getString("description"));
				// conversion sql.date en LocalDAte
				java.sql.Date jsd = java.sql.Date.valueOf(rs.getString("date_debut_encheres"));
				LocalDate ld = jsd.toLocalDate();
				articleVendu.setDateDebutEncheres(ld);
				java.sql.Date jsd2 = java.sql.Date.valueOf(rs.getString("date_debut_encheres"));
				LocalDate ld2 = jsd2.toLocalDate();
				articleVendu.setDateFinEncheres(ld2);
				articleVendu.setMiseAprix(Integer.parseInt(rs.getString("prix_initial")));
				articleVendu.setPrixVente(Integer.parseInt(rs.getString("prix_vente")));
				articleVendu.setNoUtilisateur(Integer.parseInt(rs.getString("no_utilisateur")));
				articleVendu.setNoCategorie(Integer.parseInt(rs.getString("no_categorie")));
				;
			
				
				result.add(articleVendu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Problème SQL");
		}
		return result;
	}

}
