package generateur.controller.draganddrop.entity_parameters;

import java.util.Map.Entry;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;

import generateur.Generator;
import generateur.controller.button.entity_parameters.graph.Link;
import generateur.controller.button.entity_parameters.graph.node.Node;
import generateur.model.entity_parameters.EventsEnum;
import generateur.model.entity_parameters.stack.ObjectEvent;
import generateur.view.entity_parameters.middle.Graph;

/**
 * Evènement gérant le déplacement du graphe.
 * 
 * @author Julien B.
 */

public class MoveNodeController extends DragListener {
	private int actualX;
	private int actualY;
	private Graph graph;
	
	public MoveNodeController(Graph graph) {
		this.graph = graph;
	}
	
	@Override
	public void dragStart(InputEvent event, float x, float y, int pointer) {
		actualX = Gdx.input.getX();
		actualY = Gdx.input.getY();
		
		//Désactivation des éléments du graphe
		for (Entry<Integer, Node> node : graph.getNodeList().entrySet()) {
			Generator.previousStates.add(new ObjectEvent(new Node(node.getValue()), EventsEnum.MOVE + "_Node", ObjectEvent.getGlobalGroupId()));
			if (node.getValue().isVisible()) {
				node.getValue().setTouchable(Touchable.disabled);
			}
		}
		for (Entry<Integer, Link> link : graph.getLinkList().entrySet()) {
			link.getValue().setTouchable(Touchable.disabled);
		}
	}
	
	@Override
	public void drag(InputEvent event, float x, float y, int pointer) {
		//Condition empêchant le glissement de l'écran
		if (Math.abs(Gdx.input.getDeltaX()) > 0 || Math.abs(Gdx.input.getDeltaY()) > 0) {
			int newX = Gdx.input.getX();
			int newY = Gdx.input.getY();
			int moveByX = (int) (actualX - newX);
			int moveByY = (int) (actualY - newY);
			
			for (Entry<Integer, Node> node : graph.getNodeList().entrySet()) {
				node.getValue().moveBy(moveByX, -moveByY);

				//Acteur situé sous le noeud
				Actor firstActorEncountered = Generator.stage.hit(node.getValue().getX(), node.getValue().getY(), true);
				
				//Gestion de la visibilité des noeuds
				if (node.getValue().isVisible() && (firstActorEncountered != null) && !firstActorEncountered.equals(graph)) {
					node.getValue().setVisible(false);
				} else if (!node.getValue().isVisible() && (firstActorEncountered != null) && firstActorEncountered.equals(graph)) {
					node.getValue().setVisible(true);
				}
				
				//Gestion de la visibilité des liens
				for (Entry<Integer, Link> link : node.getValue().getLinks().entrySet()) {
					if (!link.getValue().getNode1().isVisible() && !link.getValue().getNode2().isVisible()) {
						link.getValue().setVisible(false);
					} else if (link.getValue().getNode1().isVisible() || link.getValue().getNode2().isVisible()) {
						link.getValue().setVisible(true);
					}
				}
				
				node.getValue().link();
			}
			
			//Réinitialisation de la position
			actualX = newX;
			actualY = newY;
		}
	}

	@Override
	public void dragStop(InputEvent event, float x, float y, int pointer) {
		//Réactivation des éléments du graphe
		for (Entry<Integer, Node> node : graph.getNodeList().entrySet()) {
			
			if (node.getValue().isVisible()) {
				node.getValue().setTouchable(Touchable.enabled);
			}
		}

		for (Entry<Integer, Link> link : graph.getLinkList().entrySet()) {
			link.getValue().setTouchable(Touchable.enabled);
		}
		
		ObjectEvent.incrGroupId();
		Generator.nextStates.clear();
	}
	
}
