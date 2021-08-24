package fr.eni.eniEncheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.eniEncheres.bo.ArticleVendu;
import fr.eni.eniEncheres.bo.Categorie;
import fr.eni.eniEncheres.bo.Enchere;
import fr.eni.eniEncheres.dal.ArticleVenduDAO;
import fr.eni.eniEncheres.dal.ArticleVenduDAOFact;
import fr.eni.eniEncheres.dal.DALException;
import fr.eni.eniEncheres.dal.EnchereDAO;
import fr.eni.eniEncheres.dal.UtilisateurDAO;
import fr.eni.eniEncheres.dal.UtilisateurDAOFact;

public class EnchereDAOImpl implements EnchereDAO {
	private final String INSERT = "INSERT INTO ENCHERES(no_utilisateur,no_article,date_enchere,montant_enchere) VALUES (?,?,?,?)";
	private final String UPDATE = "UPDATE ENCHERES SET no_utilisateur =?,no_article=?,date_enchere=?, montant_enchere=? WHERE no_article = ?";
	private final String DELETE = "DELETE FROM ENCHERES WHERE no_utilisateur =? and no_article =?";
	private final String SELECT = "SELECT no_utilisateur,no_article,date_enchere,montant_enchere FROM ENCHERES";
	private final String SELECTBYID = "SELECT no_categorie,libelle FROM ENCHERES WHERE no_categorie=?";

	@Override
	public void insert(Enchere enchere) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(INSERT);
			stmt.setInt(1, enchere.getUtilisateur().getNoUtilisateur());
			stmt.setInt(2, enchere.getArticleVendu().getNoArticle());
			// conversion LocalDate en java.sql.date
			java.sql.Date jsd = java.sql.Date.valueOf(enchere.getDateEnchere());
			stmt.setDate(3, jsd);
			stmt.setInt(4, enchere.getMontant_enchere());
			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(Enchere enchere) throws DALException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Enchere enchere) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(DELETE);
			stmt.setInt(1, enchere.getUtilisateur().getNoUtilisateur());
			stmt.setInt(2, enchere.getArticleVendu().getNoArticle());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Problème SQL");
		}

	}

	@Override
	public List<Enchere> getAll() throws DALException {
		List<Enchere> result = new ArrayList<Enchere>();
		UtilisateurDAO daoUser = UtilisateurDAOFact.getInstanceDAO();
		ArticleVenduDAO daoAticle = ArticleVenduDAOFact.getInstanceDAO();
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Enchere enchere = new Enchere();
				enchere.setUtilisateur(daoUser.getByID(Integer.parseInt(rs.getString("no_utilisateur"))));
				enchere.setArticleVendu(daoAticle.getArticleVenduById(Integer.parseInt(rs.getString("no_article"))));
				
				LocalDate ld = rs.getDate("date_enchere").toLocalDate();
				enchere.setDateEnchere(ld);
				enchere.setMontant_enchere(rs.getInt("montant_enchere"));
				result.add(enchere);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Problème SQL");
		}
		return result;
	}

	@Override
	public Categorie selectEnchereByID(Integer numeroEnchere) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

}
