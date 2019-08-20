package generateur.controller.dialog;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import generateur.Launcher;

public class ErrorDialog extends Dialog {
	public ErrorDialog(Skin skin, List<String> errorsList) {
		super(Launcher.languageManager.getProperty("Global.Error"), skin);
		//Récupération de la résolution active
		int width = Gdx.graphics.getWidth();
		int height = Gdx.graphics.getHeight();

		//Création d'une boîte de dialogue
		setSize(width / 2, height / 2);
		setPosition(width / 2 - getWidth() / 2, height / 2 - getHeight() / 2);
		String errors = "";
		for (String error : errorsList) {
			errors += Launcher.languageManager.getProperty(error) + "\n";
		}
		text(errors);
		
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
