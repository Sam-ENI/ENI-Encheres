package fr.eni.eniEncheres.DAL;

import java.util.List;

import fr.eni.eniEncheres.BO.Utilisateur;

public interface UtilisateurDAO {
	public void insert(Utilisateur utilisateur) throws DALException;

	public void update(Utilisateur utilisateur) throws DALException;

	public void delete(Utilisateur utilisateur) throws DALException;

	public List<Utilisateur> getAll() throws DALException;

}
