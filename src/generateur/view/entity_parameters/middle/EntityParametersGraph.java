package generateur.view.entity_parameters.middle;

import java.util.Set;

import org.apache.log4j.Logger;

import java.util.HashSet;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import generateur.Generator;
import generateur.controller.button.entity_parameters.graph.Link;
import generateur.controller.button.entity_parameters.graph.Node;
import generateur.controller.draganddrop.entity_parameters.DragAndDropGraph;

/**
 * Graphe associé aux entités.
 * 
 * @author Julien B.
 */

//TODO Ajouter le drag and drop de graph vers graph
public class EntityParametersGraph extends Group {
	private Stage localStage;
	private Set<Node> nodeList;
	private Set<Link> linkList;
	private Node selected;
	private final Logger logger = Logger.getLogger(EntityParametersGraph.class);

	public EntityParametersGraph() {
		super();
		setName("graph");

		//TODO Faire le graphe
		localStage = new Stage();
		nodeList = new HashSet<Node>();
		linkList = new HashSet<Link>();
		Generator.inputMultiplexer.addProcessor(0, localStage);
		Gdx.input.setInputProcessor(Generator.inputMultiplexer);
	}

	public boolean addNode(Node node) {
		if (nodeList.add(node)) {
			new DragAndDropGraph(node, this);
			return true;
		}
		
		return false;
	}
	
	public boolean addLink(Node node1, Node node2) {
		Link link = new Link(node1, node2);
		
		if (linkList.add(link)) {
			node1.getLinks().add(link);
			node2.getLinks().add(link);

			Generator.stage.addActor(link);
			logger.debug("Link added at " + Gdx.input.getX() + ":" + (Gdx.graphics.getHeight() - Gdx.input.getY()));
			
			return true;
		}
		System.out.println("NO");
		
		return false;
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

	public Stage getLocalStage() {
		return localStage;
	}

	public void setLocalStage(Stage localStage) {
		this.localStage = localStage;
	}
}
