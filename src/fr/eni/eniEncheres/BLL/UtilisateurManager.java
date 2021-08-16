package fr.eni.eniEncheres.BLL;

import java.util.List;

import fr.eni.eniEncheres.BO.Utilisateur;

public interface UtilisateurManager {

	public void addUtilisateur(Utilisateur utilisateur) throws BLLException;
	public void deleteUtilisateur(Utilisateur utilisateur)throws BLLException;
	public void updateUtilisateur(Utilisateur utilisateur)throws BLLException;
	public List<Utilisateur> getAllUtilisateur()throws BLLException;
}
