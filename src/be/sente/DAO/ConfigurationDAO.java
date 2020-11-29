package be.sente.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

import be.sente.pojo.Categorie;
import be.sente.pojo.Configuration;
import be.sente.pojo.Spectacle;

public class ConfigurationDAO extends DAO<Configuration> {

	public ConfigurationDAO(Connection conn) {
		super(conn);
	}

	public boolean create(Configuration obj) {
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
					.executeUpdate("INSERT INTO Configuration(Type,Description,IdSpectacle) VALUES('" + obj.getType()
							+ "','" + obj.getDescription() + "'," + max_id + ")");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Configuration obj) {
		return false;
	}

	public boolean update(Configuration obj) {
		return false;
	}

	public Configuration find(int id) {
		Configuration config = new Configuration();
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM Configuration WHERE IdSpectacle = " + id);
			if (result.first())
				config = new Configuration(result.getInt("IdConfiguration"), result.getString("Type"),
						result.getString("Description"));
			result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery(
							"SELECT * FROM Categorie WHERE IdConfiguration = " + result.getInt("IdConfiguration"));
			Categorie categorie = new Categorie();
			while (result.next()) {
				categorie = new Categorie(result.getInt("IdCategorie"), result.getString("Type"), result.getInt("Prix"),
						result.getInt("NbrPlaceMax"), result.getInt("NbrPlaceRestante"));
				config.addToListCat(categorie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return config;
	}

	public Configuration findUser(String mail, String pwd) {
		return null;
	}

}
