package generateur.controller.button.entity_parameters;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

/**
 * Bouton d'aide.
 * 
 * @author Julien B.
 */

public class HelpButton extends TextButton {

	public HelpButton(Skin skin) {
		super("?", skin);
		setName("help");
		
		//TODO Gérer l'aide
	}

}
