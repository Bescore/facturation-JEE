package modele;

public class Personne {
	protected int id_personne;
	protected String nom;
	protected String prenom;
	protected String telephone;
	protected String email;
	protected String adresse;
	protected int code_postale;
	protected int isActive_personne;

	public Personne() {
	}

	public Personne(String nom, String prenom, String telephone, String email, String adresse, int code_postale,
			int isActive_personne) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.email = email;
		this.adresse = adresse;
		this.code_postale = code_postale;
		this.isActive_personne = isActive_personne;
	}

	public int getId_personne() {
		return id_personne;
	}

	public void setId_personne(int id_personne) {
		this.id_personne = id_personne;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getCode_postale() {
		return code_postale;
	}

	public void setCode_postale(int code_postale) {
		this.code_postale = code_postale;
	}

	public int getIsActive_personne() {
		return isActive_personne;
	}

	public void setIsActive_personne(int isActive_personne) {
		this.isActive_personne = isActive_personne;
	}

	
	
}
