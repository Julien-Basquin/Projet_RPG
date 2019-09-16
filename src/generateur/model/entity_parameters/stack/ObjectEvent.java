package generateur.model.entity_parameters.stack;

import generateur.model.entity_parameters.Cancelable;

/**
 * Classe liant un objet annulable avec un évènement.
 * Les ObjectEvent ayant le même identifiant de groupe sont liés par la même action (modifications de groupe).
 * 
 * @author Julien B.
 */

public class ObjectEvent {
	private static int globalGroupId;
	
	/**Identifiant de groupe (ensemble d'actions)*/
	private int groupId;
	/**Objet annulable*/
	private Cancelable object;
	/**Evènement*/
	private String event;
	
	/**
	 * Création d'un nouvel ObjectEvent seul
	 * 
	 * @param object	Objet annulable
	 * @param event		Evènement
	 */
	public ObjectEvent(Cancelable object, String event) {
		groupId = globalGroupId++;
		this.object = object;
		this.event = event;
	}
	
	/**
	 * Création d'un nouvel ObjectEvent avec groupe lié
	 * 
	 * @param object	Objet annulable
	 * @param event		Evènement
	 * @param groupId	identifiant du groupe lié
	 */
	public ObjectEvent(Cancelable object, String event, int groupId) {
		this.groupId = groupId;
		this.object = object;
		this.event = event;
	}
	
	public static void incrGroupId() {
		globalGroupId++;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public static int getGlobalGroupId() {
		return globalGroupId;
	}

	public Cancelable getObject() {
		return object;
	}

	public void setObject(Cancelable object) {
		this.object = object;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}
}
