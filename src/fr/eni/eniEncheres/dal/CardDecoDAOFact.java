package fr.eni.eniEncheres.dal;

import fr.eni.eniEncheres.dal.jdbc.CardDecoDAOImpl;

/**
 * Classe Factory de la DAO de Card
 * 
 * @author FRANDIN/AKAFFOU/BRAULT
 *
 */
public class CardDecoDAOFact {

	public static CardDecoDAO getInstanceDAO() {
		return new CardDecoDAOImpl();
	}
}
