package app.model.enumeration;

/**
 * @author Julien B.
 *
 * Enumération des catégories.
 */

public enum CategorieEnum {
	ARME,
	ARMURE,
	COMPETENCE,
	ENTITE,
	OBJET;
	
	@Override
	public String toString() {
		return this.name();
	}
}
