package be.sente.pojo;

import java.io.Serializable;

public class Client extends Personne implements Serializable {

	private static final long serialVersionUID = 6896615520018342125L;

	public Client(String nom, String prenom, String rue, int numRue, int cp, String ville, String email,
			String password) {
		super(nom, prenom, rue, numRue, cp, ville, email, password);
	}

	public Client(int id, String nom, String prenom, String rue, int numRue, int cp, String ville, String email,
			String password) {
		super(id, nom, prenom, rue, numRue, cp, ville, email, password);
	}
	
}
