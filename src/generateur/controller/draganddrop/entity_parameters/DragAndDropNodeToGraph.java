package generateur.controller.draganddrop.entity_parameters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;

import generateur.Generator;
import generateur.controller.button.entity_parameters.graph.node.Node;
import generateur.controller.button.entity_parameters.graph.node.NodeAttribut;
import generateur.controller.button.entity_parameters.graph.node.NodeCompetence;
import generateur.controller.button.entity_parameters.graph.node.NodeEquipement;
import generateur.controller.button.entity_parameters.graph.node.NodeStatistique;
import generateur.model.entity_parameters.EventsEnum;
import generateur.model.entity_parameters.stack.ObjectEvent;
import generateur.view.entity_parameters.middle.Graph;

/**
 * Implémentation du drag and drop pour déplacer des noeuds sur le graphe des entités.
 * 
 * @author Julien B.
 */

public class DragAndDropNodeToGraph extends DragAndDrop {
	
	public DragAndDropNodeToGraph(Actor source, Actor target) {
		super();
		
		addSource(new Source(source) {

			@Override
			public Payload dragStart(InputEvent event, float x, float y, int pointer) {
				Payload payload = new Payload();
				
				//Déplacement de l'image du noeud sélectionné avec un alpha réduit de moitié
				Image image = ((Node) event.getTarget()).getCategoryImage();
				Color color = image.getColor();
				image.setColor(color.r, color.g, color.b, 0.5f);
				payload.setDragActor(image);
				
				return payload;
			}
			
		});
		
		addTarget(new Target(target) {
			
			@Override
			public void drop(Source source, Payload payload, float x, float y, int pointer) {
				Node node = ((Node) source.getActor());
				switch (node.getCategory()) {
				case STATISTIQUE:
					Generator.previousStates.push(new ObjectEvent(new NodeStatistique(node), EventsEnum.MOVE + "_Node", ObjectEvent.getGlobalGroupId()));
					break;
				case EQUIPEMENT:
					Generator.previousStates.push(new ObjectEvent(new NodeEquipement(node), EventsEnum.MOVE + "_Node", ObjectEvent.getGlobalGroupId()));
					break;
				case ATTRIBUT:
					Generator.previousStates.push(new ObjectEvent(new NodeAttribut(node), EventsEnum.MOVE + "_Node", ObjectEvent.getGlobalGroupId()));
					break;
				case COMPETENCE:
					Generator.previousStates.push(new ObjectEvent(new NodeCompetence(node), EventsEnum.MOVE + "_Node", ObjectEvent.getGlobalGroupId()));
					break;
				default:
					break;
				}
				
				ObjectEvent.incrGroupId();
				Generator.nextStates.clear();

				//Changement des coordonnée du noeud déplacé
				node.setPosition(Gdx.input.getX() - 64, (Gdx.graphics.getHeight() - Gdx.input.getY()));
				
				node.link();
			}
			
			@Override
			public boolean drag(Source source, Payload payload, float x, float y, int pointer) {
				return payload.getDragActor() != null ? true : false;
			}
		});
	}
}
