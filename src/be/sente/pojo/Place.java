package be.sente.pojo;

import java.io.Serializable;

import be.sente.DAO.DAO;
import be.sente.DAO.FactoryDAO;

public class Place implements Serializable {

	private static final long serialVersionUID = -191003132641318788L;
	private int id;
	private String nom;
	private float prix;
	private int nbrPlace;
	private int idRep;
	private Representation representation;
	
	public Place() {}

	public Place(String nom, float prix, int nbrPlace,int idRep) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.nbrPlace = nbrPlace;
		this.idRep=idRep;
	}

	public Place(int id, String nom, float prix, int nbrPlace) {
		super();
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		this.nbrPlace = nbrPlace;
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

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public int getNbrPlace() {
		return nbrPlace;
	}

	public void setNbrPlace(int nbrPlace) {
		this.nbrPlace = nbrPlace;
	}

	public Representation getRepresentation() {
		return representation;
	}

	public void setRepresentation(Representation representation) {
		this.representation = representation;
	}

	public int getIdRep() {
		return idRep;
	}

	public void setIdRep(int idRep) {
		this.idRep = idRep;
	}
	
	public void CreatePlace(Place place) {
		FactoryDAO adf=new FactoryDAO();
		DAO<Place> placedao= adf.getPlaceDAO();
		placedao.create(place);
	}

	
	
	
	
	
	
	

}
