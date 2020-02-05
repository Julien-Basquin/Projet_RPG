package util;

import org.apache.log4j.Logger;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;

public abstract class ActorActions {
	private static Logger logger = Logger.getLogger(ActorActions.class);
	
	/**
	 * Parcours la stage donné et retourne l'acteur nommé
	 * 
	 * @param name	Nom de l'acteur à trouver
	 * @param stage	Stage à fouiller
	 * 
	 * @return L'acteur désigné par le nom si trouvé, null sinon
	 */
	public static Actor findActor(Stage stage, String name) {
		Actor actorByName = null;
		int i = 0;
		String actorName = "";
		
		do {
			actorName = stage.getActors().items[i].getName();
			if (actorName != null && actorName.equals(name)) {
				actorByName = stage.getActors().items[i];
			} else {
				try {
					Group group = (Group) stage.getActors().items[i];
					actorByName = group.findActor(name);
				} catch (ClassCastException e) {
					continue;
				}
			}
			
			i++;
		} while (actorByName == null && i < stage.getActors().size);
		
		return actorByName;
	}
	
	/**
	 * Parcours le stage pour remplacer un acteur par un autre
	 * 
	 * @param stage			Stage à parcourir, contient les acteurs
	 * @param toReplace		Acteur à remplacer
	 * @param replaceBy		Acteur remplaçant
	 * @param changeName	True si l'acteur remplaçant doit prendre le nom de l'acteur remplacé, false pour garder les noms
	 * 
	 * @return L'acteur qui a été remplacé en cas de succès, sinon l'acteur remplaçant
	 */
	public static Actor replaceActor(Stage stage, Actor toReplace, Actor replaceBy, boolean changeName) {
		Actor toReturn = replaceBy;
		
		try {			
			if (toReplace != null) {
				Group parent = toReplace.getParent();
				for (int i = 0; i < parent.getChildren().size; i++) {
					if (parent.getChildren().get(i).equals(toReplace)) {
						if (changeName) {
							replaceBy.setName(toReplace.getName());
						}
						parent.removeActor(toReplace);
						parent.addActorAt(i, replaceBy);
						toReturn = toReplace;
					}
				}
			}
		} catch (Exception e) {
			logger.error("Error while swapping " + toReplace + " and " + replaceBy);
		}
		
		return toReturn;
	}
}
