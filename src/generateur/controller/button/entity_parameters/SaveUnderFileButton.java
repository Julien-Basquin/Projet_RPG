package generateur.controller.button.entity_parameters;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

/**
 * Bouton d'enregistrement d'un fichier d'entité avec choix de cible.
 * 
 * @author Julien B.
 */

public class SaveUnderFileButton extends TextButton {

	public SaveUnderFileButton(Skin skin) {
		super("Enregistrer sous", skin);
		setName("save_under_file");
		
		//TODO Gérer l'enregistrement avec choix de fichier
	}

}
