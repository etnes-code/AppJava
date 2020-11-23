package be.sente.pojo;

import java.io.Serializable;
import java.util.ArrayList;

import be.sente.DAO.DAO;
import be.sente.DAO.FactoryDAO;

public class Reservation implements Serializable {
	
	private static final long serialVersionUID = 1265208454188011652L;
	private float solde;
	private String statut;
	private int idUser;
	public Reservation() {}
	public Reservation(float solde, String statut, int idUser) {
		super();
		this.solde = solde;
		this.statut = statut;
		this.idUser = idUser;
	}
	public float getSolde() {
		return solde;
	}
	public void setSolde(float solde) {
		this.solde = solde;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
	
	

	//méthode ajouter à la liste des planning de la salle

}
