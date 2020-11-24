package be.sente.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import be.sente.ecole.Eleve;
import be.sente.pojo.Categorie;
import be.sente.pojo.Organisateur;
import be.sente.pojo.Reservation;

public class ReservationDAO extends DAO<Reservation> {
	public ReservationDAO(Connection conn) {
		super(conn);
	}

	public boolean create(Reservation obj) {
		try {
			
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeUpdate("INSERT INTO Reservation(Solde,Statut,IdUser) VALUES("
							+ obj.getSolde() + ",'" + obj.getStatut() + "'," + obj.getIdUser() + ")");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Reservation obj) {
		return false;
	}

	public boolean update(Reservation obj) {
		return false;
	}

	public Reservation find(int id) {
		Reservation reservation = new Reservation();
		try{
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
	ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Reservation WHERE IdUser = " + id);
			if(result.first())
				reservation = new Reservation(result.getInt("IdReservation"), result.getInt("Solde"), result.getString("Statut"),result.getInt("IdPlanningSalle"));
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return reservation;
	}

	public Reservation findUser(String mail, String pwd) {
		return null;
	}


}
