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
	@Override
	public List<Card> getAlltEnchereOuvertes() throws BLLException {
		List<Card> lstCard = new ArrayList<>();
		try {
			lstCard = daoCard.selectEnchereOuvertes();
		} catch (DALException e) {
			e.printStackTrace();
		}
		return lstCard;
	}

	@Override
	public List<Card> getAllEnchereEnCours(Integer no_utilisateur) throws BLLException {
		List<Card> lstCard = new ArrayList<>();
		try {
			lstCard = daoCard.selectEnchereEnCours(no_utilisateur);
		} catch (DALException e) {
			e.printStackTrace();
		}
		return lstCard;
	}

	@Override
	public List<Card> getAllEnchereRemporter(Integer no_utilisateur) throws BLLException {
		List<Card> lstCard = new ArrayList<>();
		try {
			lstCard = daoCard.selectEnchereRemporter(no_utilisateur);
		} catch (DALException e) {
			e.printStackTrace();
		}
		return lstCard;
	}

	@Override
	public List<Card> getAllVentesEnCours(Integer no_utilisateur) throws BLLException {
		List<Card> lstCard = new ArrayList<>();
		try {
			lstCard = daoCard.selectVentesEnCours(no_utilisateur);
		} catch (DALException e) {
			e.printStackTrace();
		}
		return lstCard;
	}

	@Override
	public List<Card> getAllVentesNonDebuter(Integer no_utilisateur) throws BLLException {
		List<Card> lstCard = new ArrayList<>();
		try {
			lstCard = daoCard.selectVentesNonDebuter(no_utilisateur);
		} catch (DALException e) {
			e.printStackTrace();
		}
		return lstCard;
	}

	@Override
	public List<Card> getAllVentesTerminer(Integer no_utilisateur) throws BLLException {
		List<Card> lstCard = new ArrayList<>();
		try {
			lstCard = daoCard.selectVentesTerminer(no_utilisateur);
		} catch (DALException e) {
			e.printStackTrace();
		}
		return lstCard;
	}

	@Override
	public List<Card> addToListIfNotExists(List<Card> lstSource, List<Card> lstAdd) {
		boolean isInList = false;
			// Pour chaque element de la liste a rajouter
			for (Card cardAdd : lstAdd) {
				isInList = false;
				// Pour chaque element de la liste de base
				for (Card cardSource : lstSource) {
					// Si l'objet card est déjà présent dans la liste 
					if (cardAdd.equals(cardSource)) {
						isInList = true;
					}
				}
				if (!isInList) 
					lstSource.add(cardAdd);
			}
		return lstSource;
	}

}
