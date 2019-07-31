package generateur.view.global_parameters;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.SplitPane;
import com.badlogic.gdx.utils.Align;

/**
 * @author Julien B.
 *
 * Classe affichant tout la partie des paramètres globaux (titre + cotenu)
 */

public class GlobalParametersPane extends SplitPane {

	public GlobalParametersPane(Skin skin) {
		super(null, new GlobalParametersContents(skin), true, skin);
		setName("global_pane");
		
		//TODO internationalisation
		Label title = new Label("Paramètres globaux", skin);
		title.setName("global_title");
		title.setAlignment(Align.center);
		this.setFirstWidget(title);

		//Verrouillage de la barre de séparation (empêche de changer la taille des conteneurs)
		this.setMinSplitAmount(title.getPrefHeight() / this.getPrefHeight());
		this.setSplitAmount(title.getPrefHeight() / this.getPrefHeight());
		this.setMaxSplitAmount(title.getPrefHeight() / this.getPrefHeight());
	}
	
	public void dispose() {
		((GlobalParametersContents) findActor("global_contents")).dispose();
	}
}
