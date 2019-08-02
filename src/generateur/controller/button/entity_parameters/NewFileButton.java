package generateur.controller.button.entity_parameters;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

/**
 * Bouton de création d'un nouveau fichier d'entité.
 * 
 * @author Julien B.
 */

public class NewFileButton extends TextButton {

	public NewFileButton(Skin skin) {
		super("Nouveau", skin);
		setName("new_file");
		
		//TODO Gérer la réinitialisation du graphe avec confirmation
	}

}
