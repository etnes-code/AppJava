package be.sente.DAO;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;

import be.sente.ecole.Classe;
import be.sente.ecole.EleveDAO;
import be.sente.ecole.ProfesseurDAO;
import be.sente.pojo.Artistes;
import be.sente.pojo.Client;
import be.sente.pojo.Commande;
import be.sente.pojo.Organisateur;
import be.sente.pojo.Personne;
import be.sente.pojo.Place;
import be.sente.pojo.PlanningSalle;
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
		try {
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeUpdate("UPDATE INTO User SET Nom = '" + obj.getNom() + "', Prenom = '" + obj.getPrenom()
							+ "', Rue = '" + obj.getRue() + "', Numero = " + obj.getNumRue() + ",CodePostale = "
							+ obj.getCp() + ", Ville = '" + obj.getVille() + "', Email = '" + obj.getEmail()
							+ "', PassWord = '" + obj.getPassword() + "' WHERE IdUser = " + obj.getId());
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
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

	@SuppressWarnings("resource")
	public Personne find(int id) {
		Personne p = new Personne();
		FactoryDAO adf = new FactoryDAO();
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
					result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
							.executeQuery("SELECT * FROM Commande WHERE IdUser = " + p.getId());
					Commande commande = new Commande();
					DAO<Place> placedao = adf.getPlaceDAO();
					while (result.next()) {
						commande = new Commande(result.getInt("IdCommande"), result.getString("ModeLivraison"),
								result.getString("ModePaiement"), result.getInt("TotalCommande"));
						commande.setPlace(placedao.find(result.getInt("IdCommande")));
						p.addToList(commande);
					}

					break;
				case "Organisateur":
					p = new Organisateur(result.getInt("IdUser"), result.getString("Nom"), result.getString("Prenom"),
							result.getString("Rue"), result.getInt("Numero"), result.getInt("CodePostal"),
							result.getString("Ville"), result.getString("Email"), result.getString("Password"));

					result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
							.executeQuery("SELECT * FROM Reservation WHERE IdUser = " + p.getId());
					Reservation reservation = new Reservation();
					DAO<PlanningSalle> planningdao = adf.getPlanningSalleDAO();
					while (result.next()) {
						reservation = new Reservation(result.getInt("IdReservation"), result.getInt("Solde"),
								result.getString("Statut"));
						PlanningSalle plan = planningdao.find(result.getInt("IdReservation"));
						reservation.setPlanning(plan);
						p.addToList(reservation);
					}
					break;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public ArrayList<Personne> getALL() {
		// TODO Auto-generated method stub
		return null;
	}

}
