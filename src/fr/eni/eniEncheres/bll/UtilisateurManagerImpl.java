package fr.eni.eniEncheres.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.eniEncheres.bo.Utilisateur;
import fr.eni.eniEncheres.dal.DALException;
import fr.eni.eniEncheres.dal.UtilisateurDAO;
import fr.eni.eniEncheres.dal.UtilisateurDAOFact;

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
	
	// Créer un user temp pour recup le contact dans la boucle
	// le retourner 
	public Utilisateur isUserExist(String pseudo, String mdp) throws BLLException {
		boolean isExist = false;
		Utilisateur utilisateurTemp = null;
		// Verification si l'utilisateur existe dans la BDD
		try {
			for (Utilisateur utilisateur : dao.getAll()) {
				if (utilisateur.getMotDePasse().equals(mdp)
						&& utilisateur.getPseudo().equals(pseudo)) {
					utilisateurTemp = utilisateur;
					isExist = true;
				}
			}
		} catch (DALException e) {
			e.printStackTrace();
		}
		
		// Si l'user existe : Retourne TRUE
		// Sinon : Crée une exeception
		if (isExist)
			return utilisateurTemp;
		else
			throw new BLLException("Mauvais pseudo/mdp !");
	}
	
	public boolean verifInscription(String mdp, String mdpConfirm, String pseudo, String mail) throws BLLException {
		// Verification si les deux mdp corresponde
		if (!mdp.equals(mdpConfirm))
			throw new BLLException("Les deux mots de passe ne correspondent pas !");
		// Vérification si le mot de passe est alphanumérique
		if(pseudo == null || !pseudo.matches("^[a-zA-Z0-9]*$")) 
			throw new BLLException("Le pseudo ne peut contenir que des caractères alphanumérique [a-z] / [A-Z] / [0-9]");
		// Vérification si pseudo/email est unique
		try {
			for (Utilisateur user : dao.getAll()) {
				if (user.getPseudo().equals(pseudo))
					throw new BLLException("Le pseudo est déjà utilisé !");
				if (user.getEmail().equals(mail))
					throw new BLLException("L'email est déjà utilisé !");
			}
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}

}
