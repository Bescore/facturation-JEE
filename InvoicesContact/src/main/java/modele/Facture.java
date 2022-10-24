package modele;

import java.util.Date;

public class Facture {
	private int id_facture;
	private String identifiant;
	private float somme;
	private float nbr_totale_heure;
	private int payee;
	private int isActive_facture;
	private Date date;

	public Facture() {

	}

	public Facture(int id_facture, String identifiant, float somme, float nbr_totale_heure, int payee,
			int isActive_facture, Date date) {
		super();
		this.id_facture = id_facture;
		this.identifiant = identifiant;
		this.somme = somme;
		this.nbr_totale_heure = nbr_totale_heure;
		this.payee = payee;
		this.isActive_facture = isActive_facture;
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

	public float getSomme() {
		return somme;
	}

	public void setSomme(float somme) {
		this.somme = somme;
	}

	public float getNbr_totale_heure() {
		return nbr_totale_heure;
	}

	public void setNbr_totale_heure(float nbr_totale_heure) {
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Facture [id_facture=" + id_facture + ", identifiant=" + identifiant + ", somme=" + somme
				+ ", nbr_totale_heure=" + nbr_totale_heure + ", payee=" + payee + ", isActive_facture="
				+ isActive_facture + ", date=" + date + "]";
	}

	

}
