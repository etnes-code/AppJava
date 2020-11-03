package be.sente.pojo;

import java.io.Serializable;

public class Gestionnaire extends Personne  implements Serializable{

	private static final long serialVersionUID = -1129711408603590496L;
	private static final String discriminator="Gestionnaire";
	public Gestionnaire(String nom, String prenom, String rue, int numRue, int cp,String ville, String email, String password) {
		super(nom, prenom, rue, numRue, cp, ville, email, password);	
	}
	public static String getDiscriminator() {
		return discriminator;
	}
}
