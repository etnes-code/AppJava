package be.sente.pojo;

import be.sente.DAO.BosquetConnection;
import be.sente.DAO.DAO;
import be.sente.DAO.FactoryDAO;
import be.sente.DAO.PersonneDAO;

public class TestQuery {

	public static void main(String[] args) {
		//DAO<Personne> personne1 = new PersonneDAO(BosquetConnection.getInstance());
		
		
		FactoryDAO adf=new FactoryDAO();
		
	
		//DAO<Personne> personnedao=adf.getPersonneDAO();
		/*PlanningSalle p1= new PlanningSalle("16-05-2020","16-05-2020");		
		DAO<PlanningSalle> planningdao=adf.getPlanningSalleDAO();
		planningdao.create(p1);
		System.out.println("ok planning");
		Spectacle s1=new Spectacle("hello world","bob dylan",2);
		DAO<Spectacle> spectacledao=adf.getSpectacleDAO();
		spectacledao.create(s1);
		System.out.println("ok spectacle");*/
		Configuration c1= new Configuration("Assis version concert","version concert");
		DAO<Configuration>configdao=adf.getConfiguration();
		configdao.create(c1);
		
		
		//Personne p= new Personne();
		//p= new Client("sente","quentin","rue des champs",43,6200,"Châtelet","Sente.quentin@gmail.com","pwd");
		

	}

}
