package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import modele.Clients;
import modele.ConnectionBDD;
import modele.Mission;
import modele.Type;

public class MissionDao implements Interface <Mission> {
	Connection connect = new ConnectionBDD().getConnection();

	@Override
	public boolean Create(Mission object) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement sql = connect.prepareStatement("INSERT INTO mission (client,type,tarif) VALUES(?,?,?)");
			
			sql.setInt(1, object.getClient().getId_personne());
			sql.setInt(2, object.getType().getId_type());
			sql.setFloat(3, object.getTarif());
			
			
			sql.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return false;
	}

	@Override
	public ArrayList<Mission> Read() {
		// TODO Auto-generated method stub
		Connection connect = new ConnectionBDD().getConnection();
		ArrayList<Mission> missionTab = new ArrayList<Mission>();
		try {

			PreparedStatement sql = connect.prepareStatement("SELECT * FROM mission AS m INNER JOIN type AS t INNER JOIN client AS c ON m.type=t.id_type AND m.client= c.id_client");
			ResultSet rs = sql.executeQuery();
			
			while(rs.next()) {
				
				//creer client
				Clients newClient=new Clients();
				
				newClient.setNom(rs.getString("nom"));
				newClient.setPrenom(rs.getString("prenom"));
				
				//creer un type
				Type newType=new Type();
				
				newType.setId_type(rs.getInt("id_type"));
				newType.setType_mission(rs.getString("type_mission"));
				
				//creer une mission
				Mission newMission=new Mission();
				
				newMission.setId_mission(rs.getInt("id_mission"));
				newMission.setType(newType);
				newMission.setClient(newClient);
				newMission.setTarif(rs.getFloat("tarif"));
				newMission.setEn_cours(rs.getInt("en_cours"));
				
				//ajouter les missions à la collection
				missionTab.add(newMission);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return missionTab;
	}

	@Override
	public boolean Update(Mission object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Delete(Mission object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Mission> Findby(Mission object) {
		// TODO Auto-generated method stub
		return null;
	}

}
