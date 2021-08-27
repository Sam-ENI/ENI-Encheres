package fr.eni.eniEncheres.dal;

/**
 * Classe exception de la DAL
 * 
 * @author FRANDIN/AKAFFOU/BRAULT
 *
 */
public class DALException extends Exception {
	private static final long serialVersionUID = 1L;

	public DALException(String message) {
		super(message);
	}
}
