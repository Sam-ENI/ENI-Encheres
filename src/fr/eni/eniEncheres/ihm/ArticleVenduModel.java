package fr.eni.eniEncheres.ihm;

import java.util.ArrayList;
import java.util.List;

import fr.eni.eniEncheres.bo.ArticleVendu;

public class ArticleVenduModel {
	private ArticleVendu articleVendu;
	private List<ArticleVendu> lstArticles = new ArrayList<>();

	public ArticleVenduModel() {

	}

	public ArticleVenduModel(ArticleVendu articleVendu, List<ArticleVendu> lstArticles) {
		super();
		this.articleVendu = articleVendu;
		this.lstArticles = lstArticles;
	}

	public ArticleVendu getArticleVendu() {
		return articleVendu;
	}

	public void setArticleVendu(ArticleVendu articleVendu) {
		this.articleVendu = articleVendu;
	}

	public List<ArticleVendu> getLstArticles() {
		return lstArticles;
	}

	public void setLstArticles(List<ArticleVendu> lstArticles) {
		this.lstArticles = lstArticles;
	}

	@Override
	public String toString() {
		return "ArticleVenduModel [articleVendu=" + articleVendu + ", lstArticles=" + lstArticles + "]";
	}

}
