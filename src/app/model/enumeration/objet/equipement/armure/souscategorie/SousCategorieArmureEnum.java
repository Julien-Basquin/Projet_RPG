package app.model.enumeration.objet.equipement.armure.souscategorie;

public enum SousCategorieArmureEnum {

	TRES_LEGERE("Very.Light"),LEGERE("Light"),MOYENNE("Average"),LOURDE("Heavy"),TRES_LOURDE("Very.Heavy");
	
	private String nom;
	
	private SousCategorieArmureEnum(String nom) {
		this.nom=nom;
	}
	public String getNom() {
		return nom;
	}
}
