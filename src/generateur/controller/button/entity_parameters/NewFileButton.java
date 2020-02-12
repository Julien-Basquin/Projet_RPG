package generateur.controller.button.entity_parameters;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import generateur.MainWindow;
import generateur.Launcher;
import generateur.view.dialog.entity_parameters.graph.ResetGraphDialog;

/**
 * Bouton de création d'un nouveau fichier d'entité.
 * 
 * @author Julien B.
 */

public class NewFileButton extends TextButton {

	public NewFileButton(Skin skin) {
		super(Launcher.languageManager.getProperty("Global.New"), skin);
		setName("new_file");
		
		addListener(new ClickListener() {

			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);
				
				MainWindow.stage.addActor(new ResetGraphDialog(skin));
			}
			
		});
	}

}
