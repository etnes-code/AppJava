package be.sente.DAO;

import java.sql.Connection;

import be.sente.pojo.Personne;

public class FactoryDAO  extends AbstractDAOFactory{
	protected static final Connection conn = BosquetConnection.getInstance();

	@Override
	public DAO<Personne> getPersonneDAO() {
		// TODO Auto-generated method stub
		return new PersonneDAO(conn);
	}
	
	

}
