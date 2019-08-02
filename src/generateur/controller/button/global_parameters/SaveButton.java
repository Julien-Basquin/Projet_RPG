package generateur.controller.button.global_parameters;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

/**
 * @author Julien B.
 *
 * Bouton permettant d'enregistrer un objet du générateur.
 */

public class SaveButton extends TextButton {

	public SaveButton(Skin skin) {
		super("Enregistrer", skin);
		setName("save");
		
		//TODO Gérer l'enregistrement
	}

}
