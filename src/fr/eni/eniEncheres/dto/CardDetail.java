package fr.eni.eniEncheres.dto;

import java.time.LocalDate;

public class CardDetail {
	
	private String nomArticle;
	private String DescArticle;
	private String nomCategorie;
	private String montantEnchere;
	private String nomEnchereur;
	private LocalDate dateFin;
	private Integer prixInitial;
	private String rue;
	private String cp;
	private String ville;
	private String nomVendeur;
	
	public CardDetail() {
	}

	public CardDetail(String nomArticle, String descArticle, String nomCategorie, String montantEnchere,
			String nomEnchereur, LocalDate dateFin, Integer prixInitial, String rue, String cp, String ville,
			String nomVendeur) {
		super();
		this.nomArticle = nomArticle;
		DescArticle = descArticle;
		this.nomCategorie = nomCategorie;
		this.montantEnchere = montantEnchere;
		this.nomEnchereur = nomEnchereur;
		this.dateFin = dateFin;
		this.prixInitial = prixInitial;
		this.rue = rue;
		this.cp = cp;
		this.ville = ville;
		this.nomVendeur = nomVendeur;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public String getDescArticle() {
		return DescArticle;
	}

	public void setDescArticle(String descArticle) {
		DescArticle = descArticle;
	}

	public String getNomCategorie() {
		return nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	public String getMontantEnchere() {
		return montantEnchere;
	}

	public void setMontantEnchere(String montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	public String getNomEnchereur() {
		return nomEnchereur;
	}

	public void setNomEnchereur(String nomEnchereur) {
		this.nomEnchereur = nomEnchereur;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public Integer getPrixInitial() {
		return prixInitial;
	}

	public void setPrixInitial(Integer prixInitial) {
		this.prixInitial = prixInitial;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getNomVendeur() {
		return nomVendeur;
	}

	public void setNomVendeur(String nomVendeur) {
		this.nomVendeur = nomVendeur;
	}

	@Override
	public String toString() {
		return "CardDetail [nomArticle=" + nomArticle + ", DescArticle=" + DescArticle + ", nomCategorie="
				+ nomCategorie + ", montantEnchere=" + montantEnchere + ", nomEnchereur=" + nomEnchereur + ", dateFin="
				+ dateFin + ", prixInitial=" + prixInitial + ", rue=" + rue + ", cp=" + cp + ", ville=" + ville
				+ ", nomVendeur=" + nomVendeur + "]";
	}
	
	
	
}
