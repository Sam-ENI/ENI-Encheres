package fr.eni.eniEncheres.BLL;

import java.util.List;

import fr.eni.eniEncheres.BO.Utilisateur;
import fr.eni.eniEncheres.DAL.DALException;
import fr.eni.eniEncheres.DAL.UtilisateurDAO;
import fr.eni.eniEncheres.DAL.UtilisateurDAOFact;

public class UtilisateurManagerImpl implements UtilisateurManager {
	UtilisateurDAO dao = UtilisateurDAOFact.getInstanceDAO();
	
	@Override
	public void addUtilisateur(Utilisateur utilisateur) throws BLLException {
		try {
			dao.insert(utilisateur);
		} catch (DALException e) {
			throw new BLLException("SQL Exception" + e.getMessage());
		}
	}

	@Override
	public void deleteUtilisateur(Utilisateur utilisateur) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUtilisateur(Utilisateur utilisateur) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Utilisateur> getAllUtilisateur() {
		// TODO Auto-generated method stub
		return null;
	}

}
