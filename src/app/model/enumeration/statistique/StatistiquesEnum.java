package app.model.enumeration.statistique;

public enum StatistiquesEnum {

	VIE("Life"),MANA("Mana"),FORCE("Strength"),AGILITE("Agility"),VITESSE("Speed"),DEXTERITE("Dexterity"),PRECISION("Accuracy"),CONSTITUTION("Constitution"),RESISTANCE("Resistance"),INTELIGENCE("Inteligence"),CHANCE("Luck");
	
	private String nom;
	private StatistiquesEnum(String nom) {
		this.nom=nom;
	}
	public String getNom() {
		return nom;
	}
}
