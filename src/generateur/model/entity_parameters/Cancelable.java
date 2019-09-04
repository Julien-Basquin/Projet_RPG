package generateur.model.entity_parameters;

/**
 * Interface des éléments pouvant être annulés ou refaits
 * 
 * @author Julien B.
 */

public interface Cancelable {
	/**
	 * Annuler
	 */
	void undo();
	
	/**
	 * Refaire
	 */
	void redo();
}
