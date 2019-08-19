package app.model.enumeration.element;

public enum ElementEnum {

	NEUTRE("Neutral"),FEU("Fire"),EAU("Water"),AIR("Wind"),TERRE("Earth"),LUMIERE("Light"),TENEBRES("Darkness");
	
	private String nom;
	
	private ElementEnum(String nom) {
		this.nom=nom;
	}
	public String getNom() {
		return nom;
	}
}
