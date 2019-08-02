package generateur.view.entity_parameters;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.SplitPane;

import generateur.view.entity_parameters.middle.EntityParametersMiddlePane;
import generateur.view.entity_parameters.top.EntityParametersTopPane;

public class EntityParametersGlobalPane extends SplitPane {

	public EntityParametersGlobalPane(Skin skin) {
		super(new EntityParametersTopPane(skin), new EntityParametersMiddlePane(skin), true, skin);
		setName("entity_pane");
		
	}

}
