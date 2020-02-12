package generateur.controller.button.entity_parameters.graph;

import java.util.Map.Entry;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;

import generateur.MainWindow;
import generateur.controller.button.entity_parameters.graph.node.Node;
import generateur.controller.button.entity_parameters.graph.node.NodeAttribut;
import generateur.controller.button.entity_parameters.graph.node.NodeCompetence;
import generateur.controller.button.entity_parameters.graph.node.NodeEquipement;
import generateur.controller.button.entity_parameters.graph.node.NodeStatistique;
import generateur.model.entity_parameters.EventsEnum;
import generateur.model.entity_parameters.stack.ObjectEvent;
import generateur.view.entity_parameters.middle.Graph;

/**
 * Evènement gérant le déplacement du graphe.
 * 
 * @author Julien B.
 */

public class GraphEvents extends DragListener {
	private int actualX;
	private int actualY;
	private Graph graph;
	
	public GraphEvents(Graph graph) {
		this.graph = graph;
	}
	
	@Override
	public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
		super.touchUp(event, x, y, pointer, button);
		
		if (graph.getSelected() != null && !graph.isDragged()) {
			graph.getSelected().setChecked(false);
			graph.setSelected(null);
		}
		
		graph.setDragged(false);
	}

	@Override
	public void dragStart(InputEvent event, float x, float y, int pointer) {
		actualX = Gdx.input.getX();
		actualY = Gdx.input.getY();
		
		graph.setDragged(true);
		
		//Désactivation des éléments du graphe
		for (Entry<Integer, Node> node : graph.getNodeList().entrySet()) {
			switch (node.getValue().getCategory()) {
			case STATISTIQUE:
				MainWindow.previousStates.add(new ObjectEvent(new NodeStatistique(node.getValue()), EventsEnum.MOVE + "_Node", ObjectEvent.getGlobalGroupId()));
				break;

			case EQUIPEMENT:
				MainWindow.previousStates.add(new ObjectEvent(new NodeEquipement(node.getValue()), EventsEnum.MOVE + "_Node", ObjectEvent.getGlobalGroupId()));
				break;
				
			case ATTRIBUT:
				MainWindow.previousStates.add(new ObjectEvent(new NodeAttribut(node.getValue()), EventsEnum.MOVE + "_Node", ObjectEvent.getGlobalGroupId()));
				break;
				
			case COMPETENCE:
				MainWindow.previousStates.add(new ObjectEvent(new NodeCompetence(node.getValue()), EventsEnum.MOVE + "_Node", ObjectEvent.getGlobalGroupId()));
				break;
				
			default:
				break;
			}
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
				Actor firstActorEncountered = MainWindow.stage.hit(node.getValue().getX(), node.getValue().getY(), true);
				
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
		MainWindow.nextStates.clear();
	}
	
}
