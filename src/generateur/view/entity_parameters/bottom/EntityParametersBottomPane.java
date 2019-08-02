package generateur.view.entity_parameters.bottom;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.SplitPane;

import generateur.view.entity_parameters.middle.EntityParametersGraph;

public class EntityParametersBottomPane extends SplitPane {

	public EntityParametersBottomPane(Skin skin) {
		super(new EntityParametersGraph(skin), new EntityParametersStats(skin), true, skin);
		setName("entity_bottom_pane");
	}

}
