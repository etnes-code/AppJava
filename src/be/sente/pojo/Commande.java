package be.sente.pojo;

import java.io.Serializable;

import be.sente.DAO.DAO;
import be.sente.DAO.FactoryDAO;

public class Commande implements Serializable {

	private static final long serialVersionUID = 6216146991904004540L;
	private int id;
	private String modeDeLivraison;
	private String modeDePayement;
	private float totalCommande;
	private int idUser;
	private Place place;
	public Commande() {}
	public Commande(String modeDeLivraison, String modeDePayement, float totalCommande, int idUser) {
		super();
		this.modeDeLivraison = modeDeLivraison;
		this.modeDePayement = modeDePayement;
		this.totalCommande = totalCommande;
		this.idUser = idUser;
	}
	public Commande(int id, String modeDeLivraison, String modeDePayement, float totalCommande) {
		super();
		this.id = id;
		this.modeDeLivraison = modeDeLivraison;
		this.modeDePayement = modeDePayement;
		this.totalCommande = totalCommande;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModeDeLivraison() {
		return modeDeLivraison;
	}
	public void setModeDeLivraison(String modeDeLivraison) {
		this.modeDeLivraison = modeDeLivraison;
	}
	public String getModeDePayement() {
		return modeDePayement;
	}
	public void setModeDePayement(String modeDePayement) {
		this.modeDePayement = modeDePayement;
	}
	public float getTotalCommande() {
		return totalCommande;
	}
	public void setTotalCommande(float totalCommande) {
		this.totalCommande = totalCommande;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public Place getPlace() {
		return place;
	}
	public void setPlace(Place place) {
		this.place = place;
	}
	public void createCommande() {
		FactoryDAO adf=new FactoryDAO();
		DAO<Commande> commandedao=adf.getCommandeDAO();
		commandedao.create(this);
	}
	@Override
	public String toString() {
		return "Commande n "+this.id+" prix : "+this.totalCommande;
	}
	
	
	
}
