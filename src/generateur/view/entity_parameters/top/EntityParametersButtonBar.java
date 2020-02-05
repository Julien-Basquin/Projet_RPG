package generateur.view.entity_parameters.top;

import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import generateur.controller.button.entity_parameters.UndoButton;
import generateur.controller.button.entity_parameters.HelpButton;
import generateur.controller.button.entity_parameters.NewFileButton;
import generateur.controller.button.entity_parameters.OpenFileButton;
import generateur.controller.button.entity_parameters.RedoButton;
import generateur.controller.button.entity_parameters.SaveFileButton;
import generateur.controller.button.entity_parameters.SaveUnderFileButton;

/**
 * Conteneur des boutons de l'interface de création des entités.
 * 
 * @author Julien B.
 */

public class EntityParametersButtonBar extends HorizontalGroup {

	//TODO Gérer la taille des boutons
	public EntityParametersButtonBar(Skin skin) {
		super();
		setName("entity_button_bar");
		
		//Création d'un fichier d'entité
		NewFileButton newFile = new NewFileButton(skin);
		
		//Ouverture d'un fichier d'entité
		OpenFileButton openFile = new OpenFileButton(skin);
		
		//Enregistrement d'un fichier d'entité
		SaveFileButton saveFile = new SaveFileButton(skin);
		
		//Enregistrement ciblé d'un fichier d'entité
		SaveUnderFileButton saveUnderFile = new SaveUnderFileButton(skin);
		
		//Annulation de la dernière action
		UndoButton undo = new UndoButton(skin);
		
		//Reproduction de la dernière action annulée
		RedoButton redo = new RedoButton(skin);
		
		//Affichage de l'aide
		HelpButton help = new HelpButton(skin);
		
		//Ajout des boutons à l'affichage
		addActor(newFile);
		addActor(openFile);
		addActor(saveFile);
		addActor(saveUnderFile);
		addActor(undo);
		addActor(redo);
		addActor(help);
	}
}
