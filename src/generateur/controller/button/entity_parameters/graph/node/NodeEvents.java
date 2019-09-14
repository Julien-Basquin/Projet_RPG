package generateur.controller.button.entity_parameters.graph.node;

import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import generateur.view.entity_parameters.middle.EntityParametersGraph;

/**
 * Classe des évènements d'un noeud
 * 
 * @author Julien B.
 */

public class NodeEvents {
	
	public NodeEvents(Node node, EntityParametersGraph graph) {
		node.addListener(new ClickListener() {

			@Override
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				super.touchUp(event, x, y, pointer, button);
				switch(button) {
					case Buttons.LEFT :		//Sélection d'un noeud
						if (getTapCount() == 2) {
							System.out.println("lol");
						}
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
