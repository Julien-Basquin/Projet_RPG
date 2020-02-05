package generateur.controller.button.entity_parameters;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import generateur.Launcher;

/**
 * Bouton permettant de réappliquer une action annulée.
 * 
 * @author Julien B.
 */

public class RedoButton extends TextButton {

	public RedoButton(Skin skin) {
		super(Launcher.languageManager.getProperty("Global.Redo"), skin);
		setName("redo");
		
		//TODO Gérer la réapplication d'actions annulées (implique une pile)
	}

}
