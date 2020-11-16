package be.sente.pojo;

import java.io.Serializable;
import java.util.ArrayList;

public class Spectacle  implements  Serializable{
	private static final long serialVersionUID = 4019725788932367988L;
	
	private String Titre;
	private int nbrPlaceParClient;
	private Configuration config;
	private ArrayList<Representation> listRepresentation;
	
	public Spectacle(String titre, int nbrPlaceParClient) {
		this.Titre=titre;
		this.nbrPlaceParClient= nbrPlaceParClient;
		listRepresentation= new ArrayList<Representation>();
		
	}
	
	
	
	//cr�er une methode pour ajouter � la listedes r�presentation
	public void addToList(Representation rep) {
		listRepresentation.add(rep);
		
	}

}
