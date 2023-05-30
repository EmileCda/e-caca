
package fr.doranco.enums;

public enum Profil {

	COSTUMER("Costumer", 0), MANAGER("Admin", 1), STORE_KEEPER("magasinier", 2), WS_BASIC("Client WS basic", 3),
	WS_ADMIN("Client WS admin", 4), OTHER("autre", 5);

	private String name;
	private int id;

	private Profil(String name, int id) {
		this.setName(name);
		this.setId(id);
	}

	public static Profil fromString(String name) {
		for (Profil oneValue : Profil.values()) {
			if (oneValue.getName().equalsIgnoreCase(name)) {
				return oneValue;
			}
		}
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
