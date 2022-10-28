package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import modele.Clients;
import modele.ConnectionBDD;
import modele.Facture;
import modele.Type;

public class FactureDao implements Interface<Facture> {
	Connection connect = new ConnectionBDD().getConnection();
	@Override
	public boolean Create(Facture object) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement sql = connect.prepareStatement("INSERT INTO facture (identifiant,somme,nbr_totale_heure,client,date) VALUES(?,?,?,?,now())");

			sql.setString(1, object.getIdentifiant());
			sql.setString(2, object.getSomme());
			sql.setString(3,object.getNbr_totale_heure());
			sql.setInt(4, object.getClient().getId_personne());

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
	public ArrayList<Facture> Read() {
		// TODO Auto-generated method stub
		ArrayList<Facture> factureTab = new ArrayList<Facture>();
		try {

			PreparedStatement sql = connect.prepareStatement("SELECT *, DATE_FORMAT(date, '%d/%m/%Y � %H:%i:%S')as dateformat FROM facture INNER JOIN client ON client.Id_client=facture.client");
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
		return false;
	}

	@Override
	public ArrayList<Facture> Findby(Facture object) {
		// TODO Auto-generated method stub
		return null;
	}

}
