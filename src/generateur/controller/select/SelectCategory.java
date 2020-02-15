package generateur.controller.select;

import org.apache.log4j.Logger;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Disposable;

import app.model.enumeration.CategorieEnum;
import app.model.enumeration.objet.equipement.arme.TypeArmeEnum;
import app.model.enumeration.objet.equipement.arme.souscategorie.SousCategorieArmeEnum;
import app.model.enumeration.objet.equipement.armure.TypeArmureEnum;
import app.model.enumeration.objet.equipement.armure.souscategorie.SousCategorieArmureEnum;
import app.model.enumeration.objet.objet.TypeObjet;
import generateur.MainWindow;
import generateur.view.entity_parameters.EntityParametersGlobalPane;
import generateur.view.item_base.ItemPane;
import util.ActorActions;
import util.Converter;

/**
 * Liste déroulante des catégories et modification de toutes les informations liées.
 * 
 * @author Julien B.
 */

public class SelectCategory extends SelectBox<CategorieEnum> {
	
	private String value;
	private final Logger logger = Logger.getLogger(SelectCategory.class);

	public SelectCategory(Skin skin) {
		super(skin);
		
		value = "";
		setItems(CategorieEnum.values());
		
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
				
				//Retrait de la partie droite de l'écran
				if (MainWindow.mainSplit != null
						&& MainWindow.mainSplit.getChildren().items[1] != null) {
					try {
						((Disposable) MainWindow.mainSplit.getChildren().items[1]).dispose();
					} catch (ClassCastException e) {
						MainWindow.mainSplit.setSecondWidget(null);
					}
				}
				
				//Récupération des listes des sous-catégories et des types pour mise à jour
				StringSelectBox subcategorySelect = (StringSelectBox) ActorActions.findActor(MainWindow.stage, "subcategory");
				StringSelectBox typeSelect = (StringSelectBox) ActorActions.findActor(MainWindow.stage, "type");
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
							ItemPane itemPane = new ItemPane(skin);
							itemPane.setWidth(MainWindow.secondActorWidth);
							MainWindow.mainSplit.setSecondWidget(itemPane);
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
							ItemPane itemPane = new ItemPane(skin);
							itemPane.setWidth(MainWindow.secondActorWidth);
							MainWindow.mainSplit.setSecondWidget(itemPane);
						} catch (Exception e) {
							logger.fatal("Error during the loading of armor related data", e);
						}
						break;
					case ENTITE:
						EntityParametersGlobalPane entityParametersGlobalPane = new EntityParametersGlobalPane(skin);
						entityParametersGlobalPane.setWidth(MainWindow.secondActorWidth);
						MainWindow.mainSplit.setSecondWidget(entityParametersGlobalPane);
						break;
					case OBJET:
						logger.info("Loading object related data...");
						try {
							subcategorySelect.setItems(Converter.enumToStringArray(TypeObjet.class));
							subcategorySelect.setSelectedIndex(0);
							typeSelect.clearItems();
							ItemPane itemPane = new ItemPane(skin);
							itemPane.setWidth(MainWindow.secondActorWidth);
							MainWindow.mainSplit.setSecondWidget(itemPane);
						} catch (Exception e) {
							logger.fatal("Error during the loading of object related data", e);
						}
						break;
					case COMPETENCE:
						logger.info("No corresponding data. Cleaning lists...");
						subcategorySelect.clearItems();
						typeSelect.clearItems();
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
