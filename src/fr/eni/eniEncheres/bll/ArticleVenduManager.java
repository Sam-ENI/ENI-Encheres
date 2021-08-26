package fr.eni.eniEncheres.bll;

import java.time.LocalDate;
import java.util.List;

import fr.eni.eniEncheres.bo.ArticleVendu;
import fr.eni.eniEncheres.bo.Categorie;
import fr.eni.eniEncheres.bo.Retrait;
import fr.eni.eniEncheres.dto.Card;

public interface ArticleVenduManager {
	public void addArticleVendu(ArticleVendu articleVendu) throws BLLException;

	public void deleteArticleVendu(ArticleVendu articleVendu) throws BLLException;

	public void updateArticleVendu(ArticleVendu articleVendu) throws BLLException;

	public List<ArticleVendu> getAllArticleVendu() throws BLLException;
	
	public ArticleVendu getArticleByName (String string) throws BLLException;
	
	public Categorie getCategById (int id) throws BLLException;
	
	public List<Card> getListArticleByName(String name) throws BLLException;
	
	public List<Card> getListArticleByCat(Integer cat) throws BLLException;
	
	public List<Card> getListArticleByCatAndName(String name, Integer cat) throws BLLException;

	ArticleVendu getArticleVenduById(int id) throws BLLException;
	public Retrait getRetraitByNoArticle (int id) throws BLLException;
	public  Boolean verifNouvelArticle (String nom, String desc,Integer prixDepart, LocalDate dateDepart, LocalDate dateFin, String rue, String cp, String ville) throws BLLExceptionList;
}
