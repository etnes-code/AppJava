package be.sente.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Client extends Personne implements Serializable {

	private static final long serialVersionUID = 6896615520018342125L;
	private Set<Commande> listCommande= new HashSet<Commande>();

	public Client() {}
	public Client(String nom, String prenom, String rue, int numRue, int cp, String ville, String email,
			String password) {
		super(nom, prenom, rue, numRue, cp, ville, email, password);
	}

	public Client(int id, String nom, String prenom, String rue, int numRue, int cp, String ville, String email,
			String password) {
		super(id, nom, prenom, rue, numRue, cp, ville, email, password);
	}
	public Set<Commande> getListCommande() {
		return listCommande;
	}
	public void setListCommande(Set<Commande> listCommande) {
		this.listCommande = listCommande;
	}
	@Override
	public void addToList(Object obj) {
		listCommande.add((Commande) obj);
	}
}
