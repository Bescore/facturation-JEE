package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import modele.ActiviteJournaliere;
import modele.Clients;
import modele.ConnectionBDD;
import modele.Type;

public class ActiviteDao implements Interface<ActiviteJournaliere> {
	

	@Override
	public boolean Create(ActiviteJournaliere object) {
		// TODO Auto-generated method stub
		Connection connect = new ConnectionBDD().getConnection();
		try {
			PreparedStatement sql = connect.prepareStatement("INSERT INTO activite_journaliere (debut,date,client,type,tarif) VALUES(now(),now(),?,?,?)");
			
			sql.setInt(1, object.getClient().getId_personne());
			sql.setInt(2, object.getType().getId_type());
			sql.setFloat(3, object.getTarif());
			
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
	public ArrayList<ActiviteJournaliere> Read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean Update(ActiviteJournaliere object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Delete(ActiviteJournaliere object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<ActiviteJournaliere> Findby(ActiviteJournaliere object) {
		// TODO Auto-generated method stub
		return null ;
	}
	
	public ActiviteJournaliere FindbyaActiviteEnCours() {
		// TODO Auto-generated method stub
		Connection connect = new ConnectionBDD().getConnection();
		try {

			PreparedStatement sql = connect.prepareStatement("SELECT * FROM activite_journaliere INNER JOIN type INNER JOIN client ON activite_journaliere.client=client.id_client AND activite_journaliere.type=type.id_type AND duree_activite=0");
			ResultSet rs = sql.executeQuery();
			
			if(rs.next()) {
				
				//creer client
				Clients newClient= new Clients();
				
				newClient.setNom(rs.getString("nom"));
				newClient.setPrenom(rs.getString("prenom"));
				
				
				//creer un type
				Type newType=new Type();
				
				newType.setId_type(rs.getInt("id_type"));
				newType.setType_mission(rs.getString("type_mission"));
				
				//Creer une activite
				ActiviteJournaliere newActiviteJ=new ActiviteJournaliere();
				
				newActiviteJ.setClient(newClient);
				newActiviteJ.setType(newType);
				newActiviteJ.setTarif(rs.getFloat("tarif"));
				newActiviteJ.setDate(rs.getDate("date"));
				newActiviteJ.setDebut(rs.getString("debut"));
				
				connect.close();
				return newActiviteJ;
			}
			sql.close();
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return null;
	}
	
	public boolean UpdateArreterActivite() {
		// TODO Auto-generated method stub
		Connection connect = new ConnectionBDD().getConnection();
		try {
			PreparedStatement sql = connect.prepareStatement("UPDATE activite_journaliere SET duree_activite=(SELECT TIMEDIFF(now(),debut)),fin=(now()) WHERE  duree_activite=?");
			
			sql.setInt(1, 0);
			
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
	
	public ArrayList<ActiviteJournaliere> RecentesActivites() {
		// TODO Auto-generated method stub
		Connection connect = new ConnectionBDD().getConnection();
		ArrayList<ActiviteJournaliere> ActiviteTab = new ArrayList<ActiviteJournaliere>();
		
		try {
		PreparedStatement sql = connect.prepareStatement("SELECT * FROM activite_journaliere INNER JOIN type INNER JOIN client ON activite_journaliere.client=client.id_client AND activite_journaliere.type=type.id_type AND duree_activite!=0 ORDER BY fin DESC LIMIT 1");
		ResultSet rs = sql.executeQuery();
		
		while(rs.next()) {
			
			//creer client
			Clients newClient= new Clients();
			
			newClient.setNom(rs.getString("nom"));
			newClient.setPrenom(rs.getString("prenom"));
			
			
			//creer un type
			Type newType=new Type();
			
			newType.setId_type(rs.getInt("id_type"));
			newType.setType_mission(rs.getString("type_mission"));
			
			//Creer une activite
			ActiviteJournaliere newActiviteJ=new ActiviteJournaliere();
			
			newActiviteJ.setClient(newClient);
			newActiviteJ.setType(newType);
			newActiviteJ.setTarif(rs.getFloat("tarif"));
			newActiviteJ.setDate(rs.getDate("date"));
			newActiviteJ.setDebut(rs.getString("debut"));
			newActiviteJ.setDuree_activite(rs.getString("duree_activite"));
			
			ActiviteTab.add(newActiviteJ);
		}
		sql.close();
		rs.close();
		connect.close();
	} catch (Exception e) {
		// TODO: handle exception
		e.getMessage();
	}
	return ActiviteTab;
	}
	
	public ArrayList<ActiviteJournaliere> FindbyMoisAnnee(ActiviteJournaliere object,int mois, String annee) {
		// TODO Auto-generated method stub
		Connection connect = new ConnectionBDD().getConnection();
ArrayList<ActiviteJournaliere> ActiviteTab = new ArrayList<ActiviteJournaliere>();
		//trouver les données en fonction du mois et de l'année, utilis dans "mesheures"
		try {
		PreparedStatement sql = connect.prepareStatement("SELECT *,DATE_FORMAT(debut, '%H:%i:%S') as debutformat,DATE_FORMAT(fin, '%H:%i:%S')as finformat FROM activite_journaliere "
				+ "INNER JOIN type "
				+ "INNER JOIN client "
				+ "ON activite_journaliere.client=client.id_client AND activite_journaliere.type=type.id_type"
				+ " AND client.id_client=? AND month(debut)=?"
				+ " AND year(debut)=? "
				+ "AND fin!=0");
		
		sql.setInt(1, object.getClient().getId_personne());
		sql.setInt(2,mois );
		sql.setString(3, annee);
		
		ResultSet rs = sql.executeQuery();
		
		while(rs.next()) {
			
			//creer client
			Clients newClient= new Clients();
			
			newClient.setId_personne(rs.getInt("id_client"));
			newClient.setNom(rs.getString("nom"));
			newClient.setPrenom(rs.getString("prenom"));
			newClient.setEmail(rs.getString("email"));
			newClient.setAdresse(rs.getString("adresse"));
			newClient.setCode_postale(rs.getInt("code_postale"));
			newClient.setTelephone(rs.getString("telephone"));
			
			
			//creer un type
			Type newType=new Type();
			
			newType.setId_type(rs.getInt("id_type"));
			newType.setType_mission(rs.getString("type_mission"));
			
			//Creer une activite
			ActiviteJournaliere newActiviteJ=new ActiviteJournaliere();
			
			newActiviteJ.setClient(newClient);
			newActiviteJ.setType(newType);
			newActiviteJ.setTarif(rs.getFloat("tarif"));
			newActiviteJ.setDate(rs.getDate("date"));
			newActiviteJ.setDebut(rs.getString("debutformat"));
			newActiviteJ.setFin(rs.getString("finformat"));
			newActiviteJ.setDuree_activite(rs.getString("duree_activite"));
			
			ActiviteTab.add(newActiviteJ);
		}
		sql.close();
		rs.close();
		connect.close();
	} catch (Exception e) {
		// TODO: handle exception
		e.getMessage();
	}
	return ActiviteTab;
	}
}
