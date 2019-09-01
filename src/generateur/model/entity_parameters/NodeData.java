package generateur.model.entity_parameters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Informations d'un noeud.
 * 
 * @author Julien B.
 */

public class NodeData {
	private static int globalId;
	
	private int id;
	/**Nom*/
	private String name;
	/**Categorie*/
	private NodeCategorieEnum category;
	/**Lien vers un élément existant*/
	//TODO Définir comment faire les liens
	/**Description*/
	private String description;
	/**Coordonnées*/
	private Vector2 coordinates;
	private Texture categoryTexture;
	private Texture iconTexture;
	private Image categoryImage;
	private Image iconImage;
	
	public NodeData() {
		id = globalId++;
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

	public Vector2 getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Vector2 coordinates) {
		this.coordinates = coordinates;
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
	
	public void dispose() {
		if (categoryTexture != null) {
			categoryTexture.dispose();
		}
		if (iconTexture != null) {
			iconTexture.dispose();
		}
	}

	@Override
	public boolean equals(Object obj) {
		return id == ((NodeData) obj).getId();
	}
}
