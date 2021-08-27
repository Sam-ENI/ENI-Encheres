package fr.eni.eniEncheres.dto;

import java.time.LocalDate;

/**
 * Classe de la DTO de Card
 * 
 * @author FRANDIN/AKAFFOU/BRAULT
 *
 */
public class Card {

	private Integer noArticle;
	private String nomArticle;
	private Integer montant_enchere;
	private LocalDate dateFinEncheres;
	private String nomVendeur;

	public Card() {
	}

	public Card(Integer noArticle, String nomArticle, Integer montant_enchere, LocalDate dateFinEncheres,
			String nomVendeur) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.montant_enchere = montant_enchere;
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

	public Integer getMontant_enchere() {
		return montant_enchere;
	}

	public void setMontant_enchere(Integer montant_enchere) {
		this.montant_enchere = montant_enchere;
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
		return "Card [noArticle=" + noArticle + ", nomArticle=" + nomArticle + ", montant_enchere=" + montant_enchere
				+ ", dateFinEncheres=" + dateFinEncheres + ", nomVendeur=" + nomVendeur + "]\n";
	}
}
