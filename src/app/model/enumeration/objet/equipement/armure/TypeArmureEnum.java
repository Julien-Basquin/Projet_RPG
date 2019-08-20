package app.model.enumeration.objet.equipement.armure;

public enum TypeArmureEnum {

	TETE("Helmet"),CORPS("Chestplate"),MAINS("Glove"),JAMBES("Leggings"),PIEDS("Boots"),ACCESSOIRE("Accesory");
	
	private String nom;
	private TypeArmureEnum(String nom) {
		this.nom=nom;
	}
	public String getNom() {
		return nom;
	}
}
