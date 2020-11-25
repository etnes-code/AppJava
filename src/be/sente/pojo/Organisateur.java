package be.sente.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import be.sente.DAO.DAO;
import be.sente.DAO.FactoryDAO;

public class Organisateur extends Personne implements Serializable {
	private static final long serialVersionUID = -1625130318528201331L;
	
	private Set<Reservation> listReservation= new HashSet<>();
	private Reservation reservation;
	public Organisateur() {
		super();
	}
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
	
	
	public Set<Reservation> getListReservation() {
		return listReservation;
	}
	public void setListReservation(Set<Reservation> listReservation) {
		this.listReservation = listReservation;
	}
	@Override
	public void addToList(Object obj) {
		listReservation.add((Reservation) obj);
	}
	@Override
	public void displayList() {
		for(var item : listReservation) {
			System.out.println(item);		
		}
		
	}
	
}
