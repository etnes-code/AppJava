package be.sente.DAO;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import be.sente.ecole.Classe;
import be.sente.ecole.EleveDAO;
import be.sente.ecole.ProfesseurDAO;
import be.sente.pojo.Artistes;
import be.sente.pojo.Client;
import be.sente.pojo.Organisateur;
import be.sente.pojo.Personne;
import be.sente.pojo.Reservation;

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
							+ obj.getPassword() + "','" + obj.getClass().getSimpleName().toString() + "')");
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

	public Personne findUser(String mail, String pwd) {
		Personne user = new Personne();
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM User WHERE Email LIKE '" + mail + "' AND Password LIKE '" + pwd + "'");
			if (result.first()) {
				String disc = result.getString("Discriminator");
				switch (disc) {
				case "Client":
					user = new Client(result.getInt("IdUser"), result.getString("Nom"), result.getString("Prenom"),
							result.getString("Rue"), result.getInt("Numero"), result.getInt("CodePostal"),
							result.getString("Ville"), result.getString("Email"), result.getString("Password"));
					break;
				case "Organisateur":
					user = new Organisateur(result.getInt("IdUser"), result.getString("Nom"),
							result.getString("Prenom"), result.getString("Rue"), result.getInt("Numero"),
							result.getInt("CodePostal"), result.getString("Ville"), result.getString("Email"),
							result.getString("Password"));
					break;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;

	}

	public Personne find(int id) {
		Personne p = new Personne();
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM User WHERE IdUser = " + id);
			if (result.first()) {
				String disc = result.getString("Discriminator");
				switch (disc) {
				case "Client":
					p = new Client(result.getInt("IdUser"), result.getString("Nom"), result.getString("Prenom"),
							result.getString("Rue"), result.getInt("Numero"), result.getInt("CodePostal"),
							result.getString("Ville"), result.getString("Email"), result.getString("Password"));
					break;
				case "Organisateur":
					p = new Organisateur(result.getInt("IdUser"), result.getString("Nom"), result.getString("Prenom"),
							result.getString("Rue"), result.getInt("Numero"), result.getInt("CodePostal"),
							result.getString("Ville"), result.getString("Email"), result.getString("Password"));
							FactoryDAO adf=new FactoryDAO();
							DAO<Reservation> reservationdao=adf.getReservationDAO();
					 		result = this.connect
							.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
							.executeQuery("SELECT IdReservation FROM Reservation WHERE IdUser = " + p.getId());
					 		while(result.next()) {
					 			p.addToList(reservationdao.find(result.getInt("IdReservation")));
					 		}
					break;
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

}
