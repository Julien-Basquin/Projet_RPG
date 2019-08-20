package generateur.controller.button;

import org.apache.log4j.Logger;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import app.model.enumeration.CategorieEnum;
import app.model.enumeration.element.ElementEnum;
import generateur.Launcher;
import generateur.controller.select.SelectCategory;
import generateur.controller.select.StringSelectBox;
import util.Converter;

/**
 * Bouton permettant de réinitialiser tous les champs du générateur
 *  
 * @author Julien B.
 */

public class InitButton extends TextButton {
	
	private final Logger logger = Logger.getLogger(InitButton.class);

	public InitButton(Skin skin) {
		super(Launcher.languageManager.getProperty("Global.Reset"), skin);
		setName("reinit");
		
		addListener(new ClickListener() {

			//@SuppressWarnings("unchecked") car type connu
			@SuppressWarnings("unchecked")
			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);
				
				logger.info("Reinitializing parameters...");
				
				//Récupération du parent
				Group parent = getParent().getParent();
				//Réinitialisation des champs à vide ou à leur première valeur
				((TextField) parent.findActor("name")).setText("");
				//Les changements fait sur la catégorie sont répercutés dans les listes dépendantes, voir SelectCategory
				((SelectCategory) parent.findActor("category")).setItems(CategorieEnum.values());
				((SelectCategory) parent.findActor("category")).setSelectedIndex(0);
				((SelectCategory) parent.findActor("category")).fire(new ChangeListener.ChangeEvent());
				((Container<Image>) parent.findActor("icon_container")).setActor(null);
				((StringSelectBox) parent.findActor("element")).setItems(Converter.enumToStringArray(ElementEnum.class));
				((StringSelectBox) parent.findActor("element")).setSelectedIndex(0);
//				((StringSelectBox) parent.findActor("element")).setvalue(((StringSelectBox) parent.findActor("element")).getSelected());
				((StringSelectBox) parent.findActor("element")).fire(new ChangeListener.ChangeEvent());
				((TextArea) parent.findActor("description")).setText("");
				
				logger.info("...reinitializing over.");
			}
			
		});
	}

}
