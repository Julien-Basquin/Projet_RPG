package generateur.controller.dialog;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import generateur.Launcher;

public class ConfirmDialog extends Dialog {
	
	public ConfirmDialog(Skin skin) {
		super(Launcher.languageManager.getProperty("Global.Confirm"), skin);
		//Récupération de la résolution active
		int width = Gdx.graphics.getWidth();
		int height = Gdx.graphics.getHeight();

		//Création d'une boîte de dialogue
		setSize(width / 2, height / 2);
		setPosition(width / 2 - getWidth() / 2, height / 2 - getHeight() / 2);
		text(Launcher.languageManager.getProperty("Global.Confirm.Text.Saving"));
		
		//Bouton d'annulation, ferme la fenêtre de dialogue
		TextButton cancel = new TextButton(Launcher.languageManager.getProperty("Global.Close"), skin);
		cancel.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);
				
				remove();
			}
		});
		
		//Ajout des boutons à la fenêtre de dialogue
		button(cancel);
	}

}
