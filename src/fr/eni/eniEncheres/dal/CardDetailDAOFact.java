package fr.eni.eniEncheres.dal;

import fr.eni.eniEncheres.dal.jdbc.CardDetailDAOImpl;

public class CardDetailDAOFact {
	public static CardDetailDAO getInstanceCardDetail() {
		return new CardDetailDAOImpl();
	}
}
