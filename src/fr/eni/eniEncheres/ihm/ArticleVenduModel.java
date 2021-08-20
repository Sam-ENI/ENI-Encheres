package fr.eni.eniEncheres.ihm;

import java.util.ArrayList;
import java.util.List;

import fr.eni.eniEncheres.bo.ArticleVendu;
import fr.eni.eniEncheres.bo.Retrait;

public class ArticleVenduModel {
	private ArticleVendu articleVendu;
	private Retrait retrait;
	private List<ArticleVendu> lstArticles = new ArrayList<>();

	public ArticleVenduModel() {

	}

	public ArticleVenduModel(ArticleVendu articleVendu, Retrait retrait, List<ArticleVendu> lstArticles) {
		super();
		this.articleVendu = articleVendu;
		this.retrait = retrait;
		this.lstArticles = lstArticles;
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

	public List<ArticleVendu> getLstArticles() {
		return lstArticles;
	}

	public void setLstArticles(List<ArticleVendu> lstArticles) {
		this.lstArticles = lstArticles;
	}

	@Override
	public String toString() {
		return "ArticleVenduModel [articleVendu=" + articleVendu + ", retrait=" + retrait + ", lstArticles="
				+ lstArticles + "]";
	}

}
