package app.model.enumeration.objet.equipement.armure.souscategorie;

public enum SousCategorieAccessoryEnum {

	;
	
	private String nom;
	
	private SousCategorieAccessoryEnum(String nom) {
		this.nom=nom;
	}
	public String getNom() {
		return nom;
	}
}
