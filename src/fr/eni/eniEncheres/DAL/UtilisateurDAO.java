package fr.eni.eniEncheres.DAL;

import java.util.List;

import fr.eni.eniEncheres.BO.Utilisateur;

public interface UtilisateurDAO {
	public void insert(Utilisateur utilisateur);

	public void update(Utilisateur utilisateur);

	public void delete(Utilisateur utilisateur);

	public List<Utilisateur> getAll();

}
