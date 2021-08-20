package fr.eni.eniEncheres.bo;

public class Categorie {
	Integer noCategorie;
	String libelle;

	public Categorie() {
	}

	public Categorie(String libelle) {
		super();
		this.libelle = libelle;
	}

	public Integer getNoCategorie() {
		return noCategorie;
	}

	public void setNoCategorie(Integer noCategorie) {
		this.noCategorie = noCategorie;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "Categeorie [noCategorie=" + noCategorie + ", libelle=" + libelle + "]";
	}

}
