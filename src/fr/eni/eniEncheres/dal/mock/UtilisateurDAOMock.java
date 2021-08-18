package fr.eni.eniEncheres.dal.mock;

import java.util.ArrayList;
import java.util.List;

import fr.eni.eniEncheres.bo.Utilisateur;
import fr.eni.eniEncheres.dal.UtilisateurDAO;

public class UtilisateurDAOMock implements UtilisateurDAO{

	List<Utilisateur> lstUser = new ArrayList<>();
	Integer cpt =0;
	
	@Override
	public void insert(Utilisateur utilisateur) {
		utilisateur.setNoUtilsateur(cpt++);
		lstUser.add(utilisateur);
	}

	@Override
	public void update(Utilisateur utilisateur) {
		int cptLst = 0;
		for(Utilisateur user : lstUser) {
		    if(user!=null && utilisateur.getNoUtilsateur() == user.getNoUtilsateur()) {
		        lstUser.set(cptLst, utilisateur);
		        break;
		    }
		    cptLst++;
		}
	}

	@Override
	public void delete(Utilisateur utilisateur) {
		lstUser.removeIf(u -> u.getNoUtilsateur()== utilisateur.getNoUtilsateur());
	}

	@Override
	public List<Utilisateur> getAll() {
		return lstUser;
	}

}
