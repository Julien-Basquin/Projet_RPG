package generateur.view.entity_parameters.middle;

import java.util.Set;
import java.util.Stack;

import org.apache.log4j.Logger;

import java.util.HashSet;
import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.SplitPane;

import generateur.Generator;
import generateur.controller.button.entity_parameters.graph.Link;
import generateur.controller.button.entity_parameters.graph.node.Node;
import generateur.controller.draganddrop.entity_parameters.DragAndDropNodeToGraph;
import generateur.controller.draganddrop.entity_parameters.MoveNodeController;
import generateur.model.entity_parameters.Cancelable;
import generateur.model.entity_parameters.EventsEnum;
import util.stack.ObjectEvent;

/**
 * Graphe associé aux entités.
 * 
 * @author Julien B.
 */

public class Graph extends Group implements Cancelable {
	private Set<Node> nodeList;
	private Set<Link> linkList;
	private Node selected;
	
//	private static Stack<EntityParametersGraph> previousStates = new Stack<EntityParametersGraph>();
//	private static Stack<EntityParametersGraph> nextStates = new Stack<EntityParametersGraph>();
	
	private final Logger logger = Logger.getLogger(Graph.class);
	
	public Graph() {
		super();
		setName("graph");

		nodeList = new HashSet<Node>();
		linkList = new HashSet<Link>();
		
		Gdx.input.setInputProcessor(Generator.inputMultiplexer);
		
//		//First state
//		if (previousStates.isEmpty()) {
//			previousStates.push(this);
//		}
	}
	
	public Graph(Graph graph) {
		super();
		setName("graph");

		nodeList = new HashSet<Node>();
		for (Node node : graph.getNodeList()) {
			addNode(new Node(node));
		}
		
		linkList = new HashSet<Link>();
		for (Link link : graph.getLinkList()) {
			Link newLink = new Link(findNode(link.getNode1()), findNode(link.getNode2()));
			addLink(newLink, false);
		}
		
		Gdx.input.setInputProcessor(Generator.inputMultiplexer);
		
//		//First state
//		if (previousStates.isEmpty()) {
//			previousStates.push(new EntityParametersGraph(this));
//		}
	}
	
	public void addMoveNodeController() {
		addListener(new MoveNodeController(this));
	}

	/**
	 * Ajoute un noeud sur le graphe sans changer l'historique.
	 * 
	 * @param node	Noeud à ajouter
	 * 
	 * @return	True si l'ajout a réussi, false sinon
	 */
	public boolean addNode(Node node) {
		return addNode(node, false);
	}
	
	/**
	 * Ajoute un noeud sur le graphe.
	 * 
	 * @param node			Noeud à ajouter
	 * @param changeHistory true pour changer l'historique, false sinon
	 * 
	 * @return	True si l'ajout a réussi, false sinon
	 */
	public boolean addNode(Node node, boolean changeHistory) {
//		if (changeHistory) {
//			//Actual state becomes a previous state
//			previousStates.push(new EntityParametersGraph(this));
//		}
		
		if (nodeList.add(node)) {
			new DragAndDropNodeToGraph(node, this);
			
//			if (changeHistory) {
//				//Clearing the following states
//				for (EntityParametersGraph state : nextStates) {
//					state.dispose();
//				}
//				Generator.nextStates.clear();
//			}
			
			return true;
		}

		if (changeHistory) {
			//If no node added, this state stays the actual one
//			previousStates.pop();
		}
		
		return false;
	}
	
	/**
	 * Ajout d'un lien sur le graphe ayant deux noeuds distincts à chaque extrémité.
	 * Le lien est dessiné.
	 * L'historique n'est pas modifié.
	 * 
	 * @param node1	Noeud 1
	 * @param node2	Noeud 2
	 * 
	 * @return True si l'ajout a réussi, false sinon
	 */
//	public boolean addLink(Node node1, Node node2) {
//		return addLink(node1, node2, false);
//	}
	
	public boolean addLink(Link link) {
		return addLink(link, false);
	}
	
	/**
	 * Ajout d'un lien sur le graphe ayant deux noeuds distincts à chaque extrémité.
	 * Le lien est dessiné.
	 * 
	 * @param node1			Noeud 1
	 * @param node2			Noeud 2
	 * @param changeHistory true pour changer l'historique, false sinon
	 * 
	 * @return True si l'ajout a réussi, false sinon
	 */
//	public boolean addLink(Node node1, Node node2, boolean changeHistory) {
//		Link link = new Link(node1, node2);
//		
//		if (!link.isEmpty()) {
//			if (changeHistory) {
//				//Actual state becomes a previous state
//				Generator.previousStates.push(new ObjectEvent(link, EventsEnum.ADD + "_Link"));
//			}
//			
//			//TODO A CORRIGER
//			if (linkList.add(link)) {
//				node1.getLinks().add(link);
//				node2.getLinks().add(link);
//				
////				Generator.stage.addActor(link);
//				logger.debug("Link added at " + Gdx.input.getX() + ":" + (Gdx.graphics.getHeight() - Gdx.input.getY()));
//				
//				//Envoi du lien à l'arrière du stage, permet de sélectionner les noeuds
//				link.setZIndex(0);
//				
//				return true;
//			}
//		}
//		
//		if (changeHistory) {
//			//If no link added, this state stays the actual one
////			previousStates.pop();
//		}
//		
//		return false;
//	}
	
	public boolean addLink(Link link, boolean changeHistory) {
//		Link link = new Link(node1, node2);
		
		if (!link.isEmpty()) {
			if (changeHistory) {
				//Actual state becomes a previous state
				Generator.previousStates.push(new ObjectEvent(link, EventsEnum.ADD + "_Link"));
				Generator.nextStates.clear();
			}
			
			//TODO A CORRIGER
			if (linkList.add(link)) {
//				link.getNode1().getLinks().add(link);
//				link.getNode2().getLinks().add(link);
				
//				Generator.stage.addActor(link);
				logger.debug("Link added at " + Gdx.input.getX() + ":" + (Gdx.graphics.getHeight() - Gdx.input.getY()));
				
				//Envoi du lien à l'arrière du stage, permet de sélectionner les noeuds
				link.setZIndex(0);
				
				return true;
			}
		}
		
		if (changeHistory) {
			//If no link added, this state stays the actual one
//			previousStates.pop();
		}
		
		return false;
	}
	
	/**
	 * Retourne un noeud du graphe
	 * 
	 * @param nodeToFind	Noeud à trouver
	 * 
	 * @return	Le noeud si trouvé, null sinon
	 */
	public Node findNode(Node nodeToFind) {
		Node node = null;
		
		Iterator<Node> iterator = nodeList.iterator();
		
		while (iterator.hasNext() && node == null) {
			Node next = (Node) iterator.next();
			if (next.equals(nodeToFind)) {
				node = next;
			}
		}
		
		return node;
	}
	
	public Link findLink(Link linkToFind) {
		Link link = null;
		
		Iterator<Link> iterator = linkList.iterator();
		
		while (iterator.hasNext() && link == null) {
			Link next = (Link) iterator.next();
			if (next.equals(linkToFind)) {
				link = next;
			}
		}
		
		return link;
	}

	//TODO Transformer en controller
	@Override
	public void act(float delta) {
		super.act(delta);
		
		//Suppression d'un noeud
		if ((Gdx.input.isKeyJustPressed(Keys.DEL) || Gdx.input.isKeyJustPressed(Keys.FORWARD_DEL)) && selected != null) {
			//Actual state becomes a previous state
//			previousStates.push(new EntityParametersGraph(this));
			
			//Saving state
			
			//Clearing the following states
//			for (EntityParametersGraph state : nextStates) {
//				state.dispose();
//			}
//			nextStates.clear();
//			for (ObjectEvent objectEvent : Generator.)
			
//			selected.dispose();
			
			for (Link link : selected.getLinks()) {
				link.remove();
				Generator.previousStates.push(new ObjectEvent(link, EventsEnum.DELETE + "_Link", ObjectEvent.getGlobalGroupId()));
				linkList.remove(link);
			}
			
//			selected.remove();
//			nodeList.remove(selected);
			for (Actor actor : Generator.stage.getRoot().getChildren()) {
				try {
					if (selected.equals((Node) actor)) {
						actor.remove();
						nodeList.remove(actor);
						break;
					}
				} catch (ClassCastException e) {
					continue;
				}
			}

			Generator.previousStates.push(new ObjectEvent(selected, EventsEnum.DELETE + "_Node", ObjectEvent.getGlobalGroupId()));
			ObjectEvent.incrGroupId();
			Generator.nextStates.clear();
			
			
			selected = null;
		}
	}

	public Set<Node> getNodeList() {
		return nodeList;
	}

	public void setNodeList(Set<Node> nodeList) {
		this.nodeList = nodeList;
	}

	public Set<Link> getLinkList() {
		return linkList;
	}

	public void setLinkList(Set<Link> linkList) {
		this.linkList = linkList;
	}

	public Node getSelected() {
		return selected;
	}

	public void setSelected(Node selected) {
		this.selected = selected;
	}

	/**
	 * Supprime tous les noeuds et tous les liens du graphe
	 */
	public void dispose() {
		for (Link link : linkList) {
			link.dispose();
		}
		
		for (Node node : nodeList) {
			node.dispose();
		}
		
		linkList.clear();
		nodeList.clear();
	}

	@Override
	public void undo(EventsEnum event) {
		Graph graph = (Graph) Generator.findActor("graph");
		ObjectEvent objectEvent = Generator.previousStates.pop();
		
		switch(event) {
		case INIT:
			Generator.nextStates.push(new ObjectEvent(new Graph(graph), event + "_Graph", objectEvent.getGroupId()));
//			graph.setNodeList(nodeList);
			for (Node node : nodeList) {
				Node newNode = new Node(node);
				graph.addNode(newNode);
				Generator.stage.addActor(newNode);
			}
			
//			graph.setLinkList(linkList);
			for (Link link : linkList) {
				Generator.stage.addActor(link);
			}
			break;
		default:
			
			break;
		}
	}

	@Override
	public void redo(EventsEnum event) {
		Graph graph = (Graph) Generator.findActor("graph");
		ObjectEvent objectEvent = Generator.nextStates.pop();
		
		switch(event) {
		case INIT:
			Generator.previousStates.push(new ObjectEvent(new Graph(graph), event + "_Graph", objectEvent.getGroupId()));
			for (Link link : graph.getLinkList()) {
				link.remove();
			}
			graph.getLinkList().clear();
			
			for (Node node : graph.getNodeList()) {
				node.remove();
			}
			graph.getNodeList().clear();
			break;
		default:
			
			break;
		}
	}
}
