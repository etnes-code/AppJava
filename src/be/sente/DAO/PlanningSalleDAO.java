package be.sente.DAO;

import java.sql.Connection;

import be.sente.pojo.PlanningSalle;

public class PlanningSalleDAO  extends DAO<PlanningSalle>{
	

	public PlanningSalleDAO (Connection conn) {
		super(conn);
	}
	public  boolean create(PlanningSalle obj) {
	return false;
	
	}
	
	public  boolean delete(PlanningSalle obj) {
		return false;
		
	}
	
	public boolean update(PlanningSalle obj) {
		return false;
		
	}
	
	public  PlanningSalle find(int id) {
		
		
	}
	@Override
	public PlanningSalle findUser(String mail, String pwd) {
		// TODO Auto-generated method stub
		return null;
	}

}
