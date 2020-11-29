package be.sente.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import be.sente.pojo.Place;
import be.sente.pojo.Representation;

public class PlaceDAO extends DAO<Place> {

	public PlaceDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Place obj) {
		try {
			int max_id = 0;
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT max(IdCommande)max_id FROM Commande");
			if (result.first()) { max_id = result.getInt("max_id");}			
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeUpdate("INSERT INTO Place(Nom,Prix,NombreDePlace,IdRepresentation,IdCommande) VALUES ('"
							+ obj.getNom() + "'," + obj.getPrix() + "," + obj.getNbrPlace() + "," + obj.getIdRep() + ","
							+ max_id + ")");
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Place obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Place obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Place find(int id) {
		Place place= new Place();
		FactoryDAO adf=new FactoryDAO();
		try {
		ResultSet result = this.connect
				.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
				.executeQuery("SELECT * FROM Place WHERE IdCommande = "+id);
		if(result.first()) {
			DAO<Representation> repdao= adf.getRepresentationDAO();
			place = new Place(result.getInt("IdPlace"),result.getString("Nom"),result.getInt("Prix"),result.getInt("NombreDePlace"));
			place.setRepresentation(repdao.find(result.getInt("IdRepresentation")));
		}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return place;
	
	}

	@Override
	public Place findUser(String mail, String pwd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Place> getALL() {
		// TODO Auto-generated method stub
		return null;
	}
}
