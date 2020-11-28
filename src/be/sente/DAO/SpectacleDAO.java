package be.sente.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import be.sente.pojo.Configuration;
import be.sente.pojo.PlanningSalle;
import be.sente.pojo.Spectacle;

public class SpectacleDAO extends DAO<Spectacle> {
	public SpectacleDAO(Connection conn) {
		super(conn);
	}

	public boolean create(Spectacle obj) {
		try {
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeUpdate("INSERT INTO Spectacle(Titre,Artiste,NbrPlaceMaxParClient)VALUES('" + obj.getTitre()
							+ "','" + obj.getArtiste() + "'," + obj.getNbrPlaceParClient() + ")");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Spectacle obj) {
		try {
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeUpdate("DELETE FROM spectacle WHERE IdSpectacle = " + obj.getId());
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Spectacle obj) {
		try {

			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeUpdate("UPDATE INTO spectacle SET Titre = '" + obj.getTitre() + "', Artiste = '"
							+ obj.getArtiste() + "', NbrPlaceMaxParClient = " + obj.getNbrPlaceParClient()
							+ "WHERE IdSpectacle = " + obj.getId());
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public Spectacle find(int id) {
		Spectacle spectacle = new Spectacle();
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM Spectacle WHERE IdSpectacle = " + id);
			if (result.first())
				spectacle = new Spectacle(result.getInt("IdSpectacle"), result.getString("Titre"),
						result.getString("Artiste"), result.getInt("NbrPlaceMaxParClient"));
			spectacle.setConfig(spectacle.getConfig().findConfig(result.getInt("idSpectacle")));
			spectacle.setRepresentation(spectacle.getRepresentation().findRep(result.getInt("idSpectacle")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return spectacle;
	}

	public Spectacle findUser(String mail, String pwd) {
		return null;
	}

	@Override
	public ArrayList<Spectacle> getALL() {
		ArrayList<Spectacle> listSpectacle = new ArrayList<Spectacle>();
		Spectacle spectacle = new Spectacle();
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM Spectacle ");
			while (result.next()) {
				spectacle = new Spectacle(result.getInt("IdSpectacle"), result.getString("Titre"),
						result.getString("Artiste"), result.getInt("NbrPlaceMaxParClient"));
				spectacle.setConfig(spectacle.getConfig().findConfig(result.getInt("IdSpectacle")));
				spectacle.setRepresentation(spectacle.getRepresentation().findRep(result.getInt("IdSpectacle")));
				listSpectacle.add(spectacle);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listSpectacle;
	}

}
