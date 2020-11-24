package be.sente.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import be.sente.DAO.DAO;
import be.sente.DAO.FactoryDAO;

public class Reservation implements Serializable {

	private static final long serialVersionUID = 1265208454188011652L;
	private int id;
	private float solde;
	private String statut;
	private int idUser;
	private int idPlanning;
	private Set<PlanningSalle> listPlanning = new HashSet();

	public Reservation() {
	}

	public Reservation(float solde, String statut, int idUser) {
		super();
		this.solde = solde;
		this.statut = statut;
		this.idUser = idUser;
	}

	public Reservation(int id, float solde, String statut, int idPlanning) {
		super();
		this.id = id;
		this.solde = solde;
		this.statut = statut;
		this.idPlanning = idPlanning;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdPlanning() {
		return idPlanning;
	}

	public void setIdPlanning(int idPlanning) {
		this.idPlanning = idPlanning;
	}

	public void addPlanningToList(PlanningSalle planning) {
		if (!listPlanning.contains(planning)) {
			this.listPlanning.add(planning);
		}
	}

}
