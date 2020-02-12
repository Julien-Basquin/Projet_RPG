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
import util.Converter;

/**
 * Liste déroulante des catégories et modification de toutes les informations liées.
 * 
 * @author Julien B.
 */

public class SelectEquipementCategorieNode extends SelectBox<CategorieEnum> {
	
	private String value;
	private final Logger logger = Logger.getLogger(SelectEquipementCategorieNode.class);

	public SelectEquipementCategorieNode(Group parent, Skin skin) {
		super(skin);
		
		value = "";
		
		setItems(CategorieEnum.ARME, CategorieEnum.ARMURE, CategorieEnum.ACCESSORY);
		
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
				switch(getSelected()) {
					case ARME:
						logger.info("Loading weapon related data...");
						try {
							subcategorySelect.setItems(Converter.enumToStringArray(TypeArmeEnum.class));
							subcategorySelect.setSelectedIndex(0);
							typeSelect.setItems(Converter.enumToStringArray(SousCategorieArmeEnum.class));
							typeSelect.setSelectedIndex(0);
						} catch (Exception e) {
							logger.fatal("Error during the loading of weapon related data", e);
						}
						break;
					case ARMURE:
						logger.info("Loading armor related data...");
						try {
							subcategorySelect.setItems(Converter.enumToStringArray(TypeArmureEnum.class));
							subcategorySelect.setSelectedIndex(0);
							typeSelect.setItems(Converter.enumToStringArray(SousCategorieArmureEnum.class));
							typeSelect.setSelectedIndex(0);
						} catch (Exception e) {
							logger.fatal("Error during the loading of armor related data", e);
						}
						break;
					case ACCESSORY:
						logger.info("Loading accesory related data...");
						try {
							subcategorySelect.setItems(Converter.enumToStringArray(TypeAccessoryEnum.class));
							subcategorySelect.setSelectedIndex(0);
							typeSelect.clearItems();
						} catch (Exception e) {
							logger.fatal("Error during the loading of armor related data", e);
						}
						break;
					default:
						logger.warn("The category does not match any data. Updating failed.");
						break;
				}
				value = getSelected().name();
				logger.info("...updating completed.");
			}
			
		});
	}
	
}