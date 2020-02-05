package generateur.controller.button.entity_parameters.graph;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

/**
 * Style d'un lien du graphe des entités.
 * 
 * @author Julien B.
 */

public class LinkStyle extends ButtonStyle {
	
	public LinkStyle(Texture texture) {
		super();
		
		this.up = down = checked = new TextureRegionDrawable(texture);
	}
}
