package fr.eni.eniEncheres.dal;

import java.util.List;

import fr.eni.eniEncheres.bo.ArticleVendu;

public interface ArticleVenduDAO {
	public void insert(ArticleVendu articleVendu) throws DALException;

	public void update(ArticleVendu articleVendu);

	public void delete(ArticleVendu articleVendu) throws DALException;

	public List<ArticleVendu> getAll() throws DALException;
}
