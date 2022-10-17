package modele;

public class ActiviteJournaliere {
	private int id_activite_journaliere;
	private String debut;
	private String fin;
	private String duree_activite;
	private int isActive_activite;
	private Mission mission;

	public ActiviteJournaliere() {

	}

	public ActiviteJournaliere(int id_activite_journaliere, String debut, String fin, String duree_activite,
			int isActive_activite, Mission mission) {
		super();
		this.id_activite_journaliere = id_activite_journaliere;
		this.debut = debut;
		this.fin = fin;
		this.duree_activite = duree_activite;
		this.isActive_activite = isActive_activite;
		this.mission = mission;
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

	public Mission getMission() {
		return mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

}
