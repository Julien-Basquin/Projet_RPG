package generateur.model.entity_parameters;

/**
 * Interface des éléments pouvant être annulés ou refaits
 * 
 * @author Julien B.
 */

public interface Cancelable {
	/**
	 * Annuler un évènement
	 */
	void undo(EventsEnum event);
	
	/**
	 * Refaire un évènement
	 */
	void redo(EventsEnum event);
}
