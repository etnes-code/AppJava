package be.sente.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import be.sente.pojo.PlanningSalle;

public class PlanningSalleDAO extends DAO<PlanningSalle> {

	public PlanningSalleDAO(Connection conn) {
		super(conn);
	}

	public boolean create(PlanningSalle obj) {
		try {
			int max_id;
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT max(IdSpectacle)max_id FROM Spectacle ");
			if (result.first()) {
				max_id = result.getInt("max_id");
			} else {
				return false;
			}
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeUpdate("INSERT INTO PlanningSalle(DateDebut,DateFin,IdUser,IdSpectacle) VALUES ('"
							+ obj.getDateDebutR() + "','" + obj.getDateFinR() + "',1," + max_id + ")");
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
		return null;

	}

	@Override
	public PlanningSalle findUser(String mail, String pwd) {
		// TODO Auto-generated method stub
		return null;
	}

}
