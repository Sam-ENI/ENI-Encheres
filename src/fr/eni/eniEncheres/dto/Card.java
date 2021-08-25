package fr.eni.eniEncheres.dto;

import java.time.LocalDate;

public class Card {
	
	private Integer noArticle;
	private String nomArticle;
	private Integer prixInitial;
	private LocalDate dateFinEncheres;
	private String nomVendeur;
	
	public Card() {
	}

	public Card(Integer noArticle, String nomArticle, Integer prixInitial, LocalDate dateFinEncheres,
			String nomVendeur) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.prixInitial = prixInitial;
		this.dateFinEncheres = dateFinEncheres;
		this.nomVendeur = nomVendeur;
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

	public Integer getPrixInitial() {
		return prixInitial;
	}

	public void setPrixInitial(Integer prixInitial) {
		this.prixInitial = prixInitial;
	}

	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}

	public void setDateFinEncheres(LocalDate dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}

	public String getNomVendeur() {
		return nomVendeur;
	}

	public void setNomVendeur(String nomVendeur) {
		this.nomVendeur = nomVendeur;
	}

	@Override
	public String toString() {
		return "Card [noArticle=" + noArticle + ", nomArticle=" + nomArticle + ", prixInitial=" + prixInitial
				+ ", dateFinEncheres=" + dateFinEncheres + ", nomVendeur=" + nomVendeur + "]";
	}
	
	
	
}

	