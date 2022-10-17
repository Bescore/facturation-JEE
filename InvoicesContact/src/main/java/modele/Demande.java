package modele;

public class Demande {
	private int id_demande;
	private Type type;
	private String date;
	private String heure;
	private String duree;
	private Client client;

	public Demande() {

	}

	public Demande(int id_demande, Type type, String date, String heure, String duree, Client client) {
		super();
		this.id_demande = id_demande;
		this.type = type;
		this.date = date;
		this.heure = heure;
		this.duree = duree;
		this.client = client;
	}

	public int getId_demande() {
		return id_demande;
	}

	public void setId_demande(int id_demande) {
		this.id_demande = id_demande;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHeure() {
		return heure;
	}

	public void setHeure(String heure) {
		this.heure = heure;
	}

	public String getDuree() {
		return duree;
	}

	public void setDuree(String duree) {
		this.duree = duree;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
