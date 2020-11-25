package be.sente.pojo;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import javax.swing.DefaultListModel;

import be.sente.DAO.DAO;
import be.sente.DAO.FactoryDAO;

public class PlanningSalle implements Serializable {
	
	private static final long serialVersionUID = -5918981801466838303L;
	
	private int id;
	private String dateDebutR;
	private String dateFinR;
	private int idSpectacle;
	private Spectacle spectacle=new Spectacle();
	
	public PlanningSalle() {}
	public PlanningSalle(String dateDebutR, String dateFinR) {
		super();
		this.dateDebutR = dateDebutR;
		this.dateFinR = dateFinR;
	}
	
	public PlanningSalle(int id, String dateDebutR, String dateFinR, int idSpectacle) {
		super();
		this.id = id;
		this.dateDebutR = dateDebutR;
		this.dateFinR = dateFinR;
		this.idSpectacle = idSpectacle;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdSpectacle() {
		return idSpectacle;
	}
	public void setIdSpectacle(int idSpectacle) {
		this.idSpectacle = idSpectacle;
	}
	public String getDateDebutR() {
		return dateDebutR;
	}
	public void setDateDebutR(String dateDebutR) {
		this.dateDebutR = dateDebutR;
	}
	public String getDateFinR() {
		return dateFinR;
	}
	public void setDateFinR(String dateFinR) {
		this.dateFinR = dateFinR;
	}
	
	public Spectacle getSpectacle() {
		return spectacle;
	}
	public void setSpectacle(Spectacle spectacle) {
		this.spectacle = spectacle;
	}
	public void createPlanning() {
		FactoryDAO adf=new FactoryDAO();
		DAO<PlanningSalle> planningdao=adf.getPlanningSalleDAO();
		planningdao.create(this);
	}	
}
