package generateur.controller.button.global_parameters;

import java.util.List;

import org.apache.log4j.Logger;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import app.model.Base;
import app.model.enumeration.CategorieEnum;
import generateur.Generator;
import generateur.Launcher;
import generateur.controller.dialog.CloseDialog;
import generateur.controller.dialog.ConfirmDialog;
import generateur.controller.dialog.ErrorDialog;
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
			@SuppressWarnings("unchecked")
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
					List<String> errors = DataManager.objectValidation(parent);
					if ( errors != null ) {
						Generator.stage.addActor(new ErrorDialog(skin,errors));
					} else {
						//Sauvegarde de l'objet
						DataManager.saveData(object, path, ((TextField) parent.findActor("name")).getText()+".json");
						Generator.stage.addActor(new ConfirmDialog(skin));
						logger.info("File save : "+path+((TextField) parent.findActor("name")).getText()+".json");
					}
				} catch (Exception e) {
					logger.fatal(e);
				}
				
				logger.info("...Saving over.");
			}
		});
	}

}
