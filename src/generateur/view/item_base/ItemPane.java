package generateur.view.item_base;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.SplitPane;
import com.badlogic.gdx.utils.Align;

import generateur.Launcher;

public class ItemPane extends SplitPane {

	public ItemPane(Skin skin) {
		super(null, new ItemContent(skin), true, skin);
		setName("object_top_splitpane");
		
		Label objectParametersLabel = new Label(Launcher.languageManager.getProperty("Object.Settings"), skin);
		objectParametersLabel.setName("object_parameters_label");
		objectParametersLabel.setAlignment(Align.center);
		setFirstWidget(objectParametersLabel);
		
		//Verrouillage de la barre de séparation (empêche de changer la taille des conteneurs)
		this.setMinSplitAmount(0.05f);
		this.setSplitAmount(0.05f);
		this.setMaxSplitAmount(0.05f);
	}
}
