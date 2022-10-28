package modele;

import java.util.Date;

public class Facture {
	private int id_facture;
	private String identifiant;
	private String somme;
	private String nbr_totale_heure;
	private int payee;
	private int isActive_facture;
	private Clients client;
	private String date;

	public Facture() {

	}

	public Facture(int id_facture, String identifiant, String somme, String nbr_totale_heure, int payee,
			int isActive_facture, Clients client, String date) {
		super();
		this.id_facture = id_facture;
		this.identifiant = identifiant;
		this.somme = somme;
		this.nbr_totale_heure = nbr_totale_heure;
		this.payee = payee;
		this.isActive_facture = isActive_facture;
		this.client = client;
		this.date = date;
	}

	public int getId_facture() {
		return id_facture;
	}

	public void setId_facture(int id_facture) {
		this.id_facture = id_facture;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getSomme() {
		return somme;
	}

	public void setSomme(String somme) {
		this.somme = somme;
	}

	public String getNbr_totale_heure() {
		return nbr_totale_heure;
	}

	public void setNbr_totale_heure(String nbr_totale_heure) {
		this.nbr_totale_heure = nbr_totale_heure;
	}

	public int getPayee() {
		return payee;
	}

	public void setPayee(int payee) {
		this.payee = payee;
	}

	public int getIsActive_facture() {
		return isActive_facture;
	}

	public void setIsActive_facture(int isActive_facture) {
		this.isActive_facture = isActive_facture;
	}

	public Clients getClient() {
		return client;
	}

	public void setClient(Clients client) {
		this.client = client;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Facture [id_facture=" + id_facture + ", identifiant=" + identifiant + ", somme=" + somme
				+ ", nbr_totale_heure=" + nbr_totale_heure + ", payee=" + payee + ", isActive_facture="
				+ isActive_facture + ", client=" + client + ", date=" + date + "]";
	}

	
	
	
	
}
