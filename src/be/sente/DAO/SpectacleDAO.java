package be.sente.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import be.sente.pojo.Spectacle;

public class SpectacleDAO extends DAO<Spectacle> {
	public SpectacleDAO(Connection conn) {
		super(conn);
	}

	public boolean create(Spectacle obj) {
		try {
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeUpdate("INSERT INTO Spectacle(Titre,Artiste,NbrPlaceMaxParClient)VALUES('"
							+ obj.getTitre() + "','" + obj.getArtiste() + "'," + obj.getNbrPlaceParClient()+")");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Spectacle obj) {
		return false;
	}

	public boolean update(Spectacle obj) {
		return false;
	}

	public Spectacle find(int id) {
		return null;
	}

	public Spectacle findUser(String mail, String pwd) {
		return null;
	}

}
