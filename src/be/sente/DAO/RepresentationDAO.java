package be.sente.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import be.sente.pojo.Representation;

public class RepresentationDAO extends DAO<Representation> {

	public RepresentationDAO(Connection conn) {
		super(conn);
	}

	public boolean create(Representation obj) {
		try {
			int max_id;
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT max(IdSpectacle)max_id FROM Spectacle");
			if (result.first()) {
				max_id = result.getInt("max_id");
			} else {
				return false;
			}
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeUpdate("INSERT INTO Representation(HeureDebut,HeureFin,OuverturePorte,IdSpectacle) VALUES('"
							+ obj.getHeureDebut() + "','" + obj.getHeureFin() + "','" + obj.getOuverturePorte() + "',"
							+ max_id + ")");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean delete(Representation obj) {
		return false;
	}

	public boolean update(Representation obj) {
		return false;
	}

	public Representation find(int id) {
		Representation rep = new Representation();
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM Representation WHERE IdSpectacle = " + id);
			if (result.first()) {
				rep = new Representation(result.getInt("IdRepresentation"), result.getString("HeureDebut"),
						result.getString("HeureFin"), result.getString("OuverturePorte"), result.getInt("IdSpectacle"));			
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return rep;
	}

	public Representation findUser(String mail, String pwd) {
		return null;
	}

	@Override
	public ArrayList<Representation> getALL() {
		// TODO Auto-generated method stub
		return null;
	}

}
