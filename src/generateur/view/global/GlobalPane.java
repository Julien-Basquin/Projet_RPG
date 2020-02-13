package generateur.view.global;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.SplitPane;
import com.badlogic.gdx.utils.Align;

/**
 * Classe affichant tout la partie des paramètres globaux (titre + cotenu)
 * 
 * @author Julien B.
 */

public class GlobalPane extends SplitPane {

	public GlobalPane(Skin skin) {
		super(null, new GlobalContentSplitPane(skin), true, skin);
		setName("global_pane");
		
		//TODO internationalisation
		Label title = new Label("Paramètres globaux", skin);
		title.setName("global_title");
		title.setAlignment(Align.center);
		this.setFirstWidget(title);

		//Verrouillage de la barre de séparation (empêche de changer la taille des conteneurs)
		this.setMinSplitAmount(0.05f);
		this.setSplitAmount(0.05f);
		this.setMaxSplitAmount(0.05f);
	}
	
	public void dispose() {
		((GlobalContents) findActor("global_contents")).dispose();
	}
}
