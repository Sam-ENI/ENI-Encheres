package fr.eni.eniEncheres.ihm;

import java.util.ArrayList;
import java.util.List;

import fr.eni.eniEncheres.bo.Utilisateur;

/**
 * Classe du modèle de l'utilisateur
 * 
 * @author FRANDIN/AKAFFOU/BRAULT
 *
 */
public class UtilisateurModel {

	private Utilisateur utilisateur;
	private List<Utilisateur> lstUtilisateur = new ArrayList<>();

	public UtilisateurModel() {
		super();
	}

	public UtilisateurModel(Utilisateur utilisateur, List<Utilisateur> lstUtilisateur) {
		super();
		this.utilisateur = utilisateur;
		this.lstUtilisateur = lstUtilisateur;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public List<Utilisateur> getLstUtilisateur() {
		return lstUtilisateur;
	}

	public void setLstUtilisateur(List<Utilisateur> lstUtilisateur) {
		this.lstUtilisateur = lstUtilisateur;
	}

	@Override
	public String toString() {
		return "UtilisateurModel [utilisateur=" + utilisateur + ", lstUtilisateur=" + lstUtilisateur + "]";
	}

}
