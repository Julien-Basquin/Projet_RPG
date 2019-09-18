package util;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;

public abstract class ActorActions {
	
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
	
//	public static Actor replaceActor(Stage stage, Actor toReplace, Actor replaceBy) {
//		Actor toReturn = null;
//		
//		if (toReplace != null) {
//			Actor actor = findActor(stage, toReplace.getName());
//			String actorName = actor.getName();
//			Group parent = 
//		}
//		
//		return toReturn;
//	}
}
