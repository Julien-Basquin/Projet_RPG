package generateur.view.entity_parameters.top;

import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import generateur.controller.button.entity_parameters.CancelButton;
import generateur.controller.button.entity_parameters.HelpButton;
import generateur.controller.button.entity_parameters.NewFileButton;
import generateur.controller.button.entity_parameters.OpenFileButton;
import generateur.controller.button.entity_parameters.RedoButton;
import generateur.controller.button.entity_parameters.SaveFileButton;
import generateur.controller.button.entity_parameters.SaveUnderFileButton;

public class EntityParametersButtonBar extends HorizontalGroup {

	//TODO Gérer la taille des boutons
	public EntityParametersButtonBar(Skin skin) {
		super();
		setName("entity_button_bar");
		
		NewFileButton newFile = new NewFileButton(skin);
		
		OpenFileButton openFile = new OpenFileButton(skin);
		
		SaveFileButton saveFile = new SaveFileButton(skin);
		
		SaveUnderFileButton saveUnderFile = new SaveUnderFileButton(skin);
		
		CancelButton cancel = new CancelButton(skin);
		
		RedoButton redo = new RedoButton(skin);
		
		HelpButton help = new HelpButton();
	}
}
