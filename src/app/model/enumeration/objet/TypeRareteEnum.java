package app.model.enumeration.objet;

public enum TypeRareteEnum {

	COMMON("Common"),UNCOMMON("Uncommon"),RARE("Rare"),LEGENDARY("Legendary"),UNIQUE("Unique");
	private String nom;
	private TypeRareteEnum(String nom) {
		this.nom=nom;
	}
	public String getNom() {
		return nom;
	}
}
