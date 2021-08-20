package fr.eni.eniEncheres.bll;

import java.util.List;

import fr.eni.eniEncheres.bo.ArticleVendu;

public interface ArticleVenduManager {
	public void addArticleVendu(ArticleVendu articleVendu) throws BLLException;

	public void deleteArticleVendu(ArticleVendu articleVendu) throws BLLException;

	public void updateArticleVendu(ArticleVendu articleVendu) throws BLLException;

	public List<ArticleVendu> getAllArticleVendu() throws BLLException;
}
