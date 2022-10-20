package modele;

public class Mission {
	private int id_mission;
	private float tarif;
	private int isActive_mission;
	private int en_cours;
	private Clients client;
	private Type type;

	public Mission() {

	}

	public Mission(int id_mission, float tarif, int isActive_mission, int en_cours, Clients client, Type type) {
		super();
		this.id_mission = id_mission;
		this.tarif = tarif;
		this.isActive_mission = isActive_mission;
		this.en_cours = en_cours;
		this.client = client;
		this.type = type;
	}

	public int getId_mission() {
		return id_mission;
	}

	public void setId_mission(int id_mission) {
		this.id_mission = id_mission;
	}

	public float getTarif() {
		return tarif;
	}

	public void setTarif(float tarif) {
		this.tarif = tarif;
	}

	public int getIsActive_mission() {
		return isActive_mission;
	}

	public void setIsActive_mission(int isActive_mission) {
		this.isActive_mission = isActive_mission;
	}

	public int getEn_cours() {
		return en_cours;
	}

	public void setEn_cours(int en_cours) {
		this.en_cours = en_cours;
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

}
