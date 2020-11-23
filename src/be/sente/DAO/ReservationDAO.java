package be.sente.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import be.sente.pojo.Categorie;
import be.sente.pojo.Organisateur;
import be.sente.pojo.Reservation;

public class ReservationDAO extends DAO<Reservation> {
	public ReservationDAO(Connection conn) {
		super(conn);
	}

	public boolean create(Reservation obj) {
		try {
			int max_id;
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT max(IdPlanningSalle)max_id FROM PlanningSalle");
			if (result.first()) {
				max_id = result.getInt("max_id");
			} else {
				return false;
			}
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeUpdate("INSERT INTO Reservation(Solde,Statut,IdPlanningSalle,IdUser) VALUES("
							+ obj.getSolde() + ",'" + obj.getStatut() + "'," + max_id
							+ "," + obj.getIdUser() + ")");
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
		return null;
	}

	public Reservation findUser(String mail, String pwd) {
		return null;
	}


}
