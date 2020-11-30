package be.sente.pojo;

import java.io.Serializable;

import be.sente.DAO.DAO;
import be.sente.DAO.FactoryDAO;

public class Categorie implements Serializable {
	
	private static final long serialVersionUID = -7636352819892642626L;
	private int id;
	private String type;
	private float prix;
	private int nbrPlaceMax;
	private int nbrPlaceRestante;
	private int idConfig;
	public Categorie() {}
	public Categorie(String type, float prix, int nbrPlaceMax,int nbrPlaceRestante) {
		super();
		this.type = type;
		this.prix = prix;
		this.nbrPlaceMax = nbrPlaceMax;
		this.nbrPlaceRestante= nbrPlaceRestante;
	}
	
	
	public Categorie(int id, String type, float prix, int nbrPlaceMax, int nbrPlaceRestante, int idConfig) {
		super();
		this.id = id;
		this.type = type;
		this.prix = prix;
		this.nbrPlaceMax = nbrPlaceMax;
		this.nbrPlaceRestante = nbrPlaceRestante;
		this.idConfig = idConfig;
	}	
	public Categorie(int nbrPlaceMax, int idConfig) { // pour la décrémentation des places restante
		super();
		this.nbrPlaceMax = nbrPlaceMax;
		this.idConfig = idConfig;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNbrPlaceRestante() {
		return nbrPlaceRestante;
	}

	public void setNbrPlaceRestante(int nbrPlaceRestante) {
		this.nbrPlaceRestante = nbrPlaceRestante;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public int getNbrPlaceMax() {
		return nbrPlaceMax;
	}
	public void setNbrPlaceMax(int nbrPlaceMax) {
		this.nbrPlaceMax = nbrPlaceMax;
	}
	
	
	
	public int getIdConfig() {
		return idConfig;
	}
	public void setIdConfig(int idConfig) {
		this.idConfig = idConfig;
	}
	public void createCat() {
		FactoryDAO adf=new FactoryDAO();
		DAO<Categorie> categoriedao=adf.getCategorieDAO();
		categoriedao.create(this);
	}
	public void UpdateCatPlace() { //pour décrementer le nombre de place restante
		FactoryDAO adf=new FactoryDAO();
		DAO<Categorie> categoriedao=adf.getCategorieDAO();
		categoriedao.update(this);		
	}
		

}
