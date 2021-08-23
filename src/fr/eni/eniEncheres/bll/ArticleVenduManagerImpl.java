package fr.eni.eniEncheres.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.eniEncheres.bo.ArticleVendu;
import fr.eni.eniEncheres.bo.Categorie;
import fr.eni.eniEncheres.dal.ArticleVenduDAO;
import fr.eni.eniEncheres.dal.ArticleVenduDAOFact;
import fr.eni.eniEncheres.dal.DALException;

public class ArticleVenduManagerImpl implements ArticleVenduManager {
	ArticleVenduDAO dao = ArticleVenduDAOFact.getInstanceDAO();

	@Override
	public void addArticleVendu(ArticleVendu articleVendu) throws BLLException {
		try {
			dao.insert(articleVendu);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deleteArticleVendu(ArticleVendu articleVendu) throws BLLException {
		try {
			dao.delete(articleVendu);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void updateArticleVendu(ArticleVendu articleVendu) throws BLLException {
		try {
			dao.update(articleVendu);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<ArticleVendu> getAllArticleVendu() throws BLLException {
		List<ArticleVendu> listArticleVendus = new ArrayList<ArticleVendu>();
		System.out.println("KMKLJLKHJNMKLHKLn");
		try {
			listArticleVendus = dao.getAll();
		} catch (DALException e) {
			e.printStackTrace();
		}
		System.out.println(listArticleVendus);
		return listArticleVendus;
	}
	
	
	public ArticleVendu getArticleByName (String name) throws BLLException{
		try {
			for (ArticleVendu av : dao.getAll()) {
				if (av.getNomArticle().equals(name)) {
					return av;
				}
			}
			// TODO : Ajouter exception BLL
		} catch (DALException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Categorie getCategById (int id) {
		try {
			return dao.selectCategorieByNumeroCategorie(id);
		} catch (DALException e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
