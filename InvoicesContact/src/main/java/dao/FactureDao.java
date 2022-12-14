package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import modele.Clients;
import modele.ConnectionBDD;
import modele.Facture;

public class FactureDao implements Interface<Facture> {
	
	@Override
	public boolean Create(Facture object) {
		// TODO Auto-generated method stub
		Connection connect = new ConnectionBDD().getConnection();
		try {
			PreparedStatement sql = connect.prepareStatement("INSERT INTO facture (identifiant,somme,nbr_totale_heure,client,date) VALUES(?,?,?,?,now())");

			sql.setString(1, object.getIdentifiant());
			sql.setString(2, object.getSomme());
			sql.setString(3,object.getNbr_totale_heure());
			sql.setInt(4, object.getClient().getId_personne());

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
	public ArrayList<Facture> Read() {
		// TODO Auto-generated method stub
		Connection connect = new ConnectionBDD().getConnection();
		ArrayList<Facture> factureTab = new ArrayList<Facture>();
		try {

			PreparedStatement sql = connect.prepareStatement("SELECT *, DATE_FORMAT(date, '%d/%m/%Y à %H:%i:%S')as dateformat FROM facture LEFT JOIN client ON client.Id_client=facture.client");
			ResultSet rs = sql.executeQuery();
			
			while(rs.next()) {
				
				//creer client
				Clients newClient=new Clients();
				
				newClient.setId_personne(rs.getInt("id_client"));
				newClient.setNom(rs.getString("nom"));
				newClient.setPrenom(rs.getString("prenom"));
				
				
				//creer un type
				Facture newFacture=new Facture();
				
				newFacture.setId_facture(rs.getInt("id_facture"));
				newFacture.setIdentifiant(rs.getString("identifiant"));
				newFacture.setSomme(rs.getString("somme"));
				newFacture.setNbr_totale_heure(rs.getString("nbr_totale_heure"));
				newFacture.setClient(newClient);
				newFacture.setPayee(rs.getInt("payee"));
				newFacture.setDate(rs.getString("dateformat"));
				
				factureTab.add(newFacture);
			}
			sql.close();
			rs.close();
			connect.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return factureTab;
	}

	@Override
	public boolean Update(Facture object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Delete(Facture object) {
		// TODO Auto-generated method stub
		Connection connect = new ConnectionBDD().getConnection();
		try {
			PreparedStatement sql = connect.prepareStatement("DELETE FROM facture WHERE id_facture=?");
			
			sql.setInt(1, object.getId_facture());
			
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
	public ArrayList<Facture> Findby(Facture object) {
		// TODO Auto-generated method stub
		Connection connect = new ConnectionBDD().getConnection();
		//FindByIdentifiant
		ArrayList<Facture> factureTab = new ArrayList<Facture>();
		try {

			PreparedStatement sql = connect.prepareStatement("SELECT * FROM facture INNER JOIN client ON client.Id_client=facture.client AND identifiant=? AND payee=?");
			sql.setString(1, object.getIdentifiant());
			sql.setInt(2, 0);
			ResultSet rs = sql.executeQuery();
			
			if(rs.next()) {
				
				//creer client
				Clients newClient=new Clients();
				
				newClient.setId_personne(rs.getInt("id_client"));
				newClient.setNom(rs.getString("nom"));
				newClient.setPrenom(rs.getString("prenom"));
				
				
				//creer un type
				Facture newFacture=new Facture();
				
				newFacture.setId_facture(rs.getInt("id_facture"));
				newFacture.setIdentifiant(rs.getString("identifiant"));
				newFacture.setSomme(rs.getString("somme"));
				newFacture.setNbr_totale_heure(rs.getString("nbr_totale_heure"));
				newFacture.setClient(newClient);
				newFacture.setPayee(rs.getInt("payee"));
				
				factureTab.add(newFacture);
			}
			sql.close();
			rs.close();
			connect.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return factureTab;
	}
	
	
	public int FindbyNombreFactureNonPayee() {
		// TODO Auto-generated method stub
		Connection connect = new ConnectionBDD().getConnection();
		try {

			PreparedStatement sql = connect.prepareStatement("SELECT count(*) as nombreNonPayee FROM facture WHERE payee=?");
			
			sql.setInt(1, 0);
			
			ResultSet rs = sql.executeQuery();
			
			while(rs.next()) {
				
				int nombreNonPayee=rs.getInt("nombreNonPayee");
				
				return nombreNonPayee ;
			}
			sql.close();
			rs.close();
			connect.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return 0;
	}
	public int FindbyNombreFacturePayee() {
		// TODO Auto-generated method stub
		Connection connect = new ConnectionBDD().getConnection();
		try {

			PreparedStatement sql = connect.prepareStatement("SELECT count(*) as nombreNonPayee FROM facture WHERE payee=?");
			
			sql.setInt(1, 1);
			
			ResultSet rs = sql.executeQuery();
			
			while(rs.next()) {
				
				int nombreNonPayee=rs.getInt("nombreNonPayee");
				
				return nombreNonPayee ;
			}
			sql.close();
			rs.close();
			connect.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return 0;
	}
	
	public float FindbySommeTotale() {
		// TODO Auto-generated method stub
		Connection connect = new ConnectionBDD().getConnection();
		try {

			PreparedStatement sql = connect.prepareStatement("SELECT ROUND(sum(somme),2) as sommeTotale FROM facture");
			
			ResultSet rs = sql.executeQuery();
			
			while(rs.next()) {
				
				float sommeTotale=rs.getFloat("sommeTotale");
				
				return sommeTotale ;
			}
			sql.close();
			rs.close();
			connect.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return 0;
	}
	public float FindbySommeTotalePayee() {
		// TODO Auto-generated method stub
		Connection connect = new ConnectionBDD().getConnection();
		try {

			PreparedStatement sql = connect.prepareStatement("SELECT ROUND(sum(somme),2) as sommeTotalePayee FROM facture where payee=?");
			
			sql.setInt(1, 1);
			
			ResultSet rs = sql.executeQuery();
			
			while(rs.next()) {
				
				float sommeTotalePayee=rs.getFloat("sommeTotalePayee");
				
				return sommeTotalePayee;
			}
			sql.close();
			rs.close();
			connect.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return 0;
	}
	
	public float FindbySommeTotaleNonPayee() {
		// TODO Auto-generated method stub
		Connection connect = new ConnectionBDD().getConnection();
		try {

			PreparedStatement sql = connect.prepareStatement("SELECT ROUND(sum(somme),2) as sommeTotaleNonPayee FROM facture where payee=?");
			
			sql.setInt(1, 0);
			
			ResultSet rs = sql.executeQuery();
			
			while(rs.next()) {
				
				float sommeTotaleNonPayee=rs.getFloat("sommeTotaleNonPayee");
				
				return sommeTotaleNonPayee;
			}
			sql.close();
			rs.close();
			connect.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return 0;
	}
	
	public boolean UpdatePaiementClient(Facture object) {
		// TODO Auto-generated method stub
		Connection connect = new ConnectionBDD().getConnection();
		try {
			PreparedStatement sql = connect.prepareStatement("UPDATE facture SET payee=? WHERE identifiant=?");

			sql.setInt(1, 1);
			sql.setString(2, object.getIdentifiant());
			

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
}
