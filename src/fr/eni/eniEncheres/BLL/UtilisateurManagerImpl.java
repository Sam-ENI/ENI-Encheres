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
	
	
	public boolean isUserExist(String pseudo, String mdp) throws BLLException {
		boolean isExist = false;
		// Verification si l'utilisateur existe dans la BDD
		try {
			for (Utilisateur utilisateur : dao.getAll()) {
				if (utilisateur.getMotDePasse().equals(mdp)
						&& utilisateur.getPseudo().equals(pseudo)) {
					isExist = true;
				}
			}
		} catch (DALException e) {
			e.printStackTrace();
		}
		
		// Si l'user existe : Retourne TRUE
		// Sinon : Crée une exeception
		if (isExist)
			return true;
		else
			throw new BLLException("Mauvais pseudo/mdp !");
		
	}

}
