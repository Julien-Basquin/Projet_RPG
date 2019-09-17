package generateur.controller.select;

import org.apache.log4j.Logger;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import generateur.controller.button.entity_parameters.graph.node.Node;
import generateur.model.entity_parameters.NodeCategorieEnum;

/**
 * Liste déroulante des catégories et modification de toutes les informations liées au node.
 * 
 * @author Julien B.
 */

public class SelectNodeCategory extends SelectBox<NodeCategorieEnum> {

	private String value;
	private final Logger logger = Logger.getLogger(SelectNodeCategory.class);

	public SelectNodeCategory(Group parent, Skin skin, Node node) {
		super(skin);

		value = "";
		setItems(NodeCategorieEnum.values());

		addListener(new ClickListener() {

			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);

				value = getSelected() != null ? getSelected().name() : "";
			}

		});

		//Gestion des changements
		addListener(new ChangeListener() {

			@Override
			public void changed(ChangeEvent event, Actor actor) {
				//Logging du changement de valeur si la valeur a été changée
				if (getSelected() != null && value != getSelected().name()) {
					logger.debug(getName() + " changed : " + value + " -> " + (getSelected() != null ? getSelected() : ""));
				}

				//Mise à jour des listes en fonction de la catégorie
				logger.info("Updating linked lists...");
				node.setCategory(getSelected());
				switch(getSelected()) {
				case ATTRIBUT:
					logger.info("set attribut  data...");
					break;
				case COMPETENCE:
					logger.info("set competence  data...");
					break;
				case EQUIPEMENT:
					logger.info("set equipement  data...");
					break;
				case STATISTIQUE:
					logger.info("set statistique  data...");
					break;
				default:
					logger.info("set default  data...");
					break;
				}
				value = getSelected().name();
				logger.info("...updating completed.");
			}

		});
	}

}
