package be.sente.pojo;

import be.sente.DAO.BosquetConnection;
import be.sente.DAO.DAO;
import be.sente.DAO.PersonneDAO;

public class TestQuery {

	public static void main(String[] args) {
		DAO<Personne> personne1= new PersonneDAO(BosquetConnection.getInstance());
		Personne p1= new Client("sente","quentin","rue des champs",43,6200,"Châtelet","Sente.quentin@gmail.com","pwd");
	}

}
