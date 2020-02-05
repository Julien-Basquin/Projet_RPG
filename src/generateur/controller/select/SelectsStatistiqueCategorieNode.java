package generateur.controller.select;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import app.model.enumeration.CategorieEnum;
import app.model.enumeration.objet.equipement.arme.TypeArmeEnum;
import app.model.enumeration.objet.equipement.arme.souscategorie.SousCategorieArmeEnum;
import app.model.enumeration.objet.equipement.armure.TypeAccessoryEnum;
import app.model.enumeration.objet.equipement.armure.TypeArmureEnum;
import app.model.enumeration.objet.equipement.armure.souscategorie.SousCategorieAccessoryEnum;
import app.model.enumeration.objet.equipement.armure.souscategorie.SousCategorieArmureEnum;
import app.model.enumeration.statistique.StatistiquesEnum;
import util.Converter;

/**
 * Liste déroulante des catégories et modification de toutes les informations liées.
 * 
 * @author Julien B.
 */

public class SelectsStatistiqueCategorieNode extends SelectBox<StatistiquesEnum> {
	
	private String value;
	private final Logger logger = Logger.getLogger(SelectsStatistiqueCategorieNode.class);

	public SelectsStatistiqueCategorieNode(Group parent, Skin skin) {
		super(skin);
		
		value = "";
		
		setItems(StatistiquesEnum.values());
		
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
					logger.debug(getName() + " changed : " + value + " -> " + (getSelected() != null ? getSelected().getNom() : ""));
				}
				
				//Récupération des listes des sous-catégories et des types pour mise à jour
				StringSelectBox subcategorySelect = (StringSelectBox) parent.findActor("subcategory_node");
				StringSelectBox typeSelect = (StringSelectBox) parent.findActor("type_node");
				//Mise à jour des listes en fonction de la catégorie
				logger.info("Updating linked lists...");
				
				value = getSelected().name();
				logger.info("...updating completed.");
			}
			
		});
	}
	
}
