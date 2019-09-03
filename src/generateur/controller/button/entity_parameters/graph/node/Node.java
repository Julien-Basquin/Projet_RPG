package generateur.controller.button.entity_parameters.graph.node;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import generateur.controller.button.entity_parameters.graph.Link;
import generateur.model.entity_parameters.NodeCategorieEnum;
import generateur.view.entity_parameters.middle.EntityParametersGraph;

/**
 * Classe d'un noeud représenté sur le graphe.
 * Contient les informations du noeud, les images et les évènements.
 * 
 * @author Julien B.
 */

public class Node extends Button {
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
	private Set<Link> links;
	
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
		links = new HashSet<Link>();
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
		links = new HashSet<Link>();
	}
	
	/**
	 * Création des évènements du noeud
	 * 
	 * @param graph	Graphe contenant le noeud
	 */
	public void addEvents(EntityParametersGraph graph) {
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
	 * Dessine les liens du noeud
	 */
	public void drawLink() {
		for (Link link : links) {
			link.draw();
		}
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

	public Set<Link> getLinks() {
		return links;
	}

	public void setLinks(Set<Link> links) {
		this.links = links;
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
	}

	public void dispose() {
		for (Link link : links) {
			link.dispose();
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
}
