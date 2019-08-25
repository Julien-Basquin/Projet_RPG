package generateur.controller.button.entity_parameters.graph;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import generateur.model.entity_parameters.NodeCategorieEnum;
import generateur.model.entity_parameters.NodeData;
import generateur.view.entity_parameters.middle.EntityParametersGraph;

/**
 * Classe d'un noeud représenté sur le graphe.
 * Contient les informations du noeud, les images et les évènements.
 * 
 * @author Julien B.
 */

public class Node extends Button {
	/**Données du noeud*/
	private NodeData data;
	/**Base du chemin des images des noeuds*/
	private String path = "ressources/generateur/node/";
	private Set<Link> links;
	private Logger logger = Logger.getLogger(Node.class);

	public Node(float x, float y) {
		super();
		data = new NodeData();
		data.setCategory(NodeCategorieEnum.STATISTIQUE);
		data.setCoordinates(new Vector2(x, y));
//		this.setPosition(x, y);
		data.setCategoryTexture(new Texture(new FileHandle(path + "green.png")));
		data.setCategoryImage(new Image(data.getCategoryTexture()));
		ButtonStyle style = new NodeStyle(data.getCategoryTexture());
		setStyle(style);
		setSize(64, 64);
		setPosition(x, y);
		links = new HashSet<Link>();
	}
	
	public Node(NodeCategorieEnum category, float x, float y) {
		super();
		data = new NodeData();
		data.setCategory(category);
		data.setCoordinates(new Vector2(x, y));
//		this.setPosition(x, y);
		data.setCategoryTexture(new Texture(new FileHandle(path + findColor(category) + ".png")));
		data.setCategoryImage(new Image(data.getCategoryTexture()));
		ButtonStyle style = new NodeStyle(data.getCategoryTexture());
		setStyle(style);
		setSize(64, 64);
		setPosition(x, y);
		links = new HashSet<Link>();
	}
	
	public void addClickEvent(EntityParametersGraph graph) {
		Node node = this;
		
		addListener(new InputListener() {

			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				return true;
			}

			@Override
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				super.touchDown(event, x, y, pointer, button);
				
				switch(button) {
					case Buttons.LEFT :
						if (graph.getSelected() != null) {
							graph.getSelected().setChecked(false);
						}
						node.setChecked(true);
						graph.setSelected(node);
						break;
					case Buttons.RIGHT :
						if (graph.getSelected() != null) {
							graph.addLink(graph.getSelected(), node);
						}
						break;
				}
			}
			
		});
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
	
	public NodeData getData() {
		return data;
	}

	public void setData(NodeData data) {
		this.data = data;
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
		data.dispose();
	}
}
