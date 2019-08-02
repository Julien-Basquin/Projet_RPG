package generateur.view.entity_parameters.middle;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.SplitPane;

import generateur.view.entity_parameters.bottom.EntityParametersBottomPane;

public class EntityParametersMiddlePane extends SplitPane {

	public EntityParametersMiddlePane(Skin skin) {
		super(new EntityParametersNodeColumn(skin), new EntityParametersBottomPane(skin), false, skin);
		setName("entity_middle_pane");
		
		
	}

}
