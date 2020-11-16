package be.sente.DAO;

import java.sql.Connection;

import be.sente.pojo.Configuration;

public class ConfigurationDAO extends DAO<Configuration> {
	
	public ConfigurationDAO(Connection conn) {
		super(conn);
	}
	public  boolean create(Configuration obj) {
		return false;
	}
	
	public  boolean delete(Configuration obj) {
		return false;
	}
	
	public  boolean update(Configuration obj) {
		return false;
	}
	
	public Configuration find(int id) {
		return null;
	}
	public  Configuration findUser(String mail, String pwd) {
		return null;
	}

}
