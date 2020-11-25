package be.sente.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import be.sente.pojo.PlanningSalle;
import be.sente.pojo.Reservation;
import be.sente.pojo.Spectacle;

public class PlanningSalleDAO extends DAO<PlanningSalle> {

	public PlanningSalleDAO(Connection conn) {
		super(conn);
	}

	public boolean create(PlanningSalle obj) {
		try {
			int max_id;
			int max_id2;
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT max(IdSpectacle)max_id FROM Spectacle ");
			if (result.first()) {
				max_id = result.getInt("max_id");
			} else {
				return false;
			}
			 result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT max(IdReservation)max_id FROM Reservation ");
			if (result.first()) {
				max_id2 = result.getInt("max_id");
			} else {
				return false;
			}		
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeUpdate("INSERT INTO PlanningSalle(DateDebut,DateFin,IdUser,IdSpectacle,IdReservation) VALUES ('"
							+ obj.getDateDebutR() + "','" + obj.getDateFinR() + "',1," + max_id + ","+max_id2+")");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(PlanningSalle obj) {
		return false;

	}

	public boolean update(PlanningSalle obj) {
		return false;

	}

	public PlanningSalle find(int id) {
		PlanningSalle planning = new PlanningSalle();
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM PlanningSalle WHERE IdPlanningSalle = " + id);
			if (result.first())
				planning = new PlanningSalle(result.getInt("IdPlanningSalle"), result.getString("DateDebut"),
						result.getString("DateFin"), result.getInt("IdSpectacle"));						
			planning.setSpectacle(planning.getSpectacle().findSpectacle(result.getInt("IdSpectacle")));
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return planning;

	}

	@Override
	public PlanningSalle findUser(String mail, String pwd) {
		// TODO Auto-generated method stub
		return null;
	}

}
