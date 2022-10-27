package modele;

import java.util.Date;

public class ActiviteJournaliere {
	private int id_activite_journaliere;
	private String debut;
	private String fin;
	private Date date;
	private String duree_activite;
	private int isActive_activite;
	private Clients client;
	private Type type;
	private float tarif;
	

	public ActiviteJournaliere() {

	}


	public int getId_activite_journaliere() {
		return id_activite_journaliere;
	}


	public void setId_activite_journaliere(int id_activite_journaliere) {
		this.id_activite_journaliere = id_activite_journaliere;
	}


	public String getDebut() {
		return debut;
	}


	public void setDebut(String debut) {
		this.debut = debut;
	}


	public String getFin() {
		return fin;
	}


	public void setFin(String fin) {
		this.fin = fin;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getDuree_activite() {
		return duree_activite;
	}


	public void setDuree_activite(String duree_activite) {
		this.duree_activite = duree_activite;
	}


	public int getIsActive_activite() {
		return isActive_activite;
	}


	public void setIsActive_activite(int isActive_activite) {
		this.isActive_activite = isActive_activite;
	}


	public Clients getClient() {
		return client;
	}


	public void setClient(Clients client) {
		this.client = client;
	}


	public Type getType() {
		return type;
	}


	public void setType(Type type) {
		this.type = type;
	}


	public float getTarif() {
		return tarif;
	}


	public void setTarif(float tarif) {
		this.tarif = tarif;
	}


	@Override
	public String toString() {
		return "ActiviteJournaliere [id_activite_journaliere=" + id_activite_journaliere + ", debut=" + debut + ", fin="
				+ fin + ", date=" + date + ", duree_activite=" + duree_activite + ", isActive_activite="
				+ isActive_activite + ", client=" + client + ", type=" + type + ", tarif=" + tarif + "]";
	}


	
	
}
