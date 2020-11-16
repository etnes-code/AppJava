package be.sente.DAO;

import be.sente.pojo.Personne;

public abstract class AbstractDAOFactory {
	public abstract DAO<Personne> getPersonneDAO();
	
	

}
