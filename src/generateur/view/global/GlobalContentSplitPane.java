package generateur.view.global;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.SplitPane;

public class GlobalContentSplitPane extends SplitPane {

	public GlobalContentSplitPane(Skin skin) {
		super(new GlobalContents(skin), new GlobalButtonGroup(skin), true, skin);
		
		//Verrouillage de la barre de séparation (empêche de changer la taille des conteneurs)
		this.setMinSplitAmount(0.95f);
		this.setSplitAmount(0.95f);
		this.setMaxSplitAmount(0.95f);
	}

}
