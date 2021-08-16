package fr.eni.eniEncheres.BO;

import java.time.LocalDate;

public class Enchere {
	LocalDate dateEnchere;
	Integer montant_enchere;
	Integer noUtilisateur;
	Integer noArticle;

	public Enchere() {
	}

	public Enchere(LocalDate dateEnchere, Integer montant_enchere, Integer noUtilisateur, Integer noArticle) {
		super();
		this.dateEnchere = dateEnchere;
		this.montant_enchere = montant_enchere;
		this.noUtilisateur = noUtilisateur;
		this.noArticle = noArticle;
	}

	public LocalDate getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(LocalDate dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public Integer getMontant_enchere() {
		return montant_enchere;
	}

	public void setMontant_enchere(Integer montant_enchere) {
		this.montant_enchere = montant_enchere;
	}

	public Integer getNoUtilisateur() {
		return noUtilisateur;
	}

	public void setNoUtilisateur(Integer noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	public Integer getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(Integer noArticle) {
		this.noArticle = noArticle;
	}

	@Override
	public String toString() {
		return "Enchere [dateEnchere=" + dateEnchere + ", montant_enchere=" + montant_enchere + ", noUtilisateur="
				+ noUtilisateur + ", noArticle=" + noArticle + "]";
	}

}
