package generateur.view.entity_parameters.middle;

import java.util.Set;

import org.apache.log4j.Logger;

import java.util.HashSet;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.scenes.scene2d.Group;
import generateur.Generator;
import generateur.controller.button.entity_parameters.graph.Link;
import generateur.controller.button.entity_parameters.graph.node.Node;
import generateur.controller.draganddrop.entity_parameters.DragAndDropNodeToGraph;

/**
 * Graphe associé aux entités.
 * 
 * @author Julien B.
 */

public class EntityParametersGraph extends Group {
	private Set<Node> nodeList;
	private Set<Link> linkList;
	private Node selected;
	private final Logger logger = Logger.getLogger(EntityParametersGraph.class);
	
	private boolean remove;

	public EntityParametersGraph() {
		super();
		setName("graph");

		nodeList = new HashSet<Node>();
		linkList = new HashSet<Link>();
		Gdx.input.setInputProcessor(Generator.inputMultiplexer);
	}

	/**
	 * Ajoute un noeud sur le graphe.
	 * 
	 * @param node	Noeud à ajouter
	 * 
	 * @return	True si l'ajout a réussi, false sinon
	 */
	public boolean addNode(Node node) {
		if (nodeList.add(node)) {
			new DragAndDropNodeToGraph(node, this);
			return true;
		}
		
		return false;
	}
	
	/**
	 * Ajout d'un lien sur le graphe ayant deux noeuds distincts à chaque extrémité.
	 * Le lien est dessiné.
	 * 
	 * @param node1	Noeud 1
	 * @param node2	Noeud 2
	 * 
	 * @return True si l'ajout a réussi, false sinon
	 */
	public boolean addLink(Node node1, Node node2) {
		Link link = new Link(node1, node2);
		
		if (linkList.add(link)) {
			node1.getLinks().add(link);
			node2.getLinks().add(link);

			Generator.stage.addActor(link);
			logger.debug("Link added at " + Gdx.input.getX() + ":" + (Gdx.graphics.getHeight() - Gdx.input.getY()));
			
			//Envoi du lien à l'arrière du stage, permet de sélectionner les noeuds
			link.setZIndex(0);
			
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
			selected.dispose();
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

//	public Stage getLocalStage() {
//		return localStage;
//	}
//
//	public void setLocalStage(Stage localStage) {
//		this.localStage = localStage;
//	}
	
	public boolean isRemove() {
		return remove;
	}

	public void setRemove(boolean remove) {
		this.remove = remove;
	}

	public void dispose() {
		for (Link link : linkList) {
			link.remove();
			link.dispose();
		}
	}
}
