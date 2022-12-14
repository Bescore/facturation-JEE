package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import modele.Clients;
import modele.ConnectionBDD;
import modele.Demande;
import modele.Type;

public class DemandeDao implements Interface <Demande> {
	
	@Override
	public boolean Create(Demande object) {
		// TODO Auto-generated method stub
		Connection connect = new ConnectionBDD().getConnection();
		try {
			PreparedStatement sql = connect.prepareStatement("INSERT INTO demande (client,type,date,heure,duree) VALUES(?,?,?,?,?)");
			
			sql.setInt(1, object.getClient().getId_personne());
			sql.setInt(2, object.getType().getId_type());
			sql.setString(3, object.getDate());
			sql.setString(4, object.getHeure());
			sql.setString(5, object.getDuree());
			
			sql.executeUpdate();
			sql.close();
			connect.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return false;
	}

	@Override
	public ArrayList<Demande> Read() {
		// TODO Auto-generated method stub
		Connection connect = new ConnectionBDD().getConnection();
		ArrayList<Demande> demandeTab = new ArrayList<Demande>();
		try {

			PreparedStatement sql = connect.prepareStatement("SELECT * FROM demande INNER JOIN client INNER JOIN type ON demande.client=client.id_client AND demande.type=type.id_type");
			ResultSet rs = sql.executeQuery();
			
			while(rs.next()) {
				
				//creer client
				Clients newClient=new Clients();
				
				newClient.setId_personne(rs.getInt("id_client"));
				newClient.setNom(rs.getString("nom"));
				newClient.setPrenom(rs.getString("prenom"));
				
				//Creer Type
				Type newType=new Type();
				
				newType.setId_type(rs.getInt("id_type"));
				newType.setType_mission(rs.getString("type_mission"));
				
				
				//creer un type
				Demande newDemande=new Demande();
				
				newDemande.setId_demande(rs.getInt("id_demande"));
				newDemande.setClient(newClient);
				newDemande.setType(newType);
				newDemande.setDate(rs.getString("date"));
				newDemande.setHeure(rs.getString("heure"));
				newDemande.setDuree(rs.getString("duree"));
				
				demandeTab.add(newDemande);
				
			}
			sql.close();
			rs.close();
			connect.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return demandeTab;
	}

	@Override
	public boolean Update(Demande object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Delete(Demande object) {
		// TODO Auto-generated method stub
		Connection connect = new ConnectionBDD().getConnection();
		try {
			PreparedStatement sql = connect.prepareStatement("DELETE FROM demande WHERE id_demande=?");
			
			sql.setInt(1, object.getId_demande());
			
			sql.executeUpdate();
			sql.close();
			connect.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return false;
	}

	@Override
	public ArrayList<Demande> Findby(Demande object) {
		// TODO Auto-generated method stub
		return null;
	}

}
