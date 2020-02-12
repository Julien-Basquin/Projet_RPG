package generateur.view.entity_parameters.middle;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.scenes.scene2d.Group;
import generateur.MainWindow;
import generateur.controller.button.entity_parameters.graph.GraphEvents;
import generateur.controller.button.entity_parameters.graph.Link;
import generateur.controller.button.entity_parameters.graph.node.Node;
import generateur.controller.button.entity_parameters.graph.node.NodeAttribut;
import generateur.controller.button.entity_parameters.graph.node.NodeCompetence;
import generateur.controller.button.entity_parameters.graph.node.NodeEquipement;
import generateur.controller.button.entity_parameters.graph.node.NodeStatistique;
import generateur.controller.draganddrop.entity_parameters.DragAndDropNodeToGraph;
import generateur.model.entity_parameters.Cancelable;
import generateur.model.entity_parameters.EventsEnum;
import generateur.model.entity_parameters.stack.ObjectEvent;
import util.ActorActions;

/**
 * Graphe associé aux entités.
 * 
 * @author Julien B.
 */

public class Graph extends Group implements Cancelable {
	private Map<Integer, Node> nodeList;
	private Map<Integer, Link> linkList;
	private Node selected;
	private boolean isDragged;
	
	private final Logger logger = Logger.getLogger(Graph.class);
	
	public Graph() {
		super();
		setName("graph");

		nodeList = new HashMap<Integer, Node>();
		linkList = new HashMap<Integer, Link>();
		
		addListener(new GraphEvents(this));
		
		Gdx.input.setInputProcessor(MainWindow.inputMultiplexer);
	}
	
	public Graph(Graph graph) {
		super();
		setName("graph");

		nodeList = new HashMap<Integer, Node>();
		for (Entry<Integer, Node> node : graph.getNodeList().entrySet()) {
			switch (node.getValue().getCategory()) {
			case STATISTIQUE:
				addNode(new NodeStatistique(node.getValue()), false);
				break;
			case EQUIPEMENT:
				addNode(new NodeEquipement(node.getValue()), false);
				break;
			case ATTRIBUT:
				addNode(new NodeAttribut(node.getValue()), false);
				break;
			case COMPETENCE:
				addNode(new NodeCompetence(node.getValue()), false);
				break;
			default:
				break;
			}
		}
		
		linkList = new HashMap<Integer, Link>();
		for (Entry<Integer, Link> link : graph.getLinkList().entrySet()) {
			link.getValue().update(this);
			addLink(link.getValue(), false);
		}
		
		addListener(new GraphEvents(this));
		
		Gdx.input.setInputProcessor(MainWindow.inputMultiplexer);
	}
	
	/**
	 * Ajoute un noeud sur le graphe.
	 * 
	 * @param node	Noeud à ajouter
	 */
	public void addNode(Node node, boolean draw) {
		nodeList.put(node.getId(), node);
		new DragAndDropNodeToGraph(node, this);
		node.addEvents(this);
		
		if (draw) {			
			MainWindow.stage.addActor(node);
			logger.debug("Node added at " + Gdx.input.getX() + ":" + (Gdx.graphics.getHeight() - Gdx.input.getY()));
		}

	}
	
	/**
	 * Ajout d'un lien sur le graphe ayant deux noeuds distincts à chaque extrémité.
	 * Le lien est dessiné.
	 * L'historique n'est pas modifié.
	 * 
	 * @param link	Lien à ajouter
	 * 
	 * @return True si l'ajout a réussi, false sinon
	 */
	public boolean addLink(Link link) {
		return addLink(link, false);
	}
	
	/**
	 * Ajout d'un lien sur le graphe ayant deux noeuds distincts à chaque extrémité.
	 * Le lien est dessiné.
	 * 
	 * @param link			Lien à ajouter
	 * @param changeHistory true pour changer l'historique, false sinon
	 * 
	 * @return True si l'ajout a réussi, false sinon
	 */
	public boolean addLink(Link link, boolean changeHistory) {
		if (!link.isEmpty()) {
			if (changeHistory) {
				//Actual state becomes a previous state
				MainWindow.previousStates.push(new ObjectEvent(link, EventsEnum.ADD + "_Link"));
				MainWindow.nextStates.clear();
			}
			
			linkList.put(link.getId(), link);
			logger.debug("Link added at " + Gdx.input.getX() + ":" + (Gdx.graphics.getHeight() - Gdx.input.getY()));
			
			return true;
		}
		
		return false;
	}

	//TODO Transformer en controller
	@Override
	public void act(float delta) {
		super.act(delta);
		
		//Suppression d'un noeud
		if ((Gdx.input.isKeyJustPressed(Keys.DEL) || Gdx.input.isKeyJustPressed(Keys.FORWARD_DEL)) && selected != null) {
			for (Entry<Integer, Link> link : selected.getLinks().entrySet()) {
				link.getValue().remove();
				MainWindow.previousStates.push(new ObjectEvent(link.getValue(), EventsEnum.DELETE + "_Link", ObjectEvent.getGlobalGroupId()));
				linkList.remove(link.getKey());
			}

			selected.setChecked(false);
			nodeList.get(selected.getId()).remove();
			nodeList.remove(selected.getId());

			MainWindow.previousStates.push(new ObjectEvent(selected, EventsEnum.DELETE + "_Node", ObjectEvent.getGlobalGroupId()));
			ObjectEvent.incrGroupId();
			MainWindow.nextStates.clear();
			
			selected = null;
		}
	}

	public Map<Integer, Node> getNodeList() {
		return nodeList;
	}
	
	public void setNodeList(Map<Integer, Node> nodeList) {
		this.nodeList = nodeList;
	}
	
	public Map<Integer, Link> getLinkList() {
		return linkList;
	}
	
	public void setLinkList(Map<Integer, Link> linkList) {
		this.linkList = linkList;
	}

	public Node getSelected() {
		return selected;
	}

	public void setSelected(Node selected) {
		this.selected = selected;
	}

	public boolean isDragged() {
		return isDragged;
	}

	public void setDragged(boolean isDragged) {
		this.isDragged = isDragged;
	}

	/**
	 * Supprime tous les noeuds et tous les liens du graphe
	 */
	public void dispose() {
		for (Entry<Integer, Link> link : linkList.entrySet()) {
			link.getValue().dispose();
		}
		
		for (Entry<Integer, Node> node : nodeList.entrySet()) {
			node.getValue().dispose();
		}
		
		linkList.clear();
		nodeList.clear();
	}

	@Override
	public void undo(EventsEnum event) {
		//Récupération du graphe actuel, différent de this
		Graph graph = (Graph) ActorActions.findActor(MainWindow.stage, "graph");
		ObjectEvent objectEvent = MainWindow.previousStates.pop();
		
		switch(event) {
		case INIT:
			MainWindow.nextStates.push(new ObjectEvent(new Graph(graph), event + "_Graph", objectEvent.getGroupId()));
			for (Entry<Integer, Node> node : nodeList.entrySet()) {
				Node newNode = null;
				switch (node.getValue().getCategory()) {
				case STATISTIQUE:
					newNode = new NodeStatistique(node.getValue());
					break;
				case EQUIPEMENT:
					newNode = new NodeEquipement(node.getValue());
					break;
				case ATTRIBUT:
					newNode = new NodeAttribut(node.getValue());
					break;
				case COMPETENCE:
					newNode = new NodeCompetence(node.getValue());
					break;
				default:
					break;
				}
				
				graph.addNode(newNode, true);
			}
			
			for (Entry<Integer, Link> link : linkList.entrySet()) {
				link.getValue().update(graph);
				graph.addLink(link.getValue(), false);
				MainWindow.stage.addActor(link.getValue());
			}
			break;
		default:
			
			break;
		}
	}

	@Override
	public void redo(EventsEnum event) {
		Graph graph = (Graph) ActorActions.findActor(MainWindow.stage, "graph");
		ObjectEvent objectEvent = MainWindow.nextStates.pop();
		
		switch(event) {
		case INIT:
			MainWindow.previousStates.push(new ObjectEvent(new Graph(graph), event + "_Graph", objectEvent.getGroupId()));
			for (Entry<Integer, Link> link : graph.getLinkList().entrySet()) {
				link.getValue().remove();
			}
			graph.getLinkList().clear();
			
			for (Entry<Integer, Node> node : graph.getNodeList().entrySet()) {
				node.getValue().remove();
			}
			graph.getNodeList().clear();
			break;
		default:
			
			break;
		}
	}
}