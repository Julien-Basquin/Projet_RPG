package generateur.controller.button;

import org.apache.log4j.Logger;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import app.model.Base;
import app.model.enumeration.CategorieEnum;
import generateur.Launcher;
import generateur.controller.select.SelectCategory;
import util.DataManager;

/**
 * @author Julien B.
 *
 * Bouton permettant d'enregistrer un objet du générateur.
 */

public class SaveButton extends TextButton {

	private final Logger logger = Logger.getLogger(SaveButton.class);
	
	public SaveButton(Skin skin) {
		super(Launcher.languageManager.getProperty("Global.Save"), skin);
		setName("save");
		
		addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);
				
				logger.info("Saving parameters...");
				
				//Récupération du parent
				Group parent = getParent().getParent();
				//Récuperation de la catégorie
				CategorieEnum categorieEnum =((SelectCategory) parent.findActor("category")).getSelected();
				logger.debug("Categorie : " + categorieEnum);
				
				//Récupération du path
				String path = "";
				try {
					path = DataManager.pathConstructor(categorieEnum);
				} catch (Exception e) {
					logger.fatal(e);
				}
				logger.debug("Path : " + path);
				
				//Récupération de l'objet
				Base object = null;
				try {
					object = DataManager.objectConstructor(parent);
				} catch (Exception e) {
					logger.fatal(e);
				}
				
				//Sauvegarde de l'objet
				DataManager.saveData(object, path, ((TextField) parent.findActor("name")).getText()+".json");
				
				logger.info("...Saving over.");
			}
		});
	}

}
