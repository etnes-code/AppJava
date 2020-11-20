package be.sente.pojo;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import javax.swing.DefaultListModel;

public class PlanningSalle implements Serializable {
	
	private static final long serialVersionUID = -5918981801466838303L;
	String dateDebutR;
	String dateFinR;
	public PlanningSalle(String dateDebutR, String dateFinR) {
		super();
		this.dateDebutR = dateDebutR;
		this.dateFinR = dateFinR;
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
	
	
}
