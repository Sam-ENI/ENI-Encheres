package fr.eni.eniEncheres.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.eniEncheres.bo.Enchere;
import fr.eni.eniEncheres.dal.DALException;
import fr.eni.eniEncheres.dal.EnchereDAO;
import fr.eni.eniEncheres.dal.EnchereDAOFact;

public class EnchereManagerImpl implements EnchereManager {
	EnchereDAO daoEnchere = EnchereDAOFact.getInstanceDAO();

	@Override
	public void addEnchere(Enchere enchere) throws BLLException {
		try {
			daoEnchere.insert(enchere);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deleteEnchere(Enchere enchere) throws BLLException {
		try {
			daoEnchere.delete(enchere);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void updateEnchere(Enchere enchere) throws BLLException {
		try {
			daoEnchere.update(enchere);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Enchere> getAllEnchere() throws BLLException {
		List<Enchere> listEncheres = new ArrayList<Enchere>();
		try {
			listEncheres = daoEnchere.getAll();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listEncheres;
	}

}
