package app.model.enumeration.objet.equipement.arme;

public enum TypeArmeEnum {

	EPEE("Sword"),HACHE("Axe"),MASSE("Masse"),DAGUE("Dague"),LANCE("Lance"),BATON("Staff"),ARC("Bow"),ARBALETE("Crossbow"),BOUCLIER("Shield");
	
	private String nom;
	private TypeArmeEnum(String nom) {
		this.nom=nom;
	}
	public String getNom() {
		return nom;
	}
}
