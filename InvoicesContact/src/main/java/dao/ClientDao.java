package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import modele.Clients;
import modele.ConnectionBDD;

public class ClientDao implements Interface<Clients> {
	Connection connect = new ConnectionBDD().getConnection();

	@Override
	public boolean Create(Clients object) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement sql = connect.prepareStatement(
					"INSERT INTO client (nom,prenom,telephone,email,adresse,code_postale) VALUES(?,?,?,?,?,?)");

			sql.setString(1, object.getNom());
			sql.setString(2, object.getPrenom());
			sql.setString(3, object.getTelephone());
			sql.setString(4, object.getEmail());
			sql.setString(5, object.getAdresse());
			sql.setInt(6, object.getCode_postale());

			sql.executeUpdate();
			sql.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return false;
	}

	@Override
	public ArrayList<Clients> Read() {
		// TODO Auto-generated method stub
		ArrayList<Clients> clientsTab = new ArrayList<Clients>();
		try {

			PreparedStatement sql = connect.prepareStatement("SELECT * FROM client");
			ResultSet rs = sql.executeQuery();

			while (rs.next()) {

				// creer un type
				Clients newClients = new Clients();

				newClients.setId_personne(rs.getInt("id_client"));
				newClients.setNom(rs.getString("nom"));
				newClients.setPrenom(rs.getString("prenom"));
				newClients.setTelephone(rs.getString("telephone"));
				newClients.setEmail(rs.getString("email"));
				newClients.setAdresse(rs.getString("adresse"));
				newClients.setCode_postale(rs.getInt("code_postale"));

				clientsTab.add(newClients);
			}
			sql.close();
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return clientsTab;
	}

	@Override
	public boolean Update(Clients object) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement sql = connect.prepareStatement(
					"Update client SET nom=?,prenom=?,telephone=?,email=?,adresse=?,code_postale=? WHERE id_client=?");

			sql.setString(1, object.getNom());
			sql.setString(2, object.getPrenom());
			sql.setString(3, object.getTelephone());
			sql.setString(4, object.getEmail());
			sql.setString(5, object.getAdresse());
			sql.setInt(6, object.getCode_postale());
			sql.setInt(7, object.getId_personne());

			sql.executeUpdate();
			sql.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return false;
	}

	@Override
	public boolean Delete(Clients object) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement sql = connect.prepareStatement("DELETE FROM client WHERE email=?");

			sql.setString(1, object.getEmail());

			sql.executeUpdate();
			sql.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return false;
	}

	@Override
	public ArrayList<Clients> Findby(Clients object) {
		// TODO Auto-generated method stub
		return null;
	}

	public Clients FindbyId(int id) {
		// TODO Auto-generated method stub
		try {

			PreparedStatement sql = connect.prepareStatement("SELECT * FROM client WHERE id_client=?");
			sql.setInt(1, id);

			ResultSet rs = sql.executeQuery();
			if (rs.next()) {

				// creer un type
				Clients newClients = new Clients();

				newClients.setId_personne(rs.getInt("id_client"));
				newClients.setNom(rs.getString("nom"));
				newClients.setPrenom(rs.getString("prenom"));
				newClients.setTelephone(rs.getString("telephone"));
				newClients.setEmail(rs.getString("email"));
				newClients.setAdresse(rs.getString("adresse"));
				newClients.setCode_postale(rs.getInt("code_postale"));

				return newClients;
			}
			sql.close();
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return null;
	}

	public ArrayList<Clients> SearchClient(Clients object) {
		// TODO Auto-generated method stub
		ArrayList<Clients> clientsTab = new ArrayList<Clients>();
		try {
			PreparedStatement sql = connect.prepareStatement(
					"SELECT * FROM client WHERE  nom LIKE ? OR prenom LIKE ? OR email LIKE ? OR adresse LIKE ? OR code_postale LIKE ? OR telephone LIKE ?");
			sql.setString(1, "%" + object.getNom() + "%");
			sql.setString(2, "%" + object.getNom() + "%");
			sql.setString(3, "%" + object.getNom() + "%");
			sql.setString(4, "%" + object.getNom() + "%");
			sql.setString(5, "%" + object.getNom() + "%");
			sql.setString(6, "%" + object.getNom() + "%");
			ResultSet rs = sql.executeQuery();

			while (rs.next()) {

				// creer un type
				Clients newClients = new Clients();

				newClients.setId_personne(rs.getInt("id_client"));
				newClients.setNom(rs.getString("nom"));
				newClients.setPrenom(rs.getString("prenom"));
				newClients.setTelephone(rs.getString("telephone"));
				newClients.setEmail(rs.getString("email"));
				newClients.setAdresse(rs.getString("adresse"));
				newClients.setCode_postale(rs.getInt("code_postale"));

				clientsTab.add(newClients);
			}
			sql.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return clientsTab;
	}
}
