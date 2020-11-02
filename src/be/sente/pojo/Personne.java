package be.sente.pojo;

public class Personne {
	protected String nom;
	protected String prenom;
	protected String rue;
	protected int numRue;
	protected int cp;
	protected String email;
	protected String password;
	public Personne(String nom, String prenom, String rue, int numRue, int cp, String email, String password) {
		this.nom = nom;
		this.prenom = prenom;
		this.rue = rue;
		this.numRue = numRue;
		this.cp = cp;
		this.email = email;
		this.password = password;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public int getNumRue() {
		return numRue;
	}
	public void setNumRue(int numRue) {
		this.numRue = numRue;
	}
	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
