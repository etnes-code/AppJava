package be.sente.DAO;

import be.sente.pojo.Personne;

public abstract class AbstractDAOFactory {
	public static final int DAO_FACTORY = 0;
    public static final int XML_DAO_FACTORY = 1;
	public abstract DAO<Personne> getPersonneDAO();
	
	public static AbstractDAOFactory getFactory(int type){
        switch(type){
        case DAO_FACTORY:
            return new FactoryDAO();
            default:
                return null;
        }
    }
	
	

}
