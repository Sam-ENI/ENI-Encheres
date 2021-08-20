package fr.eni.eniEncheres.dal;

import fr.eni.eniEncheres.dal.jdbc.CardDecoDAOImpl;

public class CardDecoDAOFact {

	public static CardDecoDAO getInstanceDAO() {
		return new CardDecoDAOImpl();
	}
}
