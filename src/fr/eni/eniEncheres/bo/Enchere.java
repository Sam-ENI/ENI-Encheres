package fr.eni.eniEncheres.bo;

import java.time.LocalDateTime;

public class Enchere {
	private LocalDateTime dateEnchere;
	private Integer montant_enchere;
	private Utilisateur utilisateur;
	private ArticleVendu articleVendu;
//	Integer noUtilisateur;
//	Integer noArticle;

	public Enchere() {
	}

//	public Enchere(LocalDate dateEnchere, Integer montant_enchere, Integer noUtilisateur, Integer noArticle) {
//	super();
//	this.dateEnchere = dateEnchere;
//	this.montant_enchere = montant_enchere;
//	this.noUtilisateur = noUtilisateur;
//	this.noArticle = noArticle;
//}
	public Enchere(LocalDateTime dateEnchere, Integer montant_enchere, Utilisateur utilisateur,
			ArticleVendu articleVendu) {
		super();
		this.dateEnchere = dateEnchere;
		this.montant_enchere = montant_enchere;
		this.utilisateur = utilisateur;
		this.articleVendu = articleVendu;
	}

	public LocalDateTime getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(LocalDateTime dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public Integer getMontant_enchere() {
		return montant_enchere;
	}

	public void setMontant_enchere(Integer montant_enchere) {
		this.montant_enchere = montant_enchere;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public ArticleVendu getArticleVendu() {
		return articleVendu;
	}

	public void setArticleVendu(ArticleVendu articleVendu) {
		this.articleVendu = articleVendu;
	}

	@Override
	public String toString() {
		return "Enchere [dateEnchere=" + dateEnchere + ", montant_enchere=" + montant_enchere + ", utilisateur="
				+ utilisateur + ", articleVendu=" + articleVendu + "]";
	}

}
