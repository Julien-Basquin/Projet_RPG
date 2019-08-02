package generateur.view.entity_parameters.top;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.SplitPane;
import com.badlogic.gdx.utils.Align;

public class EntityParametersTopPane extends SplitPane {

	public EntityParametersTopPane(Skin skin) {
		super(null, new EntityParametersButtonBar(skin), true, skin);
		setName("entity_top_pane");
		
		//Titre
		Label title = new Label("Paramètres d'entité", skin);
		title.setName("entity_title");
		title.setAlignment(Align.center);
		this.setFirstWidget(title);
		
		//Verrouillage de la barre de séparation (empêche de changer la taille des conteneurs)
		this.setMinSplitAmount(0.5f);
		this.setSplitAmount(0.5f);
		this.setMaxSplitAmount(0.5f);
	}

}
