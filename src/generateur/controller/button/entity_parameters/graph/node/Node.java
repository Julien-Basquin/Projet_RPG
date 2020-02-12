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

import generateur.MainWindow;
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

public abstract class Node extends Button implements Cancelable {
	protected static int globalId;
	
	/**Identifiant*/	
	protected int id;
	/**Categorie*/
	protected NodeCategorieEnum category;
	/**Nom*/
	protected String name;
	/**Description*/
	protected String description;
	/**Coût de déverrouillage*/
	protected int cout;
	/**Coût de déverrouillage*/
	protected boolean unlock;
	
	/**Texture de l'image de la catégorie*/
	protected Texture categoryTexture;
	/**Texture de l'icone*/
	protected Texture iconTexture;
	/**Image de la catégorie (chargée depuis la texture)*/
	protected Image categoryImage;
	/**Image de l'icone (chargée depuis la texture)*/
	protected Image iconImage;
	
	/**Base du chemin des images des noeuds*/
	protected String path = "ressources/generateur/node/";
	
	/**Liste des liens du noeuds*/
	protected Map<Integer, Link> links;
	
	private Logger logger = Logger.getLogger(Node.class);

	
	
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
	
	public int getCout() {
		return cout;
	}
	public void setCout(int cout) {
		this.cout = cout;
	}
	public boolean isUnlock() {
		return unlock;
	}
	public void setUnlock(boolean unlock) {
		this.unlock = unlock;
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
	public abstract void undo(EventsEnum event);
		

	@Override
	public abstract void redo(EventsEnum event);
}
