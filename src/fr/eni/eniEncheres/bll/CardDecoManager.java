package fr.eni.eniEncheres.bll;

import java.util.List;

import fr.eni.eniEncheres.dto.Card;

public interface CardDecoManager {

	public List<Card> getAllCardByNom(String saisie) throws BLLException;
	public List<Card> getAllCardByCat(Integer cat) throws BLLException;
	public List<Card> getAllCardByNomAndCat(String saisie, Integer cat) throws BLLException;
}
