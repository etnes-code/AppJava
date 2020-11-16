package be.sente.pojo;

import be.sente.DAO.BosquetConnection;
import be.sente.DAO.DAO;
import be.sente.DAO.FactoryDAO;
import be.sente.DAO.PersonneDAO;

public class TestQuery {

	public static void main(String[] args) {
		//DAO<Personne> personne1 = new PersonneDAO(BosquetConnection.getInstance());
		
		
		FactoryDAO adf=new FactoryDAO();
		DAO<Personne> personnedao=adf.getPersonneDAO();
		
		
		//Personne p= new Personne();
		//p= new Client("sente","quentin","rue des champs",43,6200,"Châtelet","Sente.quentin@gmail.com","pwd");
		

	}

}
