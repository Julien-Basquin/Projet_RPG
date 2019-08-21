package generateur.controller.button.entity_parameters;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

/**
 * Bouton d'annulation des actions effectuées.
 * 
 * @author Julien B.
 */

public class UndoButton extends TextButton {

	public UndoButton(Skin skin) {
		super("Annuler", skin);
		setName("undo");
		
		//TODO Gérer l'annulation des actions (implique une pile)
	}

}
