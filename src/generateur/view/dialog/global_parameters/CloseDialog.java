package generateur.view.dialog.global_parameters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import generateur.Launcher;
import generateur.controller.button.dialog_button.CancelButton;
import generateur.controller.button.dialog_button.global_parameters.CloseGeneratorButton;

/**
 * Fenêtre de confirmation de la fermeture du générateur
 * 
 * @author Julien B.
 */

public class CloseDialog extends Dialog {

	public CloseDialog(Skin skin) {
		super(Launcher.languageManager.getProperty("Global.Confirm"), skin);
		//Récupération de la résolution active
		int width = Gdx.graphics.getWidth();
		int height = Gdx.graphics.getHeight();

		//Création d'une boîte de dialogue
		setSize(width / 2, height / 2);
		setPosition(width / 2 - getWidth() / 2, height / 2 - getHeight() / 2);
		text(Launcher.languageManager.getProperty("Global.Confirm.Leave")
				+ Launcher.languageManager.getProperty("Global.Warning.Unsaved"));
		
		//Ajout des boutons à la fenêtre de dialogue
		button(new CancelButton(skin));
		button(new CloseGeneratorButton(skin));
	}

}
