package generateur.view.entity_parameters.top;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.SplitPane;
import com.badlogic.gdx.utils.Align;

/**
 * Conteneur des informations supérieures de l'interface des entités.
 * Contient le titre et la barre des boutons.
 * 
 * @author Julien B.
 */

public class EntityParametersTopPane extends SplitPane {

	public EntityParametersTopPane(Skin skin) {
		super(null, new EntityParametersButtonBar(skin), true, skin);
		setName("entity_top_pane");
		
		//Titre
		Label title = new Label("Paramètres d'entité", skin);
		title.setName("entity_title");
		title.setAlignment(Align.center);
		this.setFirstWidget(title);
	}
}
