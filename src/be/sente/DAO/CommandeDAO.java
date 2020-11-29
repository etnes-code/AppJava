package be.sente.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import be.sente.pojo.Commande;

public class CommandeDAO extends DAO<Commande> {

	public CommandeDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Commande obj) {
		try {
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeUpdate("INSERT INTO Commande(ModeLivraison,ModePaiement,TotalCommande,IdUser) VALUES ('"
							+ obj.getModeDeLivraison() + "','" + obj.getModeDePayement() + "'," + obj.getTotalCommande()
							+ ","+obj.getIdUser()+")");
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public boolean delete(Commande obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Commande obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Commande find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Commande findUser(String mail, String pwd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Commande> getALL() {
		// TODO Auto-generated method stub
		return null;
	}

}
