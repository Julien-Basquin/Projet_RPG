package generateur.view.dialog.entity_parameters.graph;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import generateur.Launcher;
import generateur.controller.button.dialog_button.CancelButton;
import generateur.controller.button.dialog_button.entity_parameters.graph.ResetGraphButton;

/**
 * Fenêtre de confirmation de la réinitialisation du graphe des entités
 * 
 * @author Julien B.
 */

public class ResetGraphDialog extends Dialog {
	
	public ResetGraphDialog(Skin skin) {
		super(Launcher.languageManager.getProperty("Global.Confirm"), skin);
		
		//Récupération de la résolution active
		int width = Gdx.graphics.getWidth();
		int height = Gdx.graphics.getHeight();

		//Annulation
		setSize(width / 2, height / 2);
		setPosition(width / 2 - getWidth() / 2, height / 2 - getHeight() / 2);
		text(Launcher.languageManager.getProperty("Global.Graph.Confirm.Reset")
				+ Launcher.languageManager.getProperty("Global.Warning.Unsaved"));
		
		//Ajout des boutons à la fenêtre de dialogue
		button(new CancelButton(skin));
		button(new ResetGraphButton(skin));
	}

}
