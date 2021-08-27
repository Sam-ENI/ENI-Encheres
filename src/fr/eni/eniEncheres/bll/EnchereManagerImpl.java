package fr.eni.eniEncheres.bll;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.eniEncheres.bo.Enchere;
import fr.eni.eniEncheres.dal.DALException;
import fr.eni.eniEncheres.dal.EnchereDAO;
import fr.eni.eniEncheres.dal.EnchereDAOFact;
import fr.eni.eniEncheres.dal.UtilisateurDAO;
import fr.eni.eniEncheres.dal.UtilisateurDAOFact;
import fr.eni.eniEncheres.ihm.ArticleVenduModel;
import fr.eni.eniEncheres.ihm.EnchereModel;

/**
 * Classe d'impl�mentation du manager de l'ench�re
 * 
 * @author FRANDIN/AKAFFOU/BRAULT
 *
 */
public class EnchereManagerImpl implements EnchereManager {
	EnchereDAO daoEnchere = EnchereDAOFact.getInstanceDAO();
	UtilisateurDAO daoUtilisateur = UtilisateurDAOFact.getInstanceDAO();

	@Override
	public void addEnchere(Enchere enchere) throws BLLException {
		try {
			daoEnchere.insert(enchere);
		} catch (DALException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteEnchere(Enchere enchere) throws BLLException {
		try {
			daoEnchere.delete(enchere);
		} catch (DALException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateEnchere(EnchereModel enchereModel, Enchere enchSauvegarde, String saisieEnchere,
			ArticleVenduModel articleModel) throws BLLExceptionList {
		BLLExceptionList exceptionUpdateEnchereVerif = new BLLExceptionList();
		Boolean EnchereSurMOnObjet = true;

		if (articleModel.getArticleVendu().getUtilisateur().getNoUtilisateur() == enchereModel.getEnchere()
				.getUtilisateur().getNoUtilisateur()) {
			exceptionUpdateEnchereVerif.ajoutMessage("Vous ne pouvez pas ench�rir sur votre objet");
			EnchereSurMOnObjet = false;
		}

		if (enchereModel.getEnchere().getUtilisateur().getNoUtilisateur() == enchSauvegarde.getUtilisateur()
				.getNoUtilisateur() & EnchereSurMOnObjet) {
			exceptionUpdateEnchereVerif.ajoutMessage("Vous avez d�j� ench�rit sur cet objet");
		}
		// on v�rifie si le montant saisie est sup�rieur � l"enchere en cours
		if (Integer.parseInt(saisieEnchere) <= enchSauvegarde.getMontant_enchere()) {
			exceptionUpdateEnchereVerif.ajoutMessage("Le montant saisie doit �tre sup�rieur � l'ench�re actuelle");
		}
		// on verifie si le credit de l'utilisateur est suffisnt pour faire une ench�re
		if ((enchereModel.getEnchere().getUtilisateur().getCredit() - Integer.parseInt(saisieEnchere.trim())) < 0) {
			exceptionUpdateEnchereVerif.ajoutMessage("Cr�dit insuffisant");
		}
		try {
			if (!exceptionUpdateEnchereVerif.estVide()) {
				throw exceptionUpdateEnchereVerif;
			} else {
				daoEnchere.update(enchereModel.getEnchere());
			}
		} catch (DALException e) {
			e.printStackTrace();
		}

	}

	public Boolean verifSaisieEnchere(String saisieEnchere, ArticleVenduModel articleModel) throws BLLExceptionList {
		BLLExceptionList exceptionVerif = new BLLExceptionList();
		// on v�rifie si le champs de saisie n'est pas vide
		if (saisieEnchere.equals("")) {
			exceptionVerif.ajoutMessage("La saisie de l'Enchere ne peut pas �tre vide");

			throw exceptionVerif;
		} else if (articleModel.getArticleVendu().getDateFinEncheres().isBefore(LocalDate.now())) {
			exceptionVerif.ajoutMessage("L'ench�re est termin�e");
			throw exceptionVerif;
		}
		{
			return true;
		}
	}

	@Override
	public List<Enchere> getAllEnchere() throws BLLException {
		List<Enchere> listEncheres = new ArrayList<Enchere>();
		try {
			listEncheres = daoEnchere.getAll();
		} catch (DALException e) {
			e.printStackTrace();
		}
		return listEncheres;
	}

	@Override
	public Enchere selectEncherebyNoArticle(Integer noArticle) {
		Enchere enchere = null;
		try {
			enchere = daoEnchere.selectEncherebyNoArticle(noArticle);
		} catch (DALException e) {
			e.printStackTrace();
		}
		return enchere;
	}

	@Override
	public void crediterUtilsateur(ArticleVenduModel articleModel, Enchere enchereSauvegardee, Integer montant) {
		// on compare le num�ro d'utilisateur du produit � vendre � celui de
		// l'utilisateur qui � fait la derni�re ench�re
		// pour ne pas cr�diter le vendeur si aucune ench�re n'a �t� faite
		if (articleModel.getArticleVendu().getUtilisateur().getNoUtilisateur() != enchereSauvegardee.getUtilisateur()
				.getNoUtilisateur()) {
			enchereSauvegardee.getUtilisateur().setCredit(enchereSauvegardee.getUtilisateur().getCredit() + montant);

			try {
				daoUtilisateur.update(enchereSauvegardee.getUtilisateur());
			} catch (DALException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void debiterUtilisateur(Enchere enchere, Integer montant) {
		enchere.getUtilisateur().setCredit(enchere.getUtilisateur().getCredit() - montant);
		try {
			daoUtilisateur.update(enchere.getUtilisateur());
		} catch (DALException e) {
			e.printStackTrace();
		}

	}

}
