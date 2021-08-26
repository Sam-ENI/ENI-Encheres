package fr.eni.eniEncheres.dal;

import java.util.List;

import fr.eni.eniEncheres.bo.ArticleVendu;
import fr.eni.eniEncheres.bo.Categorie;
import fr.eni.eniEncheres.bo.Retrait;

public interface ArticleVenduDAO {
	public void insert(ArticleVendu articleVendu) throws DALException;

	public void insertRetrait(Retrait retrait) throws DALException;

	public void update(ArticleVendu articleVendu) throws DALException;

	public void delete(ArticleVendu articleVendu) throws DALException;

	public List<ArticleVendu> getAll() throws DALException;

	public Categorie selectCategorieByNumeroCategorie(Integer numeroCategorie) throws DALException;

	public ArticleVendu getArticleVenduById(int id) throws DALException;

	Retrait selectRetraitByNoArticle(Integer noArticle) throws DALException;
}
