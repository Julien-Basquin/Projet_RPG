package app.model.enumeration.objet.equipement.arme.souscategorie;

public enum SousCategorieArmeEnum {

	LEGER("Light"),LOURD("Heavy");
	
	private String nom;
	
	private SousCategorieArmeEnum(String nom) {
		this.nom=nom;
	}
	
	public String getNom() {
		return nom;
	}
}
