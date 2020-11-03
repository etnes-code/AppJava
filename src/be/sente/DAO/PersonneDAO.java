package be.sente.DAO;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import be.sente.pojo.Personne;

public class PersonneDAO extends DAO<Personne> {

	public PersonneDAO(Connection conn) {
		super(conn);
	}

	public boolean create(Personne obj) {
		
		try {
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate(
					"INSERT INTO User(Nom,Prenom,Rue,Numero,CodePostal,Ville,Email,PassWord,Discriminator) VALUES('"
							+ obj.getNom() + "','" + obj.getPrenom() + "','" + obj.getRue() + "'," + obj.getNumRue()
							+ "," + obj.getCp() + ",'" + obj.getVille() + "','" + obj.getEmail() + "','"
							+ obj.getPassword() + "','"+ obj.getClass().getSimpleName().toString()+"')");		
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Personne obj) {
		return false;
	}

	public boolean update(Personne obj) {
		return false;
	}

}
