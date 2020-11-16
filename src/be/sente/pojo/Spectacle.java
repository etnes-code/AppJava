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
	
	
	
	//créer une methode pour ajouter à la listedes répresentation
	public void addToList(Representation rep) {
		listRepresentation.add(rep);
		
	}

}
