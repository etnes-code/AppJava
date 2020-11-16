package be.sente.DAO;

import java.sql.Connection;

import be.sente.pojo.Categorie;

public class CategorieDAO extends DAO<Categorie> {
	public CategorieDAO(Connection conn) {
		super(conn);
	}
	public  boolean create(Categorie obj) {
		return false;
	}
	
	public  boolean delete(Categorie obj) {
		return false;
	}
	
	public  boolean update(Categorie obj) {
		return false;
	}
	
	public Categorie find(int id) {
		return null;
	}
	public  Categorie findUser(String mail, String pwd) {
		return null;
	}
	

}
