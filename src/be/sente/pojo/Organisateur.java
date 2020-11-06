package be.sente.pojo;

import java.io.Serializable;

public class Organisateur extends Personne implements Serializable {
	private static final long serialVersionUID = -1625130318528201331L;
	public Organisateur(String nom, String prenom, String rue, int numRue, int cp, String ville, String email, String password) {
		super(nom, prenom, rue, numRue, cp, ville, email, password);	
	}	
}
