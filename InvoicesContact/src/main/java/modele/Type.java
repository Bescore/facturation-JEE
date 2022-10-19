package modele;

public class Type {
	private int id_type;
	private String type_mission;

	public Type() {

	}

	public Type(int id_type, String type_mission) {
		super();
		this.id_type = id_type;
		this.type_mission = type_mission;
	}

	public int getId_type() {
		return id_type;
	}

	public void setId_type(int id_type) {
		this.id_type = id_type;
	}

	public String getType_mission() {
		return type_mission;
	}

	public void setType_mission(String type_mission) {
		this.type_mission = type_mission;
	}

	@Override
	public String toString() {
		return "Type [id_type=" + id_type + ", type_mission=" + type_mission + "]";
	}

	
}
