package fr.eni.eniEncheres.bo;

public class Retrait {
	String rue;
	String code_postal;
	String ville;
	Integer noArticle;

	public Retrait() {
	}

	public Retrait(String rue, String code_postal, String ville, Integer noArticle) {
		super();
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
		this.noArticle = noArticle;
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

	public Integer getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(Integer noArticle) {
		this.noArticle = noArticle;
	}

	@Override
	public String toString() {
		return "Retrait [rue=" + rue + ", code_postal=" + code_postal + ", ville=" + ville + ", noArticle=" + noArticle
				+ "]";
	}

}
