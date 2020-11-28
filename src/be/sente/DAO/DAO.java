package be.sente.DAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import be.sente.pojo.Personne;

public abstract class DAO<T> {
protected Connection connect = null;
	public DAO(Connection conn){
		this.connect = conn;
	}	
	public abstract boolean create(T obj);
	
	public abstract boolean delete(T obj);
	
	public abstract boolean update(T obj);
	
	public abstract T find(int id);
	public  abstract T findUser(String mail, String pwd);
	public abstract ArrayList<T>getALL();
}
