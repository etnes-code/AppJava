package be.sente.DAO;

import java.sql.Connection;

import be.sente.pojo.Categorie;
import be.sente.pojo.Configuration;
import be.sente.pojo.Personne;
import be.sente.pojo.PlanningSalle;
import be.sente.pojo.Representation;
import be.sente.pojo.Reservation;
import be.sente.pojo.Spectacle;

public class FactoryDAO  extends AbstractDAOFactory{
	protected static final Connection conn = BosquetConnection.getInstance();

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
	public  DAO<Configuration>getConfigurationDAO(){
		return new ConfigurationDAO(conn);
	}
	public  DAO<Categorie>getCategorieDAO(){
		return new CategorieDAO(conn);
	}
	public  DAO<Representation>getRepresentationDAO(){
		return new RepresentationDAO(conn);
	}
	public  DAO<Reservation>getReservationDAO(){
		return new ReservationDAO(conn);		
	}
	
	

}
