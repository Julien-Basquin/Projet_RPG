package generateur.controller.button;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import generateur.Launcher;

/**
 * @author Julien B.
 *
 * Bouton permettant d'enregistrer un objet du générateur.
 */

public class SaveButton extends TextButton {

	public SaveButton(Skin skin) {
		super(Launcher.languageManager.getProperty("Global.Save"), skin);
		setName("save");
		
		//TODO Gérer l'enregistrement
	}

}
