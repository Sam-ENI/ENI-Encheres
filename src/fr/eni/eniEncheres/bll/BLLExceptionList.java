package fr.eni.eniEncheres.bll;

import java.util.ArrayList;
import java.util.List;

public class BLLExceptionList extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	List<String> messages;
	
	public BLLExceptionList() {
		messages = new ArrayList<String>();
	}
	
	public void ajoutMessage(String msg) {
		messages.add(msg);
	}
	
	public List<String> getMessages(){
		return messages;
	}
	
	public boolean estVide() {
		return messages.isEmpty();
	}
}