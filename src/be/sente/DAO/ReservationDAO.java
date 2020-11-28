package be.sente.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import be.sente.ecole.Eleve;
import be.sente.pojo.Categorie;
import be.sente.pojo.Organisateur;
import be.sente.pojo.PlanningSalle;
import be.sente.pojo.Reservation;

public class ReservationDAO extends DAO<Reservation> {
	public ReservationDAO(Connection conn) {
		super(conn);
	}

	public boolean create(Reservation obj) {
		try {

			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeUpdate("INSERT INTO Reservation(Solde,Statut,IdUser) VALUES(" + obj.getSolde() + ",'"
							+ obj.getStatut() + "'," + obj.getIdUser() + ")");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Reservation obj) {
		try {
			
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
			.executeUpdate("DELETE FROM Reservation WHERE IdReservation = "+obj.getId());
			return true;
			
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Reservation obj) {
		try {
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
			.executeUpdate("UPDATE FROM Reservation SET Solde = "+obj.getSolde()+", Statut = '"+obj.getStatut()+"' WHERE IdReservation = "+obj.getId());	
			return true;			
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public Reservation find(int id) {
		Reservation reservation = new Reservation();
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM Reservation WHERE IdReservation = " + id);
			if (result.first())
				reservation = new Reservation(result.getInt("IdReservation"), result.getInt("Solde"),
						result.getString("Statut"));
			result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery(
							"SELECT * FROM PlanningSalle WHERE IdReservation = " + result.getInt("IdReservation"));
			if (result.first()) {
				FactoryDAO adf = new FactoryDAO();
				DAO<PlanningSalle> planningdao = adf.getPlanningSalleDAO();
				PlanningSalle plan = planningdao.find(result.getInt("IdPlanningSalle"));
				reservation.setPlanning(plan);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservation;
	}

	public Reservation findUser(String mail, String pwd) {
		return null;
	}

}
