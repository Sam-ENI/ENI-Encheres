package fr.eni.eniEncheres.bo;

import java.time.LocalDate;

public class ArticleVendu {
	Integer noArticle;
	String nomArticle;
	String description;
	LocalDate dateDebutEncheres;
	LocalDate dateFinEncheres;
	Integer miseAprix;
	Integer prixVente;
	Boolean etatVente = false;
	Utilisateur utilisateur;
	Categorie categorie;
//	Integer noUtilisateur;
//	Integer noCategorie;

	public ArticleVendu() {
	}

//	public ArticleVendu(Integer noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
//	LocalDate dateFinEncheres, Integer miseAprix, Integer prixVente, Integer noUtilisateur,
//	Integer noCategorie) {
//super();
//this.noArticle = noArticle;
//this.nomArticle = nomArticle;
//this.description = description;
//this.dateDebutEncheres = dateDebutEncheres;
//this.dateFinEncheres = dateFinEncheres;
//this.miseAprix = miseAprix;
//this.prixVente = prixVente;
//this.noUtilisateur = noUtilisateur;
//this.noCategorie = noCategorie;
//
//}
	public ArticleVendu(Integer noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, Integer miseAprix, Integer prixVente, Boolean etatVente, Utilisateur utilisateur,
			Categorie categorie) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAprix = miseAprix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.utilisateur = utilisateur;
		this.categorie = categorie;
	}

	public Integer getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(Integer noArticle) {
		this.noArticle = noArticle;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDateDebutEncheres() {
		return dateDebutEncheres;
	}

	public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}

	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}

	public void setDateFinEncheres(LocalDate dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}

	public Integer getMiseAprix() {
		return miseAprix;
	}

	public void setMiseAprix(Integer miseAprix) {
		this.miseAprix = miseAprix;
	}

	public Integer getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(Integer prixVente) {
		this.prixVente = prixVente;
	}

	public Boolean getEtatVente() {
		return etatVente;
	}

	public void setEtatVente(Boolean etatVente) {
		this.etatVente = etatVente;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	@Override
	public String toString() {
		return "ArticleVendu [noArticle=" + noArticle + ", nomArticle=" + nomArticle + ", description=" + description
				+ ", dateDebutEncheres=" + dateDebutEncheres + ", dateFinEncheres=" + dateFinEncheres + ", miseAprix="
				+ miseAprix + ", prixVente=" + prixVente + ", etatVente=" + etatVente + ", utilisateur=" + utilisateur
				+ ", categorie=" + categorie + "]";
	}

}
