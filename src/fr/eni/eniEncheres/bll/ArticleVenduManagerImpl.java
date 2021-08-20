package fr.eni.eniEncheres.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.eniEncheres.bo.ArticleVendu;
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
		try {
			listArticleVendus = dao.getAll();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listArticleVendus;
	}

}
