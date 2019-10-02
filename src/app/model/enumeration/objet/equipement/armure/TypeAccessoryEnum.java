package app.model.enumeration.objet.equipement.armure;

public enum TypeAccessoryEnum {

	RING("Ring"),
	NECKLACE("Necklace");
	
	private String nom;
	private TypeAccessoryEnum(String nom) {
		this.nom=nom;
	}
	public String getNom() {
		return nom;
	}
}
