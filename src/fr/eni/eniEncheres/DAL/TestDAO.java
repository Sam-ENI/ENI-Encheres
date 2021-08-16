package fr.eni.eniEncheres.DAL;

import fr.eni.eniEncheres.BO.Utilisateur;

public class TestDAO {
	
	public static void main(String[] args) throws DALException {
		
		
		UtilisateurDAO dao = UtilisateurDAOFact.getInstanceDAO();
		
		
		Utilisateur u1 = new Utilisateur("lol", "dupont", "jack", "j@dd.com", "021547898", "5 des oui", "44000", "Nantes", "1245", 0, false);
		
		System.out.println("Ajout un contact");
		dao.insert(u1);
		System.out.println(dao.getAll());
//		
//		System.out.println("modifier un contact");
//		u1.setNom("Gorge");
//		dao.update(u1);
//		System.out.println(dao.getAll());
//		
//		System.out.println("modifier un contact");
//		dao.delete(u1);
//		System.out.println(dao.getAll());
	}
}
