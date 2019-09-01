package generateur.controller.draganddrop.entity_parameters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;

import generateur.Generator;
import generateur.controller.button.entity_parameters.graph.Link;
import generateur.controller.button.entity_parameters.graph.node.Node;
import generateur.view.entity_parameters.middle.EntityParametersGraph;

public class MoveNodeController extends DragListener {
	private int actualX;
	private int actualY;
	private EntityParametersGraph graph;
	
	public MoveNodeController(EntityParametersGraph graph) {
		this.graph = graph;
	}
	
	@Override
	public void dragStart(InputEvent event, float x, float y, int pointer) {
		actualX = Gdx.input.getX();
		actualY = Gdx.input.getY();
		
		for (Node node : graph.getNodeList()) {
			if (node.isVisible()) {
				node.setTouchable(Touchable.disabled);
			}
		}
		
		for (Link link : graph.getLinkList()) {
			link.setTouchable(Touchable.disabled);
		}
	}
	
	@Override
	public void drag(InputEvent event, float x, float y, int pointer) {
		//Condition empêchant le glissement
		if (Math.abs(Gdx.input.getDeltaX()) > 0 || Math.abs(Gdx.input.getDeltaY()) > 0) {
			int newX = Gdx.input.getX();
			int newY = Gdx.input.getY();
			int moveByX = (int) (actualX - newX);
			int moveByY = (int) (actualY - newY);
			
			for (Node node : graph.getNodeList()) {
				node.moveBy(moveByX, -moveByY);

				//Acteur situé sous le noeud
				Actor firstActorEncountered = Generator.stage.hit(node.getX(), node.getY(), true);
				
				//Gestion de la visibilité des noeuds
				if (node.isVisible() && (firstActorEncountered != null) && !firstActorEncountered.equals(graph)) {
					node.setVisible(false);
				} else if (!node.isVisible() && (firstActorEncountered != null) && firstActorEncountered.equals(graph)) {
					node.setVisible(true);
				}
				
				//Gestion de la visibilité des liens
				for (Link link : node.getLinks()) {
					if (!link.getNode1().isVisible() && !link.getNode2().isVisible()) {
						link.setVisible(false);
					} else if (link.getNode1().isVisible() || link.getNode2().isVisible()) {
						link.setVisible(true);
					}
				}
				
				node.drawLink();
			}
			
			//Réinitialisation de la position
			actualX = newX;
			actualY = newY;
		}
	}

	@Override
	public void dragStop(InputEvent event, float x, float y, int pointer) {
		for (Node node : graph.getNodeList()) {
			if (node.isVisible()) {
				node.setTouchable(Touchable.enabled);
			}
		}
		
		for (Link link : graph.getLinkList()) {
			link.setTouchable(Touchable.enabled);
		}
	}
	
}
