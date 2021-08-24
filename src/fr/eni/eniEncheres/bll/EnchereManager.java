package fr.eni.eniEncheres.bll;

import java.util.List;

import fr.eni.eniEncheres.bo.Enchere;

public interface EnchereManager {
	public void addEnchere(Enchere enchere) throws BLLException;

	public void deleteEnchere(Enchere enchere) throws BLLException;

	public void updateEnchere(Enchere enchere) throws BLLException;

	public List<Enchere> getAllEnchere() throws BLLException;
}
