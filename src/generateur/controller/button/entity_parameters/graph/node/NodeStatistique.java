package generateur.controller.button.entity_parameters.graph.node;

import java.util.HashMap;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import generateur.Generator;
import generateur.controller.button.entity_parameters.graph.Link;
import generateur.model.entity_parameters.EventsEnum;
import generateur.model.entity_parameters.NodeCategorieEnum;
import generateur.model.entity_parameters.stack.ObjectEvent;
import generateur.view.entity_parameters.middle.Graph;
import util.ActorActions;

public class NodeStatistique extends Node {

	public NodeStatistique(float x, float y) {
		id = globalId++;
		category = NodeCategorieEnum.STATISTIQUE;
		categoryTexture = new Texture(new FileHandle(path + "green.png"));
		categoryImage = new Image(categoryTexture);
		setStyle(new NodeStyle(categoryTexture));
		setSize(64, 64);
		setPosition(x, y);
		links = new HashMap<Integer, Link>();
	}

	public NodeStatistique(NodeCategorieEnum category, float x, float y) {
		id = globalId++;
		this.category = category;
		categoryTexture = new Texture(new FileHandle(path + findColor(category) + ".png"));
		categoryImage = new Image(categoryTexture);
		setStyle(new NodeStyle(categoryTexture));
		setSize(64, 64);
		setPosition(x, y);
		links = new HashMap<Integer, Link>();
	}

	public NodeStatistique(Node node) {

		setId(node.getId());
		setCategory(node.getCategory());
		setCategoryTexture(new Texture(new FileHandle(path + findColor(category) + ".png")));
		setCategoryImage(new Image(categoryTexture));
		setStyle(new NodeStyle(categoryTexture));
		setSize(64, 64);
		setPosition(node.getX(), node.getY());
		setLinks(node.getLinks());
		setCout(node.getCout());
		setDescription(node.getDescription());
		setName(node.getName());
		setUnlock(node.isUnlock());
		//Visibilité du noeud
		setVisible(node.isVisible());
	}

	@Override
	public void redo(EventsEnum event) {
		//Graphe actuel
		Graph graph = (Graph) ActorActions.findActor(Generator.stage, "graph");
		//Récupération de l'évènement suivant
		ObjectEvent objectEvent = Generator.nextStates.pop();
		//Récupération du noeud sur le graphe ayant le même id que this
		Node node = graph.getNodeList().get(id);

		switch(event) {
		case ADD:
			//Ajout de this au graphe
			graph.addNode(this, true);

			Generator.previousStates.push(new ObjectEvent(new NodeStatistique(this), event + "_Node", objectEvent.getGroupId()));
			break;
		case DELETE:
			node.remove();
			graph.getNodeList().remove(id);

			Generator.previousStates.push(new ObjectEvent(new NodeStatistique(this), event + "_Node", objectEvent.getGroupId()));
			break;
		case EDIT:
			//TODO Edition d'un noeud
			break;
		case MOVE:
			Generator.previousStates.push(new ObjectEvent(new NodeStatistique(node), event + "_Node", objectEvent.getGroupId()));

			node.setPosition(getX(), getY());
			node.setVisible(isVisible());

			link();
			break;
		default:

			break;

		}
	}

	@Override
	public void undo(EventsEnum event) {
		//Graphe actuel
		Graph graph = (Graph) ActorActions.findActor(Generator.stage, "graph");
		//Retrait de l'évènement précédent
		ObjectEvent objectEvent = Generator.previousStates.pop();
		//Récupération du noeud sur le graphe ayant le même id que this
		Node node = graph.getNodeList().get(id);

		switch(event) {
		case ADD:	//Utilisation du noeud récupéré car différent de this
			//Retrait du noeud récupéré
			node.remove();
			graph.getNodeList().remove(id);

			Generator.nextStates.push(new ObjectEvent(new NodeStatistique(node), event + "_Node", objectEvent.getGroupId()));
			break;
		case DELETE:	//Utilsiation de this car node n'existe plus
			//Ajout de this au graphe
			graph.addNode(this, true);

			Generator.nextStates.push(new ObjectEvent(new NodeStatistique(this), event + "_Node", objectEvent.getGroupId()));
			break;
		case EDIT:
			//TODO Edition d'un noeud
			break;
		case MOVE:
			Generator.nextStates.push(new ObjectEvent(new NodeStatistique(node), event + "_Node", objectEvent.getGroupId()));

			node.setPosition(getX(), getY());
			node.setVisible(isVisible());

			link();
			break;
		default:

			break;
		}
	}
}
