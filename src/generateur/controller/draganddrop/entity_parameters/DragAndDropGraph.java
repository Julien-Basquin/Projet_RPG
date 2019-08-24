package generateur.controller.draganddrop.entity_parameters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;

import generateur.controller.button.entity_parameters.graph.Node;

/**
 * Implémentation du drag and drop pour déplacer des noeuds sur le graphe des entités.
 * 
 * @author Julien B.
 */

public class DragAndDropGraph extends DragAndDrop {
	
	public DragAndDropGraph(Actor source, Actor target) {
		super();
		
		addSource(new Source(source) {

			@Override
			public Payload dragStart(InputEvent event, float x, float y, int pointer) {
				Payload payload = new Payload();
				
				//Déplacement de l'image du noeud sélectionné avec un alpha réduit de moitié
				Image image = ((Node) event.getTarget()).getData().getCategoryImage();
				Color color = image.getColor();
				image.setColor(color.r, color.g, color.b, 0.5f);
				payload.setDragActor(image);
				
				return payload;
			}
			
		});
		
		addTarget(new Target(target) {
			
			@Override
			public void drop(Source source, Payload payload, float x, float y, int pointer) {
				//Changement des coordonnée du noeud déplacé
				Node node = ((Node) source.getActor());
//				node.remove();
//				((EntityParametersGraph) target).getLocalStage().addActor(node);
				node.setPosition(Gdx.input.getX() - 64, (Gdx.graphics.getHeight() - Gdx.input.getY()));
			}
			
			@Override
			public boolean drag(Source source, Payload payload, float x, float y, int pointer) {
				return payload.getDragActor() != null ? true : false;
			}
		});
	}
}
