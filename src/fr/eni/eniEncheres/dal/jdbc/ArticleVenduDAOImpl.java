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
import fr.eni.eniEncheres.bo.Retrait;
import fr.eni.eniEncheres.dal.ArticleVenduDAO;
import fr.eni.eniEncheres.dal.DALException;
import fr.eni.eniEncheres.dal.UtilisateurDAO;
import fr.eni.eniEncheres.dal.UtilisateurDAOFact;

public class ArticleVenduDAOImpl implements ArticleVenduDAO {
	private final String INSERT = "INSERT INTO ARTICLES_VENDUS(nom_article,description, date_debut_encheres,date_fin_encheres, prix_initial,prix_vente,no_utilisateur,no_categorie,etat_vente) VALUES (?,?,?,?,?,?,?,?,?)";
	private final String INSERTRETRAIT = "INSERT INTO RETRAIT  (no_article,rue,code_postal,ville) VALUES(?,?,?,? )";
	private final String UPDATE = "UPDATE ARTICLES_VENDUS SET nom_article=?,description=?, date_debut_encheres=?,date_fin_encheres=?, prix_initial=?,prix_vente=?,no_utilisateur=?,no_categorie=? WHERE no_article = ?";
	private final String DELETE = "DELETE FROM ARTICLES_VENDUS WHERE no_article =?";
	private final String SELECT = "SELECT no_article,nom_article,description, date_debut_encheres,date_fin_encheres, prix_initial,prix_vente,no_utilisateur,no_categorie,etat_vente FROM ARTICLES_VENDUS";
	private final String SELECTBYNUMEROCAT = "SELECT no_categorie,libelle FROM CATEGORIES WHERE no_categorie=?";
	private final String SELECTARTICLEBYID = "SELECT no_article,nom_article,description, date_debut_encheres,date_fin_encheres, prix_initial,prix_vente,no_utilisateur,no_categorie,etat_vente FROM ARTICLES_VENDUS WHERE no_article=?";
	private final String SELECT_RETRAIT_BY_NO_ARTICLE = "SELECT rue, code_postal, ville FROM RETRAITS WHERE no_article = ?";

	@Override
	public void insert(ArticleVendu articleVendu) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, articleVendu.getNomArticle());
			stmt.setString(2, articleVendu.getDescription());
			// conversion LocalDate en java.sql.date
			java.sql.Date jsd = java.sql.Date.valueOf(articleVendu.getDateDebutEncheres());
			stmt.setDate(3, jsd);
			java.sql.Date jsd2 = java.sql.Date.valueOf(articleVendu.getDateFinEncheres());
			stmt.setDate(4, jsd2);
			stmt.setInt(5, articleVendu.getMiseAprix());
			stmt.setInt(6, 0);
			stmt.setInt(7, articleVendu.getUtilisateur().getNoUtilisateur());
			stmt.setInt(8, articleVendu.getCategorie().getNoCategorie());
			stmt.setBoolean(9, articleVendu.getEtatVente());

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
	public void insertRetrait(Retrait retrait) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(INSERTRETRAIT);
			stmt.setInt(1, retrait.getArticleVendu().getNoArticle());
			stmt.setString(2, retrait.getArticleVendu().getUtilisateur().getRue());
			stmt.setString(3, retrait.getArticleVendu().getUtilisateur().getCodePostal());
			stmt.setString(4,retrait.getArticleVendu().getUtilisateur().getVille());
			stmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
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
		UtilisateurDAO daoUser = UtilisateurDAOFact.getInstanceDAO();
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
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

				// Je sélectionne l'utilisateur par le numéro d'utilisateur contenue dans la
				// table ArticleVendu
				articleVendu.setUtilisateur(daoUser.getByID(Integer.parseInt(rs.getString("no_utilisateur"))));

				articleVendu.setCategorie(selectCategorieByNumeroCategorie(rs.getInt("no_categorie")));
				articleVendu.setEtatVente(Boolean.parseBoolean(rs.getString("etat_vente")));
				result.add(articleVendu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Problème SQL");
		}
		return result;
	}

	@Override
	public Categorie selectCategorieByNumeroCategorie(Integer numeroCategorie) throws DALException {

		Categorie categorie = new Categorie();
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECTBYNUMEROCAT);
			stmt.setInt(1, numeroCategorie);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {

				categorie.setLibelle(rs.getString("libelle"));
				categorie.setNoCategorie(rs.getInt("no_categorie"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categorie;

	}

	@Override
	public Retrait selectRetraitByNoArticle(Integer noArticle) throws DALException {
		Retrait ret = new Retrait();
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_RETRAIT_BY_NO_ARTICLE);
			stmt.setInt(1, noArticle);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				ret.setCode_postal(rs.getString("code_postal"));
				ret.setRue(rs.getString("rue"));
				ret.setVille(rs.getString("ville"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;

	}

	@Override
	public ArticleVendu getArticleVenduById(int id) throws DALException {
		ArticleVendu articleVendu = new ArticleVendu();
		UtilisateurDAO daoUser = UtilisateurDAOFact.getInstanceDAO();
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECTARTICLEBYID);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {

				articleVendu.setNoArticle(rs.getInt("no_article"));
				articleVendu.setNomArticle(rs.getString("nom_article"));
				articleVendu.setDescription(rs.getString("description"));
				java.sql.Date jsd = java.sql.Date.valueOf(rs.getString("date_debut_encheres"));
				LocalDate ld = jsd.toLocalDate();
				articleVendu.setDateDebutEncheres(ld);
				java.sql.Date jsd2 = java.sql.Date.valueOf(rs.getString("date_debut_encheres"));
				LocalDate ld2 = jsd2.toLocalDate();
				articleVendu.setDateFinEncheres(ld2);
				articleVendu.setMiseAprix(Integer.parseInt(rs.getString("prix_initial")));
				articleVendu.setPrixVente(Integer.parseInt(rs.getString("prix_vente")));

				articleVendu.setUtilisateur(daoUser.getByID(Integer.parseInt(rs.getString("no_utilisateur"))));
				articleVendu.setCategorie(selectCategorieByNumeroCategorie(rs.getInt("no_categorie")));
				articleVendu.setEtatVente(Boolean.parseBoolean(rs.getString("etat_vente")));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return articleVendu;
	}


}