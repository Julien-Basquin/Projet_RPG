package generateur.controller.button.entity_parameters;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

/**
 * Bouton d'enregistrement d'un fichier d'entité.
 * 
 * @author Julien B.
 */

public class SaveFileButton extends TextButton {

	public SaveFileButton(Skin skin) {
		super("Enregistrer", skin);
		setName("save_file");
		
		//TODO Gérer l'enregistrement d'un fichier entité
	}

}
