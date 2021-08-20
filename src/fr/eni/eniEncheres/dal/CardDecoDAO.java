package fr.eni.eniEncheres.dal;

import java.util.List;


import fr.eni.eniEncheres.dto.Card;

public interface CardDecoDAO {

	public List<Card> getAllByNomArt(String saisie) throws DALException; 
	public List<Card> getAllByCat(Integer cat) throws DALException;
	public List<Card> getAllByNomArtAndCat(String saisie, Integer cat) throws DALException;
	
}
