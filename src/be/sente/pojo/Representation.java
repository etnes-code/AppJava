package be.sente.pojo;

import java.io.Serializable;
import java.sql.Date;

import be.sente.DAO.DAO;
import be.sente.DAO.FactoryDAO;

public class Representation implements Serializable {
	
	
	private static final long serialVersionUID = -2212958095864381221L;
	private int id ;
	private String HeureDebut;
	private String heureFin;
	private String OuverturePorte;
	private int idSpectacle;
	public Representation() {}
	public Representation(String heureDebut, String heureFin, String ouverturePorte) {
		super();
		HeureDebut = heureDebut;
		this.heureFin = heureFin;
		OuverturePorte = ouverturePorte;
	}
	
	public Representation(int id, String heureDebut, String heureFin, String ouverturePorte,int idSpectacle) {
		super();
		this.id = id;
		HeureDebut = heureDebut;
		this.heureFin = heureFin;
		OuverturePorte = ouverturePorte;
		this.idSpectacle= idSpectacle;
	}
	public String getHeureDebut() {
		return HeureDebut;
	}
	public void setHeureDebut(String heureDebut) {
		HeureDebut = heureDebut;
	}
	public String getHeureFin() {
		return heureFin;
	}
	public void setHeureFin(String heureFin) {
		this.heureFin = heureFin;
	}
	public String getOuverturePorte() {
		return OuverturePorte;
	}
	public void setOuverturePorte(String ouverturePorte) {
		OuverturePorte = ouverturePorte;
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
	public void createRepresentation() {
		FactoryDAO adf=new FactoryDAO();
		DAO<Representation> repdao=adf.getRepresentationDAO();
		repdao.create(this);
	}
	public Representation findRep(int id) {
		FactoryDAO adf=new FactoryDAO();
		DAO<Representation> repdao=adf.getRepresentationDAO();
		return repdao.find(id);
	}
	
	
}
