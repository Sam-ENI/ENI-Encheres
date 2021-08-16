package fr.eni.eniEncheres.BO;

public class Utilisateur {
	Integer noUtilsateur;
	String pseudo;
	String nom;
	String email;
	String telephone;
	String rue;
	String codePostal;
	String ville;
	String MotDePasse;
	Integer credit;
	Boolean administrateur;

	public Utilisateur() {
	}

	public Utilisateur(String pseudo, String nom, String email, String telephone, String rue, String codePostal,
			String ville, String motDePasse, Integer credit, Boolean administrateur) {
		super();
		this.pseudo = pseudo;
		this.nom = nom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		MotDePasse = motDePasse;
		this.credit = credit;
		this.administrateur = administrateur;
	}

	public Integer getNoUtilsateur() {
		return noUtilsateur;
	}

	public void setNoUtilsateur(Integer noUtilsateur) {
		this.noUtilsateur = noUtilsateur;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getMotDePasse() {
		return MotDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		MotDePasse = motDePasse;
	}

	public Integer getCredit() {
		return credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	public Boolean getAdministrateur() {
		return administrateur;
	}

	public void setAdministrateur(Boolean administrateur) {
		this.administrateur = administrateur;
	}

	@Override
	public String toString() {
		return "Utilisateur [noUtilsateur=" + noUtilsateur + ", pseudo=" + pseudo + ", nom=" + nom + ", email=" + email
				+ ", telephone=" + telephone + ", rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville
				+ ", MotDePasse=" + MotDePasse + ", credit=" + credit + ", administrateur=" + administrateur + "]";
	}

}
