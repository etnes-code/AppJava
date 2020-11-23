package be.sente.pojo;

import java.io.Serializable;
import java.sql.Date;

import be.sente.DAO.DAO;
import be.sente.DAO.FactoryDAO;

public class Representation implements Serializable {
	
	
	private static final long serialVersionUID = -2212958095864381221L;

	private String HeureDebut;
	private String heureFin;
	private String OuverturePorte;
	public Representation(String heureDebut, String heureFin, String ouverturePorte) {
		super();
		HeureDebut = heureDebut;
		this.heureFin = heureFin;
		OuverturePorte = ouverturePorte;
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
	public void createRepresentation() {
		FactoryDAO adf=new FactoryDAO();
		DAO<Representation> repdao=adf.getRepresentationDAO();
		repdao.create(this);
	}
	
	
	
}
