package generateur.controller.button.global_parameters;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import generateur.Generator;
import generateur.controller.dialog.CloseDialog;

/**
 * Bouton servant à fermer le générateur.
 * 
 * @author Julien B.
 */

public class CloseButton extends TextButton {

	public CloseButton(Skin skin) {
		super("Fermer", skin);
		setName("close");
		
		//Ajout d'une fenêtre de dialogue en cliquant sur le bouton
		addListener(new ClickListener() {

			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);
				
				Generator.stage.addActor(new CloseDialog(skin));
			}
			
		});
	}
}
