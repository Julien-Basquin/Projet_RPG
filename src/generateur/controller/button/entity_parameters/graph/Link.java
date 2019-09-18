package generateur.controller.button.entity_parameters.graph;

import org.apache.log4j.Logger;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

import generateur.Generator;
import generateur.controller.button.entity_parameters.graph.node.Node;
import generateur.model.entity_parameters.Cancelable;
import generateur.model.entity_parameters.EventsEnum;
import generateur.model.entity_parameters.stack.ObjectEvent;
import generateur.view.entity_parameters.middle.Graph;
import util.ActorActions;

/**
 * Classe représentant un lien entre plusieurs noeuds dans le graphe.
 * 
 * @author Julien B.
 */

public class Link extends Button implements Cancelable {
	private static int globalId;
	
	private int id;
	/**Extrémité du lien*/
	private Node node1;
	/**Extrémité du lien*/
	private Node node2;
	private Pixmap line;
	private Texture texture;
	private final Logger logger = Logger.getLogger(Link.class);
	
	public Link(Node end1, Node end2) {
		super((Drawable) null);
		
		if (end1.equals(end2)) {
			logger.error("Second node is already attached to this link.\nCreation aborted.");
		} else {
			id = globalId++;
			node1 = end1;
			node2 = end2;
			node1.getLinks().put(id, this);
			node2.getLinks().put(id, this);
			
			link();
			setZIndex(0);
		}
	}
	
	/**
	 * Création et positionnement du lien sur le graphe.
	 * Ne dessine pas le lien à l'écran.
	 */
	public void link() {
		if (texture != null) {
			texture.dispose();
		}
		
		float directionX = node2.getX() - node1.getX();
		float directionY = node2.getY() - node1.getY();
		int width = (int) Math.abs(directionX);
		int height = (int) Math.abs(directionY);
		int x = (int) (node1.getX() + node1.getWidth() / 2);
		int y = (int) (node1.getY() + node1.getHeight() / 2);
		
		//Création de l'image
		line = new Pixmap((int) width, (int)  height, Format.RGBA8888);
		line.setColor(Color.WHITE);
		
		//Positionnement
		if (directionX >= 0 && directionY >= 0) {
			setPosition(x, y);
			line.drawLine(0, height, width, 0);
		} else if (directionX >= 0 && directionY < 0) {
			setPosition(x, y - height);
			line.drawLine(0, 0, width, height);
		} else if (directionX < 0 && directionY >= 0) {
			setPosition(x - width, y);
			line.drawLine(0, 0, width, height);
		} else {
			line.drawLine(0, height, width, 0);
			setPosition(x - width, y - height);
		}
		
		texture = new Texture(line);
		line.dispose();
		setStyle(new LinkStyle(texture));
		setSize(width, height);
	}
	
	/**
	 * Met à jour les noeuds du lien
	 * 
	 * @param graph	Graphe contenant les noeuds
	 */
	public void update(Graph graph) {
		node1 = graph.getNodeList().get(node1.getId());
		node2 = graph.getNodeList().get(node2.getId());
	}
	
	public boolean isEmpty() {
		return node1 == null && node2 == null;
	}

	@Override
	public boolean equals(Object obj) {
		Link o = (Link) obj;
		
		return node1.equals(o.getNode1()) || node1.equals(o.getNode2()) || node2.equals(o.getNode1()) || node2.equals(o.getNode2());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static int getGlobalId() {
		return globalId;
	}

	public Node getNode1() {
		return node1;
	}

	public void setNode1(Node node1) {
		this.node1 = node1;
	}

	public Node getNode2() {
		return node2;
	}

	public void setNode2(Node node2) {
		this.node2 = node2;
	}
	
	public void dispose() {
		remove();
		
		if (texture != null) {
			texture.dispose();
		}
	}

	@Override
	public void undo(EventsEnum event) {
		Graph graph = (Graph) ActorActions.findActor(Generator.stage, "graph");
		ObjectEvent objectEvent = Generator.previousStates.pop();
		Link link = graph.getLinkList().get(id);
		
		Generator.nextStates.push(new ObjectEvent(this, event + "_Link", objectEvent.getGroupId()));

		switch(event) {
		case ADD:
			link.remove();
			graph.getLinkList().remove(id);
			break;
		case DELETE:
			update(graph);
			graph.getLinkList().put(id, this);
			Generator.stage.addActor(this);
			setZIndex(0);
			break;
		default:
			
			break;
		}
	}

	@Override
	public void redo(EventsEnum event) {
		Graph graph = (Graph) ActorActions.findActor(Generator.stage, "graph");
		ObjectEvent objectEvent = Generator.nextStates.pop();
		Link link = graph.getLinkList().get(id);
		
		Generator.previousStates.push(new ObjectEvent(this, event + "_Link", objectEvent.getGroupId()));
		switch(event) {
		case ADD:
			update(graph);
			graph.getLinkList().put(id, this);
			Generator.stage.addActor(this);
			setZIndex(0);
			break;
		case DELETE:
			link.remove();
			graph.getLinkList().remove(id);
			break;
		default:
			
			break;
		}
	}
}
