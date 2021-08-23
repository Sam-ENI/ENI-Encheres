package fr.eni.eniEncheres.dto;

import java.time.LocalDate;

public class Card {
	
	private String nomArticle;
	private Integer prixInitial;
	private LocalDate dateFinEncheres;
	private String nomVendeur;
	
	public Card() {
	}

	public Card(String nomArticle, Integer prixInitial, LocalDate dateFinEncheres, String nomVendeur) {
		super();
		this.nomArticle = nomArticle;
		this.prixInitial = prixInitial;
		this.dateFinEncheres = dateFinEncheres;
		this.nomVendeur = nomVendeur;
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
		return "Card [nomArticle=" + nomArticle + ", prixInitial=" + prixInitial + ", dateFinEncheres="
				+ dateFinEncheres + ", nomVendeur=" + nomVendeur + "]";
	}
	
}

	