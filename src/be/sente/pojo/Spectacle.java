package be.sente.pojo;

import java.io.Serializable;
import java.util.ArrayList;

import be.sente.DAO.DAO;
import be.sente.DAO.FactoryDAO;

public class Spectacle  implements  Serializable{
	private static final long serialVersionUID = 4019725788932367988L;
	private int id;
	private String Titre;
	private String Artiste;
	private int nbrPlaceParClient;
	private Configuration config=new Configuration();
	private Representation representation= new Representation();
	public Spectacle() {}
	public Spectacle(String titre, String artiste, int nbrPlaceParClient) {
		super();
		Titre = titre;
		Artiste = artiste;
		this.nbrPlaceParClient = nbrPlaceParClient;
	}
	
	public Spectacle(int id, String titre, String artiste, int nbrPlaceParClient) {
		super();
		this.id = id;
		Titre = titre;
		Artiste = artiste;
		this.nbrPlaceParClient = nbrPlaceParClient;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return Titre;
	}

	public void setTitre(String titre) {
		Titre = titre;
	}



	public String getArtiste() {
		return Artiste;
	}

	public void setArtiste(String artiste) {
		Artiste = artiste;
	}

	public int getNbrPlaceParClient() {
		return nbrPlaceParClient;
	}
	public void setNbrPlaceParClient(int nbrPlaceParClient) {
		this.nbrPlaceParClient = nbrPlaceParClient;
	}
	public Representation getRepresentation() {
		return representation;
	}
	public void setRepresentation(Representation representation) {
		this.representation = representation;
	}
	public Configuration getConfig() {
		return config;
	}
	public void setConfig(Configuration config) {
		this.config = config;
	}
	public void CreateSpetacle() {
		FactoryDAO adf=new FactoryDAO();
		DAO<Spectacle> spectacledao=adf.getSpectacleDAO();
		spectacledao.create(this);
	}
	public Spectacle findSpectacle(int id) {
		FactoryDAO adf=new FactoryDAO();
		DAO<Spectacle> spectacledao=adf.getSpectacleDAO();
		return spectacledao.find(id);		
	}	
	@Override
	public String toString() {
		return this.Titre;
	}
	
	 

}
