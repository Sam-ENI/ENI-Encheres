package fr.eni.eniEncheres.BLL;

import java.util.ArrayList;
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
	public void deleteUtilisateur(Utilisateur utilisateur) throws BLLException {
		try {
			dao.delete(utilisateur);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void updateUtilisateur(Utilisateur utilisateur) throws BLLException {
		try {
			dao.update(utilisateur);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Utilisateur> getAllUtilisateur() throws BLLException {
		List<Utilisateur> listU = new ArrayList<Utilisateur>();
		try {
			listU = dao.getAll();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listU;
	}

}
