package app.model.enumeration;

/**
 * @author Julien B.
 *
 * Enumération des catégories.
 */

public enum CategorieEnum {
	ARME("Weapon"),
	ARMURE("Armor"),
	ACCESSORY("Accessoryd"),
	COMPETENCE("Ability"),
	ENTITE("Entity"),
	OBJET("Object");
	
	private String nom;
	
	private CategorieEnum(String nom) {
		this.nom=nom;
	}
	public String getNom() {
		return nom;
	}
}
