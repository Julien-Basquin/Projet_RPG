package generateur.view.entity_parameters.middle;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;

/**
 * Colonne contenant les noeuds sélectionnables.
 * Source pour le drag and drop des noeuds.
 * 
 * @author Julien B.
 */

public class EntityParametersNodeColumn extends VerticalGroup {

	public EntityParametersNodeColumn(Skin skin) {
		super();
		setName("entity_node_column");
		
		VerticalGroup statGroup = new VerticalGroup();
		statGroup.setName("stat_group");
		Label stat = new Label("Statistique", skin);
		Container<Image> statContainer = new Container<Image>(new Image(new Texture("ressources/generateur/node/green.png")));
		statContainer.setName("stat");
		statGroup.addActor(stat);
		statGroup.addActor(statContainer);
		
		VerticalGroup skillGroup = new VerticalGroup();
		skillGroup.setName("skill_group");
		Label skill = new Label("Compétence", skin);
		Container<Image> skillContainer = new Container<Image>(new Image(new Texture("ressources/generateur/node/red.png")));
		skillContainer.setName("skill");
		skillGroup.addActor(skill);
		skillGroup.addActor(skillContainer);
		
		VerticalGroup equipmentGroup = new VerticalGroup();
		equipmentGroup.setName("equipment_group");
		Label equipment = new Label("Equipement", skin);
		Container<Image> equipmentContainer = new Container<Image>(new Image(new Texture("ressources/generateur/node/blue.png")));
		equipmentContainer.setName("equipment");
		equipmentGroup.addActor(equipment);
		equipmentGroup.addActor(equipmentContainer);
		
		VerticalGroup attributeGroup = new VerticalGroup();
		attributeGroup.setName("attribute_group");
		Label attribute = new Label("Attribut", skin);
		Container<Image> attributeContainer = new Container<Image>(new Image(new Texture("ressources/generateur/node/magenta.png")));
		attributeContainer.setName("attribute");
		attributeGroup.addActor(attribute);
		attributeGroup.addActor(attributeContainer);
		
		addActor(statGroup);
		addActor(skillGroup);
		addActor(equipmentGroup);
		addActor(attributeGroup);
	}
}
