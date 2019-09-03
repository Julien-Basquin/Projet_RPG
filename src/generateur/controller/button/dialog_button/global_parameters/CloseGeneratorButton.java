package generateur.controller.button.dialog_button.global_parameters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import generateur.Launcher;

/**
 * Bouton de fermeture du générateur
 * 
 * @author Julien B.
 */

public class CloseGeneratorButton extends TextButton {

	public CloseGeneratorButton( Skin skin) {
		super(Launcher.languageManager.getProperty("Global.Confirm"), skin);
		setName("confirm");
		
		addListener(new ClickListener() {

			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);

				Gdx.app.exit();
			}
			
		});
	}

}
