package fr.eni.eniEncheres.bll;

import java.util.List;

import fr.eni.eniEncheres.bo.Enchere;
import fr.eni.eniEncheres.bo.Utilisateur;
import fr.eni.eniEncheres.ihm.ArticleVenduModel;
import fr.eni.eniEncheres.ihm.EnchereModel;

public interface EnchereManager {
	public void crediterUtilsateur(ArticleVenduModel articleModel, Enchere enchere, Integer montant)throws BLLException;

	public void debiterUtilisateur(Enchere enchere, Integer montant);

	public void addEnchere(Enchere enchere) throws BLLException;

	public void deleteEnchere(Enchere enchere) throws BLLException;

	public void updateEnchere(EnchereModel enchereModel, Enchere enchSauvegarde, String saisieEnchere, ArticleVenduModel articleModel) throws BLLExceptionList;

	public List<Enchere> getAllEnchere() throws BLLException;

	public Enchere selectEncherebyNoArticle(Integer noArticle);
	
	public Boolean verifSaisieEnchere(String saisieEnchere) throws BLLExceptionList;

	
}
