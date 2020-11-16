package be.sente.DAO;

import java.sql.Connection;

import be.sente.pojo.Spectacle;

public class SpectacleDAO extends DAO<Spectacle> {
	public SpectacleDAO(Connection conn) {
		super(conn);
	}
	
	public  boolean create(Spectacle obj) {
		return false;
	}
	
	public  boolean delete(Spectacle obj) {
		return false;
	}
	
	public  boolean update(Spectacle obj) {
		return false;
	}
	public  Spectacle find(int id) {
		return null;
	}
	public  Spectacle findUser(String mail, String pwd) {
		return null;
	}

}
