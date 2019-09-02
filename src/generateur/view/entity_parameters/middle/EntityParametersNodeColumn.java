package generateur.view.entity_parameters.middle;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.utils.Disposable;

/**
 * Colonne contenant les noeuds sélectionnables.
 * Source pour le drag and drop des noeuds.
 * 
 * @author Julien B.
 */

public class EntityParametersNodeColumn extends VerticalGroup implements Disposable {
	/**Textures utilisées pour les images*/
	private Texture[] textures;

	public EntityParametersNodeColumn(Skin skin) {
		super();
		setName("entity_node_column");
		textures = new Texture[4];
		
		VerticalGroup statGroup = new VerticalGroup();
		statGroup.setName("stat_group");
		Label stat = new Label("Statistique", skin);
		textures[0] = new Texture("ressources/generateur/node/green.png");
		Container<Image> statContainer = new Container<Image>(new Image(textures[0]));
		statContainer.setName("stat");
		statGroup.addActor(stat);
		statGroup.addActor(statContainer);
		
		VerticalGroup skillGroup = new VerticalGroup();
		skillGroup.setName("skill_group");
		Label skill = new Label("Compétence", skin);
		textures[1] = new Texture("ressources/generateur/node/red.png");
		Container<Image> skillContainer = new Container<Image>(new Image(textures[1]));
		skillContainer.setName("skill");
		skillGroup.addActor(skill);
		skillGroup.addActor(skillContainer);
		
		VerticalGroup equipmentGroup = new VerticalGroup();
		equipmentGroup.setName("equipment_group");
		Label equipment = new Label("Equipement", skin);
		textures[2] = new Texture("ressources/generateur/node/blue.png");
		Container<Image> equipmentContainer = new Container<Image>(new Image(textures[2]));
		equipmentContainer.setName("equipment");
		equipmentGroup.addActor(equipment);
		equipmentGroup.addActor(equipmentContainer);
		
		VerticalGroup attributeGroup = new VerticalGroup();
		attributeGroup.setName("attribute_group");
		Label attribute = new Label("Attribut", skin);
		textures[3] = new Texture("ressources/generateur/node/magenta.png");
		Container<Image> attributeContainer = new Container<Image>(new Image(textures[3]));
		attributeContainer.setName("attribute");
		attributeGroup.addActor(attribute);
		attributeGroup.addActor(attributeContainer);
		
		addActor(statGroup);
		addActor(skillGroup);
		addActor(equipmentGroup);
		addActor(attributeGroup);
	}

	@Override
	public void dispose() {
		for (Texture texture : textures) {
			texture.dispose();
		}
	}
}
