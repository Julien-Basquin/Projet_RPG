package generateur.controller.select;

import org.apache.log4j.Logger;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.SplitPane;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Disposable;

import app.model.enumeration.CategorieEnum;
import app.model.enumeration.element.ElementEnum;
import app.model.enumeration.objet.equipement.arme.TypeArmeEnum;
import app.model.enumeration.objet.equipement.arme.souscategorie.SousCategorieArmeEnum;
import app.model.enumeration.objet.equipement.armure.TypeArmureEnum;
import app.model.enumeration.objet.equipement.armure.souscategorie.SousCategorieArmureEnum;
import app.model.enumeration.objet.objet.TypeObjet;
import generateur.MainWindow;
import generateur.view.item.EffectTable;
import generateur.view.item.ItemPane;
import generateur.MainWindow;
import generateur.view.entity_parameters.EntityParametersGlobalPane;
import generateur.view.global.GlobalParametersPane;
import util.Converter;

/**
 * Liste déroulante des catégories et modification de toutes les informations liées.
 * 
 * @author Julien B.
 */

public class SelectElement extends SelectBox<ElementEnum> {
	
	private String value;
	private final Logger logger = Logger.getLogger(SelectElement.class);

	public SelectElement(Group parent, Skin skin) {
		super(skin);
		
		value = "";
		setItems(ElementEnum.values());
		
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
				
				//Mise à jour des listes en fonction de la catégorie
				logger.info("Updating linked lists...");
				
				value = getSelected().name();
				logger.info("...updating completed.");
			}
			
		});
	}
	
}
