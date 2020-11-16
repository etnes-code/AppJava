package be.sente.DAO;

import java.sql.Connection;

import be.sente.pojo.Reservation;

public class ReservationDAO extends DAO<Reservation> {
	public ReservationDAO(Connection conn) {
		super(conn);
	}
	public  boolean create(Reservation obj) {
		return false;
	}
	
	public  boolean delete(Reservation obj) {
		return false;
	}
	
	public boolean update(Reservation obj) {
		return false;
	}
	
	public Reservation find(int id) {
		return null;
	}
	public  Reservation findUser(String mail, String pwd) {
		return null;
	}
	

}
