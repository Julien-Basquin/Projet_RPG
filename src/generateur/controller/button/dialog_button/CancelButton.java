package generateur.controller.button.dialog_button;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import generateur.Launcher;

/**
 * Bouton d'annulation des fenêtres de dialogue.
 * Ferme la fenêtre de dialogue.
 * 
 * @author Julien B.
 */

public class CancelButton extends TextButton {

	public CancelButton(Skin skin) {
		super(Launcher.languageManager.getProperty("Global.Cancel"), skin);
		setName("cancel");
		
		addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);
				
				remove();
			}
		});
	}

}
