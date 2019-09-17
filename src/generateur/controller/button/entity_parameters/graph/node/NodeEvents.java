package generateur.controller.button.entity_parameters.graph.node;

import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import generateur.Generator;
import generateur.controller.button.entity_parameters.graph.Link;
import generateur.view.dialog.entity_parameters.graph.NodeModificationDialogue;
import generateur.view.entity_parameters.middle.Graph;

/**
 * Classe des évènements d'un noeud
 * 
 * @author Julien B.
 */

public class NodeEvents {

	public NodeEvents(Node node, Graph graph) {
		
		//Sélection d'un noeud
		node.addListener(new ClickListener() {

			@Override
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				super.touchUp(event, x, y, pointer, button);
				if (getTapCount() == 2) {
							Generator.stage.addActor(new NodeModificationDialogue(Generator.skin,node));
				}
				if (graph.getSelected() != null) {
					graph.getSelected().setChecked(false);
				}
				node.setChecked(true);
				graph.setSelected(node);
			}

		});
		
		//Création d'un lien
		node.addListener(new ClickListener(Buttons.RIGHT) {
			@Override
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				super.touchUp(event, x, y, pointer, button);
				if (graph.getSelected() != null) {
					Link link = new Link(graph.getSelected(), node);
					if (graph.addLink(link, true)) {
						Generator.stage.addActor(link);
						link.setZIndex(0);
					}
				}
			}
		});
	}
}
