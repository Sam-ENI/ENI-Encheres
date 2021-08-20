package fr.eni.eniEncheres.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.eniEncheres.dal.CardDecoDAO;
import fr.eni.eniEncheres.dal.CardDecoDAOFact;
import fr.eni.eniEncheres.dal.DALException;
import fr.eni.eniEncheres.dto.Card;

public class CardDecoManagerImpl implements CardDecoManager {
	
	CardDecoDAO daoCard = CardDecoDAOFact.getInstanceDAO(); 
	@Override
	public List<Card> getAllCardByNom(String saisie) throws BLLException {
		List<Card> lstCard = new ArrayList<>();
		try {
			lstCard = daoCard.selectAllByNomArt(saisie);
		} catch (DALException e) {
			e.printStackTrace();
		}
		return lstCard;
	}

	@Override
	public List<Card> getAllCardByCat(Integer cat) throws BLLException {
		List<Card> lstCard = new ArrayList<>();
		try {
			lstCard = daoCard.selectAllByCat(cat);
		} catch (DALException e) {
			e.printStackTrace();
		}
		return lstCard;
	}

	@Override
	public List<Card> getAllCardByNomAndCat(String saisie, Integer cat) throws BLLException {
		List<Card> lstCard = new ArrayList<>();
		try {
			lstCard =daoCard.selectAllByNomArtAndCat(saisie, cat);
		} catch (DALException e) {
			e.printStackTrace();
		}
		return lstCard;
	}

}
