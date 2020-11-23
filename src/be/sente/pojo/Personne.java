package be.sente.pojo;

import java.io.Serializable;

import be.sente.DAO.DAO;
import be.sente.DAO.FactoryDAO;

public class Personne implements Serializable {
	private static final long serialVersionUID = -7002606308230390313L;
	
	protected int id;
	protected String nom;
	protected String prenom;
	protected String rue;
	protected int numRue;
	protected int cp;
	protected String ville;
	protected String email;
	protected String password;
	public Personne() {}
	public Personne(String nom, String prenom, String rue, int numRue, int cp, String ville, String email, String password) {
		this.nom = nom;
		this.prenom = prenom;
		this.rue = rue;
		this.numRue = numRue;
		this.cp = cp;
		this.ville=ville;
		this.email = email;
		this.password = password;
	}
	
	public Personne(int id, String nom, String prenom, String rue, int numRue, int cp, String ville, String email,
			String password) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.rue = rue;
		this.numRue = numRue;
		this.cp = cp;
		this.ville = ville;
		this.email = email;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
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
	public  Personne getUser(int id) {
		Personne p=new Personne();
		FactoryDAO adf=new FactoryDAO();
		DAO<Personne> personnedao=adf.getPersonneDAO();
		p=personnedao.find(id);
		return p;
	}
	public void addToList(Object obj) {}
	
	
	

}
