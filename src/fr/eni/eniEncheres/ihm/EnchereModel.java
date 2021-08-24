package fr.eni.eniEncheres.ihm;

import java.util.ArrayList;
import java.util.List;

import fr.eni.eniEncheres.bo.Enchere;

public class EnchereModel {
	private Enchere enchere;
	private List<Enchere> lstEncheres = new ArrayList<Enchere>();

	public EnchereModel() {

	}

	public EnchereModel(Enchere enchere, List<Enchere> lstEncheres) {
		super();
		this.enchere = enchere;
		this.lstEncheres = lstEncheres;
	}

	public Enchere getEnchere() {
		return enchere;
	}

	public void setEnchere(Enchere enchere) {
		this.enchere = enchere;
	}

	public List<Enchere> getLstEncheres() {
		return lstEncheres;
	}

	public void setLstEncheres(List<Enchere> lstEncheres) {
		this.lstEncheres = lstEncheres;
	}

	@Override
	public String toString() {
		return "EncheresModel [enchere=" + enchere + ", lstEncheres=" + lstEncheres + "]";
	}

}
