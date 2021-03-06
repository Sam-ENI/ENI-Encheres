package fr.eni.eniEncheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.eniEncheres.bo.Utilisateur;
import fr.eni.eniEncheres.dal.DALException;
import fr.eni.eniEncheres.dal.UtilisateurDAO;

/**
 * Classe de l'implémentation de la DAO de l'utilisateur
 * 
 * @author FRANDIN/AKAFFOU/BRAULT
 */
public class UtilisateurDAOImpl implements UtilisateurDAO {
	private final String INSERT = "INSERT INTO UTILISATEURS(pseudo,nom, prenom,email, telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	private final String UPDATE = "UPDATE UTILISATEURS SET pseudo=?,nom=?, prenom=?,email=?, telephone=?,rue=?,code_postal=?,ville=?,mot_de_passe=?,credit=?,administrateur=? WHERE no_utilisateur = ?";
	private final String DELETE = "DELETE FROM UTILISATEURS WHERE no_utilisateur =?";
	private final String SELECT = "SELECT no_utilisateur ,pseudo,nom, prenom,email, telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur FROM UTILISATEURS";
	private final String SELECTBYID = "SELECT no_utilisateur ,pseudo,nom, prenom,email, telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur FROM UTILISATEURS WHERE no_utilisateur = ?";

	@Override
	public void insert(Utilisateur utilisateur) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, utilisateur.getPseudo());
			stmt.setString(2, utilisateur.getNom());
			stmt.setString(3, utilisateur.getPrenom());
			stmt.setString(4, utilisateur.getEmail());
			stmt.setString(5, utilisateur.getTelephone());
			stmt.setString(6, utilisateur.getRue());
			stmt.setString(7, utilisateur.getCodePostal());
			stmt.setString(8, utilisateur.getVille());
			stmt.setString(9, utilisateur.getMotDePasse());
			stmt.setInt(10, 0);
			stmt.setBoolean(11, utilisateur.getAdministrateur());

			int nb = stmt.executeUpdate();
			if (nb > 0) {
				ResultSet rs = stmt.getGeneratedKeys();
				if (rs.next()) {
					utilisateur.setNoUtilisateur(rs.getInt(1));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Problčme SQL lors de l'insertion");
		}
	}

	@Override
	public void update(Utilisateur utilisateur) throws fr.eni.eniEncheres.dal.DALException {
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(UPDATE);
			stmt.setString(1, utilisateur.getPseudo());
			stmt.setString(2, utilisateur.getNom());
			stmt.setString(3, utilisateur.getPrenom());
			stmt.setString(4, utilisateur.getEmail());
			stmt.setString(5, utilisateur.getTelephone());
			stmt.setString(6, utilisateur.getRue());
			stmt.setString(7, utilisateur.getCodePostal());
			stmt.setString(8, utilisateur.getVille());
			stmt.setString(9, utilisateur.getMotDePasse());
			stmt.setInt(10, utilisateur.getCredit());
			stmt.setBoolean(11, utilisateur.getAdministrateur());
			stmt.setInt(12, utilisateur.getNoUtilisateur());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Problčme SQL");
		}
	}

	@Override
	public void delete(Utilisateur utilisateur) throws fr.eni.eniEncheres.dal.DALException {
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(DELETE);
			stmt.setInt(1, utilisateur.getNoUtilisateur());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Problčme SQL");
		}

	}

	@Override
	public List<Utilisateur> getAll() throws fr.eni.eniEncheres.dal.DALException {
		List<Utilisateur> result = new ArrayList<Utilisateur>();
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Utilisateur utilisateur = new Utilisateur();
				utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));
				utilisateur.setPseudo(rs.getString("pseudo"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setEmail(rs.getString("email"));
				utilisateur.setTelephone(rs.getString("telephone"));
				utilisateur.setRue(rs.getString("rue"));
				utilisateur.setCodePostal(rs.getString("code_postal"));
				utilisateur.setVille(rs.getString("ville"));
				utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
				utilisateur.setCredit(rs.getInt("credit"));
				utilisateur.setAdministrateur(rs.getBoolean("administrateur"));

				result.add(utilisateur);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Problčme SQL");
		}
		return result;
	}

	@Override
	public Utilisateur getByID(int nbUtilisateur) throws fr.eni.eniEncheres.dal.DALException {
		Utilisateur utilisateur = new Utilisateur();
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECTBYID);
			stmt.setInt(1, nbUtilisateur);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));
				utilisateur.setPseudo(rs.getString("pseudo"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setEmail(rs.getString("email"));
				utilisateur.setTelephone(rs.getString("telephone"));
				utilisateur.setRue(rs.getString("rue"));
				utilisateur.setCodePostal(rs.getString("code_postal"));
				utilisateur.setVille(rs.getString("ville"));
				utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
				utilisateur.setCredit(rs.getInt("credit"));
				utilisateur.setAdministrateur(rs.getBoolean("administrateur"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Problčme SQL");
		}
		return utilisateur;
	}

}
