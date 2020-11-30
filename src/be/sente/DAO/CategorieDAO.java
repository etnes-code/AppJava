package be.sente.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import be.sente.pojo.Categorie;
import be.sente.pojo.Configuration;

public class CategorieDAO extends DAO<Categorie> {
	public CategorieDAO(Connection conn) {
		super(conn);
	}

	public boolean create(Categorie obj) {
		try {
			int max_id;
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT max(IdConfiguration)max_id FROM Configuration ");
			if (result.first()) {
				max_id = result.getInt("max_id");
			} else {
				return false;
			}
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate(
					"INSERT INTO Categorie(Type,Prix,NbrPlaceMax,NbrPlaceRestante,IdConfiguration)VALUES('"
							+ obj.getType() + "'," + obj.getPrix() + "," + obj.getNbrPlaceMax() + ","
							+ obj.getNbrPlaceRestante() + "," + max_id + ")");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Categorie obj) {
		return false;
	}

	public boolean update(Categorie obj) {
		try {

			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeUpdate("UPDATE Categorie SET NbrPlaceRestante = "+obj.getNbrPlaceRestante()+" WHERE IdConfiguration = "+obj.getIdConfig());
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public Categorie find(int id) {
		Categorie cat = new Categorie();
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM Categorie WHERE IdConfiguration = " + id);
			if (result.first())
				cat = new Categorie(result.getInt("IdCategorie"), result.getString("Type"), result.getInt("Prix"),
						result.getInt("NbrPlaceMax"), result.getInt("NbrPlaceRestante"),
						result.getInt("IdConfiguration"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cat;
	}

	public Categorie findUser(String mail, String pwd) {
		return null;
	}

	@Override
	public ArrayList<Categorie> getALL() {
		// TODO Auto-generated method stub
		return null;
	}

}
