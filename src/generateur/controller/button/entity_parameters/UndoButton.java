package generateur.controller.button.entity_parameters;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import generateur.MainWindow;
import generateur.Launcher;
import generateur.model.entity_parameters.EventsEnum;
import generateur.model.entity_parameters.stack.ObjectEvent;

/**
 * Bouton d'annulation des actions effectuées.
 * 
 * @author Julien B.
 */

public class UndoButton extends TextButton {

	public UndoButton(Skin skin) {
		super(Launcher.languageManager.getProperty("Global.Cancel"), skin);
		setName("undo");
		
		addListener(new ClickListener() {

			@Override
			public void clicked(InputEvent event, float x, float y) {
				if (!MainWindow.previousStates.isEmpty()) {
					ObjectEvent objectEvent = MainWindow.previousStates.peek();
					Pattern pattern = Pattern.compile("([A-Z]+)_([A-Z][a-z]+)");
					Matcher match;
					
					for (ObjectEvent obj : MainWindow.previousStates.searchByGroup(objectEvent.getGroupId())) {
						match = pattern.matcher(obj.getEvent());
						
						if (match.find()) {
							MainWindow.previousStates.peek().getObject().undo(EventsEnum.valueOf(match.group(1)));
						}
					}
				}
			}
			
		});
	}

}
