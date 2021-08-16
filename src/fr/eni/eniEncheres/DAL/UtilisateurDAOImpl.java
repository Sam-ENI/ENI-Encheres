package fr.eni.eniEncheres.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import fr.eni.eniEncheres.BO.Utilisateur;


public class UtilisateurDAOImpl implements UtilisateurDAO {
	private final String INSERT = "INSERT INTO utilisateur(pseudo,nom, prenom,email, telephone,rue,codePostal,ville,motDePasse,credit,administrateur) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	private final String UPDATE = "UPDATE utilisateur SET pseudo=?,nom=?, prenom=?,email=?, telephone=?,rue=?,codePostal=?,ville=?,motDePasse=?,credit=?,administrateur=? WHERE noUtilisateur = ?";
	private final String DELETE = "DELETE FROM utilisateur WHERE noUtilisateur =?";
	private final String SELECT = "SELECT noUtilisateur ,pseudo,nom, prenom,email, telephone,rue,codePostal,ville,motDePasse,credit,administrateur FROM utilisateur";

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
			stmt.setInt(10, utilisateur.getCredit());
			stmt.setBoolean(11, utilisateur.getAdministrateur());

			int nb = stmt.executeUpdate();
			if (nb > 0) {
				ResultSet rs = stmt.getGeneratedKeys();
				if (rs.next()) {
					utilisateur.setNoUtilsateur(rs.getInt(1));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Probl�me SQL lors de l'insertion");
		}
	}

	@Override
	public void update(Utilisateur utilisateur) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Utilisateur utilisateur) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Utilisateur> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}