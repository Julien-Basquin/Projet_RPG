package generateur.controller.button.entity_parameters.graph;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

/**
 * Style d'un noeud du graphe des entités.
 * 
 * @author Julien B.
 */

public class NodeStyle extends Button.ButtonStyle {
	
	public NodeStyle(Texture texture) {
		super();
		
		this.up = new TextureRegionDrawable(texture);
		this.down = this.checked = new TextureRegionDrawable(new Texture(new FileHandle("ressources/generateur/node/white.png")));
	}
}
