package generateur.controller.button.entity_parameters.graph.node;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

import generateur.view.entity_parameters.middle.EntityParametersGraph;

public class NodeEvents {
	
	public NodeEvents(Node node, EntityParametersGraph graph) {
		node.addListener(new InputListener() {

			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				return true;
			}

			@Override
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				switch(button) {
					case Buttons.LEFT :
						if (graph.getSelected() != null) {
							graph.getSelected().setChecked(false);
						}
						node.setChecked(true);
						graph.setSelected(node);
						break;
					case Buttons.RIGHT :
						if (graph.getSelected() != null) {
							graph.addLink(graph.getSelected(), node);
						}
						break;
				}
			}

		});
	}
}
