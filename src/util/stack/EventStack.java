package util.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.badlogic.gdx.utils.Disposable;

/**
 * Pile des évènements du graphe
 * 
 * @author Julien B.
 */

public class EventStack extends Stack<ObjectEvent> {
	private static final long serialVersionUID = 8523362993164036053L;

	@Override
	public void clear() {
		//Appel à la méthode dispose si disponible
		for (ObjectEvent objectEvent : this) {
			if (Disposable.class.isAssignableFrom(objectEvent.getObject().getClass())) {
				((Disposable) objectEvent.getObject()).dispose();
			}
		}

		super.clear();
	}

	/**
	 * Retourne une liste des ObjectEvent de même groupe
	 * 
	 * @param id	Identifiant du groupe
	 * 
	 * @return	Liste des ObjectEvent de même groupe
	 */
	public List<ObjectEvent> searchByGroup(int id) {
		List<ObjectEvent> list = new ArrayList<ObjectEvent>();
		
		for (ObjectEvent obj : this) {
			if (obj.getGroupId() == id) {
				list.add(obj);
			}
		}
		
		return list;
	}
}
