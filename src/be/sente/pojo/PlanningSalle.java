package be.sente.pojo;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import javax.swing.DefaultListModel;

public class PlanningSalle implements Serializable {
	
	private static final long serialVersionUID = -5918981801466838303L;
	LocalDate dateDebutR;
	LocalDate dateFinR;
	public PlanningSalle(LocalDate dateDebutR, LocalDate dateFinR) {
		super();
		this.dateDebutR = dateDebutR;
		this.dateFinR = dateFinR;
	}
	public LocalDate getDateDebutR() {
		return dateDebutR;
	}
	public void setDateDebutR(LocalDate dateDebutR) {
		this.dateDebutR = dateDebutR;
	}
	public LocalDate getDateFinR() {
		return dateFinR;
	}
	public void setDateFinR(LocalDate dateFinR) {
		this.dateFinR = dateFinR;
	}
	@Override
	public String toString() {
		return   ""+getDateDebutR()+" 12:00:00 jusqu'a "+getDateFinR()+" 12:00:00" ;
	}
	
	
	
	
	
}
