package be.sente.pojo;

import java.io.Serializable;

public class Artistes extends Personne implements Serializable {
	
	private static final long serialVersionUID = 3953577625264131314L;

	public Artistes(String nom, String prenom, String rue, int numRue, int cp,String ville, String email, String password) {
		super(nom, prenom, rue, numRue, cp, ville, email, password);
		
	}
}
