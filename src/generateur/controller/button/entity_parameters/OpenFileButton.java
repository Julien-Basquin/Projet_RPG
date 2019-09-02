package generateur.controller.button.entity_parameters;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import generateur.Launcher;

/**
 * Bouton d'ouverture d'un fichier d'entité
 * 
 * @author Julien B.
 */

public class OpenFileButton extends TextButton {

	public OpenFileButton(Skin skin) {
		super(Launcher.languageManager.getProperty("Global.Open"), skin);
		setName("open_file");
		
		//TODO Gérer l'ouverture et le chargement d'un fichier entité
	}
	
}
