package generateur.controller.button.global_parameters;

import org.apache.log4j.Logger;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.kotcrab.vis.ui.widget.file.FileChooserListener;

import generateur.Generator;

/**
 * @author Julien B.
 *
 * Bouton de sélection de l'icône.
 */

public class IconButton extends TextButton {
	
	private Texture newTexture;
	private String value;
	
	private final Logger logger = Logger.getLogger(IconButton.class);
	
	public IconButton(Skin skin) {
		super("Choisir icône", skin);
		setName("icon_selector");
		
		value = "";
		
		addListener(new ClickListener() {

			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);
				
				//Action à la sélection du fichier
				Generator.fileChooser.setListener(new FileChooserListener() {
					
					@Override
					public void selected(Array<FileHandle> files) {
						dispose();
						Container<Image> container = getParent().findActor("icon_container");
						newTexture = new Texture(files.first());
						container.setActor(new Image(newTexture));
						logger.debug("Icon changed : " + value + " -> " + files.first().name());
						value = files.first().name();
					}
					
					@Override
					public void canceled() {
					}
				});
				
				//Apparition de la fenêtre de sélection
				Generator.stage.addActor(Generator.fileChooser.fadeIn());
			}
			
		});
	}
	
	/**Libération des objets inutilisés*/
	public void dispose() {
		if (newTexture != null) {
			newTexture.dispose();
		}
	}
}
