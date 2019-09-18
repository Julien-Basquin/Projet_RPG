package generateur.controller.button.entity_parameters.graph.node;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.log4j.Logger;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import generateur.Generator;
import generateur.controller.button.entity_parameters.graph.Link;
import generateur.model.entity_parameters.Cancelable;
import generateur.model.entity_parameters.EventsEnum;
import generateur.model.entity_parameters.NodeCategorieEnum;
import generateur.model.entity_parameters.stack.ObjectEvent;
import generateur.view.entity_parameters.middle.Graph;
import util.ActorActions;

/**
 * Classe d'un noeud représenté sur le graphe.
 * Contient les informations du noeud, les images et les évènements.
 * 
 * @author Julien B.
 */

public class Node extends Button implements Cancelable {
	private static int globalId;
	
	/**Identifiant*/	
	private int id;
	/**Nom*/
	private String name;
	/**Categorie*/
	private NodeCategorieEnum category;
	/**Description*/
	private String description;
	
	/**Texture de l'image de la catégorie*/
	private Texture categoryTexture;
	/**Texture de l'icone*/
	private Texture iconTexture;
	/**Image de la catégorie (chargée depuis la texture)*/
	private Image categoryImage;
	/**Image de l'icone (chargée depuis la texture)*/
	private Image iconImage;
	
	/**Base du chemin des images des noeuds*/
	private String path = "ressources/generateur/node/";
	
	/**Liste des liens du noeuds*/
	private Map<Integer, Link> links;
	
	private Logger logger = Logger.getLogger(Node.class);

	public Node(float x, float y) {
		super();
		id = globalId++;
		category = NodeCategorieEnum.STATISTIQUE;
		categoryTexture = new Texture(new FileHandle(path + "green.png"));
		categoryImage = new Image(categoryTexture);
		setStyle(new NodeStyle(categoryTexture));
		setSize(64, 64);
		setPosition(x, y);
		links = new HashMap<Integer, Link>();
	}
	
	public Node(NodeCategorieEnum category, float x, float y) {
		super();
		id = globalId++;
		this.category = category;
		categoryTexture = new Texture(new FileHandle(path + findColor(category) + ".png"));
		categoryImage = new Image(categoryTexture);
		setStyle(new NodeStyle(categoryTexture));
		setSize(64, 64);
		setPosition(x, y);
		links = new HashMap<Integer, Link>();
	}
	
	public Node(Node node) {
		super();
		id = node.getId();
		category = node.getCategory();
		categoryTexture = new Texture(new FileHandle(path + findColor(category) + ".png"));
		categoryImage = new Image(categoryTexture);
		setStyle(new NodeStyle(categoryTexture));
		setSize(64, 64);
		setPosition(node.getX(), node.getY());
		links = node.getLinks();
		
		//Visibilité du noeud
		setVisible(node.isVisible());
	}
	
	/**
	 * Création des évènements du noeud
	 * 
	 * @param graph	Graphe contenant le noeud
	 */
	public void addEvents(Graph graph) {
		new NodeEvents(this, graph);
	}
	
	/**
	 * Nom de la couleur de la catégorie du noeud en paramètre
	 * 
	 * @param category	Catégorie du noeud
	 * 
	 * @return	Nom de la couleur de la catégorie
	 */
	public String findColor(NodeCategorieEnum category) {
		String color = "";
		
		switch(category) {
		case STATISTIQUE:
			color = "green";
			break;
		case COMPETENCE:
			color = "red";
			break;
		case EQUIPEMENT:
			color = "blue";
			break;
		case ATTRIBUT:
			color = "magenta";
		}
		
		return color;
	}
	
	/**
	 * Création et positionnement des liens du noeud sur le graphe.
	 * Ne dessine pas les liens à l'écran.
	 */
	public void link() {
		for (Entry<Integer, Link> link : links.entrySet()) {
			link.getValue().link();
		}
	}

	/**
	 * update image
	 */
	private void updateImage() {
		if (categoryTexture != null) {
			categoryTexture.dispose();
		}
		if (iconTexture != null) {
			iconTexture.dispose();
		}
		
		categoryTexture = new Texture(new FileHandle(path + findColor(category) + ".png"));
		categoryImage = new Image(categoryTexture);
		setStyle(new NodeStyle(categoryTexture));
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public NodeCategorieEnum getCategory() {
		return category;
	}

	public void setCategory(NodeCategorieEnum category) {
		this.category = category;
		updateImage();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Texture getCategoryTexture() {
		return categoryTexture;
	}

	public void setCategoryTexture(Texture categoryTexture) {
		this.categoryTexture = categoryTexture;
	}

	public Texture getIconTexture() {
		return iconTexture;
	}

	public void setIconTexture(Texture iconTexture) {
		this.iconTexture = iconTexture;
	}

	public Image getCategoryImage() {
		return categoryImage;
	}

	public void setCategoryImage(Image categoryImage) {
		this.categoryImage = categoryImage;
	}

	public Image getIconImage() {
		return iconImage;
	}

	public void setIconImage(Image iconImage) {
		this.iconImage = iconImage;
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public static int getGlobalId() {
		return globalId;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Map<Integer, Link> getLinks() {
		return links;
	}

	public void setLinks(Map<Integer, Link> links) {
		this.links = links;
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
	}

	public void dispose() {
		for (Entry<Integer, Link> link : links.entrySet()) {
			link.getValue().dispose();
		}
		
		if (categoryTexture != null) {
			categoryTexture.dispose();
		}
		if (iconTexture != null) {
			iconTexture.dispose();
		}
		
		remove();
	}

	@Override
	public boolean equals(Object obj) {
		return id == ((Node) obj).getId();
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
			
			Generator.nextStates.push(new ObjectEvent(new Node(node), event + "_Node", objectEvent.getGroupId()));
			break;
		case DELETE:	//Utilsiation de this car node n'existe plus
			//Ajout de this au graphe
			graph.addNode(this, true);

			Generator.nextStates.push(new ObjectEvent(new Node(this), event + "_Node", objectEvent.getGroupId()));
			break;
		case EDIT:
			//TODO Edition d'un noeud
			break;
		case MOVE:
			Generator.nextStates.push(new ObjectEvent(new Node(node), event + "_Node", objectEvent.getGroupId()));
			
			node.setPosition(getX(), getY());
			node.setVisible(isVisible());
			
			link();
			break;
		default:
			
			break;
		}
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

			Generator.previousStates.push(new ObjectEvent(new Node(this), event + "_Node", objectEvent.getGroupId()));
			break;
		case DELETE:
			node.remove();
			graph.getNodeList().remove(id);
			
			Generator.previousStates.push(new ObjectEvent(new Node(this), event + "_Node", objectEvent.getGroupId()));
			break;
		case EDIT:
			//TODO Edition d'un noeud
			break;
		case MOVE:
			Generator.previousStates.push(new ObjectEvent(new Node(node), event + "_Node", objectEvent.getGroupId()));
			
			node.setPosition(getX(), getY());
			node.setVisible(isVisible());
			
			link();
			break;
		default:
			
			break;
		}
	}
}
