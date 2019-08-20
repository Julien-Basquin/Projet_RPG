package app.model.enumeration.attaque;

public enum TypeAttaqueEnum {
	
	TRANCHANT("Sharpness"),CONTONDANT("Blunt"),PERCANT("Piercing"),MAGIE("Magic");
	
	private String name;
	
	private TypeAttaqueEnum(String name) {
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
}
