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
	public Categorie() {}
	public Categorie(String type, float prix, int nbrPlaceMax,int nbrPlaceRestante) {
		super();
		this.type = type;
		this.prix = prix;
		this.nbrPlaceMax = nbrPlaceMax;
		this.nbrPlaceRestante= nbrPlaceRestante;
	}
	
	
	public Categorie(int id, String type, float prix, int nbrPlaceMax, int nbrPlaceRestante) {
		super();
		this.id = id;
		this.type = type;
		this.prix = prix;
		this.nbrPlaceMax = nbrPlaceMax;
		this.nbrPlaceRestante = nbrPlaceRestante;
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
	public void createCat() {
		FactoryDAO adf=new FactoryDAO();
		DAO<Categorie> categoriedao=adf.getCategorieDAO();
		categoriedao.create(this);
	}
		

}
