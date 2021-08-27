package fr.eni.eniEncheres.ihm;

import java.util.ArrayList;

import java.util.List;

import fr.eni.eniEncheres.bo.ArticleVendu;
import fr.eni.eniEncheres.bo.Categorie;
import fr.eni.eniEncheres.bo.Retrait;
import fr.eni.eniEncheres.dto.Card;

/**
 * Classe du model de l'article
 * 
 * @author FRANDIN/AKAFFOU/BRAULT
 *
 */
public class ArticleVenduModel {
	private ArticleVendu articleVendu;
	private Retrait retrait;
	private Categorie categorie;
	private List<ArticleVendu> lstArticles = new ArrayList<>();
	private List<Card> lstCard = new ArrayList<>();

	public ArticleVenduModel() {
	}

	public ArticleVenduModel(ArticleVendu articleVendu, Retrait retrait, Categorie categorie,
			List<ArticleVendu> lstArticles, List<Card> lstCard) {
		super();
		this.articleVendu = articleVendu;
		this.retrait = retrait;
		this.categorie = categorie;
		this.lstArticles = lstArticles;
		this.lstCard = lstCard;
	}

	public ArticleVendu getArticleVendu() {
		return articleVendu;
	}

	public void setArticleVendu(ArticleVendu articleVendu) {
		this.articleVendu = articleVendu;
	}

	public Retrait getRetrait() {
		return retrait;
	}

	public void setRetrait(Retrait retrait) {
		this.retrait = retrait;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public List<ArticleVendu> getLstArticles() {
		return lstArticles;
	}

	public void setLstArticles(List<ArticleVendu> lstArticles) {
		this.lstArticles = lstArticles;
	}

	public List<Card> getLstCard() {
		return lstCard;
	}

	public void setLstCard(List<Card> lstCard) {
		System.out.println("LST1 :" + lstCard);
		this.lstCard = lstCard;
	}

	@Override
	public String toString() {
		return "ArticleVenduModel [articleVendu=" + articleVendu + ", retrait=" + retrait + ", categorie=" + categorie
				+ ", lstArticles=" + lstArticles + ", lstCard=" + lstCard + "]";
	}

}
