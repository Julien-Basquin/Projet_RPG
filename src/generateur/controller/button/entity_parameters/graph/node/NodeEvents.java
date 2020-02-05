package generateur.controller.button.entity_parameters.graph.node;

import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

import generateur.view.entity_parameters.middle.EntityParametersGraph;

/**
 * Classe des évènements d'un noeud
 * 
 * @author Julien B.
 */

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
					case Buttons.LEFT :		//Sélection d'un noeud
						if (graph.getSelected() != null) {
							graph.getSelected().setChecked(false);
						}
						node.setChecked(true);
						graph.setSelected(node);
						break;
					case Buttons.RIGHT :	//Création d'un lien
						if (graph.getSelected() != null) {
							graph.addLink(graph.getSelected(), node);
						}
						break;
				}
			}

		});
	}
}
