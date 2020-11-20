package be.sente.DAO;

import java.sql.Connection;

import be.sente.pojo.Categorie;
import be.sente.pojo.Configuration;
import be.sente.pojo.Personne;
import be.sente.pojo.PlanningSalle;
import be.sente.pojo.Spectacle;

public class FactoryDAO  extends AbstractDAOFactory{
	protected static final Connection conn = BosquetConnection.getInstance();

	@Override
	public DAO<Personne> getPersonneDAO() {
		// TODO Auto-generated method stub
		return new PersonneDAO(conn);
	}
	public  DAO<PlanningSalle>getPlanningSalleDAO(){
		return new PlanningSalleDAO(conn);
	}
	public  DAO<Spectacle>getSpectacleDAO(){
		return new SpectacleDAO(conn);
	}
	public  DAO<Configuration>getConfiguration(){
		return new ConfigurationDAO(conn);
	}
	public  DAO<Categorie>getCategorie(){
		return new CategorieDAO(conn);
	}
	
	

}
