package be.sente.pojo;

import java.io.Serializable;
import java.util.ArrayList;

import be.sente.DAO.DAO;
import be.sente.DAO.FactoryDAO;

public class Organisateur extends Personne implements Serializable {
	private static final long serialVersionUID = -1625130318528201331L;
	
	private Reservation reservation;
	
	
	public Organisateur() {}
	public Organisateur(String nom, String prenom, String rue, int numRue, int cp, String ville, String email, String password) {
		super(nom, prenom, rue, numRue, cp, ville, email, password);	
	}
	public Organisateur(int id, String nom, String prenom, String rue, int numRue, int cp, String ville, String email,
			String password) {
		super(id, nom, prenom, rue, numRue, cp, ville, email, password);
		reservation=new Reservation();
	}
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public void createReservation() {
		FactoryDAO adf=new FactoryDAO();
		DAO<Reservation> reservationdao=adf.getReservationDAO();
		reservationdao.create(this.reservation);
	}
	
}
