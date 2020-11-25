package be.sente.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import be.sente.DAO.DAO;
import be.sente.DAO.FactoryDAO;

public class Configuration implements Serializable {
	
	private static final long serialVersionUID = 1544320728798868626L;
	private int id;
	private String type;
	private String description;
	private Set<Categorie> listCat= new HashSet<Categorie>();
	

	public Configuration() {}	
	public Configuration(String type, String description) {
		super();
		this.type = type;
		this.description = description;
	}	
	public Configuration(int id, String type, String description) {
		super();
		this.id = id;
		this.type = type;
		this.description = description;
	}
	
	public Set<Categorie> getListCat() {
		return listCat;
	}
	public void setListCat(Set<Categorie> listCat) {
		this.listCat = listCat;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
		DAO<Configuration> configdao=adf.getConfigurationDAO();
		configdao.create(this);
		
	}
	public void addToListCat(Categorie cat) {
		listCat.add(cat);
	}
	public Configuration findConfig(int id) {
		FactoryDAO adf=new FactoryDAO();
		DAO<Configuration> configdao=adf.getConfigurationDAO();
		return configdao.find(id);
	}
	
}
