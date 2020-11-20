package be.sente.pojo;

import java.io.Serializable;
import java.util.ArrayList;

import be.sente.DAO.DAO;
import be.sente.DAO.FactoryDAO;

public class Spectacle  implements  Serializable{
	private static final long serialVersionUID = 4019725788932367988L;
	
	private String Titre;
	private String Artiste;
	private int nbrPlaceParClient;
	private Configuration config;
	private ArrayList<Representation> listRepresentation;
	
	
	public Spectacle(String titre, String artiste, int nbrPlaceParClient) {
		super();
		Titre = titre;
		Artiste = artiste;
		this.nbrPlaceParClient = nbrPlaceParClient;
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


	public void CreateSpetacle() {
		FactoryDAO adf=new FactoryDAO();
		DAO<Spectacle> spectacledao=adf.getSpectacleDAO();
		spectacledao.create(this);
	}

	//créer une methode pour ajouter à la listedes répresentation
	public void addToList(Representation rep) {
		listRepresentation.add(rep);
		
	}

}
