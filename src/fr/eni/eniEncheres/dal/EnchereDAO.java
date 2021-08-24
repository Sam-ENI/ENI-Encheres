package fr.eni.eniEncheres.dal;

import java.util.List;

import fr.eni.eniEncheres.bo.ArticleVendu;
import fr.eni.eniEncheres.bo.Categorie;
import fr.eni.eniEncheres.bo.Enchere;

public interface EnchereDAO {
	public void insert(Enchere enchere) throws DALException ;

	public void update(Enchere enchere)throws DALException;

	public void delete(Enchere enchere) throws DALException;

	public List<Enchere> getAll() throws DALException;
	
	public Categorie selectEnchereByID (Integer numeroEnchere)throws DALException;
}
