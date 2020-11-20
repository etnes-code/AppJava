package be.sente.DAO;

import be.sente.pojo.Categorie;
import be.sente.pojo.Configuration;
import be.sente.pojo.Personne;
import be.sente.pojo.PlanningSalle;
import be.sente.pojo.Spectacle;

public abstract class DAOFactory {
	
	public static final int DAO_FACTORY = 0;
	public static final int XML_DAO_FACTORY = 1;
	
	public abstract DAO<Personne> getPersonneDAO();
	public abstract DAO<PlanningSalle>getPlanningSalleDAO();
	public abstract DAO<Spectacle>getSpectacleDAO();
	public abstract DAO<Configuration>getConfiguration();
	public abstract DAO<Categorie>getCategorie();
	
	
		
	


}