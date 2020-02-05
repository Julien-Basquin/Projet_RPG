package generateur.controller.draganddrop.entity_parameters;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
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
import generateur.model.entity_parameters.NodeCategorieEnum;
import generateur.model.entity_parameters.stack.ObjectEvent;
import generateur.view.entity_parameters.middle.Graph;

/**
 * Implémentation du drag and drop pour les noeuds du graphe des entités.
 * Les noeuds sont amenés de la source vers la cible.
 * 
 * @author Julien B.
 */

public class DragAndDropNodeListToGraph extends DragAndDrop {
	private String path;
	private NodeCategorieEnum category;

	public DragAndDropNodeListToGraph(Actor source, Actor target) {
		super();

		addSource(new Source(source) {

			@Override
			public Payload dragStart(InputEvent event, float x, float y, int pointer) {
				Payload payload = new Payload();

				Pattern pattern = Pattern.compile("^([a-z]+)_?[a-z_]*");
				Matcher match = pattern.matcher(event.getTarget().getParent().getName());

				if (match.find()) {
					path = "ressources/generateur/node/";

					switch(match.group(1)) {
					case "stat":
						path += "green";
						category = NodeCategorieEnum.STATISTIQUE;
						break;
					case "skill":
						path += "red";
						category = NodeCategorieEnum.COMPETENCE;
						break;
					case "equipment":
						path += "blue";
						category = NodeCategorieEnum.EQUIPEMENT;
						break;
					case "attribute":
						path += "magenta";
						category = NodeCategorieEnum.ATTRIBUT;
						break;
					}

					path += ".png";

					Image image = new Image(new Texture(path));
					image.setSize(64, 64);

					payload.setDragActor(image);
					payload.getDragActor().setPosition(x, y);
				}

				return payload;
			}
		});

		addTarget(new Target(target) {

			@Override
			public void drop(Source source, Payload payload, float x, float y, int pointer) {
				//Création du noeud
				Node node ;
				switch (category) {
				case STATISTIQUE:
					node = new NodeStatistique(category, Gdx.input.getX() - 64, (Gdx.graphics.getHeight() - Gdx.input.getY()));
					//Ajout du noeud sur le graphe
					((Graph) target).addNode(node, true);

					//Enregistrement de l'état
					Generator.previousStates.push(new ObjectEvent(new NodeStatistique(node), EventsEnum.ADD + "_Node"));
					Generator.nextStates.clear();
					break;
				case EQUIPEMENT:
					node = new NodeStatistique(category, Gdx.input.getX() - 64, (Gdx.graphics.getHeight() - Gdx.input.getY()));
					//Ajout du noeud sur le graphe
					((Graph) target).addNode(node, true);

					//Enregistrement de l'état
					Generator.previousStates.push(new ObjectEvent(new NodeEquipement(node), EventsEnum.ADD + "_Node"));
					Generator.nextStates.clear();
					break;
				case ATTRIBUT:
					node = new NodeStatistique(category, Gdx.input.getX() - 64, (Gdx.graphics.getHeight() - Gdx.input.getY()));
					//Ajout du noeud sur le graphe
					((Graph) target).addNode(node, true);

					//Enregistrement de l'état
					Generator.previousStates.push(new ObjectEvent(new NodeAttribut(node), EventsEnum.ADD + "_Node"));
					Generator.nextStates.clear();
					break;
				case COMPETENCE:
					node = new NodeStatistique(category, Gdx.input.getX() - 64, (Gdx.graphics.getHeight() - Gdx.input.getY()));
					//Ajout du noeud sur le graphe
					((Graph) target).addNode(node, true);

					//Enregistrement de l'état
					Generator.previousStates.push(new ObjectEvent(new NodeCompetence(node), EventsEnum.ADD + "_Node"));
					Generator.nextStates.clear();
					break;
				default:
					break;
				}
			}

			@Override
			public boolean drag(Source source, Payload payload, float x, float y, int pointer) {
				return payload.getDragActor() != null ? true : false;
			}
		});
	}
}
