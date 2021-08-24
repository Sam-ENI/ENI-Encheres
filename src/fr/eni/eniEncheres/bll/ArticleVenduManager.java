package fr.eni.eniEncheres.bll;

import java.util.List;

import fr.eni.eniEncheres.bo.ArticleVendu;
import fr.eni.eniEncheres.bo.Categorie;
import fr.eni.eniEncheres.dto.Card;

public interface ArticleVenduManager {
	public void addArticleVendu(ArticleVendu articleVendu) throws BLLException;

	public void deleteArticleVendu(ArticleVendu articleVendu) throws BLLException;

	public void updateArticleVendu(ArticleVendu articleVendu) throws BLLException;

	public List<ArticleVendu> getAllArticleVendu() throws BLLException;
	
	public ArticleVendu getArticleByName (String string) throws BLLException;
	
	public ArticleVendu getArticleVenduById (int id )throws BLLException;
	
	public Categorie getCategById (int id);
	
	public List<Card> getListArticleByName(String name);
	
	public List<Card> getListArticleByCat(Integer cat);
}
