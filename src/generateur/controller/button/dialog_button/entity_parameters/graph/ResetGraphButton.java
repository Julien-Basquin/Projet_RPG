package generateur.controller.button.dialog_button.entity_parameters.graph;

import org.apache.log4j.Logger;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import generateur.Generator;
import generateur.Launcher;
import generateur.view.entity_parameters.middle.EntityParametersGraph;

/**
 * Bouton de réinitialisation du graphe des entités
 * 
 * @author Julien B.
 */

public class ResetGraphButton extends TextButton {
	private Logger logger = Logger.getLogger(ResetGraphButton.class);

	public ResetGraphButton(Skin skin) {
		super(Launcher.languageManager.getProperty("Global.Confirm"), skin);
		setName("confirm");
		
		addListener(new ClickListener() {

			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);

				logger.debug("Cleaning entity graph...");
				((EntityParametersGraph) Generator.findActor("graph")).dispose();
				logger.debug("...cleaning completed");
				
				remove();
			}
			
		});
	}
}
