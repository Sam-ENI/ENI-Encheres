package fr.eni.eniEncheres.bo;

public class Retrait {
	String rue;
	String code_postal;
	String ville;
	ArticleVendu articleVendu;
//	Integer noArticle;

	public Retrait() {
	}

//	public Retrait(String rue, String code_postal, String ville, Integer noArticle) {
//	super();
//	this.rue = rue;
//	this.code_postal = code_postal;
//	this.ville = ville;
//	this.noArticle = noArticle;
//}
	public Retrait(String rue, String code_postal, String ville, ArticleVendu articleVendu) {
		super();
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
		this.articleVendu = articleVendu;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public ArticleVendu getArticleVendu() {
		return articleVendu;
	}

	public void setArticleVendu(ArticleVendu articleVendu) {
		this.articleVendu = articleVendu;
	}

	@Override
	public String toString() {
		return "Retrait [rue=" + rue + ", code_postal=" + code_postal + ", ville=" + ville + ", articleVendu="
				+ articleVendu + "]";
	}

}
