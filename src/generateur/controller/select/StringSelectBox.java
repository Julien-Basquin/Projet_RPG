package generateur.controller.select;

import org.apache.log4j.Logger;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import generateur.MainWindow;
import generateur.Launcher;
import generateur.view.item.ItemSpecialOptions;
import util.ActorActions;
import util.Converter;

/**
 * Simple SelectBox pour String avec implémentation des logs.
 * 
 * @author Julien B.
 */

public class StringSelectBox extends SelectBox<String> {
	
	private String value;
	private final Logger logger = Logger.getLogger(StringSelectBox.class);

	/**
	 * Constructeur d'une SelectBox de String vide.
	 * 
	 * @param skin
	 */
	public StringSelectBox(Skin skin) {
		this(null, skin);
	}
	
	/**
	 * Constructeur d'une SelectBox de String.
	 * 
	 * @param enumeration	Enum utilisée.
	 * 						Mettre à null pour ne charger aucune valeur.
	 * @param skin			skin
	 */
	public StringSelectBox(Class<? extends Enum<?>> enumeration, Skin skin) {
		super(skin);

		//Récupération des valeurs de l'Enum si présente, vide sinon
		if (enumeration != null) {
			setItems(Converter.enumToStringArray(enumeration));
		}

		value = getSelected() != null ? getSelected() : "";

		//Récupération de la valeur actuelle à chaque clique
		addListener(new ClickListener() {

			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);

				value = getSelected() != null ? getSelected() : "";
			}

		});

		//Gestion des changements
		addListener(new ChangeListener() {

			@Override
			public void changed(ChangeEvent event, Actor actor) {
				//Logging du changement de valeur si la valeur a été changée
				if (getSelected() != null && value != getSelected()) {
					logger.debug(getName() + " changed : " + value + " -> " + (getSelected() != null ? getSelected() : ""));
				}
				value = getSelected();
				
				//ChangeListener pour les items
				Group group = (Group) ActorActions.findActor(MainWindow.stage, "item_content");
				if (group != null) {
					String cristal = Launcher.languageManager.getProperty("Object.Cristal");
					String scroll = Launcher.languageManager.getProperty("Object.Scroll");
					
					if (group.findActor("item_special_options") != null) {
						group.findActor("item_special_options").remove();
					}
					
					if (getSelected() != null && (getSelected().equalsIgnoreCase(cristal) || getSelected().equalsIgnoreCase(scroll))) {
						((VerticalGroup) group.findActor("item_content_group")).addActorAt(1, new ItemSpecialOptions(getSelected(), skin));
					}
				}
			}
		});
	}

	/**
	 * @return value pour log
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value pour log
	 */
	public void setvalue(String value) {
		this.value = value != null ? value : "";
	}
}