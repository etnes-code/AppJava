package be.sente.pojo;

public class Client extends Personne {

	public Client(String nom, String prenom, String rue, int numRue, int cp, String email, String password) {
		super(nom, prenom, rue, numRue, cp, email, password);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + ", rue=" + rue + ", numRue=" + numRue + ", cp=" + cp
				+ ", email=" + email + ", password=" + password + "]";
	}
	
	
}
