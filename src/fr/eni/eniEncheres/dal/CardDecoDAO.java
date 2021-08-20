package fr.eni.eniEncheres.dal;

import java.util.List;


import fr.eni.eniEncheres.dto.Card;

public interface CardDecoDAO {

	public List<Card> selectAllByNomArt(String saisie) throws DALException; 
	public List<Card> selectAllByCat(Integer cat) throws DALException;
	public List<Card> selectAllByNomArtAndCat(String saisie, Integer cat) throws DALException;
	
}
