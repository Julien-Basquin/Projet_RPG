package generateur.view.global;

import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import generateur.controller.button.global_parameters.CloseButton;
import generateur.controller.button.global_parameters.InitButton;
import generateur.controller.button.global_parameters.SaveButton;

public class GlobalButtonGroup extends HorizontalGroup {
	public GlobalButtonGroup(Skin skin) {
		//Boutons de fermeture, de réinitialisation et d'enregistrement
		addActor(new CloseButton(skin));
		addActor(new InitButton(skin));
		addActor(new SaveButton(skin));
		grow();
		center();
	}
}
