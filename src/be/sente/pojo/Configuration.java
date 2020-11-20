package be.sente.pojo;

import java.io.Serializable;

import be.sente.DAO.DAO;
import be.sente.DAO.FactoryDAO;

public class Configuration implements Serializable {
	
	private static final long serialVersionUID = 1544320728798868626L;
	private String type;
	private String description;
	public Configuration(String type, String description) {
		super();
		this.type = type;
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void CreateConfig() {
		FactoryDAO adf=new FactoryDAO();
		DAO<Configuration> configdao=adf.getConfiguration();
		configdao.create(this);
		
	}
	
}
